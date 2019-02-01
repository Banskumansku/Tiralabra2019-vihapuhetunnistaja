/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;

import Datastructures.Word;
import FileRead.FileRead;
import FileRead.TableParser;
import Preprocess.Tokenizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

/**
 *
 * @author jan
 */
public class Classifier {

    private HashMap<String, Word> wordObjects;
    Tokenizer tokenizer = new Tokenizer();
    CalculateBayes bayes = new CalculateBayes();
    private final FileRead fileRead;
    private final TableParser tableParser;
    private final HashSet<String> stopwords;
    private final CSVParser csvParser;
    private int totalHatecount;
    private int totalNormcount;

    public Classifier() {
        this.fileRead = new FileRead();
        this.tableParser = new TableParser();
        this.stopwords = fileRead.importStopword();
        this.csvParser = TableParser.parser();
        this.wordObjects = new HashMap<>();
        this.totalHatecount = 0;
        this.totalNormcount = 0;
    }

// 
    public void trainClassifier() {
        String file = System.getProperty("user.dir") + "/lib/alltextsandannotations.csv";
        int stopwordsA = 0;
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
                        stopwordsA++;
                    }
                }
            }
        }
        for (String key : wordObjects.keySet()) {
            // TFIDF calculation here
            wordObjects.get(key).calculateProbability(totalHatecount, totalNormcount);
        }

    }

    public boolean relevant(String classifier) {
        String relevance = "idk/skip";
        return classifier.equals(relevance);
    }

    public void addClass(String word, boolean hate) {
        if (hate) {
            wordObjects.get(word).countHate();
        } else {
            wordObjects.get(word).countNorm();
        }
    }

    public boolean isItHate(String classifier) {
        return classifier.equals("hate");
    }

    public ArrayList<Word> testClassifier(String test) {
        String[] tokenizedText = tokenizer.tokenize(test);
        ArrayList<Word> calculable = new ArrayList<>();
        for (int i = 0; i < tokenizedText.length; i++) {
            String wordString = tokenizedText[i];
            if (!wordObjects.containsKey(wordString)) {
                if (!stopwords.contains(wordString)) {
                    Word w = new Word(wordString);
                    w.setProbOfHate(0.5f);
                    wordObjects.put(wordString, w);
                    calculable.add(this.wordObjects.get(wordString));
                }
            } else if (wordObjects.containsKey(wordString)) {
                calculable.add(this.wordObjects.get(wordString));
            }
        }
        return calculable;
    }

}
