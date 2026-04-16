package com.filesystem.core;

import java.util.Date;

/**
 * FileSystemElement representing the Abstract base class (Abstraction).
 * Demonstrates Encapsulation using private fields and getters/setters.
 */
public abstract class FileSystemElement {
    private String name;
    private final Date creationDate;

    public FileSystemElement(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Node name cannot be empty");
        }
        this.name = name;
        this.creationDate = new Date(); // Current time
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
    }

    public Date getCreationDate() {
        return creationDate;
    }

    // Abstract methods to enforce Polymorphism
    public abstract long getSize();
    
    public abstract void display(String indent);

    // Advanced Feature: Recursive search
    public abstract FileSystemElement search(String queryName);
}
