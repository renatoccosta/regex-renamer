
package br.com.renatoccosta.renamer.element;

import junit.framework.TestCase;

/**
 *
 * @author Renato Costa
 */
public class ElementDiscoveryTest extends TestCase {
    
    public ElementDiscoveryTest(String testName) {
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
        ElementDiscovery.initialize();
    }

    public void testLookup() {
        System.out.println("lookup");
        String id = "case";
        Class expResult = CaseElement.class;
        Class result = ElementDiscovery.lookup(id);
        assertEquals(expResult, result);
    }

}
