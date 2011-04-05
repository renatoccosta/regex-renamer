/*
 *  Copyright 2011 Renato Couto da Costa.
 * 
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *  under the License.
 */
package br.com.renatoccosta.regexrenamer.api.element;

import br.com.renatoccosta.regexrenamer.api.element.Element;
import br.com.renatoccosta.regexrenamer.api.InvalidElementException;
import br.com.renatoccosta.regexrenamer.i18n.Messages;

/**
 *
 * @author Renato Costa
 */
public abstract class EmptyElement extends Element {

    @Override
    public void add(Element element) throws InvalidElementException {
        throw new InvalidElementException(
                Messages.getEmptyElementChildsMessage(element.getId()));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString());

        sb.append("/>");

        return sb.toString();
    }

}