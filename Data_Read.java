package com.mycompany.team5;

import java.time.LocalDate;
import java.util.Random;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class Data_Read {
    String Name;
    String Gender;
    String Religion;
    String Address;
    String Government;
    String Date;
    int day, month, year;

    public Id_Class getDataFromUser() {
        Name = JOptionPane.showInputDialog("Enter Name:");
        Gender = getGender();
        Religion = getReligion();
        Address = getAddress();
        Government = JOptionPane.showInputDialog("Enter Government:");
        Date = getValidatedDate();
        
        // Generate a unique ID
        String uniqueID = generate_unique();

        // Create an Id_Class object with collected data
        return new Id_Class(uniqueID, Name, Gender, Religion, Government,Address, Date);
    }

  public void editData(Id_Class userRecord) {
    while (true) {
        // Define options for the dropdown
        String[] options = {"Name", "Gender", "Religion", "Address", "Government", "Date"};
        
        // Define buttons for the dialog
        Object[] buttons = {"Edit", "Done"};
        
        // Create the dropdown menu for selecting the field to edit
        JComboBox<String> fieldSelector = new JComboBox<>(options);
        
        // Show dialog with the dropdown and custom buttons
        int result = JOptionPane.showOptionDialog(
                null,
                fieldSelector, // Add the dropdown to the dialog
                "Edit User Data",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                buttons, // Custom buttons
                buttons[0] // Default button
        );
        
        // Check if the user clicked "Done" or closed the dialog
        if (result != 0) { // If "Edit" is not clicked, exit the loop
            break;
        }
        
        // Get the selected field to edit
        String fieldToEdit = (String) fieldSelector.getSelectedItem();
        
        // Handle the selected field
        switch (fieldToEdit) {
            case "Name":
                userRecord.setName(JOptionPane.showInputDialog("Enter new Name:", userRecord.getName()));
                break;

            case "Gender":
                userRecord.setGender(getGender());
                break;

            case "Religion":
                userRecord.setReligion(getReligion());
                break;

            case "Address":
                userRecord.setAddress(getAddress());
                break;

            case "Government":
                userRecord.setGovernment(JOptionPane.showInputDialog("Enter new Government:", userRecord.getGovernment()));
                break;

            case "Date":
                userRecord.setDate(getValidatedDate());
                break;

            default:
                JOptionPane.showMessageDialog(null, "Invalid option!");
        }
    }
}

    private String getGender() {
        String[] options = {"Male", "Female"};
        return (String) JOptionPane.showInputDialog(null, "Select Gender:", "Gender Selection",
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
    }

    private String getReligion() {
        String[] options = {"Muslim", "Christian", "Other"};
        return (String) JOptionPane.showInputDialog(null, "Select Religion:", "Religion Selection",
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
    }

    private String getAddress() {
        String address;
        do {
            address = JOptionPane.showInputDialog("Enter Address (min 6 characters):");
            if (address.length() < 6) {
                JOptionPane.showMessageDialog(null, "Address must be at least 6 characters long.");
            }
        } while (address.length() < 6);
        return address;
    }

    private String getValidatedDate() {
        while (true) {
            try {
                int day = Integer.parseInt(JOptionPane.showInputDialog("Enter Day:"));
                int month = Integer.parseInt(JOptionPane.showInputDialog("Enter Month:"));
                int year = Integer.parseInt(JOptionPane.showInputDialog("Enter Year:"));

                LocalDate inputDate = LocalDate.of(year, month, day);
                if (inputDate.isAfter(LocalDate.now())) {
                    JOptionPane.showMessageDialog(null, "The date cannot be in the future.");
                } else {
                    this.day = day;
                    this.month = month;
                    this.year = year;
                    return day + "/" + month + "/" + year;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Invalid date. Please try again.");
            }
        }
    }

    public String generate_unique() {
        String prefix = (year >= 2000) ? "3" : "2";
        String yearPart = String.valueOf(year).substring(2);
        String monthPart = (month < 10) ? "0" + month : String.valueOf(month);
        String dayPart = (day < 10) ? "0" + day : String.valueOf(day);
        String governorateCode = getGovernorateCode(Government);
        String genderCode = Gender.equals("Male") ? "1" : "2";
        int randomNum = new Random().nextInt(100);

        return prefix + yearPart + monthPart + dayPart + "21" + governorateCode + genderCode + randomNum;
    }

    public String getGovernorateCode(String government) {
        switch (government.toLowerCase()) {
            case "cairo":
            return "01";
        case "alexandria":
            return "02";
        case "port said":
            return "03";
        case "suez":
            return "04";
        case "damietta":
            return "11";
        case "dakahlia":
            return "12";
        case "sharkia":
            return "13";
        case "qalyubia":
            return "14";
        case "kafr el sheikh":
            return "15";
        case "gharbia":
            return "16";
        case "monufia":
            return "17";
        case "beheira":
            return "18";
        case "ismailia":
            return "19";
        case "giza":
            return "21";
        case "beni suef":
            return "22";
        case "fayoum":
            return "23";
        case "minya":
            return "24";
        case "assiut":
            return "25";
        case "sohag":
            return "26";
        case "qena":
            return "27";
        case "aswan":
            return "28";
        case "luxor":
            return "29";
        case "red sea":
            return "31";
        case "new valley":
            return "32";
        case "matruh":
            return "33";
        case "north sinai":
            return "34";
        case "south sinai":
            return "35";
        default:
            return "99"; // Unknown governorate
        }
    }
}
