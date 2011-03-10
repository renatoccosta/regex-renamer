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
import java.text.ParseException;
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

    // <editor-fold defaultstate="collapsed" desc="contants">
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

    private List<String> filesBefore = new ArrayList<String>();

    private List<String> filesAfter = new ArrayList<String>();

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
     * Retorna uma lista com o nome dos arquivos antes da mudança de nome
     * @return Lista com o nome dos arquivos
     */
    public List<String> getFileNamesBefore() {
        return this.filesBefore;
    }

    /**
     * Retorna uma lista com o nome dos arquivos depois da mudança de nome
     * @return Lista com o nome dos arquivos
     */
    public List<String> getFileNamesAfter() {
        return this.filesAfter;
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
        this.includeExtensions = includeExtensions;
        this.dirty = true;
    }

    public void setSearch(String search) throws RenamerException {
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
    public void moveFilesUp(int startIndex, int endIndex) {
        if (startIndex <= 0) {
            return;
        }

        this.filesBefore = ArrayUtil.moveBlock(filesBefore, -1, startIndex,
                endIndex);
        this.filesAfter = ArrayUtil.moveBlock(filesAfter, -1, startIndex,
                endIndex);
    }

    public void moveFilesDown(int startIndex, int endIndex) {
        if (endIndex >= this.filesBefore.size() - 1) {
            return;
        }

        this.filesBefore = ArrayUtil.moveBlock(filesBefore, 1, startIndex,
                endIndex);
        this.filesAfter = ArrayUtil.moveBlock(filesAfter, 1, startIndex,
                endIndex);
    }

    /**
     * Validates if all the requirements for the rename are filled depending
     * on the chosen criteria.
     * @return Whether it is ready for rename or not.
     */
    public boolean isReady() {
        boolean r1 = !this.filesBefore.isEmpty() && this.rootReplace != null;
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

        filesAfter.clear();
        rootReplace.resetState();
        canRename = true;
        List<String> preRenameFiles = fillPreRenameList();

        //iteração na lista de arquivos
        for (String strFile : preRenameFiles) {
            File f = new File(strFile);
            String base = FilenameUtils.getBaseName(f.getName());
            String ext = FilenameUtils.getExtension(f.getName());
            String target;

            if (isIncludeExtensions()) {
                target = base + "." + ext;
            } else {
                target = base;
            }

            Matcher matcher = search.matcher(f.getName());
            if (matcher.find()) {
                try {
                    target = rootReplace.getContent(search.pattern(),
                            target, f);
                } catch (Exception ex) {
                    target = Messages.getErrorRenamingMessage();
                    LOGGER.error(ex);
                    canRename = false;
                }
            }

            if (!isIncludeExtensions()) {
                target = target + "." + ext;
            }

            filesAfter.add(f.getParent() + File.separator + target);
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
        for (int i = 0; i < filesBefore.size(); i++) {
            String strFile = filesBefore.get(i);

            if (strFile.equals(filesAfter.get(i))) {
                continue;
            }

            File file = new File(strFile);
            file.renameTo(new File(strFile + TMP_SUFIX));
        }

        //renomea para o definitivo
        //apenas os arquivos que tiverem alterações nos nomes
        for (int i = 0; i < filesBefore.size(); i++) {
            String strFile = filesBefore.get(i);

            if (strFile.equals(filesAfter.get(i))) {
                continue;
            }

            File file = new File(strFile + TMP_SUFIX);
            file.renameTo(new File(filesAfter.get(i)));
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

        for (int i = 0; i < filesAfter.size(); i++) {
            String fAfter = filesAfter.get(i);
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
        if (sortType.equals(SortType.FILE_NAME)) {
            FileUtil.sortFilesByName(filesBefore);
            FileUtil.sortFilesByName(filesAfter);
        } else {
            FileUtil.sortFilesByDate(filesBefore);
            FileUtil.sortFilesByDate(filesAfter);
        }
    }

    private void fillFileLists() {
        this.filesBefore.clear();
        this.filesAfter.clear();
        this.conflicts.clear();

        if (rootFolder != null) {
            List<String> flattenedFiles = FileUtil.flattenFiles(rootFolder,
                    includeSubFolders);
            this.filesBefore.addAll(flattenedFiles);
            this.filesAfter.addAll(flattenedFiles);

            sortFiles();
        }
    }

    private List<String> fillPreRenameList() {
        List<String> lst = null;

        switch (searchType) {
            case SELECTED_FILES:
                lst = new ArrayList<String>(selectedFiles.length);

                for (int i : selectedFiles) {
                    lst.add(filesBefore.get(i));
                }

                break;
            default: //all other options
                lst = filesBefore;
        }

        return lst;
    }
    // </editor-fold>
}
