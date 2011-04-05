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
 * Element that changes the case of it's content text. It can upper case,
 * lower case or swap case.
 *
 * e.g.
 * Replace: <case mode='upper'>aBc</case>
 * Result: ABC
 *
 * @author Renato Costa
 */
@ElementType(id="case",
i18n = "br.com.renatoccosta.renamer.i18n.Messages")
public class CaseElement extends CompositeElement {

    public enum CaseEnum {

        UPPER,
        LOWER,
        SWAP

    }

    @Parameter
    private CaseEnum mode = CaseEnum.LOWER;

    /* ---------------------------------------------------------------------- */

    public CaseEnum getMode() {
        return mode;
    }

    public void setMode(CaseEnum mode) {
        this.mode = mode;
    }

    /* ---------------------------------------------------------------------- */

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
