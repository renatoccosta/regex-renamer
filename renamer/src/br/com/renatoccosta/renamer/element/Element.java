package br.com.renatoccosta.renamer.element;

import java.io.File;

/**
 *
 * @author renato
 */
public abstract class Element {

    private Element next;

    public Element getNext() {
        return next;
    }

    public void setNext(Element next) {
        this.next = next;
    }

    public String getConvertedString(String srcName, File srcFile) {
        return this.getStringRepresentation(srcName, srcFile) + (next == null
                ? "" : next.getConvertedString(srcName, srcFile));
    }

    public abstract void setContent(String... content);

    public abstract String getStringRepresentation(String srcName,
            File srcFile);

}
