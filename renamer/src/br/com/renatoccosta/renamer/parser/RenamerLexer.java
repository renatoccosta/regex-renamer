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

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.RecognizerSharedState;

/**
 *
 * @author renato
 */
public class RenamerLexer extends GrammarLexer {

    public RenamerLexer(CharStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public RenamerLexer(CharStream input) {
        super(input);
    }

    public RenamerLexer() {
    }

    public RenamerLexer(String input) {
        super(new ANTLRStringStream(input));
    }

}
