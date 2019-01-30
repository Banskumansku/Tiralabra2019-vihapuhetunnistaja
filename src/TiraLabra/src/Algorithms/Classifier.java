/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;

import Datastructures.Word;
import FileRead.FileRead;
import Preprocess.Tokenizer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import org.apache.commons.csv.CSVFormat;
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
    private final HashSet<String> stopwords;

    public Classifier() {
        this.fileRead = new FileRead();
        this.stopwords = fileRead.importStopword();
        this.wordObjects = new HashMap<>();
    }

    // 
    public void trainClassifier() {
        String line = "";
        int totalHatecount = 0;
        int totalNormcount = 0;
        String file = System.getProperty("user.dir") + "/lib/hate-speech-classifier.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(file));
                CSVParser csvParser = new CSVParser(br, CSVFormat.DEFAULT);) {
            for (CSVRecord csvRecord : csvParser) {
                // Accessing Values by Column Index
                boolean hate = isItHate(csvRecord.get(5));
                String[] tokenizedLine = tokenizer.tokenize(csvRecord.get(19));
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
                    }
                }
            }
            //for (int i = 0; i < 1000; i++) {
            int i = 0;
            /* while ((line = br.readLine()) != null) {
                line = line + br.readLine();
                i++;
                // use comma as separator
                String[] separatedLine = line.split(",");
                boolean hate = isItHate(separatedLine[0]);
                String[] tokenizedLine = tokenizer.tokenize(separatedLine[4]);
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
                    }
                }
                if (i == 100) {
                    break;
                }
            }*/

        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String key : wordObjects.keySet()) {
            wordObjects.get(key).calculateProbability(totalHatecount, totalNormcount);
        }
    }

    public void addClass(String word, boolean hate) {
        if (hate) {
            wordObjects.get(word).countHate();
        } else {
            wordObjects.get(word).countNorm();
        }
    }

    public boolean isItHate(String classifier) {
        if (classifier.equals("The tweet is not offensive")
                || classifier.equals("The tweet uses offensive language but not hate speech")) {
            return false;
        } else {
            return true;
        }

    }

    public ArrayList<Word> testClassifier(String test) {
        String[] tokenizedText = tokenizer.tokenize(test);
        ArrayList<Word> calculable = new ArrayList<>();
        for (int i = 0; i < tokenizedText.length; i++) {
            String wordString = tokenizedText[i];
            if (!wordObjects.containsKey(wordString)) {
                if (!stopwords.contains(wordString)) {
                    Word w = new Word(wordString);
                    w.setProbOfHate(0.40f);
                    wordObjects.put(wordString, w);
                    calculable.add(this.wordObjects.get(wordString));
                }
            } else if (wordObjects.containsKey(wordString)){
                calculable.add(this.wordObjects.get(wordString));
            }
        }
        return calculable;
    }
    
    
    

}
