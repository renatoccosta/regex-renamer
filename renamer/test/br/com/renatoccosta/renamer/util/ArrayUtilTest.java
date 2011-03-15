/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.renatoccosta.renamer.util;

import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;

/**
 *
 * @author renato
 */
public class ArrayUtilTest extends TestCase {

    public ArrayUtilTest(String testName) {
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

    public void testMoveBlockOneElementUp() throws Exception {
        System.out.println("testMoveBlockOneElementUp");

        List<String> source = generateList();

        ArrayUtil.moveBlock(source, -2, new int[]{3});

        String expResult = "[a, d, b, c, e, f, g, h]";

        assertEquals(expResult, source.toString());
    }

    public void testMoveBlockOneElementDown() throws Exception {
        System.out.println("testMoveBlockOneElementDown");

        List<String> source = generateList();

        ArrayUtil.moveBlock(source, 2, new int[]{3});

        String expResult = "[a, b, c, e, f, d, g, h]";

        assertEquals(expResult, source.toString());
    }

    public void testMoveBlockMultipleElementUp() throws Exception {
        System.out.println("testMoveBlockMultipleElementUp");

        List<String> source = generateList();

        ArrayUtil.moveBlock(source, -2, new int[]{3, 4});

        String expResult = "[a, d, e, b, c, f, g, h]";

        assertEquals(expResult, source.toString());
    }

    public void testMoveBlockMultipleElementDown() throws Exception {
        System.out.println("testMoveBlockMultipleElementDown");

        List<String> source = generateList();

        ArrayUtil.moveBlock(source, 2, new int[] {3, 4});

        String expResult = "[a, b, c, f, g, d, e, h]";

        assertEquals(expResult, source.toString());
    }

    private List<String> generateList() {
        List<String> source = new ArrayList<String>();
        source.add("a");
        source.add("b");
        source.add("c");
        source.add("d");
        source.add("e");
        source.add("f");
        source.add("g");
        source.add("h");

        return source;
    }

}
