/*
 * For some reason buffered reader decided not to work -> Scanner it is
 * Takes in a list of words in a txt file format and returns it as a list
 * to be used by the stopworder and when user wants to add own txt files
 */
package FileRead;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.HashSet;
/**
 *
 * @author jan
 */
public class FileRead {

    private Scanner scanner;

    public FileRead() {
        this.scanner = null;
    }

    /**
     *
     * @return makes stopword set to be used in classifying
     */
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

    /**
     *
     * @return opens txt file to be analyzed
     */
    public boolean openFile() {
        Scanner asker = new Scanner(System.in);
        System.out.println("Give the name of the file \nMust be in .txt format");
        // this will be used for inputting various training files etc
        // stopwords and lemmatizations will be done when built
        String fileName = asker.nextLine();
        try {
            this.scanner = new Scanner(new File(fileName));
            return true;
        } catch (Exception e) {
            System.err.println("No file found");
        }
        return false;
    }

    /**
     *
     * @return makes file into arraylist object
     */
    public List<String> readFile() {
        List<String> lista = new ArrayList<>();
        while (this.scanner.hasNext()) {
            lista.add(this.scanner.next());
        }
        scanner.close();
        return lista;
    }
}
