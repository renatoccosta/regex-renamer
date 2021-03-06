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

import br.com.renatoccosta.regexrenamer.api.element.EmptyElement;
import br.com.renatoccosta.regexrenamer.api.exception.RenamerException;
import java.io.File;

/**
 *
 * @author Renato Costa
 */
public class Id3Element extends EmptyElement {

    @Override
    public String getContent(String find, String target, File file) throws
            RenamerException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
