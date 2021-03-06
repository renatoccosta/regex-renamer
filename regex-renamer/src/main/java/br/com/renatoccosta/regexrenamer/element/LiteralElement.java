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
import java.io.File;

/**
 * Element that represents a string literal in the replace string
 * 
 * @author renato
 */
public class LiteralElement extends EmptyElement {

    private String content;

    /* ---------------------------------------------------------------------- */
    public LiteralElement(String content) {
        this.content = content;
    }

    /* ---------------------------------------------------------------------- */

    @Override
    public String getContent(String find, String target, File file) {
        return content;
    }

    @Override
    public String toString() {
        return content;
    }

}
