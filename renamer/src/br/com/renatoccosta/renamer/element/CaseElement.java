package br.com.renatoccosta.renamer.element;

import br.com.renatoccosta.renamer.element.base.StreamChangeElement;

/**
 * Elemento que altera o caso dos caracteres dos próximos elementos.
 * Pode ser alteração para maiúscula, minúscula ou sem alterações.
 *
 * Ex: ${case:upper}
 * Coloca em maiúscula
 * aBc -> ABC
 *
 * Ex: ${case:none}
 * Não altera
 * aBc -> aBc
 *
 * @author Renato Costa
 */
public class CaseElement extends StreamChangeElement {

    @Override
    public void setParameters(String... content) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String convert(String src) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
