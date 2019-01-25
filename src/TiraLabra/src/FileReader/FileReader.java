/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileReader;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jan
 */
public class FileReader {

    public FileReader() {
    }

    public String[] FileAsString() {
        // pass the path to the file as a parameter 
        String fileName = whatFile();
        String[] wordArray = new String[10000];
        int index = 0;
        File file = new File(fileName);
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (sc.hasNextLine()) {
            wordArray[index] = sc.nextLine();
        }
        return wordArray;
    }
    public String whatFile(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give the name of the file");
        String file = scanner.nextLine();
        return file;
    }
}
