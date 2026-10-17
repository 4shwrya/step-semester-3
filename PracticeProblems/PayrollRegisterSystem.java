import java.util.*;

class Employee {
    String name;
    double basicSalary;

    Employee(String name, double basicSalary) {
        this.name = name;
        this.basicSalary = basicSalary;
    }

    double calculateHRA() {
        return basicSalary * 0.20;
    }

    double calculateDA() {
        return basicSalary * 0.10;
    }

    double calculatePF() {
        return basicSalary * 0.12;
    }

    double calculateGrossSalary() {
        return basicSalary + calculateHRA() + calculateDA();
    }

    double calculateTax() {
        if (basicSalary > 750000) {
            return basicSalary * 0.10;
        }
        return 0;
    }

    double calculateNetSalary() {
        return calculateGrossSalary() - calculatePF() - calculateTax();
    }

    void displaySalary() {
        System.out.println("Employee: " + name);
        System.out.printf("Gross Salary: %.2f%n", calculateGrossSalary());
        System.out.printf("PF: %.2f%n", calculatePF());
        System.out.printf("Tax: %.2f%n", calculateTax());
        System.out.printf("Net Salary: %.2f%n", calculateNetSalary());
    }
}

public class PayrollRegisterSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name = sc.nextLine();
        double basicSalary = sc.nextDouble();

        Employee employee = new Employee(name, basicSalary);
        employee.displaySalary();

        sc.close();
    }
}