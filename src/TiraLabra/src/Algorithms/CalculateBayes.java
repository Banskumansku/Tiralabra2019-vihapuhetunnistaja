package Algorithms;

import Datastructures.Word;
import java.util.ArrayList;

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
        float probabilityOfPositiveProduct = 1.0f;
        float probabilityOfNegativeProduct = 1.0f;
        for (int i = 0; i < line.length; i++) {
            Word word = line[i];
            probabilityOfPositiveProduct *= word.getProbOfHate();
            probabilityOfNegativeProduct *= (1.0f - word.getProbOfHate());
        }
        float probOfHate = probabilityOfPositiveProduct / (probabilityOfPositiveProduct + probabilityOfNegativeProduct);
        return probOfHate > 0.75f;
    }

    /**
     *
     * @param line
     * @return probablity of hate speech
     */
    public static float percentageBayes(Word line[]) {
        float probabilityOfPositiveProduct = 1.0f;
        float probabilityOfNegativeProduct = 1.0f;
        for (int i = 0; i < line.length; i++) {
            Word word = line[i];
            probabilityOfPositiveProduct *= word.getProbOfHate();
            probabilityOfNegativeProduct *= (1.0f - word.getProbOfHate());
        }
        float probOfHate = probabilityOfPositiveProduct / (probabilityOfPositiveProduct + probabilityOfNegativeProduct);
        return probOfHate;
    }

}
