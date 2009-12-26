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

import br.com.renatoccosta.renamer.element.base.StreamChangeElement;
import br.com.renatoccosta.renamer.i18n.Messages;
import org.apache.commons.lang.StringUtils;

/**
 * Elemento que substitui todas as ocorrências de um caractere por outro no
 * conteúdo dos próximos elementos.
 *
 * @author Renato Costa
 */
public class ReplaceElement extends StreamChangeElement {

    private String[] de = new String[] {""};

    private String[] para = new String[] {""};

    @Override
    public String[] getParameters() {
        String[] parms = new String[de.length + para.length];

        for (int i = 0; i < parms.length; i+=2) {
            parms[i] = de[i/2];
            parms[i+1] = para[i/2];
        }

        return parms;
    }

    @Override
    public void setParameters(String... content) {
        if (content.length % 2 > 0) {
            throw new IllegalArgumentException(
                    Messages.getReplaceElementInvalidNumberParametersMessage());
        }

        de = new String[content.length / 2];

        para = new String[content.length / 2];

        for (int i = 0; i < content.length; i+=2) {
            de[i/2] = content[i];
            para[i/2] = content[i+1];
        }
    }

    @Override
    public String convert(String src) {
        return StringUtils.replaceEach(src, de, para);
    }

}
