/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 first_name last_name
 */

package ex45;

import java.io.*;
import java.util.*;

public class WordFinder {
    // Main method that throws IOException
    public static void main(String[]args) throws IOException {
        // Creating object of Scanner class
        Scanner scan = new Scanner(System.in);
        // Prompt the user for name of output file
        System.out.print("Enter the output file: "); // Name of my output file is: output_file.txt
        String outputFile = scan.next();
        // Creating object of ReadFile class
        ReadFile rf = new ReadFile();
        // Read the file
        rf.readFile();
        // Get list that contains file data
        ArrayList<String>list = rf.getData();
        // Creating object of WriteFile and passing outputFile and list
        WriteFile wr = new WriteFile(outputFile, list);
        wr.writeIntoFile();
        // Print number of modifications to console
        System.out.print("The number of modifications are: " +wr.getModification());
    }
}

class ReadFile {
    // Instance variable
    private ArrayList<String>list;
    private Scanner sc;
    // Constructor
    public ReadFile() throws FileNotFoundException {
        list = new ArrayList<String>();
        // Passing the path to the file as a parameter
        File file = new File("src/main/java/ex45/exercise45_input.txt");
        sc = new Scanner(file);
    }
    public void readFile() {
        // Use try and finally to avoid exceptions
        try {
            int i = 0;
            while(sc.hasNext()) {
                // Read the file line by line and store into list
                String fileData = sc.nextLine();
                list.add(fileData);
            }
        }
        finally {
            sc.close();
        }
    }
    public ArrayList<String> getData() {
        return list;
    }
}

class WriteFile {
    // Instance variable
    private FileWriter writer;
    private int count;
    private ArrayList<String>list;
    // Constructor
    public WriteFile(String name, ArrayList<String>list) throws IOException {
        //Initialize variables
        writer = new FileWriter("src/main/java/ex45/" +name);
        this.list = list;
    }
    // Write into file
    public void writeIntoFile() throws IOException{
        for(int i = 0; i < list.size(); i++) {
            String temp = list.get(i);
            String string = "utilize";
            int index = 0;

            //Count the modifications
            while(true) {
                index = temp.indexOf(string, index);
                if(index != -1) {
                    count++;
                    index += string.length();
                }
                else {
                    break;
                }
            }
            // Modification
            temp = temp.replaceAll("utilize", "use");
            // Write into file
            writer.write(temp +"\n");
        }
        writer.close();
    }
    // Creating a method that returns the count of modifications
    public int getModification() {
        return count;
    }
}
