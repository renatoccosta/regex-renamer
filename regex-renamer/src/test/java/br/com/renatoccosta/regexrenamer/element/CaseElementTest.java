package br.com.renatoccosta.renamer.element;

import br.com.renatoccosta.regexrenamer.api.RenamerException;
import br.com.renatoccosta.regexrenamer.element.CaseElement;
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
        String result;

        try {
            result = instance.getContent(src, src, null);
            assertEquals(expResult, result);
        } catch (RenamerException ex) {
            fail(ex.getMessage());
        }
    }

    public void testConvertLower() {
        System.out.println("convertLower");

        String src = "renATO";
        CaseElement instance = new CaseElement();
        instance.setMode(CaseElement.CaseEnum.LOWER);

        String expResult = "renato";
        String result;

        try {
            result = instance.getContent(src, src, null);
            assertEquals(expResult, result);
        } catch (RenamerException ex) {
            fail(ex.getMessage());
        }
    }

    public void testConvertSwap() {
        System.out.println("convertSwap");

        String src = "renATO";
        CaseElement instance = new CaseElement();
        instance.setMode(CaseElement.CaseEnum.SWAP);

        String expResult = "RENato";
        String result;

        try {
            result = instance.getContent(src, src, null);
            assertEquals(expResult, result);
        } catch (RenamerException ex) {
            fail(ex.getMessage());
        }
    }

}
