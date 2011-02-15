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
import br.com.renatoccosta.renamer.element.meta.ElementType;
import br.com.renatoccosta.renamer.element.meta.Parameter;
import org.apache.commons.lang.StringUtils;

/**
 * Element that replaces all the occurrences of a character with another one
 * Elemento que substitui todas as ocorrências de um caractere por outro no
 * conteúdo dos próximos elementos.
 *
 * @author Renato Costa
 */
@ElementType(id="replace")
public class ReplaceElement extends CompositeElement {

    @Parameter
    private String from;

    @Parameter
    private String to;

    /* ---------------------------------------------------------------------- */
    
    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    /* ---------------------------------------------------------------------- */
    
    @Override
    public String convert(String src) {
        return StringUtils.replace(src, from, to);
    }

}
