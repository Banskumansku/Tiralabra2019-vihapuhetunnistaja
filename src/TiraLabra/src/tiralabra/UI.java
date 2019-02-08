/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra;

import Algorithms.CalculateBayes;
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
            System.out.println("Enter to quit to quit");
            String checker = scanner.nextLine();
            switch (checker) {
                case "1":
                    // User is given a description on how the thing works
                    // its ups and downs
                    System.out.println("You chose 1");

                    break;
                case "2":
                    // case 2 is when user wants to add their own file
                    System.out.println("You chose 2");
                    ownData();
                    // Things with own dataset, call different function
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
                    while (true) {
                        System.out.println("Give a sentence or string to analyze");
                        System.out.println("Enter nothing to exit");
                        String line = scanner.nextLine();
                        if (line.equals("")) {
                            break;
                        }
                        System.out.println(test.isIthate(line));
                    }
                    break;
                case "quit":
                    System.out.println("Bye bye");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Dumb dumb");
                    break;
            }

        }
    }

    private void ownData() {
        test = new TestClass("");
        boolean continuum = true;
        while (continuum) {
            System.out.println("enter 1 for testing with your own .txt file");
            System.out.println("enter 2 for testing with a string");
            System.out.println("enter \"continue\" to exit own dataset analysis");
            if (null != scanner.next()) {
                switch (scanner.next()) {
                    case "1":
                        test = new TestClass("");
                        break;
                    case "2":
                        while (true) {
                            System.out.println("Give a sentence or string to analyze");
                            System.out.println("Enter nothing to exit");
                            String line = scanner.nextLine();
                            if (line.equals("")) {
                                break;
                            }
                            System.out.println(test.isIthate(line));
                        }
                        break;
                    case "continue":
                        continuum = false;
                        break;
                }
            }

        }
    }
}
