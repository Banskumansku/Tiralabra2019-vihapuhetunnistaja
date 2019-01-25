/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Preprocess;

/**
 *
 * @author jan
 */
public class Tokenizer {

    public Tokenizer() {
        
    }
    
    public String[] tokenize (String line) {
        String[] tokens;
        tokens = line.split("([.,!?:;\"-]|\\s)+");
        return tokens;
    }
    // Breaks up lines of text into individual tokens
    // Input line and tokenize into individual parts
    
    
    
}
