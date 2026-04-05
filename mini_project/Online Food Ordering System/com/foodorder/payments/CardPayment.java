package com.foodorder.payments;

public class CardPayment implements Payment {
    private String cardNumber;
    private String cardHolderName;

    public CardPayment(String cardNumber, String cardHolderName) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }

    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing Card payment for: $" + String.format("%.2f", amount));
        System.out.println("Card Holder: " + cardHolderName + " | Last 4 digits: " + cardNumber.substring(Math.max(0, cardNumber.length() - 4)));
        System.out.println("Payment Successful!");
        return true;
    }
}
