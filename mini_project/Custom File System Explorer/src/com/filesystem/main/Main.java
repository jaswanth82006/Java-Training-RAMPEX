package com.filesystem.main;

import com.filesystem.core.Directory;
import com.filesystem.core.File;
import com.filesystem.core.FileSystem;
import com.filesystem.exceptions.FileSystemException;

/**
 * Main driver class to execute sample test cases.
 */
public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Starting Custom File System Explorer...\n");

            // 1. Initialize abstract entity representation Manager
            FileSystem fs = new FileSystem();
            Directory root = fs.getRoot();

            // 2. Create folders and files
            Directory documents = new Directory("Documents");
            Directory pictures = new Directory("Pictures");

            File resume = new File("resume.txt", "John Doe | Software Engineer | 5 Yrs Exp");
            File notes = new File("notes.txt", "Learn Java OOP, Inheritance, Polymorphism...");
            File logo = new File("logo.png", "binary_data_1010101");

            // 3. Organise the hierarchy
            root.addElement(documents);
            root.addElement(pictures);

            documents.addElement(resume);
            documents.addElement(notes);
            pictures.addElement(logo);

            // 4. Test Error Handling (Adding duplicate element)
            System.out.println(">> Testing Error Handling (Duplicate name):");
            try {
                documents.addElement(new File("notes.txt", "Another note"));
            } catch (FileSystemException e) {
                System.err.println("Caught Exception Expected: " + e.getMessage());
            }
            System.out.println();

            // 5. Test Error Handling (Invalid name)
            System.out.println(">> Testing Error Handling (Empty file name):");
            try {
                new File("");
            } catch (IllegalArgumentException e) {
                System.err.println("Caught Exception Expected: " + e.getMessage());
            }
            System.out.println();

            // 6. Test Polymorphism & Abstraction via Display & Size
            System.out.println(">> Displaying File System Structure:");
            fs.displayStructure();
            fs.displayTotalSize();
            System.out.println();

            // 7. Test Advanced Feature: Search function
            System.out.println(">> Testing Search Functionality:");
            fs.searchFileSystem("resume.txt");
            System.out.println();
            fs.searchFileSystem("Pictures");
            System.out.println();
            fs.searchFileSystem("non_existent_file.txt");
            System.out.println();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
