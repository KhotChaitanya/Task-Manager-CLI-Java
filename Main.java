// File: src/Main.java

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();

        System.out.println("=====================================");
        System.out.println("     Welcome to Task Manager CLI     ");
        System.out.println("=====================================");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add a New Task");
            System.out.println("2. View All Tasks");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Exit");

            System.out.print("\nEnter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter Task Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Task Description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter Task Deadline (dd-mm-yyyy): ");
                    String deadline = scanner.nextLine();
                    
                    int id = taskManager.generateTaskId();
                    Task newTask = new Task(id, title, description, deadline);
                    taskManager.addTask(newTask);
                    break;

                case "2":
                    taskManager.viewTasks();
                    break;

                case "3":
                    System.out.print("Enter Task ID to mark as completed: ");
                    try {
                        int taskId = Integer.parseInt(scanner.nextLine());
                        taskManager.markTaskCompleted(taskId);
                    } catch (NumberFormatException e) {
                        System.out.println("❌ Invalid Task ID. Please enter a number.");
                    }
                    break;

                case "4":
                    taskManager.saveTasks();
                    System.out.println("📂 Tasks saved. Exiting program...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("⚠️ Invalid choice. Please select 1, 2, 3 or 4.");
            }
        }
    }
}
