/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra;

import java.util.Scanner;

/**
 *
 * @author jan
 */
public class UI {

    private final Scanner scanner;
    private TestClass test;

    public UI() {
        this.scanner = new Scanner(System.in);
    }

    public void welcome() {
        while (true) {
            System.out.println("Hello jne jne");
            System.out.println("Enter 1 to do a thing");
            System.out.println("Enter 2 to do a thing");
            System.out.println("Enter 3 to do a thing");
            System.out.println("Enter 4 to do a thing");
            if (null != scanner.next()) {
                switch (scanner.next()) {
                    case "1":
                        // User is given a description on how the thing works
                        // its ups and downs
                        System.out.println("You chose 1");
                        break;
                    case "2":
                        // case 2 is when user wants to add their own file
                        System.out.println("You chose 2");
                        test = new TestClass("");
                        break;
                    case "3":
                        // case 3 is when user wants to use default package
                        System.out.println("You chose 3");
                        test = new TestClass("default");
                        System.out.println(test.howMany());
                        break;
                    case "4":
                        // case 4 is when user wants to test individual words with default
                        System.out.println("You chose 4");
                        break;
                    default:
                        System.out.println("Dumb dumb");
                        break;
                }
            }
        }
    }

}
