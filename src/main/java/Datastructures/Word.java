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

    private final String word;	//the word itself
    private int hateCount;	//number of this words appearances in hate speech
    private int normCount;	//number of this words appearances in normal speech
    private double hateRate;	//spamCount divided by total hate count
    private double normRate;	//hamCount divided by total norm count
    private double probOfHate;	//probability of word being hate

    public Word(String word) {
        this.word = word;
        hateCount = 0;
        normCount = 0;
        hateRate = 0.0;
        normRate = 0.0;
        probOfHate = 0.0;
    }

    public void countHate() {
        hateCount++;
    }

    public void countNorm() {
        normCount++;
    }

    public int getHateCount() {
        return hateCount;
    }

    public int getNormCount() {
        return normCount;
    }

    //calculates the probability of
    //and gives the smallest and biggest probabilities more precedence
    public void calculateProbability(int totHate, int totNorm) {
        hateRate = hateCount / (double) totHate;
        normRate = normCount / (double) totNorm;
        if (totNorm == 0) {
            normRate = 0.001;
        }
        if (totHate == 0) {
            hateRate = 0.001;
        }
        
        if (hateRate + normRate > 0) {
            probOfHate = hateRate / (hateRate + normRate);
        }
        if (probOfHate < 0.01) {
            probOfHate = 0.01;
        } else if (probOfHate > 0.9999) {
            probOfHate = 0.9999;
        }
    }

    
    
    
    public String getWord() {
        return word;
    }

    public double getHateRate() {
        return hateRate;
    }

    public void setHateRate(double hateRate) {
        this.hateRate = hateRate;
    }

    public double getNormRate() {
        return normRate;
    }

    public void setNormRate(double normRate) {
        this.normRate = normRate;
    }

    public double getProbOfHate() {
        return probOfHate;
    }

    public void setProbOfHate(double probOfHate) {
        this.probOfHate = probOfHate;
    }

}
