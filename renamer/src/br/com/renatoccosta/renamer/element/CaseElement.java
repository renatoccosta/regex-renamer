package br.com.renatoccosta.renamer.element;

import br.com.renatoccosta.renamer.element.base.StreamChangeElement;
import br.com.renatoccosta.renamer.i18n.Messages;
import org.apache.commons.lang.StringUtils;

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

    public static final String UPPER_CASE = "upper";

    public static final String LOWER_CASE = "lower";

    public static final String SWAP = "swap";

    private String mode = LOWER_CASE;

    @Override
    public String[] getParameters() {
        return new String[] {mode};
    }

    /**
     * Itens do array:
     * 0 -> (Opcional) Modo. Padrão é 'none'
     *
     * @param content Parâmetros
     */
    @Override
    public void setParameters(String... content) {
        if (content.length > 0) {
            String mode = content[0];

            if (UPPER_CASE.equals(mode) || LOWER_CASE.equals(mode) ||
                    SWAP.equals(mode)) {
                this.mode = mode;
            } else {
                throw new IllegalArgumentException(
                        Messages.getCaseElementInvalidParametersMessage());
            }
        }
    }

    @Override
    protected String convert(String src) {
        if (UPPER_CASE.equals(mode)) {
            return src.toUpperCase();
        } else if (LOWER_CASE.equals(mode)) {
            return src.toLowerCase();
        } else if (SWAP.equals(mode)) {
            return StringUtils.swapCase(src);
        } else {
            return src;
        }
    }

}
