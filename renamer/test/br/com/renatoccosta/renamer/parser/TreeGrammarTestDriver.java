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
package br.com.renatoccosta.renamer.parser;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;

/**
 *
 * @author Renato Couto da Costa
 */
public class TreeGrammarTestDriver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        CommonTokenStream tokens = new CommonTokenStream();

        InputStream stream = new ByteArrayInputStream(
                "${idx}${filter}${/filter}${/idx}".getBytes());

        ANTLRInputStream input = new ANTLRInputStream(stream);
        Lexer lexer = new GrammarLexer(input);
        tokens.setTokenSource(lexer);

        GrammarParser parser = new GrammarParser(tokens);
        GrammarParser.begin_return example = parser.begin();

        CommonTreeNodeStream nodes;

        CommonTree tree = (CommonTree) example.getTree();
        nodes = new CommonTreeNodeStream(tree);

        TreeGrammar walker = new TreeGrammar(nodes);

        walker.begin();
        System.out.println(example.toString());

        System.exit(0);

    }

}
