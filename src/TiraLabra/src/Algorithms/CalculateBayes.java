/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

    public boolean calculateBayes(ArrayList<Word> line) {
        float probabilityOfPositiveProduct = 1.0f;
        float probabilityOfNegativeProduct = 1.0f;
        for (int i = 0; i < line.size(); i++) {
            Word word = line.get(i);
            probabilityOfPositiveProduct *= word.getProbOfHate();
            probabilityOfNegativeProduct *= (1.0f - word.getProbOfHate());
        }
        float probOfHate = probabilityOfPositiveProduct / (probabilityOfPositiveProduct + probabilityOfNegativeProduct);
        if (probOfHate > 0.85f) {
            return true;
        } else {
            return false;
        }
    }

    public float percentageBayes(ArrayList<Word> line) {
        float probabilityOfPositiveProduct = 1.0f;
        float probabilityOfNegativeProduct = 1.0f;
        for (int i = 0; i < line.size(); i++) {
            Word word = line.get(i);
            probabilityOfPositiveProduct *= word.getProbOfHate();
            probabilityOfNegativeProduct *= (1.0f - word.getProbOfHate());
        }
        float probOfHate = probabilityOfPositiveProduct / (probabilityOfPositiveProduct + probabilityOfNegativeProduct);
        return probOfHate;
    }

}
