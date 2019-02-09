/*
 * Test class to run commands of UI
 */
package Main;

import Algorithms.CalculateBayes;
import Algorithms.Classifier;
import FileRead.FileRead;
import java.util.List;

/**
 *
 * @author jan
 */
public class TestClass {

    private final List<String> lines;
    private Classifier c = new Classifier();

    public TestClass(String file) {
        if (!file.equals("defaultTest")) {
            FileRead fileRead = new FileRead();
            fileRead.openFile();
            this.lines = fileRead.readFile();
            Classifier classifier = new Classifier();
            classifier.trainClassifier(file);
        } else {
            c.trainClassifier("default");
            this.lines = null;
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
        String results = "Out of the " + total + " results" + hate + " were considered hateful and " + notHate + " were considered normal speech.\n"
                + " On average the results were considered " + aver + " hateful";
        return results;
    }

    //return chance of being hatespeech
    public String isIthate(String line) {
        return "Your string is hatespeech with the probablity of " + CalculateBayes.percentageBayes(c.testClassifier(line));
    }

}
