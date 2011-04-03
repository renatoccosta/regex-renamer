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
import br.com.renatoccosta.renamer.exception.RenamerException;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Element that represents a capturing group of the regular expression defined
 * on the search string. It's content is the text of the capture group. The '0'
 * index means the whole string and 1,2,3... means the group numbers.
 *
 * e.g.
 * Text: 123abc
 * Search: ([0-9]+).*
 * Replace: &lt;group idx='1'/&gt;
 * Result: 123
 *
 * @author renato
 */
@ElementType(id = "group",
i18n = "br.com.renatoccosta.renamer.i18n.Messages")
public class CaptureGroupElement extends EmptyElement {

    @Parameter
    private int idx = 0;

    private Pattern patternFind;

    /* ---------------------------------------------------------------------- */
    public CaptureGroupElement() {
    }

    public CaptureGroupElement(int groupNumber) {
        this.idx = groupNumber;
    }

    /* ---------------------------------------------------------------------- */
    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        if (idx < 0) {
            throw new IndexOutOfBoundsException();
        }

        this.idx = idx;
    }

    /* ---------------------------------------------------------------------- */
    @Override
    public String getContent(String find, String target, File file) throws
            RenamerException {

        if (patternFind == null) {
            patternFind = Pattern.compile(find);
        }

        Matcher matcher = patternFind.matcher(target);
        matcher.find();

        try {
            return matcher.group(idx);
        } catch (IllegalStateException e) {
            throw new RenamerException(e);
        } catch (IndexOutOfBoundsException e) {
            throw new RenamerException(e);
        }
    }

}
