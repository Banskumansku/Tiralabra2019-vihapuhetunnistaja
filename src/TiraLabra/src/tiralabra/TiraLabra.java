/*
 * A messy work in progress
 */
package tiralabra;
import Algorithms.CalculateBayes;
import Algorithms.Classifier;
import Preprocess.Tokenizer;
import FileRead.FileRead;
import java.util.List;
/**
 *
 * @author jan
 */
public class TiraLabra {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CalculateBayes bayes = new CalculateBayes();
        Tokenizer t = new Tokenizer();
        String a = "asd. asd ... asd asd  asd can't";
        String[] b = t.tokenize(a);
        for (String string : b) {
            System.out.println(string);
        }
       /* FileRead fileReader = new FileRead();
        fileReader.openFile();
        List<String> list = fileReader.readFile();
        for (String string : list) {
            System.out.println(string);
            
        }
*/
       // Etsi parempi koulutustiedosto
        Classifier classifier = new Classifier();
        classifier.trainClassifier();
        String test = "";
        System.out.println(bayes.percentageBayes(classifier.testClassifier(test)));
    }
}
