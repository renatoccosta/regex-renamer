package br.com.renatoccosta.renamer.element.base;

/**
 * Classe base que representa um elemento na string de substituição. Cada
 * elemento aponta para o próximo, formando uma cadeia de elementos.
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

    public abstract void setParameters(String... content);

}
