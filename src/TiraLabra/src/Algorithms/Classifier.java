/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;

import Datastructures.Word;
import FileRead.FileRead;
import Preprocess.Tokenizer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author jan
 */
public class Classifier {

    HashMap<String, Word> words = new HashMap<String, Word>();
    // 

    public void trainClassifier() {
        int totalHatecount = 0;
        int totalNormcount = 0;
        Tokenizer tokenizer = new Tokenizer();
        FileRead fileRead = new FileRead();
        fileRead.openFile();
        HashSet<String> stopwords = fileRead.importStopword();
        List<String> lines = fileRead.readFile();
        for (String line : lines) {
            // read if it's hate or normal
            boolean hate = false;
            String[] tokenizedLine = tokenizer.tokenize(line);
            for (String string : tokenizedLine) {
                if (words.containsKey(string)) {
                    addClass(string, hate);
                    if (hate) {
                        totalHatecount++;
                    } else {
                        totalNormcount++;
                    }
                } else if (!stopwords.contains(string)) {
                    Word word = new Word(string);
                    addClass(string, hate);
                    if (hate) {
                        totalHatecount++;
                    } else {
                        totalNormcount++;
                    }
                }
            }
        }
        for (String key : words.keySet()) {
            words.get(key).calculateProbability(totalHatecount, totalNormcount);
        }
    }

    public void addClass(String word, boolean hate) {
        if (hate) {
            words.get(word).countHate();
        } else {
            words.get(word).countNorm();
        }
    }

}
