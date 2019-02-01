/*
 * A messy work in progress
 */
package tiralabra;
import Algorithms.CalculateBayes;
import Algorithms.Classifier;
/**
 *
 * @author jan
 */
public class TiraLabra {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Classifier classifier = new Classifier();
        classifier.trainClassifier();
        String test = "";
        System.out.println(CalculateBayes.percentageBayes(classifier.testClassifier(test)));
    }
}
