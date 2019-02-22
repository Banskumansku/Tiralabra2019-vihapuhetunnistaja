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
        double probabilityOfPositiveProduct = 1.0;
        double probabilityOfNegativeProduct = 1.0;
        for (Word word : line) {
            probabilityOfPositiveProduct *= word.getProbOfHate();
            probabilityOfNegativeProduct *= (1.0 - word.getProbOfHate());
        }
        double probOfHate = probabilityOfPositiveProduct / (probabilityOfPositiveProduct + probabilityOfNegativeProduct);
        return probOfHate > 0.75;
    }

    /**
     *
     * @param line
     * @return probablity of hate speech
     */
    public static double percentageBayes(Word line[]) {
        double probabilityOfPositiveProduct = 1.0f;
        double probabilityOfNegativeProduct = 1.0f;
        for (Word word : line) {
            probabilityOfPositiveProduct *= word.getProbOfHate();
            probabilityOfNegativeProduct *= (1.0 - word.getProbOfHate());
        }
        double probOfHate = probabilityOfPositiveProduct / (probabilityOfPositiveProduct + probabilityOfNegativeProduct);
        if (probOfHate < 0.01) {
            return 0.01;
        } 
        return probOfHate;
    }

}
