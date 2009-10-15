
package br.com.renatoccosta.renamer.element;

import java.io.File;
import junit.framework.TestCase;

/**
 *
 * @author Renato Costa
 */
public class CaptureGroupElementTest extends TestCase {
    
    public CaptureGroupElementTest(String testName) {
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
        CaptureGroupElement instance = new CaptureGroupElement();

        instance.setParameters("1");
    }

    public void testGetContent() {
        System.out.println("getContent");

        String find = ".*?(a+).*";
        String target = "renaaaato";
        File file = null;
        CaptureGroupElement instance = new CaptureGroupElement();
        instance.setParameters("1");

        String expResult = "aaaa";
        String result = instance.getContent(find, target, file);

        assertEquals(expResult, result);
    }

}
