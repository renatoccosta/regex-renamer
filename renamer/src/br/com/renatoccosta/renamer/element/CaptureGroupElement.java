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

    private int groupNumber = 0;

    private Pattern patternFind;

    public CaptureGroupElement() {
    }

    public CaptureGroupElement(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    @Override
    public String[] getParameters() {
        return new String[] {String.valueOf(groupNumber)};
    }

    @Override
    public void setParameters(String... groupNumber) {
        this.groupNumber = Integer.parseInt(groupNumber[0]);
    }

    @Override
    public String getContent(String find, String target, File file) {
        if (patternFind == null) {
            patternFind = Pattern.compile(find);
        }

        Matcher matcher = patternFind.matcher(target);
        matcher.find();

        try {
            return matcher.group(groupNumber);
        } catch (IllegalStateException e) {
            return "";
        }
    }

    @Override
    public String toString() {
        return "$" + groupNumber;
    }

    @Override
    public void resetState() {
        
    }

}
