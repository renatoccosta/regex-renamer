/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.renatoccosta.renamer.exception;

import br.com.renatoccosta.renamer.i18n.Messages;

/**
 *
 * @author renato
 */
public class ElementNotFoundException extends RuntimeRenamerException {

    public ElementNotFoundException(String xpName) {
        super(Messages.getExpressionNotFoundMessage(xpName));
    }

    public ElementNotFoundException() {
    }

}
