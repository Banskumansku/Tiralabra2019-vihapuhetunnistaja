package Algorithms;

import Datastructures.Word;

/**
 *
 * @author jan
 */
public class CalculateBayes {

    public CalculateBayes() {
    }

    /**
     *
     * @param line of words
     * @return boolean of hatespeech
     */
    public static boolean calculateBayes(Word line[]) {
        double probabilityOfPositiveProduct = Math.log(1.0);
        double probabilityOfNegativeProduct = Math.log(1.0);
        for (Word word : line) {
            probabilityOfPositiveProduct += Math.log(word.getProbOfHate());
            probabilityOfNegativeProduct += Math.log(1.0 - word.getProbOfHate());
        }
        double probOfHate = Math.exp(probabilityOfPositiveProduct) / (Math.exp(probabilityOfPositiveProduct) + Math.exp(probabilityOfNegativeProduct));
        return Math.exp(probOfHate) < 0.75;
    }

    /**
     *
     * @param line
     * @return probablity of hate speech
     */
    public static double percentageBayes(Word line[]) {
        double probabilityOfPositiveProduct = Math.log(1.0);
        double probabilityOfNegativeProduct = Math.log(1.0);
        for (Word word : line) {
            probabilityOfPositiveProduct += Math.log(word.getProbOfHate());
            probabilityOfNegativeProduct += Math.log(1.0 - word.getProbOfHate());
        }
        double probOfHate = Math.exp(probabilityOfPositiveProduct) / (Math.exp(probabilityOfPositiveProduct) + Math.exp(probabilityOfNegativeProduct));
        if (probOfHate < 0.01) {
            return 0.01;
        }
        return probOfHate;
    }

}
