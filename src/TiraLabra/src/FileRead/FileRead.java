/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileRead;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author jan
 */
public class FileRead {

    private Scanner scanner;

    public FileRead() {
        this.scanner = null;
    }

    public HashSet<String> importStopword() {
        //this method is only used for importing the stopwords
        HashSet<String> set = new HashSet<>();
        String fileName = System.getProperty("user.dir") + "/lib/stopwords.txt";
        try {
            this.scanner = new Scanner(new File(fileName));
        } catch (Exception e) {
            System.err.println("No file found");
        }
        while (this.scanner.hasNext()) {
            set.add(this.scanner.next());
        }
        this.scanner.close();
        return set;
    }

    public void openFile() {
        System.out.println(System.getProperty("user.dir"));
        // pass the path to the file as a parameter 
        Scanner asker = new Scanner(System.in);
        System.out.println("Give the name of the file \nMust be in .txt format");
        // this will be used for inputting various training files etc
        // stopwords and lemmatizations will be done when built
        String fileName = asker.nextLine();
        try {
            this.scanner = new Scanner(new File(fileName));
        } catch (Exception e) {
            System.err.println("No file found");
        }

    }

    public List<String> readFile() {
        List<String> lista = new ArrayList<>();
        while (this.scanner.hasNext()) {
            lista.add(this.scanner.next());
        }
        scanner.close();
        return lista;
    }
}
