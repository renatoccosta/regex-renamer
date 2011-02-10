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

import br.com.renatoccosta.renamer.element.base.CompositeElement;
import br.com.renatoccosta.renamer.exception.InvalidParameterException;
import br.com.renatoccosta.renamer.i18n.Messages;
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
public class FilterElement extends CompositeElement {

    private enum FilterEnum {

        LETTERS,
        NUMBERS,
        SYMBOLS,
        WHITE_SPACE

    }

    private FilterEnum mode = FilterEnum.SYMBOLS;

    /* ---------------------------------------------------------------------- */

    @Override
    public String getParameter(String name) throws InvalidParameterException {
        if ("mode".equals(name)) {
            return this.mode.toString();
        } else {
            throw new InvalidParameterException(
                    Messages.getInvalidParameterName(name));
        }
    }

    @Override
    public void setParameter(String name, String value) throws
            InvalidParameterException {
        if ("mode".equals(name)) {
            this.mode = convertModeValue(value);
        } else {
            throw new InvalidParameterException(
                    Messages.getInvalidParameterName(name));
        }
    }

    @Override
    public String[] getParameterValues() {
        return new String[] {this.mode.toString()};
    }

    @Override
    public String[] getParameterNames() {
        return new String[]{"mode"};
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

    /* ---------------------------------------------------------------------- */

    private FilterEnum convertModeValue(String value) throws
            InvalidParameterException {
        try {
            return FilterEnum.valueOf(value);
        } catch (IllegalArgumentException e) {
            throw new InvalidParameterException(
                    Messages.getCaseElementInvalidParametersMessage());
        }
    }

}
