package br.com.renatoccosta.renamer.element;

import br.com.renatoccosta.renamer.element.base.StreamChangeElement;

/**
 * Elemento que remove determinados caracteres do conteúdo dos próximos
 * elementos. As opções de caracteres podem ser: letras, números e símbolos.
 * Espaços em branco não são removidos.
 *
 * @author Renato Costa
 */
public class FilterElement extends StreamChangeElement {

    @Override
    public void setParameters(String... content) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
