/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datastructures;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jan
 */
public class SetTest {
    
    public SetTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of contains method, of class Set.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        Object haku = new Word("test");
        Set instance = new Set();
        instance.add(haku);
        boolean expResult = true;
        boolean result = instance.contains(haku);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of add method, of class Set.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Object a = new Word("test");
        Set instance = new Set();
        boolean expResult = true;
        boolean result = instance.add(a);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getSize method, of class Set.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        Set instance = new Set();
        int expResult = 1;
        instance.add(new Word("test"));
        int result = instance.size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
