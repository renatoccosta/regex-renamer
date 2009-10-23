package br.com.renatoccosta.renamer.parser;

import br.com.renatoccosta.renamer.element.ElementDiscovery;
import java.io.File;
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
        ElementDiscovery.initialize();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testCompleto() throws RecognitionException {
        System.out.println("testCompleto");

        String exemplo = "abc$1 ${idx:1:3}";
        RenamerLexer lexer = new RenamerLexer(exemplo);
        CommonTokenStream cts = new CommonTokenStream(lexer);
        RenamerParser instance = new RenamerParser(cts);

        instance.inicio();

        String expected = "abcrenato 001";
        String actual = instance.root.getContent("(.+)", "renato",
                new File("teste.txt"));

        assertEquals(expected, actual);
    }

}
