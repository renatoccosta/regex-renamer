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

import br.com.renatoccosta.renamer.element.base.EmptyElement;
import br.com.renatoccosta.renamer.exception.InvalidParameterException;
import br.com.renatoccosta.renamer.i18n.Messages;
import java.io.File;

/**
 * Element that creates sequencial indexes to enumerate the files. It's possible
 * to specify the starting index and the leading zeros.
 *
 * e.g.
 * Replace: <idx init='0' leading='3'/>
 * Result: 000, 001, 002, ...
 *
 * Replace: <idx init='5'/>
 * Result: 5, 6, 7, ...
 *
 * @author renato
 */
public class IndexedElement extends EmptyElement {

    public static final String NAME = "idx";

    private int init = 0;

    private int contOriginal = 0;

    private int leading = 1;

    /* ---------------------------------------------------------------------- */
    @Override
    public void setParameter(String name, String value) throws
            InvalidParameterException {
        if ("init".equals(name)) {
            try {
                this.init = Integer.parseInt(value);
                this.contOriginal = init;
            } catch (NumberFormatException ex) {
                throw new InvalidParameterException(ex);
            }
        } else if ("leading".equals(name)) {
            try {
                this.leading = Integer.parseInt(value);
            } catch (NumberFormatException ex) {
                throw new InvalidParameterException(ex);
            }
        } else {
            throw new InvalidParameterException(
                    Messages.getInvalidParameterName(name));
        }
    }

    @Override
    public String getParameter(String name) throws InvalidParameterException {
        if ("init".equals(name)) {
            return Integer.toString(this.init);
        } else if ("leading".equals(name)) {
            return Integer.toString(this.leading);
        } else {
            throw new InvalidParameterException(
                    Messages.getInvalidParameterName(name));
        }
    }

    @Override
    public String[] getParameterNames() {
        return new String[]{"init", "leading"};
    }

    @Override
    public String[] getParameterValues() {
        return new String[]{String.valueOf(contOriginal),
                    String.valueOf(leading)};
    }

    /* ---------------------------------------------------------------------- */
    @Override
    public String getContent(String find, String target, File file) {
        return String.format("%0" + leading + "d", init++);
    }

    @Override
    public void resetState() {
        this.init = contOriginal;
    }

}
