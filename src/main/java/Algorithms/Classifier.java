package Algorithms;

import Datastructures.Set;
import Datastructures.Word;
import FileRead.TableParser;
import Preprocess.Tokenizer;
import java.util.Arrays;
import java.util.HashMap;
import org.apache.commons.csv.CSVRecord;

/**
 *
 * @author jan
 */
public class Classifier {

    private final HashMap<String, Word> wordObjects;
    Tokenizer tokenizer;
    CalculateBayes bayes;
    private final TableParser tableParser;
    private final Set<String> stopwords;
    private int totalHatecount;
    private int totalNormcount;

    public Classifier(Set<String> stopwords) {
        this.bayes = new CalculateBayes();
        this.tokenizer = new Tokenizer();
        this.tableParser = new TableParser();
        this.stopwords = stopwords;
        this.wordObjects = new HashMap<>();
        this.totalHatecount = 0;
        this.totalNormcount = 0;
    }

// 
    /**
     *
     * @param file if default uses default dataset from stormfront Can also take
     * any properly formatted csv file
     * @return this is for checking tests
     */
    public boolean trainClassifier(String file) {
        //String file = System.getProperty("user.dir") + "/lib/alltextsandannotations.csv";
        Iterable<CSVRecord> csvParser;
        if (file.equals("default") || file.equals("defaultTest")) {
            csvParser = TableParser.parserDefault();
        } else {
            csvParser = TableParser.parser();
        }

        for (CSVRecord csvRecord : csvParser) {
            // Accessing Values by Column Index
            //if (!relevant(csvRecord.get(3))) {
            boolean hate = isItHate(csvRecord.get(53));
            if (!relevant(csvRecord.get(53))) {
                String[] tokenizedLine = tokenizer.tokenize(csvRecord.get(1));
                for (String string : tokenizedLine) {
                    if (wordObjects.containsKey(string)) {
                        addClass(string, hate);
                        if (hate) {
                            totalHatecount++;
                        } else {
                            totalNormcount++;
                        }
                    } else if (!stopwords.contains(string)) {
                        Word word = new Word(string);
                        wordObjects.put(string, word);
                        addClass(string, hate);
                        if (hate) {
                            totalHatecount++;
                        } else {
                            totalNormcount++;
                        }
                    } else {
                    }
                }
            }
        }
        for (String key : wordObjects.keySet()) {
            // TODO TFIDF calculation here
            wordObjects.get(key).calculateProbability(totalHatecount, totalNormcount);
        }
        return true;
    }

    // for the default CSV file
    private boolean relevant(String classifier) {
        String relevance = "idk/skip";
        return classifier.equals(relevance);
    }

    //adds classifying to the word at hand
    private void addClass(String word, boolean hate) {
        if (hate) {
            wordObjects.get(word).countHate();
        } else {
            wordObjects.get(word).countNorm();
        }
    }

    private boolean isItHate(String classifier) {
        return classifier.equals("hate");
    }

    // takes list of words and tests it through the CalculateBayes classs
    /**
     *
     * @param test tests Strings using the classifier
     * @return
     */
    public Word[] testClassifier(String test) {
        int amount = 0;
        String[] tokenizedText = tokenizer.tokenize(test);
        Word wordObj[] = new Word[tokenizedText.length];
        for (int i = 0; i < tokenizedText.length; i++) {
            String wordString = tokenizedText[i];
            if (!wordObjects.containsKey(wordString)) {
                if (!stopwords.contains(wordString)) {
                    Word w = new Word(wordString);
                    w.setProbOfHate(0.5f);
                    wordObjects.put(wordString, w);
                    wordObj[amount] = w;
                    amount++;
                }
            } else if (wordObjects.containsKey(wordString)) {
                wordObj[amount] = this.wordObjects.get(wordString);
                amount++;
            }
        }
        if (amount == 0) {
            return null;
        }
        return Arrays.copyOfRange(wordObj, 0, amount);
    }

}
