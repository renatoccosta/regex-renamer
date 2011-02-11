/*
 *  Copyright 2011 Renato Couto da Costa.
 * 
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *  under the License.
 */

package br.com.renatoccosta.renamer.element.base;

import junit.framework.TestCase;

/**
 *
 * @author Renato Costa
 */
public class ElementFactoryTest extends TestCase {
    
    public ElementFactoryTest(String testName) {
        super(testName);
    }

    public void testCompile() throws Exception {
        System.out.println("compile");
        String alias = "";
        Element expResult = null;
        Element result = ElementFactory.compile(alias);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public void testSetProperty() throws Exception {
        System.out.println("setProperty");
        Element element = null;
        String name = "";
        String value = "";
        ElementFactory.setProperty(element, name, value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
