package com.DesignPatterns;

class OrderService {
    public void createOrder(String product) {
        System.out.println("Order created for: " + product);
    }
}

class PaymentService {
    public void processPayment(String paymentMethod) {
        System.out.println("Payment processed using: " + paymentMethod);
    }
}

class InvoiceService {
    public void generateInvoice() {
        System.out.println("Invoice generated for the order.");
    }
}

class NotificationService {
    public void sendConfirmation() {
        System.out.println("Order confirmation email sent.");
    }
}

class OrderFacade {
    private OrderService orderService;
    private PaymentService paymentService;
    private InvoiceService invoiceService;
    private NotificationService notificationService;

    public OrderFacade() {
        this.orderService = new OrderService();
        this.paymentService = new PaymentService();
        this.invoiceService = new InvoiceService();
        this.notificationService = new NotificationService();
    }

    public void placeOrder(String product, String paymentMethod) {
        System.out.println("\n--- Placing Order ---");
        orderService.createOrder(product);
        paymentService.processPayment(paymentMethod);
        invoiceService.generateInvoice();
        notificationService.sendConfirmation();
        System.out.println("--- Order Completed Successfully ---\n");
    }
}

public class FacadePatternDemo {
    public static void main(String[] args) {
        OrderFacade orderFacade = new OrderFacade();

        // Placing an order using the facade
        orderFacade.placeOrder("Laptop", "Credit Card");
    }
}

