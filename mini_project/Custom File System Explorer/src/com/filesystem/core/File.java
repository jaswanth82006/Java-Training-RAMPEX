package com.filesystem.core;

/**
 * File subclass representing a concrete file in the system.
 * Demonstrates Inheritance and Polymorphism.
 */
public class File extends FileSystemElement {
    private String content;

    public File(String name) {
        super(name);
        this.content = "";
    }

    public File(String name, String content) {
        super(name);
        this.content = content != null ? content : "";
    }

    public String getContent() {
        return content;
    }

    public void appendContent(String appendingStr) {
        if (appendingStr != null) {
            this.content += appendingStr;
        }
    }

    public void clearContent() {
        this.content = "";
    }

    @Override
    public long getSize() {
        // Simple mock of file size (number of characters = bytes)
        return content.length();
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + "📄 File: " + getName() + " [" + getSize() + " bytes]");
    }

    @Override
    public FileSystemElement search(String queryName) {
        if (this.getName().equalsIgnoreCase(queryName)) {
            return this;
        }
        return null;
    }
}
