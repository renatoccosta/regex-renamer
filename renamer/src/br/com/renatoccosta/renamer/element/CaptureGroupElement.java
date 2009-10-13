package br.com.renatoccosta.renamer.element;

import br.com.renatoccosta.renamer.element.base.*;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Elemento que representa um grupo de captura da expressão regular definida no
 * localizar. Seu conteúdo é o texto do grupo de captura.
 *
 * Ex: $1
 * Localizar: ([0-9]*).+
 * Texto: 1teste
 * Retorno: 1
 *
 * @author renato
 */
public class CaptureGroupElement extends ContentElement {

    private String groupNumber;

    private Pattern patternFind;

    public CaptureGroupElement(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    @Override
    public void setParameters(String... groupNumber) {
        this.groupNumber = groupNumber[0];
    }

    @Override
    public String getContent(String find, String target, File file) {
        if (patternFind == null) {
            patternFind = Pattern.compile(find);
        }

        Matcher matcher = patternFind.matcher(target);
        return matcher.replaceAll(this.toString());
    }

    @Override
    public String toString() {
        return "$" + groupNumber;
    }

}
