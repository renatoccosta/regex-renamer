/**
 * Copyright 2009 Renato Couto da Costa
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.com.renatoccosta.renamer;

import br.com.renatoccosta.renamer.exception.RenamerException;
import br.com.renatoccosta.renamer.element.base.Element;
import br.com.renatoccosta.renamer.exception.ParseErrorsException;
import br.com.renatoccosta.renamer.i18n.Messages;
import br.com.renatoccosta.renamer.parser.RenamerLexer;
import br.com.renatoccosta.renamer.parser.RenamerParser;
import br.com.renatoccosta.renamer.parser.RenamerTreeParser;
import br.com.renatoccosta.renamer.util.ArrayUtil;
import br.com.renatoccosta.renamer.util.FileUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.runtime.tree.Tree;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;

/**
 * Main class of the application. It's responsible for all the business rules of
 * renaming the files
 * 
 * @author Renato Costa
 */
public class Renamer {

    // <editor-fold defaultstate="collapsed" desc="constants">
    private static final Logger LOGGER = Logger.getLogger(Renamer.class);

    private static final String TMP_SUFIX = "~";

    private static final String SEARCH_ALL = "(.*)";
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="fields">
    private File rootFolder;

    private boolean includeSubFolders = false;

    private boolean includeExtensions = false;

    private CriteriaTypeEnum searchType = CriteriaTypeEnum.REGULAR_EXPRESSION;

    private SortType sortType = SortType.FILE_NAME;

    private int[] selectedFiles = new int[]{};

    private List<RenamedFile> files = new ArrayList<RenamedFile>();

    /**
     * Map de nome do arquivo que possui conflitos com os indices de
     * sua ocorrência na lista filesAfter
     */
    private Map<String, List<Integer>> conflicts =
            new HashMap<String, List<Integer>>();

    private Pattern search;

    private Element rootReplace;

    /**
     * Indica que variáveis foram alteradas depois do método
     * {@code previewRename()} ter sido chamado.
     */
    private boolean dirty = true;

    /**
     * Indica que o preview foi realizado com sucesso e os arquivos podem ser
     * renomeados. Não significa que não possam ocorrer erros durante o processo
     * de renomear.
     */
    private boolean canRename = true;
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="constructor">
    /**
     * Cria uma instancia do renomeador.
     */
    public Renamer() {
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="gets/sets">
    public File getRootFolder() {
        return rootFolder;
    }

    /**
     * Return the list of files in the specified folder
     * @return
     */
    public List<RenamedFile> getFiles() {
        return files;
    }

    public Map<String, List<Integer>> getConflicts() {
        return conflicts;
    }

    public SortType getSortType() {
        return sortType;
    }

    public CriteriaTypeEnum getSearchType() {
        return searchType;
    }

    public boolean isIncludeSubFolders() {
        return includeSubFolders;
    }

    public boolean isIncludeExtensions() {
        return includeExtensions;
    }

    public void setRootFolder(File rootFolder) throws
            RenamerException {
        if (rootFolder.equals(this.rootFolder)) {
            return;
        }

        if (!rootFolder.exists()) {
            throw new RenamerException(
                    Messages.getFileNotFoundMessage());
        }

        this.rootFolder = rootFolder;

        fillFileLists();

        this.dirty = true;
    }

    public void setIncludeSubFolders(boolean includeSubFolders) {
        if (includeSubFolders == this.includeSubFolders) {
            return;
        }

        this.includeSubFolders = includeSubFolders;

        fillFileLists();

        this.dirty = true;
    }

    public void setIncludeExtensions(boolean includeExtensions) {
        if (this.includeExtensions == includeExtensions) {
            return;
        }

        this.includeExtensions = includeExtensions;
        this.dirty = true;
    }

    public void setSearch(String search) throws RenamerException {
        if (!searchType.equals(CriteriaTypeEnum.REGULAR_EXPRESSION)) {
            throw new IllegalStateException(
                    "Can only set regex expression when search type is regex");
        }

        if (this.search != null && search.equals(this.search.pattern())) {
            return;
        }

        parseSearch(search);
        this.dirty = true;
    }

    public void setReplace(String replace) throws RenamerException {
        String lastReplace = null;

        if (this.rootReplace != null) {
            lastReplace = this.rootReplace.toString();
        }

        this.rootReplace = parseReplace(replace);

        if (!this.rootReplace.toString().equals(lastReplace)) {
            this.dirty = true;
        }
    }

    public void setSortType(SortType sortType) {
        this.sortType = sortType;
        sortFiles();
    }

    public void setSearchType(CriteriaTypeEnum type) {
        if (this.searchType.equals(type)) {
            return;
        }

        this.searchType = type;

        try {
            parseSearch(SEARCH_ALL);
        } catch (RenamerException ex) {
            throw new IllegalArgumentException(ex);
        }

        this.dirty = true;
    }

    public void setSelectedFiles(int[] selectedFiles) {
        this.selectedFiles = selectedFiles;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="public methods">
    /**
     * Move the selected items (files) one step up in the list
     * @param selectedIndexes Array of selected items (as in JList)
     */
    public void moveFilesUp(int[] selectedIndexes) {
        //there is no reason to move up if the firs item is selected
        if (selectedIndexes.length < 0 || selectedIndexes[0] <= 0) {
            return;
        }

        ArrayUtil.moveBlock(files, -1, selectedIndexes);
    }

    /**
     * Move the selected items (files) one step down in the list
     * @param selectedIndexes Array of selected items (as in JList)
     */
    public void moveFilesDown(int[] selectedIndexes) {
        //there is no reason to move down if the last item is selected
        if (selectedIndexes.length < 0
                || selectedIndexes[selectedIndexes.length - 1]
                >= this.files.size() - 1) {
            return;
        }

        ArrayUtil.moveBlock(files, 1, selectedIndexes);
    }

    /**
     * Validates if all the requirements for the rename are filled depending
     * on the chosen criteria.
     * @return Whether it is ready for rename or not.
     */
    public boolean isReady() {
        boolean r1 = !this.files.isEmpty() && this.rootReplace != null;
        boolean r2 = false;

        switch (searchType) {
            case SELECTED_FILES:
                r2 = selectedFiles.length > 0;
                break;
            case REGULAR_EXPRESSION:
                r2 = this.search != null;
                break;
            default: //all files
                r2 = true;
        }

        return r1 && r2;
    }

    /**
     * Verifies if there are file name conflicts
     * @return True for file conflicts
     */
    public boolean hasConflicts() throws RenamerException {
        return !conflicts.isEmpty();
    }

    /**
     * Executes the parse of the text and analyse the cursor position to
     * generate the auto complete options.
     *
     * @param text Text to be parsed
     * @param pos Position of the carret in the text
     * @return List of auto-complete options or null if there was no options.
     */
    public List<String> queryAutoCompleteOptions(String text, int pos) {
        try {
            parseReplace(text);

        } catch (RenamerException ex) {
            if (ex instanceof ParseErrorsException) {
                ParseErrorsException pee = (ParseErrorsException) ex;
                int realPos = text.length() == pos ? -1 : pos;

                return AutoComplete.process(pee.getExceptions(), realPos);
            }
        }

        return null;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="core methods">
    /**
     * This is the core method of this class.
     * It executes the renaming process in memory, without actually renaming the
     * files. It fills the destination file list with the new names. This method
     * needs to be called before the files are actually renamed because it
     * verifies for any conflict that may happen.
     */
    public void previewRename() throws RenamerException {
        if (!isReady()) {
            throw new RenamerException(Messages.getNotReadyMessage());
        }

        rootReplace.resetState();
        canRename = true;

        switch (searchType) {
            case SELECTED_FILES:
                for (int i = 0; i < files.size(); i++) {
                    RenamedFile rf = files.get(i);

                    if (isSelected(i)) {
                        convertName(rf);
                    } else {
                        rf.setFileNameAfter(null);
                    }
                }
                break;
            default: //regex and all files
                for (RenamedFile file : files) {
                    convertName(file);
                }
        }

        //ocorreram problemas durante o rename de alguns arquivos
        if (!canRename) {
            throw new RenamerException(Messages.getErrorRenamingFilesMessage());
        }

        calculateConflicts();

        this.dirty = false;
    }

    /**
     * Executes the actual renaming process if everything is ready. Before
     * calling this method, the {@code previewRename()} must be called.
     */
    public void rename() throws RenamerException {
        if (!isReady() || this.dirty || !this.canRename) {
            throw new RenamerException(Messages.getNotReadyMessage());
        }

        if (hasConflicts()) {
            throw new RenamerException(Messages.getConflictMessage());
        }

        /*
         * o ato de renomear é feito em dois passos para que não existam
         * conflitos de nomes de arquivos entre os nomes de origem e os de
         * destino.
         *
         * ex:
         * joao -> maria
         * maria -> joao
         *
         * se 'joao' fosse renomeado diretamente para 'maria', existiria um
         * conflito de nomes (existe um arquivo com o nome 'maria').
         *
         * joao -> joao~
         * maria -> maria~
         * joao~ -> maria
         * maria~ -> joao
         *
         * desta forma não existe conflito de nome.
         */

        //renomea para o temporário
        //apenas os arquivos que tiverem alterações nos nomes
        for (RenamedFile f : files) {
            if (f.shouldRename()) {
                File file = new File(f.getFileNameBefore());
                file.renameTo(new File(f.getFileNameBefore() + TMP_SUFIX));
            }
        }

        //renomea para o definitivo
        //apenas os arquivos que tiverem alterações nos nomes
        for (RenamedFile f : files) {
            if (f.shouldRename()) {
                File file = new File(f.getFileNameBefore() + TMP_SUFIX);
                file.renameTo(new File(f.getFileNameAfter()));
            }
        }

        fillFileLists();

        this.dirty = true;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="private methods">
    /**
     * Verifica se a string de localização do padrão de nome de arquivo é válida
     * como uma expressão regular
     *
     * @param localizar String de localizar
     * @throws ParseException Case existe um erro de sintaxe
     */
    private void parseSearch(String localizar) throws RenamerException {
        try {
            this.search = Pattern.compile(localizar);
        } catch (PatternSyntaxException e) {
            throw new RenamerException(e);
        }
    }

    /**
     * Executes the parse in the substitution string, generating the
     * corresponding elements.
     *
     * @param replace Substitution string
     * @return Root element
     * @throws RenamerException If there was any error during the parse
     */
    private Element parseReplace(String replace) throws RenamerException {
        try {
            CharStream input = new ANTLRStringStream(replace);
            Lexer lex = new RenamerLexer(input);

            CommonTokenStream tokens = new CommonTokenStream(lex);
            RenamerParser parser = new RenamerParser(tokens);
            RenamerParser.document_return root = parser.document();

            CommonTreeNodeStream nodes = new CommonTreeNodeStream(
                    (Tree) root.getTree());
            RenamerTreeParser walker = new RenamerTreeParser(nodes);
            walker.document();

            return walker.root;

        } catch (RecognitionException ex) {
            throw new RenamerException(ex);
        }
    }

    private void calculateConflicts() {
        conflicts.clear();

        //chave: nome do arquivo
        //valor: lista com o indice de cada ocorrência do nome do arquivo na
        //lista original
        Map<String, List<Integer>> cfsTemp =
                new HashMap<String, List<Integer>>();

        for (int i = 0; i < files.size(); i++) {
            String fAfter = files.get(i).getFileNameAfter();
            if (cfsTemp.containsKey(fAfter)) {
                cfsTemp.get(fAfter).add(i);
            } else {
                List<Integer> idx = new ArrayList<Integer>();
                idx.add(i);
                cfsTemp.put(fAfter, idx);
            }
        }

        for (Map.Entry<String, List<Integer>> entry : cfsTemp.entrySet()) {
            if (entry.getValue().size() > 1) {
                conflicts.put(entry.getKey(), entry.getValue());
            }
        }
    }

    private void sortFiles() {
        switch (sortType) {
            case FILE_NAME:
                FileUtil.sortFilesByName(files);
                break;

            default:
                FileUtil.sortFilesByDate(files);
        }
    }

    private void fillFileLists() {
        this.files.clear();
        this.conflicts.clear();

        if (rootFolder != null) {
            List<String> flattenedFiles = FileUtil.flattenFiles(rootFolder,
                    includeSubFolders);
            for (String f : flattenedFiles) {
                RenamedFile rf = new RenamedFile(f, rootFolder.getAbsolutePath());
                files.add(rf);
            }

            sortFiles();
        }
    }

    /**
     * Checks if the corresponding item index is selected in the list
     * 
     * @param i Item index
     * @return True if selected
     */
    private boolean isSelected(int i) {
        for (int j : selectedFiles) {
            if (i == j) {
                return true;
            } else if (i < j) {
                return false;
            }
        }

        return false;
    }

    /**
     * Converts the old file name for the new one, using the parsed replace string
     * @param file File name to be changed
     * @return New file name
     */
    private void convertName(RenamedFile file) {
        File f = new File(file.getFileNameBefore());
        String base = FilenameUtils.getBaseName(f.getName());
        String ext = FilenameUtils.getExtension(f.getName());
        String target;

        if (isIncludeExtensions()) {
            target = base + "." + ext;
        } else {
            target = base;
        }

        Matcher matcher = search.matcher(target);
        if (matcher.find()) {
            try {
                target = rootReplace.getContent(search.pattern(),
                        target, f);
            } catch (Exception ex) {
                target = Messages.getErrorRenamingMessage();
                LOGGER.error(ex);
                canRename = false;
            }

            if (!isIncludeExtensions()) {
                target = target + "." + ext;
            }

            file.setFileNameAfter(f.getParent() + File.separator + target);
        } else {
            file.setFileNameAfter(null);
        }

    }
    // </editor-fold>
}
