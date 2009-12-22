/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.renatoccosta.renamer.exception;

import br.com.renatoccosta.renamer.i18n.Messages;
import org.antlr.runtime.IntStream;

/**
 * Exceção lançada sempre que um elemento foi identificado durante o parse, mas
 * o mesmo não foi encontrado no registro de elementos.
 * 
 * @author renato
 */
public class ElementNotFoundException extends RuntimeRenamerException {

    public ElementNotFoundException() {
    }

    public ElementNotFoundException(IntStream input) {
        super(input);
    }

    public ElementNotFoundException(String xpName) {
        super(Messages.getExpressionNotFoundMessage(xpName));
    }

}
