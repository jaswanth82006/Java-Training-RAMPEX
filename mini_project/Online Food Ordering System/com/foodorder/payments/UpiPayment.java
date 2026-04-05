package com.foodorder.payments;

public class UpiPayment implements Payment {
    private String upiId;

    public UpiPayment(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing UPI payment for: $" + String.format("%.2f", amount));
        System.out.println("UPI ID: " + upiId);
        System.out.println("Payment Successful!");
        return true;
    }
}
