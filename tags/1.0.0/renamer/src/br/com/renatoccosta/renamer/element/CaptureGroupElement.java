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

import br.com.renatoccosta.renamer.element.base.*;
import br.com.renatoccosta.renamer.exception.RenamerException;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Elemento que representa um grupo de captura da expressão regular definida no
 * localizar. Seu conteúdo é o texto do grupo de captura.
 *
 * Ex: $1
 * Localizar: ([0-9]*).+
 * Texto: 1teste
 * Retorno: 1
 *
 * @author renato
 */
public class CaptureGroupElement extends ContentElement {

    private int groupNumber = 0;

    private Pattern patternFind;

    public CaptureGroupElement() {
    }

    public CaptureGroupElement(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    @Override
    public String[] getParameters() {
        return new String[] {String.valueOf(groupNumber)};
    }

    @Override
    public void setParameters(String... groupNumber) {
        this.groupNumber = Integer.parseInt(groupNumber[0]);
    }

    @Override
    public String getContent(String find, String target, File file) throws
            RenamerException {
        if (patternFind == null) {
            patternFind = Pattern.compile(find);
        }

        Matcher matcher = patternFind.matcher(target);
        matcher.find();

        try {
            return matcher.group(groupNumber);
        } catch (IllegalStateException e) {
            throw new RenamerException(e);
        } catch (IndexOutOfBoundsException e) {
            throw new RenamerException(e);
        }
    }

    @Override
    public String toString() {
        return "$" + groupNumber;
    }

    @Override
    public void resetState() {
        
    }

}
