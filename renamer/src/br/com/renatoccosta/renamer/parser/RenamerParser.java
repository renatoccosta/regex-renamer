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
package br.com.renatoccosta.renamer.parser;

import org.antlr.runtime.MismatchedTokenException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.TokenStream;

/**
 *
 * @author renato
 */
public class RenamerParser extends GramaticaParser {

    private String errorMessage;

    public RenamerParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public RenamerParser(TokenStream input) {
        super(input);
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public void emitErrorMessage(String msg) {
        super.emitErrorMessage(msg);
        this.errorMessage = msg;
    }

    @Override
    public void reportError(RecognitionException e) {
        if (e instanceof MismatchedTokenException) {
            MismatchedTokenException me = (MismatchedTokenException)e;
        }

        System.out.println(e.getClass().getName());
        super.reportError(e);
    }

}
