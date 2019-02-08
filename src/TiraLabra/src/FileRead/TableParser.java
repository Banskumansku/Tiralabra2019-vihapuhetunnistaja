/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileRead;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectStreamConstants;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

/**
 *
 * @author jan
 */
public class TableParser {

    public TableParser() {
    }

    /**
     *
     * @return return default csv parser with stormfront data
     */
    public static CSVParser parserDefault() {
        String file = System.getProperty("user.dir") + "/lib/alltextsandannotations.csv";

        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(file));
            CSVParser csvParser = new CSVParser(br, CSVFormat.DEFAULT);
            return csvParser;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TableParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TableParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     *
     * @return asks and generates parser for any properly indexed csv file
     */
    public static CSVParser parser() {
        System.out.println("Give csv file, second index (1) must be data and 53rd must be classifier, hatespeech must be classified as \"hate\"");
        Scanner s = new Scanner(System.in);
        String file = s.nextLine();

        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(file));
            CSVParser csvParser = new CSVParser(br, CSVFormat.DEFAULT);
            return csvParser;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TableParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TableParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
