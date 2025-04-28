// File: src/TaskManager.java

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks;
    private static final String FILE_NAME = "tasks.txt";

    // Constructor
    public TaskManager() {
        tasks = new ArrayList<>();
        loadTasks(); // Jab program start hoga, existing tasks load kar lenge
    }

    // Add a new task
    public void addTask(Task task) {
        tasks.add(task);
        System.out.println("✅ Task added successfully!\n");
    }

    // View all tasks
    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("⚠️ No tasks found!\n");
        } else {
            for (Task task : tasks) {
                System.out.println(task);
                System.out.println("----------------------------");
            }
        }
    }

    // Mark a task as completed by ID
    public void markTaskCompleted(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.markCompleted();
                System.out.println("✅ Task marked as completed!\n");
                return;
            }
        }
        System.out.println("⚠️ Task with ID " + id + " not found!\n");
    }

    // Save tasks to file
    public void saveTasks() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Task task : tasks) {
                writer.write(task.getId() + "|" +
                             task.getTitle() + "|" +
                             task.getDescription() + "|" +
                             task.getDeadline() + "|" +
                             task.isCompleted());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("❌ Error saving tasks: " + e.getMessage());
        }
    }

    // Load tasks from file
    private void loadTasks() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return; // Agar file nahi hai to kuch karne ka zarurat nahi
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 5) {
                    int id = Integer.parseInt(parts[0]);
                    String title = parts[1];
                    String description = parts[2];
                    String deadline = parts[3];
                    boolean isCompleted = Boolean.parseBoolean(parts[4]);
                    Task task = new Task(id, title, description, deadline);
                    if (isCompleted) {
                        task.markCompleted();
                    }
                    tasks.add(task);
                }
            }
        } catch (IOException e) {
            System.out.println("❌ Error loading tasks: " + e.getMessage());
        }
    }

    // Generate new task ID
    public int generateTaskId() {
        return tasks.size() + 1;
    }
}
