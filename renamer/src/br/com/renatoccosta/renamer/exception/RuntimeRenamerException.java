
package br.com.renatoccosta.renamer.exception;

import org.antlr.runtime.IntStream;
import org.antlr.runtime.RecognitionException;

/**
 *
 * @author Renato Costa
 */
public class RuntimeRenamerException extends RecognitionException {

    protected String message;

    public RuntimeRenamerException(String message) {
        this.message = message;
    }

    public RuntimeRenamerException(IntStream input) {
        super(input);
    }

    public RuntimeRenamerException() {
    }

    @Override
    public String getMessage() {
        return message;
    }

}
