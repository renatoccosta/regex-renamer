package br.com.renatoccosta.renamer;

import br.com.renatoccosta.renamer.exception.RenamerException;
import br.com.renatoccosta.renamer.element.base.Element;
import br.com.renatoccosta.renamer.i18n.Messages;
import br.com.renatoccosta.renamer.parser.RenamerLexer;
import br.com.renatoccosta.renamer.parser.RenamerParser;
import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.apache.commons.lang.ArrayUtils;

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

        flattenFiles(rootFile, includeSubFolders);
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

        parseReplace(replace);

        if (!this.rootReplace.toString().equals(lastReplace)) {
            this.dirty = true;
        }
    }

    /* ---------------------------------------------------------------------- */

    public void moveFilesUp(int startIndex, int endIndex) {
        
    }

    public void moveFilesDown(int startIndex, int endIndex) {

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

        //iteração na lista de arquivos
        for (String strFile : filesBefore) {
            File f = new File(strFile);

            String destino = f.getName();

            Matcher matcher = search.matcher(f.getName());
            if (matcher.find()) {
                destino = rootReplace.getContent(search.pattern(),
                        f.getName(), f);
            }

            filesAfter.add(f.getParent() + File.separator + destino);
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
        if (!isReady() || this.dirty) {
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

    /* ---------------------------------------------------------------------- */
    /**
     * Varre todos os arquivos da pasta e subpastas e preenche o array de
     * arquivos com seus respectivos nomes completos.
     *
     * @param files
     */
    private void flattenFiles(File files, boolean includeSubFolders) throws
            RenamerException {
        if (files.isDirectory()) {
            for (File arq : files.listFiles()) {
                if (arq.isFile() || includeSubFolders) {
                    flattenFiles(arq, includeSubFolders);
                }
            }
        } else {
            this.filesBefore.add(files.getAbsolutePath());
            this.filesAfter.add(files.getAbsolutePath());
        }
    }

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
     * Executa um parse na string de substituição, gerando os elementos
     * correspondentes.
     *
     * @param replace String de substituição
     * @throws ParseException Case exista um erro de sintaxe
     */
    private void parseReplace(String replace) throws RenamerException {
        RenamerLexer lexer = new RenamerLexer(replace);

        CommonTokenStream cts = new CommonTokenStream(lexer);
        RenamerParser instance = new RenamerParser(cts);

        try {
            instance.inicio();
            this.rootReplace = instance.root;
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

}
