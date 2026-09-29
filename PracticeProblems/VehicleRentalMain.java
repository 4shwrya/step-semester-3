import java.util.*;

abstract class Vehicle {
    private String id;
    private boolean available = true;

    Vehicle(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public abstract double calculateCharge(int days);
}

class Sedan extends Vehicle {
    Sedan(String id) {
        super(id);
    }

    public double calculateCharge(int days) {
        return days * 50;
    }
}

class SUV extends Vehicle {
    SUV(String id) {
        super(id);
    }

    public double calculateCharge(int days) {
        return days * 80;
    }
}

class Customer {
    String name;

    Customer(String name) {
        this.name = name;
    }
}

class Rental {
    Vehicle vehicle;
    Customer customer;
    int days;

    Rental(Vehicle vehicle, Customer customer, int days) {
        this.vehicle = vehicle;
        this.customer = customer;
        this.days = days;
    }

    public double getCharge() {
        return vehicle.calculateCharge(days);
    }
}

class RentalSystem {
    private List<Rental> rentals = new ArrayList<>();

    public void rentVehicle(Vehicle v, Customer c, int days) {
        if (days <= 0) {
            System.out.println("Invalid rental duration.");
            return;
        }

        if (!v.isAvailable()) {
            System.out.println(v.getId() + " is currently unavailable.");
            return;
        }

        v.setAvailable(false);
        Rental rental = new Rental(v, c, days);
        rentals.add(rental);

        System.out.println(v.getId() + " rented successfully by " + c.name);
        System.out.println("Rental charge: $" + rental.getCharge());
    }

    public void returnVehicle(Vehicle v, Customer c) {
        for (Rental r : rentals) {
            if (r.vehicle == v && r.customer == c) {
                rentals.remove(r);
                v.setAvailable(true);
                System.out.println(v.getId() + " returned by " + c.name);
                return;
            }
        }

        System.out.println("No active rental found.");
    }
}

public class VehicleRentalMain {
    public static void main(String[] args) {
        Vehicle sedan = new Sedan("Sedan A");
        Vehicle suv = new SUV("SUV B");

        Customer c1 = new Customer("Customer 1");
        Customer c2 = new Customer("Customer 2");
        Customer c3 = new Customer("Customer 3");

        RentalSystem system = new RentalSystem();

        system.rentVehicle(sedan, c1, 3);
        system.rentVehicle(sedan, c2, 2);
        system.returnVehicle(sedan, c1);
        system.rentVehicle(suv, c3, 5);
    }
}