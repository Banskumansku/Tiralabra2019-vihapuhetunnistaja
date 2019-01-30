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

    public String[] tokenize(String line) {
        String[] tokens;
        tokens = line.split("([.,!?:;\"-]|\\s)+");
        for (int i = 0; i < tokens.length; i++) {
            String toLowerCase = tokens[i].toLowerCase();
        }
        return tokens;
    }
    // Breaks up lines of text into individual tokens
    // Input line and tokenize into individual parts

}
