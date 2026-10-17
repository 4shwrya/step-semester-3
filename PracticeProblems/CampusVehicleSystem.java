import java.util.*;

class Vehicle {
    String number;
    String type;

    Vehicle(String number, String type) {
        this.number = number;
        this.type = type;
    }
}

class ParkingLot {
    ArrayList<Vehicle> vehicles = new ArrayList<>();

    void parkVehicle(String number, String type) {
        for (Vehicle v : vehicles) {
            if (v.number.equals(number)) {
                System.out.println("Duplicate vehicle");
                return;
            }
        }

        vehicles.add(new Vehicle(number, type));
        System.out.println("Vehicle parked");
    }

    void removeVehicle(String number) {
        for (Vehicle v : vehicles) {
            if (v.number.equals(number)) {
                vehicles.remove(v);
                System.out.println("Vehicle removed");
                return;
            }
        }

        System.out.println("Vehicle not found");
    }

    void displayVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles parked");
            return;
        }

        for (Vehicle v : vehicles) {
            System.out.println(v.number + " " + v.type);
        }
    }
}

public class CampusVehicleSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ParkingLot lot = new ParkingLot();

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split(" ");

            String operation = input[0];
            String number = input[1];

            switch (operation) {
                case "PARK":
                    String type = input[2];
                    lot.parkVehicle(number, type);
                    break;

                case "REMOVE":
                    lot.removeVehicle(number);
                    break;

                case "DISPLAY":
                    lot.displayVehicles();
                    break;
            }
        }

        sc.close();
    }
}