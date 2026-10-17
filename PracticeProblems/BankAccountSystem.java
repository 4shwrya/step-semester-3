
import java.util.*;

abstract class Staff {
    String name;
    String type;

    Staff(String name, String type) {
        this.name = name;
        this.type = type;
    }

    abstract long calculatePay();

    @Override
    public String toString() {
        return "Payslip[name=" + name
            + ", type=" + type
            + ", pay=" + calculatePay() + "]";
    }
}

class FullTime extends Staff {
    long salary;

    FullTime(String name, long salary) {
        super(name, "FullTime");
        this.salary = salary;
    }

    long calculatePay() {
        return salary;
    }
}

class PartTime extends Staff {
    long hours;
    long rate;

    PartTime(String name, long hours, long rate) {
        super(name, "PartTime");
        this.hours = hours;
        this.rate = rate;
    }

    long calculatePay() {
        return hours * rate;
    }
}

class Intern extends Staff {
    long stipend;

    Intern(String name, long stipend) {
        super(name, "Intern");
        this.stipend = stipend;
    }

    long calculatePay() {
        return stipend;
    }
}

public class BankAccountSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Staff> staffList = new ArrayList<>();

        while (sc.hasNext()) {
            String type = sc.next();
            String name = sc.next();

            switch (type) {
                case "FullTime":
                    staffList.add(
                        new FullTime(name, sc.nextLong())
                    );
                    break;

                case "PartTime":
                    long hours = sc.nextLong();
                    long rate = sc.nextLong();

                    staffList.add(
                        new PartTime(name, hours, rate)
                    );
                    break;

                case "Intern":
                    staffList.add(
                        new Intern(name, sc.nextLong())
                    );
                    break;
            }
        }

        Staff[] payslips = staffList.toArray(new Staff[0]);

        long total = 0;
        Staff topEarner = null;

        for (Staff staff : payslips) {
            System.out.println(staff);
            long pay = staff.calculatePay();

            total += pay;

            if (topEarner == null
                    || pay > topEarner.calculatePay()) {
                topEarner = staff;
            }
        }

        System.out.println("Total " + total);

        if (topEarner != null) {
            System.out.println("top earner " + topEarner.name);
        }

        sc.close();
    }
}
