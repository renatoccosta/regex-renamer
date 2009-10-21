package br.com.renatoccosta.renamer.element.base;

import java.util.ArrayList;
import java.util.List;

/**
 * Elemento que não gera conteúdo após sua aplicação na substituição, e sim
 * altera o conteúdo dos elementos contidos.
 *
 * @author Renato Costa
 */
public abstract class StreamChangeElement extends Element {

    protected boolean elementoAberto = true;

    protected Element parent;

    protected List<Element> childs = new ArrayList<Element>();

    @Override
    public Element add(Element element) {
        if (elementoAberto) {
            //quando este está aberto, o elemento é adicionado como filho
            childs.add(element);

            if (element instanceof StreamChangeElement) {
                return element;
            } else {
                return this;
            }
            
        } else {
            //quando este está fechado, qualquer elemento é adicionado como irmão
            setNext(element);
            return element;
        }
    }

    /**
     * Converte a string src para o formato de saida, de acordo com o propósito
     * do elemento.
     * 
     * @param src String de entrada
     * @return String convertida
     */
    protected abstract String convert(String src);

}
