/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 first_name last_name
 */

package ex42;
import java.util.*;
import java.io.*;

public class EmployeeList {

    // Creating a method to print details in table format
    public String printDetails(String filename) {

        try {
            File inputFile = new File(filename);
            Scanner scan = new Scanner(inputFile);
            while(scan.hasNext()) {
                String string = scan.nextLine();
                String[] temp = string.split(",");
                System.out.printf("%-17s%-17s%-17s\n", temp[0], temp[1], temp[2]);
            }
        } catch(FileNotFoundException ex) {
            System.out.print("Error: File not found.");
        }
        return filename;
    }
    // Main method to test code
    public static void main(String[] args) throws FileNotFoundException {
        EmployeeList emp = new EmployeeList();
        System.out.printf("%-17s%-17s%-17s\n", "Last", "First", "Salary");
        System.out.println("----------------------------------------");
        Scanner inputFile = new Scanner(new File("src/main/java/ex42/exercise42_input.txt"));
        emp.printDetails("src/main/java/ex42/exercise42_input.txt");
    }
}
