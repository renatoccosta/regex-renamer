
package br.com.renatoccosta.renamer.element;

import br.com.renatoccosta.regexrenamer.element.FilterElement;
import junit.framework.TestCase;

/**
 *
 * @author Renato Costa
 */
public class FilterElementTest extends TestCase {
    
    public FilterElementTest(String testName) {
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

    public void testConvertFilterNumbers() {
        System.out.println("convertFilterNumbers");

        String src = "r1e2n3a4t5o";
        FilterElement instance = new FilterElement();
        instance.setMode(FilterElement.FilterEnum.NUMBERS);

        String expResult = "renato";
        String result = instance.convert(src);

        assertEquals(expResult, result);
    }

    public void testConvertFilterLetters() {
        System.out.println("convertFilterLetters");

        String src = "r1e2n3a4t5o";
        FilterElement instance = new FilterElement();
        instance.setMode(FilterElement.FilterEnum.LETTERS);

        String expResult = "12345";
        String result = instance.convert(src);

        assertEquals(expResult, result);
    }

    public void testConvertFilterSymbols() {
        System.out.println("convertFilterSymbols");

        String src = "r1!e2@n3#a4$t5%o";
        FilterElement instance = new FilterElement();
//        instance.setParameters("s");

        String expResult = "r1e2n3a4t5o";
        String result = instance.convert(src);

        assertEquals(expResult, result);
    }

    public void testConvertFilterWhiteSpace() {
        System.out.println("convertFilterWhiteSpace");

        String src = "renato costa";
        FilterElement instance = new FilterElement();
        instance.setMode(FilterElement.FilterEnum.WHITE_SPACE);

        String expResult = "renatocosta";
        String result = instance.convert(src);

        assertEquals(expResult, result);
    }

}
