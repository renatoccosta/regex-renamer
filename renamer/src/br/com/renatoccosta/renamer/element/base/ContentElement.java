package br.com.renatoccosta.renamer.element.base;

/**
 * Elemento que gera algum conteúdo após sua aplicação na substituição 
 *
 * @author renato
 */
public abstract class ContentElement extends Element {

    @Override
    public Element add(Element element) {
        this.setNext(element);
        return element;
    }

}
