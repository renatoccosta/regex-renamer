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
import java.io.File;

/**
 *
 * @author Renato Costa
 */
public class ExifElement extends EmptyElement {

    @Override
    public void setParameter(String name, String value) throws
            InvalidParameterException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getParameter(String name) throws
            InvalidParameterException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String[] getParameterNames() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String[] getParameterValues() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /* ---------------------------------------------------------------------- */

    @Override
    public String getContent(String find, String target, File file) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void resetState() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
