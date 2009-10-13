package br.com.renatoccosta.renamer.element;

import br.com.renatoccosta.renamer.element.base.ContentElement;
import java.io.File;

/**
 *
 * @author renato
 */
public class LiteralElement extends ContentElement {

    private String content;

    public LiteralElement(String content) {
        this.content = content;
    }

    @Override
    public void setParameters(String... content) {
        this.content = content[0];
    }

    @Override
    public String getContent(String find, String target, File file) {
        return content;
    }

}
