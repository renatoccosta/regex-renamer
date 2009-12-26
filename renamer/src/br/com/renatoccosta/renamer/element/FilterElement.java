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
 * Elemento que remove determinados caracteres do conteúdo dos próximos
 * elementos. As opções de caracteres podem ser: letras, números e símbolos.
 * Espaços em branco não são removidos.
 *
 * @author Renato Costa
 */
public class FilterElement extends StreamChangeElement {

    public static final String LETTERS = "l";

    public static final String NUMBERS = "n";

    public static final String SYMBOLS = "s";

    public static final String WHITE_SPACE = "w";

    private String mode = SYMBOLS;

    @Override
    public String[] getParameters() {
        return new String[] {mode};
    }

    @Override
    public void setParameters(String... content) {
        if (content.length > 0) {
            String mode = content[0];

            if (LETTERS.equals(mode) || NUMBERS.equals(mode) ||
                    SYMBOLS.equals(mode) || WHITE_SPACE.equals(mode)) {
                this.mode = mode;
            } else {
                throw new IllegalArgumentException(
                        Messages.getFilterElementInvalidParametersMessage());
            }
        }
    }

    @Override
    public String convert(String src) {
        if (LETTERS.equals(mode)) {
            StringBuffer sb = new StringBuffer();

            char[] caracs = src.toCharArray();
            for (int i = 0; i < caracs.length; i++) {
                char c = caracs[i];
                if (!Character.isLetter(c)) {
                    sb.append(c);
                }
            }

            return sb.toString();

        } else if (NUMBERS.equals(mode)) {
            StringBuffer sb = new StringBuffer();

            char[] caracs = src.toCharArray();
            for (int i = 0; i < caracs.length; i++) {
                char c = caracs[i];
                if (!Character.isDigit(c)) {
                    sb.append(c);
                }
            }

            return sb.toString();

        } else if (SYMBOLS.equals(mode)) {
            StringBuffer sb = new StringBuffer();

            char[] caracs = src.toCharArray();
            for (int i = 0; i < caracs.length; i++) {
                char c = caracs[i];
                if (Character.isLetterOrDigit(c) ||
                        Character.isSpaceChar(c)) {
                    sb.append(c);
                }
            }

            return sb.toString();

        } else if (WHITE_SPACE.equals(mode)) {
            return StringUtils.deleteWhitespace(src);
        } else {
            return src;
        }
    }

}
