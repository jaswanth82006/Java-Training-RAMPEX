package com.foodorder.payments;

public interface Payment {
    // Abstract method to process payment
    boolean processPayment(double amount);
}
