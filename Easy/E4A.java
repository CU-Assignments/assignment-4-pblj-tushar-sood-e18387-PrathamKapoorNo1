import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ID :- " + id + ", Name :- " + name + ", Salary :- " + salary;
    }
}

public class E4A {
    private static ArrayList<Employee> employees = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void addEmployee() {
        System.out.print("Enter Employee ID :- ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Employee Name :- ");
        String name = scanner.nextLine();
        System.out.print("Enter Employee Salary :- ");
        double salary = scanner.nextDouble();
        employees.add(new Employee(id, name, salary));
        System.out.println("Employee Added Successfully!\n");
    }

    public static void updateEmployee() {
        System.out.print("Enter Employee ID to Update :- ");
        int id = scanner.nextInt();
        scanner.nextLine();
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                System.out.print("Enter New Name :- ");
                emp.setName(scanner.nextLine());
                System.out.print("Enter New Salary :- ");
                emp.setSalary(scanner.nextDouble());
                System.out.println("Employee Updated Successfully!\n");
                return;
            }
        }
        System.out.println("Employee Not Found!\n");
    }

    public static void removeEmployee() {
        System.out.print("Enter Employee ID to Remove :- ");
        int id = scanner.nextInt();
        employees.removeIf(emp -> emp.getId() == id);
        System.out.println("Employee Removed Successfully!\n");
    }

    public static void searchEmployee() {
        System.out.print("Enter Employee ID to Search :- ");
        int id = scanner.nextInt();
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                System.out.println(emp + "\n");
                return;
            }
        }
        System.out.println("Employee Not Found!\n");
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Remove Employee");
            System.out.println("4. Search Employee");
            System.out.println("5. Exit");
            System.out.print("Choose an Option :- ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    updateEmployee();
                    break;
                case 3:
                    removeEmployee();
                    break;
                case 4:
                    searchEmployee();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid Choice!\n");
            }
        }
    }
}