/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Preprocess;

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
public class TokenizerTest {
    
    public TokenizerTest() {
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
     * Test of tokenize method, of class Tokenizer.
     */
    @Test
    public void testTokenize() {
        System.out.println("tokenize");
        String line = "";
        Tokenizer instance = new Tokenizer();
        String[] expResult = new String[1];
        expResult[0] = "";
        String[] result = instance.tokenize(line);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
