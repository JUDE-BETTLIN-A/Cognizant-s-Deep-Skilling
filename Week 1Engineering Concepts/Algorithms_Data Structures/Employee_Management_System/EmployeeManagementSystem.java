import java.util.Scanner;

class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ID: " + employeeId + " | Name: " + name + " | Position: " + position + " | Salary: ₹" + salary;
    }
}

public class EmployeeManagementSystem {

    static final int MAX_EMPLOYEES = 100;
    static Employee[] employees = new Employee[MAX_EMPLOYEES];
    static int count = 0;

    public static void addEmployee(Scanner sc) {
        if (count >= MAX_EMPLOYEES) {
            System.out.println("Employee array is full.");
            return;
        }

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Position: ");
        String position = sc.nextLine();

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();
        sc.nextLine();

        employees[count++] = new Employee(id, name, position, salary);
        System.out.println("Employee added successfully.\n");
    }

    public static void searchEmployee(Scanner sc) {
        System.out.print("Enter Employee ID to search: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                System.out.println("Employee found: " + employees[i] + "\n");
                return;
            }
        }
        System.out.println("Employee not found.\n");
    }

    public static void traverseEmployees() {
        if (count == 0) {
            System.out.println("No employee records found.\n");
            return;
        }

        System.out.println("Employee List:");
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
        System.out.println();
    }

    public static void deleteEmployee(Scanner sc) {
        System.out.print("Enter Employee ID to delete: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--count] = null;
                System.out.println("Employee deleted successfully.\n");
                return;
            }
        }
        System.out.println("Employee not found.\n");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Employee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Search Employee by ID");
            System.out.println("3. Display All Employees");
            System.out.println("4. Delete Employee by ID");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addEmployee(sc);
                    break;
                case 2:
                    searchEmployee(sc);
                    break;
                case 3:
                    traverseEmployees();
                    break;
                case 4:
                    deleteEmployee(sc);
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting Employee Management System.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.\n");
            }
        }
        sc.close();
    }
}
