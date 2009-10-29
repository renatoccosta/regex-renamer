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
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;

/**
 * Classe principal da aplicacao. Realiza toda a orquestracao do negocio
 * (renomear arquivos) da aplicacao.
 *
 * @author Renato Costa
 */
public class Renamer {

    private List<String> filesBefore = new ArrayList<String>();

    private List<String> filesAfter = new ArrayList<String>();

    /**
     * Map de nome do arquivo que possui conflitos com os indices de
     * sua ocorrência na lista filesAfter
     */
    private Map<String, List<Integer>> conflicts =
            new HashMap<String, List<Integer>>();

    private Pattern localizar;

    private Element rootReplace;

    private static final String TMP_SUFIX = "~";

    private boolean ready = false;

    /* ---------------------------------------------------------------------- */
    /**
     * Cria uma instancia do renomeador.
     *
     * @param localizar String com o padrao de localizacao dos nomes dos
     * arquivos a serem alterados. Utiliza a notacao de regex do Java.
     *
     * @param substituir String com o padrao de substituicao para o nome de
     * destino dos arquivos que se encaixarem no padrao de localizacao. Utiliza
     * a notacao de regex do Java alem das extensoes definidas.
     *
     * @throws ParseException Caso existe algum erro de sintaxe nas strings de
     * localizar e substituir.
     */
    public Renamer(File files, String search, String replace) throws
            RenamerException {
        flattenFiles(files);
        parseLocalizar(search);
        parseSubstituir(replace);
        previewRename();
        calculateConflicts();
        this.ready = true;
    }

    /**
     * Cria uma instancia do renomeador.
     *
     * @param localizar String com o padrao de localizacao dos nomes dos
     * arquivos a serem alterados. Utiliza a notacao de regex do Java.
     *
     * @param substituir String com o padrao de substituicao para o nome de
     * destino dos arquivos que se encaixarem no padrao de localizacao. Utiliza
     * a notacao de regex do Java alem das extensoes definidas.
     *
     * @throws ParseException Caso existe algum erro de sintaxe nas strings de
     * localizar e substituir.
     */
    public Renamer(File files) throws
            RenamerException {
        flattenFiles(files);
//        parseLocalizar(search);
//        parseSubstituir(replace);
//        previewRename();
    }

    /* ---------------------------------------------------------------------- */
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

    /**
     * Executa a renomeação dos arquivos, desde que não existam conflitos
     */
    public void rename() throws RenamerException {
        if (!ready) {
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
        for (String strFile : filesBefore) {
            File file = new File(strFile);
            file.renameTo(new File(strFile + TMP_SUFIX));
        }

        //renomea para o definitivo
        for (int i = 0; i < filesBefore.size(); i++) {
            File file = new File(filesBefore.get(i) + TMP_SUFIX);
            file.renameTo(new File(filesAfter.get(i)));
        }

    }

    /**
     * Verifica se existem conflitos de nomes de arquivos destino.
     * @return True caso existam.
     */
    public boolean hasConflicts() {
        return conflicts.isEmpty();
    }

    public Map<String, List<Integer>> getConflicts() {
        return conflicts;
    }

    /* ---------------------------------------------------------------------- */
    /**
     * Varre todos os arquivos da pasta e subpastas e preenche o array de
     * arquivos com seus respectivos nomes completos.
     *
     * @param files
     */
    private void flattenFiles(File files) throws RenamerException {
        if (!files.exists()) {
            throw new RenamerException(
                    Messages.getFileNotFoundMessage());
        }

        if (files.isDirectory()) {
            for (File arq : files.listFiles()) {
                flattenFiles(arq);
            }
        } else {
            this.filesBefore.add(files.getAbsolutePath());
        }
    }

    /**
     * Verifica se a string de localização do padrão de nome de arquivo é válida
     * como uma expressão regular
     * 
     * @param localizar String de localizar
     * @throws ParseException Case existe um erro de sintaxe
     */
    private void parseLocalizar(String localizar) throws RenamerException {
        try {
            this.localizar = Pattern.compile(localizar);
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
    private void parseSubstituir(String replace) throws RenamerException {
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

    /**
     * Realiza a transformação dos nomes dos arquivos, sem efetivamente
     * renomeá-los. Preenche a lista com os nomes de destino. 
     */
    private void previewRename() {
        filesAfter.clear();

        //iteração na lista de arquivos
        for (String strFile : filesBefore) {
            File f = new File(strFile);

            String destino = rootReplace.getContent(localizar.pattern(),
                    f.getName(), f);

            //qnd o destino é vazio é porque a string de localizar não encontrou
            //uma ocorrência no alvo. o destino deve ser igual à origem.
            if (destino == null | "".equals(destino)) {
                destino = f.getName();
            }

            filesAfter.add(f.getParent() + File.separator + destino);
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
