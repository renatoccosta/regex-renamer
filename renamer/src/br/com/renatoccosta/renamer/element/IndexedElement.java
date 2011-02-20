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
import br.com.renatoccosta.renamer.element.meta.ElementType;
import br.com.renatoccosta.renamer.element.meta.Parameter;
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
@ElementType(id = "idx",
i18n = "br.com.renatoccosta.renamer.i18n.Messages")
public class IndexedElement extends EmptyElement {

    @Parameter
    private int init = 0;

    @Parameter
    private int leading = 1;

    private int contOriginal = 0;

    /* ---------------------------------------------------------------------- */
    public int getInit() {
        return init;
    }

    public void setInit(int init) {
        this.init = init;
        this.contOriginal = init;
    }

    public int getLeading() {
        return leading;
    }

    public void setLeading(int leading) {
        this.leading = leading;
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
