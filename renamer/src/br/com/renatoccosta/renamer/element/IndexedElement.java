package br.com.renatoccosta.renamer.element;

import java.io.File;

/**
 *
 * @author renato
 */
public class IndexedElement extends ExpressionElement {

    public static final String NAME = "idx";

    private int cont = 0;

    private int leadingZeros = 0;

    @Override
    public void setContent(String... content) {
        cont = Integer.parseInt(content[0]);

        if (content.length > 1) {
            leadingZeros = Integer.parseInt(content[1]);
        }
    }

    @Override
    public String getStringRepresentation(String srcName, File srcFile) {
        return String.format("%0" + leadingZeros +"d", cont++);
    }

}
