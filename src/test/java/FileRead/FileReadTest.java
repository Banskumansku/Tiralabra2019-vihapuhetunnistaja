/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileRead;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import Datastructures.Set;

/**
 *
 * @author jan
 */
public class FileReadTest {

    public FileReadTest() {
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
     * Test of importStopword method, of class FileRead.
     */
    @Test
    public void testImportStopword() {
        System.out.println("importStopword");
        FileRead instance = new FileRead();
        Set<String> result = instance.importStopword();
        assertTrue(result.contains("and"));
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of openFile method, of class FileRead.
     *
    @Test
    public void testOpenFile() {
        // use file path String fileName = System.getProperty("user.dir") + "/lib/stopwords.txt";
        System.out.println("openFile");
        FileRead instance = new FileRead();
        boolean open = instance.openFile();
        assertTrue(open);
    } */

    /**
     * Test of readFile method, of class FileRead.
     */
    /*    @Test
    public void testReadFile() {
        System.out.println("readFile");
        FileRead instance = new FileRead();
        boolean open = instance.openFile();
        HashSet<String> expResult = instance.importStopword();
        String[] variable = instance.readFile();
        HashSet<String> result = new HashSet<>();
        for (String string : variable) {
            result.add(string);
        }
        assertEquals(expResult, result);
    }
     */
}
