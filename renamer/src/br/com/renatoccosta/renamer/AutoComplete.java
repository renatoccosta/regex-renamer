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

import br.com.renatoccosta.renamer.exception.ElementNotFoundException;
import br.com.renatoccosta.renamer.exception.RenamerSemanticException;
import java.util.List;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;

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
        for (RecognitionException re : errors) {
            if (re.charPositionInLine == carretPosition) {
                if (re instanceof NoViableAltException) {
                    if (((NoViableAltException) re).decisionNumber == 2) {
                        //executes the autocomplete
                        }
                } else if (re instanceof RenamerSemanticException &&
                        re.getCause() instanceof ElementNotFoundException) {
                    ElementNotFoundException enfe =
                            (ElementNotFoundException) re.getCause();

                }
            }
        }

//        expressions.addAll(ElementsDirectory.getInstance().getMapId().keySet());
//        this.text = text;
//
//        for (String exp : expressions) {
//            if (exp.startsWith(text)) {
//                JMenuItem mnu = createMenuItem(exp);
//                add(mnu);
//            }
//        }

        return null;
    }

}
