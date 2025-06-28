import java.util.Scanner;

class Task {
    int taskId;
    String taskName;
    String status;
    Task next;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.next = null;
    }

    @Override
    public String toString() {
        return "TaskID: " + taskId + ", Name: " + taskName + ", Status: " + status;
    }
}

public class TaskManagementSystem {

    private Task head;

    public void addTask(int id, String name, String status) {
        Task newTask = new Task(id, name, status);
        if (head == null) {
            head = newTask;
        } else {
            Task current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newTask;
        }
        System.out.println("Task added: " + newTask);
    }

    public Task searchTask(int id) {
        Task current = head;
        while (current != null) {
            if (current.taskId == id) return current;
            current = current.next;
        }
        return null;
    }

    public void traverseTasks() {
        if (head == null) {
            System.out.println("No tasks found.");
            return;
        }
        System.out.println("Task List:");
        Task current = head;
        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
    }

    public boolean deleteTask(int id) {
        if (head == null) return false;
        if (head.taskId == id) {
            head = head.next;
            return true;
        }
        Task current = head;
        Task prev = null;
        while (current != null && current.taskId != id) {
            prev = current;
            current = current.next;
        }
        if (current == null) return false;
        prev.next = current.next;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskManagementSystem system = new TaskManagementSystem();

        boolean exit = false;
        while (!exit) {
            System.out.println("\nTask Management System");
            System.out.println("1. Add Task");
            System.out.println("2. Search Task by ID");
            System.out.println("3. Traverse Tasks");
            System.out.println("4. Delete Task by ID");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Task ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Task Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Status: ");
                    String status = sc.nextLine();
                    system.addTask(id, name, status);
                    break;

                case 2:
                    System.out.print("Enter Task ID to search: ");
                    int searchId = sc.nextInt();
                    sc.nextLine();
                    Task found = system.searchTask(searchId);
                    if (found != null) System.out.println("Found: " + found);
                    else System.out.println("Task not found.");
                    break;

                case 3:
                    system.traverseTasks();
                    break;

                case 4:
                    System.out.print("Enter Task ID to delete: ");
                    int delId = sc.nextInt();
                    sc.nextLine();
                    boolean deleted = system.deleteTask(delId);
                    System.out.println(deleted ? "Task deleted." : "Task not found.");
                    break;

                case 5:
                    exit = true;
                    System.out.println("Exiting Task Management System.");
                    break;

                default:
                    System.out.println("Invalid option, try again.");
            }
        }
        sc.close();
    }
}
