package com.todo;

public class User {
    private String name;
    private TaskNode head;

    public User(String name) {
        this.name = name;
        this.head = null;
    }

    public String getName() {
        return name;
    }

    public void addTask(String description) {
        Task newTask = new Task(description);
        TaskNode newNode = new TaskNode(newTask);
        if (head == null) {
            head = newNode;
        } else {
            TaskNode current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    public void markTaskAsCompleted(String description) {
        TaskNode current = head;
        while (current != null) {
            if (current.getTask().getDescription().equals(description)) {
                current.getTask().markAsCompleted();
                return;
            }
            current = current.getNext();
        }
    }

    public void viewTasks() {
        TaskNode current = head;
        while (current != null) {
            System.out.println(current.getTask().toString());
            current = current.getNext();
        }
    }
}
