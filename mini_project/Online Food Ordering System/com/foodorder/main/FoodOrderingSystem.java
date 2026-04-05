package com.foodorder.main;

import com.foodorder.exceptions.InvalidOrderException;
import com.foodorder.models.Customer;
import com.foodorder.models.MenuItem;
import com.foodorder.models.Order;
import com.foodorder.payments.CardPayment;
import com.foodorder.payments.UpiPayment;
import com.foodorder.payments.Payment;

public class FoodOrderingSystem {

    public static void main(String[] args) {
        System.out.println("=== Welcome to the Online Food Ordering System ===\n");

        // 1. Create a Customer (Demonstrates Inheritance from User)
        Customer customer = new Customer(1, "Jaswanth K", "jaswanth@example.com", "123 Main St, Chennai.");
        customer.displayDashboard(); // Demonstrates Polymorphism
        System.out.println();

        // 2. Create Menu Items (Demonstrates Encapsulation and Validation)
        try {
            MenuItem burger = new MenuItem(101, "Classic Burger", 8.99, true);
            MenuItem fries = new MenuItem(102, "French Fries", 3.49, true);
            MenuItem pizza = new MenuItem(103, "Margherita Pizza", 12.00, false); // Out of stock
            MenuItem drink = new MenuItem(104, "Cola", 1.99, true);
            
            // Uncommenting the below line will throw an IllegalArgumentException due to negative price
            // MenuItem invalidItem = new MenuItem(105, "Free Water", -1.00, true);

            // 3. Create an Order
            Order order = new Order(customer);
            order.addItem(burger);
            order.addItem(fries);
            order.addItem(pizza); // Will show out of stock message
            order.addItem(drink);

            System.out.println("\n--- Order Summary ---");
            order.printReceipt();

            // 4. Validate Order
            validateOrder(order);

            // 5. Apply Extra Feature: Coupon Code
            System.out.println("\n--- Applying Coupon ---");
            order.applyCoupon("WELCOME10"); // Applies 10% discount
            order.printReceipt();

            // 6. Process Payment (Demonstrates Interface Abstraction and Polymorphism)
            double finalAmount = order.calculateDiscountedTotal();
            
            System.out.println("\n--- Checkout ---");
            Payment ccPayment = new CardPayment("1234567890123456", customer.getName());
            processCheckout(order, ccPayment, finalAmount);
            
            System.out.println();
            
            // Example of using a different payment method for the same interface
            // Payment upiPayment = new UpiPayment("jaswanth@upi");
            // processCheckout(order, upiPayment, finalAmount);
            
        } catch (IllegalArgumentException e) {
            System.out.println("Validation Error: " + e.getMessage());
        } catch (InvalidOrderException e) {
            System.out.println("Order Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        }
    }

    private static void validateOrder(Order order) throws InvalidOrderException {
        if (order.getItems().isEmpty()) {
            throw new InvalidOrderException("Cannot checkout an empty order. Please add items.");
        }
        if (order.calculateTotal() <= 0) {
            throw new InvalidOrderException("Order total must be greater than zero.");
        }
    }

    private static void processCheckout(Order order, Payment paymentMethod, double amount) {
        boolean success = paymentMethod.processPayment(amount);
        if (success) {
            order.setStatus("PREPARING");
            System.out.println("Order Status updated to: " + order.getStatus());
            
            // Add Loyalty Points (1 point per dollar spent)
            int pointsEarned = (int) amount;
            order.getCustomer().addLoyaltyPoints(pointsEarned);
            System.out.println("You earned " + pointsEarned + " loyalty points! Total points: " + order.getCustomer().getLoyaltyPoints());
        } else {
            System.out.println("Payment failed. Please try again.");
        }
    }
}
