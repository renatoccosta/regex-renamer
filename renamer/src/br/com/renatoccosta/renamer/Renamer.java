package br.com.renatoccosta.renamer;

import java.io.File;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * Classe principal da aplicacao. Realiza toda a orquestracao do negocio
 * (renomear arquivos) da aplicacao.
 *
 * @author Renato Costa
 */
public class Renamer {

    private Pattern localizar;

    private String substituir;

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
    public Renamer(String localizar, String substituir) throws ParseException {
        parseLocalizar(localizar);
        this.substituir = substituir;
        parseSubstituir();        
    }

    /* ---------------------------------------------------------------------- */

    public File preview(File original) throws ParseException {
        String dest = convert(original);
        
        return new File(original.getParent() + File.separator + dest);
    }

    public File rename(File original) throws ParseException {
        File dest = preview(original);
        original.renameTo(dest);

        return dest;
    }

    /* ---------------------------------------------------------------------- */

    private void parseLocalizar(String localizar) throws ParseException {
        try {
            this.localizar = Pattern.compile(localizar);
        } catch (PatternSyntaxException e) {
            throw new ParseException(e.getMessage(), e.getIndex());
        }
    }

    private void parseSubstituir() throws ParseException {
    }

    private String convert(File original) throws ParseException {
        try {
            Matcher matcher = localizar.matcher(original.getName());
            return matcher.replaceAll(substituir);
        } catch (RuntimeException e) {
            throw new ParseException(e.getMessage(), -1);
        }
    }

}
