class EmployeeData {

    String empName;
    double salary;

    static String companyName = "Bright Horizon Technologies";

    static int employeeCount = 0;

    EmployeeData(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}

public class M5_StaticEmployee {
    public static void main(String[] args) {

        new EmployeeData("Divya", 65000);
        new EmployeeData("Arjun", 50000);
        new EmployeeData("Priya", 55000);

        EmployeeData.printCompanyInfo();
    }
}