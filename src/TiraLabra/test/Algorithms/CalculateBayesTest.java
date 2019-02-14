/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;

import Datastructures.Word;
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
public class CalculateBayesTest {
    
    public CalculateBayesTest() {
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
     * Test of calculateBayes method, of class CalculateBayes.
     */
    @Test
    public void testCalculateBayes() {
        System.out.println("calculateBayes");
        Word line[] = new Word[1];
        Word word = new Word("test");
        word.setProbOfHate((float) 0.5);
        line[0] = word;
        
        boolean expResult = false;
        boolean result = CalculateBayes.calculateBayes(line);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of percentageBayes method, of class CalculateBayes.
     */
    @Test
    public void testPercentageBayes() {
        System.out.println("percentageBayes");
        Word line[] = new Word[1];
        Word word = new Word("test");
        word.setProbOfHate((float) 0.5);
        line[0] = word;
        float expResult = 0.5f;
        float result = CalculateBayes.percentageBayes(line);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
