/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.renatoccosta.renamer;

/**
 *
 * @author renato
 */
public class RenamerException extends Exception {

    public RenamerException(Throwable cause) {
        super(cause);
    }

    public RenamerException(String message, Throwable cause) {
        super(message, cause);
    }

    public RenamerException(String message) {
        super(message);
    }

    public RenamerException() {
    }

}
