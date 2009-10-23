
package br.com.renatoccosta.renamer.exception;

/**
 *
 * @author Renato Costa
 */
public class RuntimeRenamerException extends RuntimeException {

    public RuntimeRenamerException(Throwable cause) {
        super(cause);
    }

    public RuntimeRenamerException(String message, Throwable cause) {
        super(message, cause);
    }

    public RuntimeRenamerException(String message) {
        super(message);
    }

    public RuntimeRenamerException() {
    }

}
