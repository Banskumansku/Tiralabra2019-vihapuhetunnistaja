/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;

import Datastructures.Word;
import java.util.ArrayList;
import java.util.HashMap;
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
public class ClassifierTest {
    
    public ClassifierTest() {
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
     * Test of trainClassifier method, of class Classifier.
     */
    @Test
    public void testTrainClassifier() {
        System.out.println("trainClassifier");
        Classifier instance = new Classifier();
        instance.trainClassifier();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of relevant method, of class Classifier.
     */
    @Test
    public void testRelevant() {
        System.out.println("relevant");
        String classifier = "ik/skip";
        Classifier instance = new Classifier();
        
        boolean expResult = false;
        boolean result = instance.relevant(classifier);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of addClass method, of class Classifier.
     */
    @Test
    public void testAddClass() {
        System.out.println("addClass");
        
        String word = "test";
        boolean hate = false;
        HashMap<String, Word> wordObjects = new HashMap<>();
        Word wordTest = new Word("test");
        wordObjects.put(word, wordTest);
        Classifier instance = new Classifier();
        instance.addClass(word, hate);
        int expected = 1;
        int actual = wordObjects.get(word).getNormCount();
        assertEquals(actual, expected);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of isItHate method, of class Classifier.
     */
    @Test
    public void testIsItHate() {
        System.out.println("isItHate");
        String classifier = "hate";
        Classifier instance = new Classifier();
        boolean expResult = true;
        boolean result = instance.isItHate(classifier);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of testClassifier method, of class Classifier.
     */
    @Test
    public void testTestClassifier() {
        System.out.println("testClassifier");
        String test = "test";
        Classifier instance = new Classifier();
        Word word = new Word("test");
        word.setProbOfHate(0.5f);
        ArrayList<Word> result = instance.testClassifier(test);
        assertEquals(word.getWord(), result.get(0).getWord());
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
