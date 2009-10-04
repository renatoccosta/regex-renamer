package br.com.renatoccosta.renamer.parser;

import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.TokenStream;

/**
 *
 * @author renato
 */
public class RenamerParser extends GramaticaParser {

    public RenamerParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public RenamerParser(TokenStream input) {
        super(input);
    }

}
