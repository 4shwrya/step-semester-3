import java.util.*;

class Customer {
    String name;

    Customer(String name) {
        this.name = name;
    }
}

class Product {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class OrderItem {
    Product product;
    int quantity;

    OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    double getSubtotal() {
        return product.price * quantity;
    }
}

interface PaymentMethod {
    boolean processPayment(double amount);
}

class CreditCardPayment implements PaymentMethod {
    public boolean processPayment(double amount) {
        System.out.println("Processing Credit Card payment: $" + amount);
        return true;
    }
}

class PayPalPayment implements PaymentMethod {
    public boolean processPayment(double amount) {
        System.out.println("Processing PayPal payment: $" + amount);
        return false;
    }
}

class BankTransferPayment implements PaymentMethod {
    public boolean processPayment(double amount) {
        System.out.println("Processing Bank Transfer: $" + amount);
        return true;
    }
}

class Order {
    private String orderId;
    private Customer customer;
    private List<OrderItem> items = new ArrayList<>();
    private String status = "Pending";

    Order(String orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        System.out.println("Order created for " + customer.name);
    }

    public void addProduct(Product product, int quantity) {
        if (quantity <= 0 || product.price < 0) {
            System.out.println("Invalid product or quantity.");
            return;
        }

        items.add(new OrderItem(product, quantity));
    }

    public double getTotal() {
        double total = 0;

        for (OrderItem item : items) {
            total += item.getSubtotal();
        }

        return total;
    }

    public void pay(PaymentMethod method, String methodName) {
        if (items.isEmpty()) {
            System.out.println("Cannot process payment for an empty order.");
            return;
        }

        if (status.equals("Paid")) {
            System.out.println("Order has already been paid.");
            return;
        }

        System.out.println("Payment initiated via " + methodName
                + " for Order " + orderId);

        if (method.processPayment(getTotal())) {
            status = "Paid";
            System.out.println("Payment for Order "
                    + orderId + " successful.");
        } else {
            System.out.println("Payment for Order "
                    + orderId + " failed.");
        }

        System.out.println("Order status: " + status);
    }
}

public class PaymentMain {
    public static void main(String[] args) {
        Customer x = new Customer("Customer X");
        Customer y = new Customer("Customer Y");
        Customer z = new Customer("Customer Z");

        Product a = new Product("Product A", 20);
        Product b = new Product("Product B", 30);
        Product c = new Product("Product C", 50);

        Order orderX = new Order("X", x);
        orderX.addProduct(a, 2);
        orderX.addProduct(b, 1);
        orderX.pay(new CreditCardPayment(), "Credit Card");

        Order orderY = new Order("Y", y);
        orderY.pay(new CreditCardPayment(), "Credit Card");

        Order orderZ = new Order("Z", z);
        orderZ.addProduct(c, 1);
        orderZ.pay(new PayPalPayment(), "PayPal");
    }
}