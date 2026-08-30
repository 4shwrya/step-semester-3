class Employee {

    String id;
    double salary;

    Employee(String id, double salary) {
        this.id = id;
        this.salary = salary;
    }

    void raiseSalary(double salary) {
        this.salary = this.salary + salary;
    }

    void display() {
        System.out.println(id +
                " | Final Salary: Rs " + salary);
    }
}

public class EmployeePayroll {

    public static void main(String[] args) {

        Employee[] emp = {
                new Employee("E-101", 40000),
                new Employee("E-102", 55000),
                new Employee("E-103", 62000),
                new Employee("E-104", 48000)
        };

        for (Employee e : emp) {
            e.raiseSalary(5000);
            e.display();
        }
    }
}