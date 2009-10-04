/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.renatoccosta.renamer.parser;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.RecognizerSharedState;

/**
 *
 * @author renato
 */
public class RenamerLexer extends GramaticaLexer {

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
