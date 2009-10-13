package br.com.renatoccosta.renamer.element;

import br.com.renatoccosta.renamer.element.base.StreamChangeElement;

/**
 * Elemento que substitui todas as ocorrências de um caractere por outro no
 * conteúdo dos próximos elementos.
 *
 * @author Renato Costa
 */
public class ReplaceElement extends StreamChangeElement {

    @Override
    public void setParameters(String... content) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String convert(String src) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
