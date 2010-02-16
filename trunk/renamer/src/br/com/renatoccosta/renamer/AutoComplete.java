/*
 *  Copyright 2010 Renato Couto da Costa.
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
package br.com.renatoccosta.renamer;

import br.com.renatoccosta.renamer.element.base.ElementsDirectory;
import br.com.renatoccosta.renamer.exception.ElementNotFoundException;
import br.com.renatoccosta.renamer.exception.RenamerSemanticException;
import br.com.renatoccosta.renamer.parser.GrammarLexer;
import java.util.ArrayList;
import java.util.List;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;

/**
 * Class that has the rules to identify whether an auto-complete intention
 * proceeds and indicates what kind of auto-complete should be done.
 *
 * It doesn't tell how the complete dialog box should be displayed. Rather, it
 * only returns the options that should be displayed.
 *
 * @author Renato Costa
 */
public class AutoComplete {

    /**
     * Process an auto-complete intention based on the errors returned by an
     * analisys of the text and the carret position on the code box.
     *
     * @param errors Errors returned by an analisys
     * @param carretPosition Carret position on the code box.
     * @return A list of auto-complete options to be displayed to the user
     */
    public static List<String> process(List<RecognitionException> errors,
            int carretPosition) {
        List<String> options = new ArrayList<String>();

        for (RecognitionException re : errors) {
            if (re.charPositionInLine == carretPosition) {
                if (re instanceof NoViableAltException) {
                    //decisionNumber = 3 means that the parser found an error on
                    //the variableExpression rule
                    if (((NoViableAltException) re).decisionNumber == 3) {
                        options.addAll(ElementsDirectory.getInstance().
                                getMapId().keySet());
                    }

                } else if (re instanceof EarlyExitException) {
                    EarlyExitException eee = (EarlyExitException) re;
                    TokenStream ts = (TokenStream) eee.input;

                    //decisionNumber = 6 means that the parser found an error on
                    //the literal rule. If the last token is a colon, means
                    //that is a parameter
                    if ((eee.decisionNumber == 6) &&
                            (ts.LA(-1) == GrammarLexer.COLON)) {
                        System.out.println(ts.LT(-1));
                    }

                } else if (re instanceof RenamerSemanticException &&
                        re.getCause() instanceof ElementNotFoundException) {
                    ElementNotFoundException enfe =
                            (ElementNotFoundException) re.getCause();

                    for (String exp : ElementsDirectory.getInstance().
                            getMapId().keySet()) {
                        if (exp.startsWith(enfe.getElement())) {
                            options.add(exp);
                        }
                    }
                }
            }
        }

        return options;
    }

}
