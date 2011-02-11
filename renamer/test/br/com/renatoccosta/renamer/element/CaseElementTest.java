package br.com.renatoccosta.renamer.element;

import junit.framework.TestCase;

/**
 *
 * @author Renato Costa
 */
public class CaseElementTest extends TestCase {
    
    public CaseElementTest(String testName) {
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

        CaseElement instance = new CaseElement();
//        instance.setParameters("upper");
    }

    public void testSetParametersInvalido() {
        System.out.println("setParametersInvalido");

        CaseElement instance = new CaseElement();

        try {
//            instance.setParameters("test");
            fail("Não foi lançada uma exceção");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    public void testConvertUpper() {
        System.out.println("convertUpper");

        String src = "renATO";
        CaseElement instance = new CaseElement();
//        instance.setParameters("upper");

        String expResult = "RENATO";
        String result = instance.convert(src);

        assertEquals(expResult, result);
    }

    public void testConvertLower() {
        System.out.println("convertLower");

        String src = "renATO";
        CaseElement instance = new CaseElement();
//        instance.setParameters("lower");

        String expResult = "renato";
        String result = instance.convert(src);

        assertEquals(expResult, result);
    }

    public void testConvertSwap() {
        System.out.println("convertSwap");

        String src = "renATO";
        CaseElement instance = new CaseElement();
//        instance.setParameters("swap");

        String expResult = "RENato";
        String result = instance.convert(src);

        assertEquals(expResult, result);
    }

}
