/*
 * For some reason buffered reader decided not to work -> Scanner it is
 * Takes in a list of words in a txt file format and returns it as a list
 * to be used by the stopworder and when user wants to add own txt files
 */
package FileRead;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import Datastructures.Set;

/**
 *
 * @author jan
 */
public class FileRead {

    private Scanner scanner;
    int rowCount;

    public FileRead() {
        this.scanner = null;
        this.rowCount = 0;
    }

    /**
     *
     * @return makes stopword set to be used in classifying
     */
    public Set<String> importStopword() {
        //this method is only used for importing the stopwords
        Set<String> set = new Set<>();
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
        System.out.println("Give the name of the file \nMust be in .txt format and in working directory");
        // this will be used for inputting various training files etc
        // stopwords and lemmatizations will be done when built
        String add = asker.nextLine();
        String fileName = System.getProperty("user.dir") + "/lib/" + add;
        try {
            this.scanner = new Scanner(new File(fileName));
            Path path = Paths.get(fileName);
            this.rowCount = (int) Files.lines(path).count();
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
    public String[] readFile() {

        String[] lista = new String[this.rowCount];
        int index = 0;
        while (this.scanner.hasNext()) {
            //lista.add(this.scanner.next());
            lista[index] = this.scanner.nextLine();
            index++;
        }
        this.scanner.close();
        return lista;
    }
}
