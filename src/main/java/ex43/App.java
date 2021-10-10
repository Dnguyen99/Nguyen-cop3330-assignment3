/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 first_name last_name
 */

package ex43;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Input
        Scanner newScan = new Scanner(System.in);
        String siteName;
        String author;
        String wantCSS;
        String wantJS;

        System.out.print("Site name: ");
        siteName = newScan.nextLine();
        System.out.print("Author: ");
        author = newScan.nextLine();
        System.out.print("Do you want a folder for JavaScript? ");
        wantJS = newScan.nextLine();
        System.out.print("Do you want a folder for CSS? ");
        wantCSS = newScan.nextLine();
        // Creating Website Generator
        WebsiteGenerator newWebsite = new WebsiteGenerator();
        newWebsite.siteName = siteName;
        newWebsite.author = author;
        newWebsite.path = "src/main/java/ex43/";
        // Creating website and HTML file
        System.out.println("Created" + newWebsite.createWebsite());
        System.out.println("Created" + newWebsite.createHTML());

        // Output
        if(wantJS.equals("y")) {
            System.out.println("Created" + newWebsite.createJSFolder());
        }
        if (wantCSS.equals("y")) {
            System.out.println("Created" + newWebsite.createCSSFolder());
        }
    }
}
