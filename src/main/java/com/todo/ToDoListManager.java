package com.todo;

import java.util.ArrayList;
import java.util.Scanner;

public class ToDoListManager {
    private ArrayList<User> users;

    public ToDoListManager() {
        users = new ArrayList<>();
    }

    public void addUser(String name) {
        if (getUser(name) == null) {
            users.add(new User(name));
            System.out.println("User '" + name + "' created successfully.");
        } else {
            System.out.println("User with name '" + name + "' already exists.");
        }
    }

    public User getUser(String name) {
        for (User user : users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    public void addTaskToUser(String userName, String taskDescription) {
        User user = getUser(userName);
        if (user != null) {
            user.addTask(taskDescription);
        } else {
            System.out.println("User not found");
        }
    }

    public void markTaskAsCompleted(String userName, String taskDescription) {
        User user = getUser(userName);
        if (user != null) {
            user.markTaskAsCompleted(taskDescription);
        } else {
            System.out.println("User not found");
        }
    }

    public void viewTasksOfUser(String userName) {
        User user = getUser(userName);
        if (user != null) {
            user.viewTasks();
        } else {
            System.out.println("User not found");
        }
    }

    public static void main(String[] args) {
        ToDoListManager manager = new ToDoListManager();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nTo-Do List Manager");
            System.out.println("1. Add User");
            System.out.println("2. Add Task to User");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. View Tasks of User");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter user name: ");
                    String userName = scanner.nextLine();
                    manager.addUser(userName);
                    break;
                case 2:
                    System.out.print("Enter user name: ");
                    userName = scanner.nextLine();
                    System.out.print("Enter task description: ");
                    String taskDescription = scanner.nextLine();
                    manager.addTaskToUser(userName, taskDescription);
                    break;
                case 3:
                    System.out.print("Enter user name: ");
                    userName = scanner.nextLine();
                    System.out.print("Enter task description to mark as completed: ");
                    taskDescription = scanner.nextLine();
                    manager.markTaskAsCompleted(userName, taskDescription);
                    break;
                case 4:
                    System.out.print("Enter user name: ");
                    userName = scanner.nextLine();
                    System.out.println(userName + "'s tasks:");
                    manager.viewTasksOfUser(userName);
                    break;
                case 5:
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }

        scanner.close();
    }
}
