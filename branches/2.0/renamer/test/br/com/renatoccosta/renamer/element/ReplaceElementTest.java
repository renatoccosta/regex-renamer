package br.com.renatoccosta.renamer.element;

import junit.framework.TestCase;

/**
 *
 * @author Renato Costa
 */
public class ReplaceElementTest extends TestCase {

    public ReplaceElementTest(String testName) {
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

    public void testConvert() {
        System.out.println("convert");

        String src = "renato";
        ReplaceElement instance = new ReplaceElement();
        instance.setFrom("e");
        instance.setTo("3");

        String expResult = "r3nato";
        String result = instance.convert(src);

        assertEquals(expResult, result);
    }

}
