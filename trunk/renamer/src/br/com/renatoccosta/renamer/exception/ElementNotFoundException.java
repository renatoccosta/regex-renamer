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
package br.com.renatoccosta.renamer.exception;

import br.com.renatoccosta.renamer.i18n.Messages;

/**
 * Used to indicate that an element was identified during parse but it wasn't
 * found
 * Exceção lançada sempre que um elemento foi identificado durante o parse, mas
 * o mesmo não foi encontrado no registro de elementos.
 * 
 * @author renato
 */
public class ElementNotFoundException extends RuntimeRenamerException {

    public ElementNotFoundException(Throwable cause) {
        super(cause);
    }

    public ElementNotFoundException(String message, Throwable cause) {
        super(Messages.getExpressionNotFoundMessage(message), cause);
    }

    public ElementNotFoundException(String message) {
        super(Messages.getExpressionNotFoundMessage(message));
    }

    public ElementNotFoundException() {
    }

}
