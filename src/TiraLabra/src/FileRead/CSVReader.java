/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileRead;

/**
 *
 * @author jan
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CSVReader {

    public void CSVread() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Training file location");
        String file = scanner.nextLine();
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] typeOfSpeech = line.split(cvsSplitBy);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
