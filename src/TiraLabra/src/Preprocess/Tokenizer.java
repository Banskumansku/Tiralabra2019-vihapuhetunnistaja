/*
 * Tokenizes all words in a string
 * "A little list" becomes -> "a" "little" "list"
 * Used in conjunction with lemmatization
 * @param line can be any line of string 
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
