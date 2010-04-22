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
import br.com.renatoccosta.renamer.parser.TreeGrammar;
import br.com.renatoccosta.renamer.util.ArrayUtil;
import br.com.renatoccosta.renamer.util.FileUtil;
import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;

/**
 * Classe principal da aplicacao. Realiza toda a orquestracao do negocio
 * (renomear arquivos) da aplicacao.
 *
 * @author Renato Costa
 */
public class Renamer {

    private static final String TMP_SUFIX = "~";

    private File rootFile;

    private boolean includeSubFolders = false;

    private SortType sortType = SortType.FILE_NAME;

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

    private Comparator<String> cmpFiles = new Comparator<String>() {

        public int compare(String o1, String o2) {
            int qtdo1 = o1.split("\\/").length;
            int qtdo2 = o2.split("\\/").length;

            if (qtdo1 != qtdo2) {
                return qtdo1 - qtdo2;
            }

            return o1.compareTo(o2);
        }

    };

    /* ---------------------------------------------------------------------- */
    /**
     * Cria uma instancia do renomeador.
     */
    public Renamer() {
    }

    /**
     * Cria uma instancia do renomeador.
     *
     * @param files Pasta ou Arquivo a ser renomeado. Se for uma pasta, todos os
     * arquivos desta e das subpastas serão considerados.
     *
     * @throws RenamerException Caso exista algum erro no caminho dos arquivos
     */
    public Renamer(File files) throws
            RenamerException {
        setRootFiles(files, true);
    }

    /**
     * Cria uma instancia do renomeador.
     *
     * @param files Pasta ou Arquivo a ser renomeado. Se for uma pasta, todos os
     * arquivos desta e das subpastas serão considerados.
     *
     * @param search String com o padrao de localizacao dos nomes dos
     * arquivos a serem alterados. Utiliza a notacao de regex do Java.
     *
     * @param replace String com o padrao de substituicao para o nome de
     * destino dos arquivos que se encaixarem no padrao de localizacao. Utiliza
     * a notacao de regex do Java alem das extensoes definidas.
     *
     * @throws RenamerException Caso exista algum erro de sintaxe nas strings de
     * localizar e substituir.
     */
    public Renamer(File files, String search, String replace) throws
            RenamerException {
        this(files);
        setSearch(search);
        setReplace(replace);
        previewRename();
    }

    /* ---------------------------------------------------------------------- */
    public File getRootFile() {
        return rootFile;
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

    public boolean isReady() {
        return !this.filesBefore.isEmpty() && this.search != null &&
                this.rootReplace != null;
    }

    public void setRootFiles(File rootFile, boolean includeSubFolders) throws
            RenamerException {
        if (rootFile.equals(this.rootFile) && includeSubFolders ==
                this.includeSubFolders) {
            return;
        }

        if (!rootFile.exists()) {
            throw new RenamerException(
                    Messages.getFileNotFoundMessage());
        }

        this.rootFile = rootFile;
        this.includeSubFolders = includeSubFolders;

        this.filesBefore.clear();
        this.filesAfter.clear();
        this.conflicts.clear();

        List<String> flattenedFiles = FileUtil.flattenFiles(rootFile,
                includeSubFolders);
        this.filesBefore.addAll(flattenedFiles);
        this.filesAfter.addAll(flattenedFiles);

        sortFiles();

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

    /* ---------------------------------------------------------------------- */
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
     * Realiza a transformação dos nomes dos arquivos, sem efetivamente
     * renomeá-los. Preenche a lista com os nomes de destino. Este método deve
     * ser chamado antes de qualquer outro método desta classe, pois ele prepara
     * todo o estado desta classe.
     */
    public void previewRename() throws RenamerException {
        if (!isReady()) {
            throw new RenamerException(Messages.getNotReadyMessage());
        }

        filesAfter.clear();
        rootReplace.resetState();
        canRename = true;

        //iteração na lista de arquivos
        for (String strFile : filesBefore) {
            File f = new File(strFile);

            String target = f.getName();

            Matcher matcher = search.matcher(f.getName());
            if (matcher.find()) {
                try {
                    target = rootReplace.getContent(search.pattern(),
                            f.getName(), f);
                } catch (RenamerException ex) {
                    target = Messages.getErrorRenamingMessage();
                    canRename = false;
                } catch (RuntimeException ex) {
                    target = Messages.getErrorRenamingMessage();
                    canRename = false;
                }
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
     * Executa a renomeação dos arquivos, desde que não existam conflitos. Antes
     * de chamar este método, chame o {@code previewRename()} para que resultado
     * da renomeação saia correto.
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
    }

    /**
     * Verifica se existem conflitos de nomes de arquivos destino.
     * @return True caso existam.
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

    /* ---------------------------------------------------------------------- */
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
     * @throws ParseErrorsException If there was any error during the parse
     */
    private Element parseReplace(String replace) throws ParseErrorsException {
        RenamerLexer lexer = new RenamerLexer(replace);

        TokenStream cts = new CommonTokenStream(lexer);
        RenamerParser parser = new RenamerParser(cts);

        RenamerParser.begin_return br = null;
        try {
            br = parser.begin();
        } catch (RecognitionException ex) {
        }

        if (!parser.getExceptions().isEmpty()) {
            throw new ParseErrorsException(parser.getExceptions());
        }

        CommonTree t = (CommonTree) br.getTree();
        CommonTreeNodeStream nodes = new CommonTreeNodeStream(t);
        nodes.setTokenStream(cts);
        TreeGrammar tg = new TreeGrammar(nodes);

        try {
            tg.begin();
        } catch (RecognitionException ex) {
        }

        return tg.root;
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

}
