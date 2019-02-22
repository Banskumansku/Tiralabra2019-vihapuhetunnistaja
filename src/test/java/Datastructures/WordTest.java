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
public class WordTest {

    public WordTest() {
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
     * Test of countHate method, of class Word.
     */
    @Test
    public void testCountHate() {
        System.out.println("countHate");
        Word instance = new Word("test");
        instance.countHate();
        int expResult = 1;
        int result = instance.getHateCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of countNorm method, of class Word.
     */
    @Test
    public void testCountNorm() {
        System.out.println("countNorm");
        Word instance = new Word("test");
        instance.countNorm();
        int expResult = 1;
        int result = instance.getNormCount();
        assertEquals(expResult, result);
    }

    /**
     * Test of calculateProbability method, of class Word.
     */
    @Test
    public void testCalculateProbability() {
        System.out.println("calculateProbability");
        int totHate = 3;
        int totNorm = 3;
        Word instance = new Word("test");
        instance.countHate();
        instance.countHate();
        instance.countHate();
        
        instance.calculateProbability(totNorm, totHate);
        double expected = 0.9999;
        double actual = instance.getProbOfHate();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(expected, actual, 0);
    }

    /**
     * Test of getWord method, of class Word.
     */
    @Test
    public void testGetWord() {
        System.out.println("getWord");
        Word instance = new Word("test");
        String expResult = "test";
        String result = instance.getWord();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getHateRate method, of class Word.
     */
    @Test
    public void testGetHateRate() {
        System.out.println("getHateRate");
        Word instance = new Word("test");
        instance.setHateRate(0.5);
        double expResult = 0.5;
        double result = instance.getHateRate();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getNormRate method, of class Word.
     */
    @Test
    public void testGetNormRate() {
        System.out.println("getNormRate");
        Word instance = new Word("test");
        instance.setNormRate(0.5);
        double expResult = 0.5;
        double result = instance.getNormRate();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setNormRate method, of class Word.
     */
    @Test
    public void testSetNormRate() {
        System.out.println("setNormRate");
        double normRate = 0.0;
        Word instance = new Word("test");
        instance.setNormRate(normRate);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(normRate, instance.getNormRate(), 0);
    }

    /**
     * Test of getProbOfHate method, of class Word.
     */
    @Test
    public void testGetProbOfHate() {
        System.out.println("getProbOfHate");
        Word instance = new Word("test");
        double expResult = 0.0;
        double result = instance.getProbOfHate();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setProbOfHate method, of class Word.
     */
    @Test
    public void testSetProbOfHate() {
        System.out.println("setProbOfHate");
        double probOfHate = 0.0;
        Word instance = new Word("test");
        instance.setProbOfHate(probOfHate);
        double expected = 0;
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(probOfHate, expected, 0);
    }

}
