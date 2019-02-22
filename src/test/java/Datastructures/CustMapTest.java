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
 * @author Jan
 */
public class CustMapTest {

    public CustMapTest() {
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
     * Test of put method, of class HashMapCustom.
     */
    @Test
    public void testPut() {
        System.out.println("put");
        CustMap instance = new CustMap();
        for (int i = 0; i < 200; i++) {
            instance.put(i, i);
        }
        int a = 200;
        
        assertEquals(instance.size(), a);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of get method, of class HashMapCustom.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        CustMap instance = new CustMap();
        instance.put(1, 12);
        Object expResult = 12;
        Object result = instance.get(1);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of remove method, of class HashMapCustom.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        CustMap instance = new CustMap();
        instance.put(12, 21);
        instance.put(13, 24);
        instance.put(14, 24);
        instance.put(15, 24);
        instance.put(16, 24);
        for (Object object : instance.keySet()) {
           instance.remove(object);
        }
        int i = instance.size();
        int exp = 0;
        int result = i;
        assertEquals(exp, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of keySet method, of class HashMapCustom.
     */
    @Test
    public void testKeySet() {
        System.out.println("keySet");
        CustMap instance = new CustMap();
        instance.put(1, 2);
        instance.put(2, 2);
        instance.put(3, 2);
        instance.put(4, 2);
        instance.put(5, 2);
        Object[] expResult = new Object[instance.size()];
        for (int i = 0; i < instance.size(); i++) {
            expResult[i] = i + 1;
        }
        Object[] result = instance.keySet();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getSize method, of class HashMapCustom.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        CustMap instance = new CustMap();
        int expResult = 3;
        instance.put(2, "foo");
        instance.put(3, "foo");
        instance.put(4, "foo");
        instance.put(5, "foo");
        instance.remove(2);
        int result = instance.size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of contains method, of class HashMapCustom.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        CustMap instance = new CustMap();
        instance.put(1, 1);
        instance.put(2, 1);
        instance.put(3, 1);
        instance.put(4, 1);
        instance.put(5, 1);
        instance.put(6, 1);
        instance.put(7, 1);
        instance.put(1, 1);
        instance.put(1, 1);
        instance.put(1, 1);
        boolean expResult = true;
        boolean result = instance.contains(7);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

}
