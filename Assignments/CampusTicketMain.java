import java.time.LocalDateTime;
import java.util.*;

public class CampusTicketMain {

    abstract static class Seat {
        private String seatId;

        Seat(String seatId) {
            this.seatId = seatId;
        }

        String getSeatId() {
            return seatId;
        }

        abstract double getPrice();
    }

    static class RegularSeat extends Seat {
        RegularSeat(String id) { super(id); }
        double getPrice() { return 150; }
    }

    static class PremiumSeat extends Seat {
        PremiumSeat(String id) { super(id); }
        double getPrice() { return 250; }
    }

    static class ReclinerSeat extends Seat {
        ReclinerSeat(String id) { super(id); }
        double getPrice() { return 400; }
    }

    static class Customer {
        private String name;

        Customer(String name) {
            this.name = name;
        }

        String getName() {
            return name;
        }
    }

    static class Show {
        private String showName;
        private LocalDateTime startTime;
        private Map<String, Seat> seats = new HashMap<>();
        private Set<String> bookedSeats = new HashSet<>();

        Show(String showName, LocalDateTime startTime) {
            this.showName = showName;
            this.startTime = startTime;
        }

        void addSeat(Seat seat) {
            seats.put(seat.getSeatId(), seat);
        }

        Booking book(Customer customer, String... seatIds) {
            if (seatIds.length == 0 || seatIds.length > 6) {
                System.out.println(
                        "A booking must contain 1 to 6 seats.");
                return null;
            }

            Set<String> requested = new HashSet<>(
                    Arrays.asList(seatIds));

            if (requested.size() != seatIds.length) {
                System.out.println("Duplicate seat in booking.");
                return null;
            }

            for (String id : seatIds) {
                if (!seats.containsKey(id)) {
                    System.out.println("Invalid seat: " + id);
                    return null;
                }

                if (bookedSeats.contains(id)) {
                    System.out.println("Seat " + id
                            + " is already booked for this show.");
                    return null;
                }
            }

            List<Seat> selected = new ArrayList<>();

            for (String id : seatIds) {
                selected.add(seats.get(id));
            }

            bookedSeats.addAll(requested);

            Booking booking = new Booking(
                    customer, this, selected);

            booking.display();
            return booking;
        }

        boolean cancel(Booking booking) {
            if (LocalDateTime.now().isAfter(startTime)
                    || LocalDateTime.now().isEqual(startTime)) {
                System.out.println("Cannot cancel after the show starts.");
                return false;
            }

            for (Seat seat : booking.getSeats()) {
                bookedSeats.remove(seat.getSeatId());
            }

            System.out.println(booking.getCustomer().getName()
                    + "'s booking cancelled.");

            System.out.print("Seats released: ");
            booking.getSeats().forEach(
                    s -> System.out.print(s.getSeatId() + " "));
            System.out.println();

            return true;
        }
    }

    static class Booking {
        private Customer customer;
        private Show show;
        private List<Seat> seats;

        Booking(Customer customer, Show show, List<Seat> seats) {
            this.customer = customer;
            this.show = show;
            this.seats = seats;
        }

        Customer getCustomer() { return customer; }
        List<Seat> getSeats() { return seats; }

        void display() {
            System.out.print("Booking confirmed for "
                    + customer.getName() + ": ");

            double total = 0;

            for (Seat seat : seats) {
                System.out.print(seat.getSeatId() + " ");
                total += seat.getPrice();
            }

            System.out.printf("%nTotal: ₹%.2f%n", total);
        }
    }

    public static void main(String[] args) {
        Show show = new Show("7 PM Show",
                LocalDateTime.now().plusHours(2));

        show.addSeat(new RegularSeat("A1"));
        show.addSeat(new RegularSeat("A2"));
        show.addSeat(new PremiumSeat("F5"));
        show.addSeat(new ReclinerSeat("R1"));

        Customer asha = new Customer("Asha");
        Customer ravi = new Customer("Ravi");
        Customer neha = new Customer("Neha");

        Booking ashaBooking = show.book(asha, "A1", "A2", "F5");

        show.book(ravi, "A2");
        show.book(ravi, "R1");

        if (ashaBooking != null) {
            show.cancel(ashaBooking);
        }

        show.book(neha, "A2");
    }
}
