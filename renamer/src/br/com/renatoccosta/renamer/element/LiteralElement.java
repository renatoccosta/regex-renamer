package br.com.renatoccosta.renamer.element;

import java.io.File;

/**
 *
 * @author renato
 */
public class LiteralElement extends Element {

    private String content;

    public LiteralElement(String content) {
        this.content = content;
    }

    @Override
    public void setContent(String... content) {
        this.content = content[0];
    }

    @Override
    public String getStringRepresentation(String srcName, File srcFile) {
        return content;
    }

}
