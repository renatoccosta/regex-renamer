/**
 * Copyright 2009 Renato Couto da Costa
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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

    public static final String UPPER = "upper";

    public static final String LOWER_CASE = "lower";

    public static final String SWAP = "swap";

    private CaseEnum mode = CaseEnum.LOWER;

    @Override
    public Class[] getParameterDataTypes() {
        return new Class[]{CaseEnum.class};
    }

    @Override
    public String[] getParameterValues() {
        return new String[]{mode.toString()};
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
            try {
                mode = CaseEnum.valueOf(content[0]);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(
                        Messages.getCaseElementInvalidParametersMessage());
            }
        }
    }

    @Override
    protected String convert(String src) {
        switch (mode) {
            case UPPER:
                return src.toUpperCase();
            case LOWER:
                return src.toLowerCase();
            case SWAP:
                return StringUtils.swapCase(src);
        }

        return src;
    }

}

enum CaseEnum {

    UPPER,
    LOWER,
    SWAP

}
