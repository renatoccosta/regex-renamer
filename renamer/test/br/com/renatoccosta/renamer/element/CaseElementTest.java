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

    public void testConvertUpper() {
        System.out.println("convertUpper");

        String src = "renATO";
        CaseElement instance = new CaseElement();
        instance.setMode(CaseElement.CaseEnum.UPPER);

        String expResult = "RENATO";
        String result = instance.convert(src);

        assertEquals(expResult, result);
    }

    public void testConvertLower() {
        System.out.println("convertLower");

        String src = "renATO";
        CaseElement instance = new CaseElement();
        instance.setMode(CaseElement.CaseEnum.LOWER);

        String expResult = "renato";
        String result = instance.convert(src);

        assertEquals(expResult, result);
    }

    public void testConvertSwap() {
        System.out.println("convertSwap");

        String src = "renATO";
        CaseElement instance = new CaseElement();
        instance.setMode(CaseElement.CaseEnum.SWAP);

        String expResult = "RENato";
        String result = instance.convert(src);

        assertEquals(expResult, result);
    }

}
