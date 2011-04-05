
package br.com.renatoccosta.renamer.element.base;

import br.com.renatoccosta.regexrenamer.element.base.ElementsDirectory;
import br.com.renatoccosta.regexrenamer.element.CaseElement;
import br.com.renatoccosta.regexrenamer.exception.ElementNotFoundException;
import junit.framework.TestCase;

/**
 *
 * @author Renato Costa
 */
public class ElementsDirectoryTest extends TestCase {
    
    public ElementsDirectoryTest(String testName) {
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

    public void testInitialize() throws Exception {
        System.out.println("initialize");
    }

    public void testLookup() throws ElementNotFoundException {
        System.out.println("lookup");
        String id = "case";
        Class expResult = CaseElement.class;
        Class result = ElementsDirectory.getInstance().lookup(id);
        assertEquals(expResult, result);
    }

}
