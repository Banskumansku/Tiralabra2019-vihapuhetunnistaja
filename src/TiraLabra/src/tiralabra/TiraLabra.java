/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra;
import Preprocess.Tokenizer;
import FileReader.FileReader;
/**
 *
 * @author jan
 */
public class TiraLabra {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Tokenizer t = new Tokenizer();
        String a = "asd. asd ... asd asd  asd can't";
        String[] b = t.tokenize(a);
        for (String string : b) {
            System.out.println(string);
        }
        FileReader fileReader = new FileReader();
        String[] s = fileReader.FileAsString();
        for (String string : s) {
            System.out.println(string);
        }
    }
}