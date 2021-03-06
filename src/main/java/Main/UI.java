package Main;

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

    /**
     * User lands here from main Gives instructions
     */
    public void welcome() {
        hello();
        while (true) {
            String checker = scanner.nextLine();
            switch (checker) {
                case "1":
                    // User is given a description on how the thing works
                    // its ups and downs
                    System.out.println("You chose 1");
                    System.out.println("Basic functionality is pretty much to that of spam/ham, but with an approach to hate speech");
                    System.out.println("The classifier natively installed isn't the best, but that's why there is the added functionality to add your own classifier");
                    System.out.println("Naive bayes takes in the data and statistically approximates how likely is it that the text entered is hatespeech");
                    System.out.println("");
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
                    test = new TestClass("defaultDataset");
                    System.out.println(test.howMany());
                    break;
                case "4":
                    // case 4 is when user wants to test individual words with default
                    System.out.println("You chose 4");
                    System.out.println("Give a sentence or string to analyze");
                    System.out.println("Press enter twice to exit");
                    test = new TestClass("defaultDatasetTest");
                    while (true) {
                        String line = scanner.nextLine();
                        if (line.equals("")) {
                            break;
                        } else if (line.equals(" ")) {
                            System.out.println("Be more creative than that");
                        } else {
                            System.out.println(test.isIthate(line));
                        }
                    }
                    break;
                case "quit":
                    System.out.println("Bye bye");
                    System.exit(0);
                    break;
                default:
                    hello();
                    break;
            }

        }
    }

    //method for user to add their own data
    //in the same vein as the method above
    private void ownData() {
        ownFileHello();
        test = new TestClass("");
        boolean continuum = true;
        while (continuum) {
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
                    case "":
                        continuum = false;
                        break;
                    default:
                        ownFileHello();
                        break;
                }
            }

        }
    }

    public void hello() {
        System.out.println("Hello jne jne");
        System.out.println("Enter 1 to get information on the logic behind the application");
        System.out.println("Enter 2 to add your own classifier csv file");
        System.out.println("Enter 3 to add your own .txt file for analysis");
        System.out.println("Enter 4 to test with default package with individual strings");
        System.out.println("Enter quit to quit");
    }

    public void ownFileHello() {
        System.out.println("enter 1 for testing with your own .txt file");
        System.out.println("enter 2 for testing with a string");
        System.out.println("enter nothing to exit own dataset analysis");
    }
}
