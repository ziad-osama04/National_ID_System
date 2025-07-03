package com.mycompany.team5;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

public class Team5 {
    public static void main(String[] args) {
        // Initialize a list to hold user data
        List<Id_Class> users = new ArrayList<>();
        // Create an instance of Data_Read to handle data operations
        Data_Read dataRead = new Data_Read();

        // Main loop to continuously display the menu until the user chooses to exit
        while (true) {
            // Define the menu options
            String[] options = {"Add User", "Edit User", "Display All Users", "Exit"};
            // Show the menu to the user and get their choice
            int choice = JOptionPane.showOptionDialog(
                    null,
                    "Choose an option:",
                    "User Management System",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]
            );

            // If the user chooses to exit or closes the dialog, break the loop
            if (choice == -1 || choice == 3) { 
                break;
            }

            // Handle the user's choice
            switch (choice) {
                case 0: // Add User
                    // Get user data from the user
                    dataRead.getDataFromUser();
                    // Generate a unique ID for the new user
                    String generatedId = dataRead.generate_unique();
                    // Create a new user object with the collected data
                    Id_Class newUser = new Id_Class(
                            generatedId,
                            dataRead.Name,
                            dataRead.Gender,
                            dataRead.Religion,
                            dataRead.Government,
                            dataRead.Address,
                            dataRead.Date
                    );
                    // Add the new user to the list
                    users.add(newUser);
                    // Inform the user that the user was added successfully
                    JOptionPane.showMessageDialog(null, "User added successfully!");
                     // Display the collected data
        JOptionPane.showMessageDialog(null, "Collected User Data:\n" +
        "Name: " + newUser.Name + "\n" +
        "Gender: " + newUser.Gender + "\n" +
        "Religion: " + newUser.Religion + "\n" +
        "Address: " + newUser.Address + "\n" +
        "Government: " + newUser.Government + "\n" +
        "Date: " + newUser.Date + "\n" +
        "Unique ID: " + newUser.ID + "\n" +
        "Starting Date: " + newUser.startingDate + "\n" +
        "Issue Date: " + newUser.IssueDate
);
                    break;

                case 1: // Edit User
                    // Check if there are any users to edit
                    if (users.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No users to edit.");
                    } else {
                        // Display all IDs for search
                        StringBuilder allIds = new StringBuilder("User IDs:\n");
                        for (Id_Class user : users) {
                            allIds.append(user.getID()).append("\n");
                        }

                        // Allow the user to search for a user by part of the ID
                        String searchQuery = JOptionPane.showInputDialog(
                                null,
                                allIds.toString() + "\nEnter a number or part of the ID to search:",
                                "Search User by ID",
                                JOptionPane.QUESTION_MESSAGE
                        );

                        if (searchQuery != null && !searchQuery.trim().isEmpty()) {
                            // Filter users by ID containing the search query
                            List<Id_Class> filteredUsers = users.stream()
                                    .filter(user -> user.getID().contains(searchQuery))
                                    .collect(Collectors.toList());

                            if (!filteredUsers.isEmpty()) {
                                // Show filtered IDs
                                StringBuilder filteredIds = new StringBuilder("Filtered User IDs:\n");
                                for (Id_Class user : filteredUsers) {
                                    filteredIds.append(user.getID()).append("\n");
                                }
                                String selectedUserId = JOptionPane.showInputDialog(
                                        null,
                                        filteredIds.toString() + "\nEnter the exact ID of the user you want to edit:",
                                        "Edit User",
                                        JOptionPane.QUESTION_MESSAGE
                                );

                                // Find and edit the user
                                if (selectedUserId != null) {
                                    Id_Class userToEdit = null;
                                    for (Id_Class user : filteredUsers) {
                                        if (user.getID().equals(selectedUserId)) {
                                            userToEdit = user;
                                            break;
                                        }
                                    }

                                    if (userToEdit != null) {
                                        dataRead.editData(userToEdit);
                                    } else {
                                        JOptionPane.showMessageDialog(null, "User with ID " + selectedUserId + " not found.");
                                    }
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "No users found with that ID.");
                            }
                        }
                    }
                    break;

                case 2: // Display All Users
                    // Check if there are any users to display
                    if (users.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No users available.");
                    } else {
                        StringBuilder userDisplay = new StringBuilder();
                        for (Id_Class user : users) {
                            userDisplay.append("Name: ").append(user.getName())
                                    .append("\nID: ").append(user.getID())
                                    .append("\nGender: ").append(user.getGender())
                                    .append("\nReligion: ").append(user.getReligion())
                                    .append("\nAddress: ").append(user.getAddress())
                                    .append("\nGovernment: ").append(user.getGovernment())
                                    .append("\nDate: ").append(user.getDate())
                                    .append("\n---\n");
                        }
                        JOptionPane.showMessageDialog(null, userDisplay.toString());
                    }
                    break;
            }
        }
    }
}
