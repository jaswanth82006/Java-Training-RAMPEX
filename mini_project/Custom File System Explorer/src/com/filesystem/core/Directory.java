package com.filesystem.core;

import com.filesystem.exceptions.FileSystemException;
import java.util.ArrayList;
import java.util.List;

/**
 * Directory subclass representing a container for files and other directories.
 * Demonstrates Inheritance, Polymorphism, and Encapsulation.
 */
public class Directory extends FileSystemElement {
    private List<FileSystemElement> children;

    public Directory(String name) {
        super(name);
        this.children = new ArrayList<>();
    }

    public void addElement(FileSystemElement element) throws FileSystemException {
        // Validation: No duplicates allowed in the same directory
        for (FileSystemElement child : children) {
            if (child.getName().equalsIgnoreCase(element.getName())) {
                throw new FileSystemException("Error: Element with name '" + element.getName() + "' already exists in directory '" + getName() + "'.");
            }
        }
        children.add(element);
    }

    public void removeElement(String name) throws FileSystemException {
        FileSystemElement found = null;
        for (FileSystemElement child : children) {
            if (child.getName().equalsIgnoreCase(name)) {
                found = child;
                break;
            }
        }
        
        if (found != null) {
            children.remove(found);
        } else {
            throw new FileSystemException("Error: Element '" + name + "' not found in directory '" + getName() + "'.");
        }
    }

    public List<FileSystemElement> getChildren() {
        return new ArrayList<>(children); // Returning a copy for encapsulation
    }

    @Override
    public long getSize() {
        long totalSize = 0;
        // Polymorphism applied here; we don't care if child is File or Directory
        for (FileSystemElement child : children) {
            totalSize += child.getSize();
        }
        return totalSize;
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + "📁 Directory: " + getName() + " [" + getSize() + " bytes total]");
        for (FileSystemElement child : children) {
            child.display(indent + "   ");
        }
    }

    @Override
    public FileSystemElement search(String queryName) {
        if (this.getName().equalsIgnoreCase(queryName)) {
            return this;
        }

        // Recursive search deeper into directories
        for (FileSystemElement child : children) {
            FileSystemElement result = child.search(queryName);
            if (result != null) {
                return result;
            }
        }
        
        return null; // Not found recursively
    }
}
