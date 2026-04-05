package com.foodorder.models;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private static int orderCounter = 1000;
    private int orderId;
    private Customer customer;
    private List<MenuItem> items;
    private double discountPercentage = 0.0;
    private String status;

    public Order(Customer customer) {
        this.orderId = ++orderCounter;
        this.customer = customer;
        this.items = new ArrayList<>();
        this.status = "PENDING";
    }

    public void addItem(MenuItem item) {
        if(item.isAvailable()) {
            items.add(item);
        } else {
            System.out.println("Sorry, " + item.getName() + " is currently out of stock.");
        }
    }

    public void applyCoupon(String couponCode) {
        if(couponCode != null && !couponCode.trim().isEmpty()) {
            if(couponCode.equalsIgnoreCase("WELCOME10")) {
                this.discountPercentage = 10.0;
                System.out.println("Applied 10% discount from coupon: " + couponCode);
            } else if(couponCode.equalsIgnoreCase("SAVE20")) {
                this.discountPercentage = 20.0;
                System.out.println("Applied 20% discount from coupon: " + couponCode);
            } else {
                System.out.println("Invalid coupon code.");
            }
        }
    }

    public double calculateTotal() {
        double total = 0;
        for (MenuItem item : items) {
            total += item.getPrice();
        }
        return total;
    }
    
    public double calculateDiscountedTotal() {
        double total = calculateTotal();
        return total - (total * (discountPercentage / 100));
    }

    public int getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public void printReceipt() {
        System.out.println("--- Receipt for Order #" + orderId + " ---");
        System.out.println("Customer: " + customer.getName());
        for (MenuItem item : items) {
            System.out.println("- " + item.getName() + ": $" + item.getPrice());
        }
        System.out.println("Subtotal: $" + String.format("%.2f", calculateTotal()));
        if(discountPercentage > 0) {
            System.out.println("Discount: " + discountPercentage + "%");
        }
        System.out.println("Total Amount: $" + String.format("%.2f", calculateDiscountedTotal()));
        System.out.println("Status: " + status);
        System.out.println("---------------------------------");
    }
}
