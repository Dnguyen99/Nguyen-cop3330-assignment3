/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 first_name last_name
 */

package ex46;

import java.io.*;
import java.util.*;
import java.util.Map.*;

public class WordFrequencyFinder {
    // Main method
    public static void main(String[]args) throws FileNotFoundException {
        // Create ReadInputFile object
        ReadInputFile rf = new ReadInputFile();
        // Read the file
        rf.readFile();
        // Get the map
        HashMap<String, Integer>map = rf.getMap();
        // Create object of PrintReport class
        PrintReport pr = new PrintReport(map);
        // Print to screen
        pr.printScreen();
    }
}

class ReadInputFile {
    // Instance variables
    private Scanner scan;
    private File file;
    private HashMap<String, Integer>map;
    // Constructor
    public ReadInputFile() throws FileNotFoundException {
        // Initialize instance variable
        // Pass path to file as a parameter
        file = new File("src/main/java/ex46/exercise46_input.txt");
        scan = new Scanner(file);
        map = new HashMap<String, Integer>();
    }
    public void readFile() {
        // Use try and finally to avoid exceptions
        try {
            while(scan.hasNext()) {
                // Read input
                String input = scan.nextLine();
                // Split by spaces inbetween
                String array[] = input.split(" ");
                for(int i = 0; i < array.length; i++) {
                    String key = array[i];
                    // If key is already in map then
                    if(map.containsKey(key)) {
                        int value = map.get(key);
                        // Update value by 1
                        value++;
                        map.put(key, value);
                    }
                    else {
                        map.put(key, 1);
                    }
                }
            }
        }
        finally {
            scan.close();
        }
    }
    // Method for returning map
    public HashMap<String, Integer> getMap() {
        return map;
    }
}

class PrintReport {
    // Instance variable
    private HashMap<String, Integer> map;
    // Constructor
    public PrintReport(HashMap<String, Integer> map) {
        // Initialize variable
        this.map = map;
    }
    public void printScreen() {
        // Declaring arrays to store values and keys
        String keys[] = new String[map.size()];
        Integer values[] = new Integer[map.size()];
        int k = 0;
        for(Entry<String, Integer> entry : map.entrySet()) {
            keys[k] = entry.getKey();
            values[k++] = entry.getValue();
        }
        // Declaring another set of arrays of String and Integer to store values
        int tempvalues[] = new int[map.size()];
        String tempkeys[] = new String[map.size()];
        // Duplicate values array to tempvalues
        for(int i = 0; i < values.length; i++) {
            tempvalues[i] = values[i];
        }
        // Reverse sort values array
        Arrays.sort(values, Collections.reverseOrder());
        // Sort the keys arrays according to values array, then store in tempkeys
        for(int i = 0; i < map.size(); i++) {
            int value = values[i];
            for(int j = 0; j < tempvalues.length; j++) {
                if(value == tempvalues[j]) {
                    tempkeys[i] = keys[j];
                    break;
                }
            }
        }
        System.out.println();
        // Print hostogram
        for(int i = 0; i < map.size(); i++) {
            int value = map.get(tempkeys[i]);
            System.out.print(tempkeys[i] + " : \t");
            for(int j = 0; j < value; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
