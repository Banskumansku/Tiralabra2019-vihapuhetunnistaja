/*
 * Test class to run commands of UI
 */
package Main;

import Algorithms.CalculateBayes;
import Algorithms.Classifier;
import FileRead.FileRead;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author jan
 */
public class TestClass {

    private String[] lines;
    Classifier c;

    public TestClass(String file) {
        FileRead fileRead = new FileRead();
        HashSet<String> stopwords = new HashSet<>();

        switch (file) {
            case "defaultDatasetTest":
                c = new Classifier(stopwords);
                c.trainClassifier("default");
                this.lines = new String[1];
                lines[0] = "asd";
                break;
            case "defaultDataset":
                c = new Classifier(stopwords);
                c.trainClassifier("default");
                fileRead.openFile();
                this.lines = fileRead.readFile();
                break;
            default:
                Classifier classifier = new Classifier(stopwords);
                classifier.trainClassifier(file);
                fileRead.openFile();
                this.lines = fileRead.readFile();
                break;
        }
    }

    /**
     *
     * @return tests and classifies given txt. file for hatespeech
     */
    public String howMany() {
        int hate = 0;
        int notHate = 0;
        double aver = 0;
        for (String line : this.lines) {
            if (CalculateBayes.calculateBayes(c.testClassifier(line))) {
                hate++;
            } else {
                notHate++;
            }
            aver = +CalculateBayes.percentageBayes(c.testClassifier(line));
        }
        int total = hate + notHate;
        aver = aver / (hate + notHate);
        String results = "Out of the " + total + " results " + hate + " were considered hateful and " + notHate + " were considered normal speech.\n"
                + " On average the results were considered " + aver + " hateful";
        return results;
    }

    //return chance of being hatespeech
    public String isIthate(String line) {
        return "Your string is hatespeech with the probablity of " + CalculateBayes.percentageBayes(c.testClassifier(line));
    }

}
