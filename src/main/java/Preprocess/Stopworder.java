/**
 * Contains a HashSet of all stopwords that will be used in lemmatization
 * will be used to detect words like the, a and an
 * Has its own fileread method, to import the stopwords on initialization
 */
package Preprocess;

import FileRead.FileRead;
import Datastructures.Set;

/**
 *
 * @author jan
 */
public class Stopworder {
    private Set<String> stopwordlist;
            

    public Stopworder() {
        FileRead fr = new FileRead();
        this.stopwordlist = fr.importStopword();
    }
    // will use self made hashset in the end
    public boolean isItStop(String word) {
        return this.stopwordlist.contains(word);
    }
}
