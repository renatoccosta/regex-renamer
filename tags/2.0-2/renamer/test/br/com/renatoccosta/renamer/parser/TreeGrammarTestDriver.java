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

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
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

        CharStream input = new ANTLRStringStream(
                "${idx}${filter}${/filter}${/idx}");
        Lexer lexer = new RenamerLexer(input);
        tokens.setTokenSource(lexer);

        RenamerParser parser = new RenamerParser(tokens);
        RenamerParser.document_return example = parser.document();

        CommonTreeNodeStream nodes;

        CommonTree tree = (CommonTree) example.getTree();
        nodes = new CommonTreeNodeStream(tree);

        RenamerTreeParser walker = new RenamerTreeParser(nodes);

        walker.document();
        System.out.println(example.toString());

        System.exit(0);
    }

}
