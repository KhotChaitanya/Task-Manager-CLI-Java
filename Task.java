// File: src/Task.java

public class Task {
    private int id;
    private String title;
    private String description;
    private String deadline;
    private boolean isCompleted;

    // Constructor
    public Task(int id, String title, String description, String deadline) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.isCompleted = false; // By default, task is not completed
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDeadline() {
        return deadline;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public void markCompleted() {
        this.isCompleted = true;
    }

    // toString method to display task nicely
    @Override
    public String toString() {
        return "Task ID: " + id + "\n" +
               "Title: " + title + "\n" +
               "Description: " + description + "\n" +
               "Deadline: " + deadline + "\n" +
               "Status: " + (isCompleted ? "Completed ✅" : "Pending ❌");
    }
}
