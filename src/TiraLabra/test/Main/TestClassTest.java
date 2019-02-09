/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

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
public class TestClassTest {
    
    public TestClassTest() {
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
     * Test of howMany method, of class TestClass.
     */
    @Test
    public void testHowMany() {
        System.out.println("howMany");
        TestClass instance = new TestClass("defaultDatasetTest");
        String expResult = "Out of the " + 1 + " results " + 0 + " were considered hateful and " + 1 + " were considered normal speech.\n"
                + " On average the results were considered " + 0.5 + " hateful";
        String result = instance.howMany();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of isIthate method, of class TestClass.
     */
    @Test
    public void testIsIthate() {
        System.out.println("isIthate");
        String line = "asd";
        TestClass instance = new TestClass("defaultDatasetTest");
        String expResult = "Your string is hatespeech with the probablity of " + 0.5;
        String result = instance.isIthate(line);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
