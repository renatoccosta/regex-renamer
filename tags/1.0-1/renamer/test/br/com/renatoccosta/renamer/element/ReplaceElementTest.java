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

    public void testSetParameters() {
        System.out.println("setParameters");

        ReplaceElement instance = new ReplaceElement();

        instance.setParameters("a", "4");
    }

    public void testSetParametersInvalido() {
        System.out.println("setParameters");

        ReplaceElement instance = new ReplaceElement();

        try {
            instance.setParameters("a");
            fail("Não foi lançada uma exceção");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    public void testConvert() {
        System.out.println("convert");

        String src = "renato";
        ReplaceElement instance = new ReplaceElement();
        instance.setParameters("e", "3", "a", "4", "o", "0");

        String expResult = "r3n4t0";
        String result = instance.convert(src);

        assertEquals(expResult, result);
    }

}
