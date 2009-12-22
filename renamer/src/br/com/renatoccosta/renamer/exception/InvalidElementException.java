
package br.com.renatoccosta.renamer.exception;

import org.antlr.runtime.IntStream;

/**
 *
 * @author Renato Costa
 */
public class InvalidElementException extends RuntimeRenamerException {

    public InvalidElementException() {
    }

    public InvalidElementException(IntStream input) {
        super(input);
    }

    public InvalidElementException(String message) {
        super(message);
    }

}
