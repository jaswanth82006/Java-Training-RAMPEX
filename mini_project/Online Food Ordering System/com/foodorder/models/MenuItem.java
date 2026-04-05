package com.foodorder.models;

public class MenuItem {
    private int itemId;
    private String name;
    private double price;
    private boolean isAvailable;

    public MenuItem(int itemId, String name, double price, boolean isAvailable) {
        this.itemId = itemId;
        this.name = name;
        setPrice(price); // Use setter to enforce validation
        this.isAvailable = isAvailable;
    }

    public int getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price < 0) {
            throw new IllegalArgumentException("Item price cannot be negative.");
        }
        this.price = price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
    
    @Override
    public String toString() {
        return name + " - $" + price + (isAvailable ? "" : " (Out of stock)");
    }
}
