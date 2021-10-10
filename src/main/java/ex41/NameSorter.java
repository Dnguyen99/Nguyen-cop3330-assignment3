/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Dylan Nguyen
 */


package ex41;
import java.io.*;
import java.util.*;

public class NameSorter {

    // Defining the readNames() function to read the data from Scanner to the ArrayList
    public static void readNames(Scanner input, ArrayList<String> names) {
        // reading the data until the file has nextLine
        while (input.hasNextLine()) {
            // adding the read line to the list of names
            names.add(input.nextLine());
        }
    }

    // Defining the function to print names in file
    public static void outputNames(ArrayList<String> names) throws IOException {
        // FileWriter is created for the output file
        FileWriter output = new FileWriter("src/main/java/ex41/exercise41_output.txt");
        // Header of output file about how many names are read from input file
        output.write("Total of " + names.size() + " names\n");
        output.write("--------------------\n");
        // Writing names in file
        for (String i : names) {
            output.write(i + "\n");
        }
        output.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        // Creating a scanner object to read from input file
        Scanner inputFile = new Scanner(new File("src/main/java/ex41/exercise41_input.txt"));
        // Declare ArrayList to store names
        ArrayList<String> names = new ArrayList<String>();
        // Calling readNames() function to read names from input file
        readNames(inputFile, names);
        // Sorting the list of names using sort function
        Collections.sort(names, String.CASE_INSENSITIVE_ORDER);
        // Closing scanner object
        inputFile.close();
        // Writing data to the output file
        try {
            outputNames(names);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
