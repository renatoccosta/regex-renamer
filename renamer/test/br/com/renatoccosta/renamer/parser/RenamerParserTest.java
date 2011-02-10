package br.com.renatoccosta.renamer.parser;

import junit.framework.TestCase;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.runtime.tree.Tree;

/**
 *
 * @author Renato
 */
public class RenamerParserTest extends TestCase {

    public RenamerParserTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testCompleto() throws Exception {
        System.out.println("testCompleto");

        String replaceString = "1234<abc pro='prop1'>1234</abc>123456";

        CharStream input = new ANTLRStringStream(replaceString);
        Lexer lex = new RenamerLexer(input);

        CommonTokenStream tokens = new CommonTokenStream(lex);
        RenamerParser parser = new RenamerParser(tokens);
        RenamerParser.document_return root = parser.document();

        System.out.println("tree=" + ((Tree) root.tree).toStringTree());

        CommonTreeNodeStream nodes = new CommonTreeNodeStream((Tree) root.tree);
        RenamerTreeParser walker = new RenamerTreeParser(nodes);
        walker.document();

        walker.

        assertTrue(true);
    }

}
