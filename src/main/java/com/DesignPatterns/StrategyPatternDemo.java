package com.DesignPatterns;

// Strategy Interface
 interface PaymentStrategy {
    void pay(int amount);
}


// Credit Card Payment Strategy
 class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid ₹" + amount + " using Credit Card: " + cardNumber);
    }
}

// PayPal Payment Strategy
 class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid ₹" + amount + " using PayPal: " + email);
    }
}

// UPI Payment Strategy
 class UpiPayment implements PaymentStrategy {
    private String upiId;

    public UpiPayment(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid ₹" + amount + " using UPI: " + upiId);
    }
}


// Context Class
 class PaymentContext {
    private PaymentStrategy paymentStrategy;

    // Set strategy dynamically
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    // Delegate payment to strategy
    public void pay(int amount) {
        if (paymentStrategy == null) {
            throw new IllegalStateException("Payment strategy is not set.");
        }
        paymentStrategy.pay(amount);
    }
}

public class StrategyPatternDemo {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        // Pay using Credit Card
        context.setPaymentStrategy(new CreditCardPayment("1234-5678-9876-5432"));
        context.pay(5000);

        // Pay using PayPal
        context.setPaymentStrategy(new PayPalPayment("user@example.com"));
        context.pay(3000);

        // Pay using UPI
        context.setPaymentStrategy(new UpiPayment("user@upi"));
        context.pay(2000);
    }
}


