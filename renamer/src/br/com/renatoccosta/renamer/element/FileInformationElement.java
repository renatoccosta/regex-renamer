
package br.com.renatoccosta.renamer.element;

import br.com.renatoccosta.renamer.element.base.ExpressionElement;
import java.io.File;

/**
 * Elemento que imprime determinadas informações sobre o arquivo que está tendo
 * seu nome alterado.
 *
 * @author Renato Costa
 */
public class FileInformationElement extends ExpressionElement {

    public static final String FOLDER = "folder";

    public static final String DATE = "date";

    public static final String SIZE = "size";

    @Override
    public void setParameters(String... content) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getContent(String find, String target, File file) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
