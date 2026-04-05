package com.foodorder.models;

public class Customer extends User {
    private String deliveryAddress;
    private int loyaltyPoints; // Extra feature: Loyalty Points

    public Customer(int id, String name, String email, String deliveryAddress) {
        super(id, name, email); // Demonstrates Inheritance
        this.deliveryAddress = deliveryAddress;
        this.loyaltyPoints = 0; // Initialize points
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void addLoyaltyPoints(int points) {
        this.loyaltyPoints += points;
    }

    public void deductLoyaltyPoints(int points) {
        if (this.loyaltyPoints >= points) {
            this.loyaltyPoints -= points;
        }
    }

    @Override
    public void displayDashboard() {
        System.out.println("--- Customer Dashboard ---");
        System.out.println("Welcome, " + this.name + "!");
        System.out.println("Email: " + this.email);
        System.out.println("Delivery Address: " + this.deliveryAddress);
        System.out.println("Loyalty Points: " + this.loyaltyPoints);
    }
}
