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
 * Element that replaces all the occurrences of a character with another one
 * Elemento que substitui todas as ocorrências de um caractere por outro no
 * conteúdo dos próximos elementos.
 *
 * @author Renato Costa
 */
public class ReplaceElement extends CompositeElement {

    private String from;

    private String to;

    /* ---------------------------------------------------------------------- */
    @Override
    public void setParameter(String name, String value) throws
            InvalidParameterException {
        if ("from".equals(name)) {
            this.from = value;
        } else if ("to".equals(name)) {
            this.to = value;
        } else {
            throw new InvalidParameterException(
                    Messages.getInvalidParameterName(name));
        }
    }

    @Override
    public String getParameter(String name) throws InvalidParameterException {
        if ("from".equals(name)) {
            return this.from;
        } else if ("to".equals(name)) {
            return this.to;
        } else {
            throw new InvalidParameterException(
                    Messages.getInvalidParameterName(name));
        }
    }

    @Override
    public String[] getParameterNames() {
        return new String[]{"from", "to"};
    }

    @Override
    public String[] getParameterValues() {
        return new String[]{from, to};
    }

    /* ---------------------------------------------------------------------- */
    
    @Override
    public String convert(String src) {
        return StringUtils.replace(src, from, to);
    }

}
