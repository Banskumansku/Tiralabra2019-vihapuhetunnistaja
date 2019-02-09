/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;

import Datastructures.Word;
import java.util.ArrayList;
import java.util.HashSet;
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
        HashSet<String> stop = new HashSet<>();
        stop.add("what");
        Classifier instance = new Classifier(stop);
        instance.trainClassifier("default");
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of relevant method, of class Classifier.
     */
    /**
     * Test of testClassifier method, of class Classifier.
     */
    @Test
    public void testTestClassifier() {
        System.out.println("testClassifier");
        String test = "test";
        HashSet<String> stop = new HashSet<>();
        stop.add("what");
        Classifier instance = new Classifier(stop);
        Word word = new Word("test");
        word.setProbOfHate(0.5f);
        ArrayList<Word> result = instance.testClassifier(test);
        assertEquals(word.getWord(), result.get(0).getWord());
        // TODO review the generated test code and remove the default call to fail.
    }

}
