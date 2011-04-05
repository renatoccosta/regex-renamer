/*
 *  Copyright 2010 Renato.
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

package br.com.renatoccosta.regexrenamer.exception;

import br.com.renatoccosta.regexrenamer.api.RenamerException;
import org.antlr.runtime.IntStream;
import org.antlr.runtime.RecognitionException;

/**
 * Exception class to indicate a semantic error in the input text while the
 * parser was running. These exceptions usually encapsulate other Renamer
 * exceptions, preserving it's original messages and adding the input context
 * the parser has.
 *
 * @author Renato Costa
 */
public class RenamerSemanticException extends RecognitionException {

    private RenamerException cause;

    public RenamerSemanticException(IntStream input) {
        super(input);
    }

    public RenamerSemanticException(IntStream input, RenamerException cause) {
        super(input);
        this.cause = cause;
    }

    public RenamerSemanticException() {
    }

    @Override
    public String getMessage() {
        return cause.getMessage();
    }

    @Override
    public Throwable getCause() {
        return cause;
    }

}
