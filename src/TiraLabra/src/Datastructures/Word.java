/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datastructures;

/**
 *
 * @author jan
 */
public class Word {

    private String word;	//the word itself
    private int hateCount;	//number of this words appearances in hate speech
    private int normCount;	//number of this words appearances in normal speech
    private float hateRate;	//spamCount divided by total hate count
    private float normRate;	//hamCount divided by total norm count
    private float probOfHate;	//probability of word being hate

    public Word(String word) {
        this.word = word;
        hateCount = 0;
        normCount = 0;
        hateRate = 0.0f;
        normRate = 0.0f;
        probOfHate = 0.0f;
    }

    public void countHate() {
        hateCount++;
    }

    public void countNorm() {
        normCount++;
    }

    //calculates the probability of
    //and gives the smallest and biggest probabilities more precedence
    public void calculateProbability(int totHate, int NormHam) {
        hateRate = hateCount / (float) totHate;
        normRate = normCount / (float) NormHam;

        if (hateRate + normRate > 0) {
            probOfHate = hateRate / (hateRate + normRate);
        }
        if (probOfHate < 0.01f) {
            probOfHate = 0.01f;
        } else if (probOfHate > 0.99f) {
            probOfHate = 0.99f;
        }
    }

    public String getWord() {
        return word;
    }

    public float getHateRate() {
        return hateRate;
    }

    public float getNormRate() {
        return normRate;
    }

    public void setNormRate(float normRate) {
        this.normRate = normRate;
    }

    public float getProbOfHate() {
        return probOfHate;
    }

    public void setProbOfHate(float probOfHate) {
        this.probOfHate = probOfHate;
    }

}
