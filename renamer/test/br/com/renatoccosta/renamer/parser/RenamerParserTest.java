package br.com.renatoccosta.renamer.parser;

import junit.framework.TestCase;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;

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

    public void testCompleto() throws RecognitionException {
        System.out.println("testCompleto");

        String exemplo = "abc$1 $2${idx:1:3}";
        RenamerLexer lexer = new RenamerLexer(exemplo);
        CommonTokenStream cts = new CommonTokenStream(lexer);
        RenamerParser instance = new RenamerParser(cts);

        instance.inicio();

//        String expected = "123abc$1 $2001";
//        String actual = instance.root.getConvertedString("renato", null);
//
//        assertEquals(expected, actual);
    }

}
