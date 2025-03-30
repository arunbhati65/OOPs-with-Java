package com.DesignPatterns;

interface PaymentGateway {
    void pay(double amount);
}

class BankPayment {
    void processPayment(double amount) {
        System.out.println("Processing payment of ₹" + amount + " via bank transfer.");
    }
}

class BankPaymentAdapter implements PaymentGateway {
    private BankPayment bankPayment;

    public BankPaymentAdapter(BankPayment bankPayment) {
        this.bankPayment = bankPayment;
    }

    @Override
    public void pay(double amount) {
        bankPayment.processPayment(amount); // Adapting method
    }
}

public class AdapterPatternDemo {
    public static void main(String[] args) {
        BankPayment bankPayment = new BankPayment();
        PaymentGateway paymentGateway = new BankPaymentAdapter(bankPayment);

        paymentGateway.pay(5000); // Uses adapter to call processPayment()
    }
}
