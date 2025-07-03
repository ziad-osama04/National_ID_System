package com.mycompany.team5;
import java.time.LocalDate; // to use the current time method

public class Id_Class {
    // declaration part
    final String ID;  // Unique ID (13 digits)
    String Name;
    String Gender;
    String Religion;
    String Address;
    String Government;
    String Date;
    LocalDate startingDate;
    final LocalDate IssueDate;

    // the constructor part to initialize the class with the generated ID and user data
    public Id_Class(String ID, String Name, String Gender, String Religion,String Government, String Address, String Date) {
        this.ID = ID;  // Set the unique ID which will take from (generate_unique) method
        this.Name = Name;
        this.Gender = Gender;
        this.Religion = Religion;
        this.Address = Address;
        this.Date = Date;
        this.Government = Government;
        // Set the starting date as the current date
        this.startingDate = LocalDate.now();
        
        // The issue date is set as 7 years after the starting date
        this.IssueDate = startingDate.plusYears(7);
    }
    
    // getter and setter methods
    public String getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getReligion() {
        return Religion;
    }

    public void setReligion(String Religion) {
        this.Religion = Religion;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public LocalDate getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(LocalDate startingDate) {
        this.startingDate = startingDate;
    }

    public LocalDate getIssueDate() {
        return IssueDate;
    }

    public String getGovernment() {
        return Government;
    }

    public void setGovernment(String Government) {
        this.Government = Government;
    }

}
