package com.filesystem.core;

/**
 * FileSystem class serving as the main manager for the file system operations.
 */
public class FileSystem {
    private Directory root;

    public FileSystem() {
        this.root = new Directory("root");
    }

    public Directory getRoot() {
        return root;
    }

    public void displayStructure() {
        System.out.println("--- File System Structure ---");
        root.display("");
        System.out.println("-----------------------------");
    }

    public void displayTotalSize() {
        System.out.println("Total File System Size: " + root.getSize() + " bytes");
    }

    public void searchFileSystem(String queryName) {
        System.out.println("🔍 Searching for: '" + queryName + "'...");
        FileSystemElement found = root.search(queryName);
        if (found != null) {
            System.out.println("✅ Found! Details:");
            found.display("  -> ");
        } else {
            System.out.println("❌ Element '" + queryName + "' not found.");
        }
    }
}
