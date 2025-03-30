package com.solidPrinciples;

/*class DiscountCalculatorBAD {
    public double calculateDiscount(String customerType, double amount) {
        if (customerType.equals("Regular")) {
            return amount * 0.1;
        } else if (customerType.equals("Premium")) {
            return amount * 0.2;
        }
        return 0;
    }
}*/
//GOOD EXAMPLE
interface DiscountStrategy {
    double applyDiscount(double amount);
}

class RegularCustomerDiscount implements DiscountStrategy {
    public double applyDiscount(double amount) {
        return amount * 0.1;
    }
}

class PremiumCustomerDiscount implements DiscountStrategy {
    public double applyDiscount(double amount) {
        return amount * 0.2;
    }
}

class DiscountCalculator {
    public double calculateDiscount(DiscountStrategy strategy, double amount) {
        return strategy.applyDiscount(amount);
    }
}

// Usage
public class O {
    public static void main(String[] args) {
        DiscountCalculator calculator = new DiscountCalculator();
        double discount = calculator.calculateDiscount(new RegularCustomerDiscount(), 1000);
        System.out.println("Discount: " + discount);
    }
}
