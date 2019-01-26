
package Preprocess;

import FileRead.FileRead;
import java.util.HashSet;

/**
 *
 * @author jan
 */
public class Stopworder {
    HashSet<String> stopwordlist;

    public Stopworder() {
        FileRead fr = new FileRead();
        this.stopwordlist = fr.importStopword();

    }
    // will use self made hashset in the end
    public boolean isItStop(String word) {
        return this.stopwordlist.contains(word);
    }
}
