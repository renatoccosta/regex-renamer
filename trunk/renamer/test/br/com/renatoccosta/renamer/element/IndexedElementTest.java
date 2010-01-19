package br.com.renatoccosta.renamer.element;

import java.io.File;
import junit.framework.TestCase;

/**
 *
 * @author Renato Costa
 */
public class IndexedElementTest extends TestCase {
    
    public IndexedElementTest(String testName) {
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

        IndexedElement instance = new IndexedElement();
        instance.setParameters("1", "2");
    }

    public void testGetContent() {
        System.out.println("getContent");

        String find = "";
        String target = "";
        File file = null;
        IndexedElement instance = new IndexedElement();
        instance.setParameters("1", "2");

        assertEquals("01", instance.getContent(find, target, file));

        assertEquals("02", instance.getContent(find, target, file));
    }

}
