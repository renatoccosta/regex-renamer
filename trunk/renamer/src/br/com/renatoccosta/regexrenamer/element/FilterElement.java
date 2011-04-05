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
package br.com.renatoccosta.regexrenamer.element;

import br.com.renatoccosta.regexrenamer.api.element.CompositeElement;
import br.com.renatoccosta.regexrenamer.api.meta.ElementType;
import br.com.renatoccosta.regexrenamer.api.meta.Parameter;
import org.apache.commons.lang.StringUtils;

/**
 * Element that remove certain characters from it's content based on the mode.
 * The mode can be:
 * - letters: remove all letters from text
 * - numbers: remove all numbers
 * - symbols: remove all characters that are neither letters nor numbers
 * - whitespace: remove all whitespaces (all other modes don't remove whitespaces)
 *
 * e.g:
 * Replace: <filter mode='numbers'>123abc<filter/>
 * Result: abc
 *
 * @author Renato Costa
 */
@ElementType(id="filter",
i18n = "br.com.renatoccosta.renamer.i18n.Messages")
public class FilterElement extends CompositeElement {

    public enum FilterEnum {

        LETTERS,
        NUMBERS,
        SYMBOLS,
        WHITE_SPACE

    }

    @Parameter
    private FilterEnum mode = FilterEnum.SYMBOLS;

    /* ---------------------------------------------------------------------- */

    public FilterEnum getMode() {
        return mode;
    }

    public void setMode(FilterEnum mode) {
        this.mode = mode;
    }

    /* ---------------------------------------------------------------------- */
    
    @Override
    public String convert(String src) {
        StringBuilder sb = new StringBuilder();
        char[] caracs = src.toCharArray();

        switch (mode) {
            case LETTERS:
                for (int i = 0; i < caracs.length; i++) {
                    char c = caracs[i];
                    if (!Character.isLetter(c)) {
                        sb.append(c);
                    }
                }

                return sb.toString();

            case NUMBERS:
                for (int i = 0; i < caracs.length; i++) {
                    char c = caracs[i];
                    if (!Character.isDigit(c)) {
                        sb.append(c);
                    }
                }

                return sb.toString();

            case SYMBOLS:
                for (int i = 0; i < caracs.length; i++) {
                    char c = caracs[i];
                    if (Character.isLetterOrDigit(c)
                            || Character.isSpaceChar(c)) {
                        sb.append(c);
                    }
                }

                return sb.toString();

            case WHITE_SPACE:
                return StringUtils.deleteWhitespace(src);
        }

        return src;
    }

}
