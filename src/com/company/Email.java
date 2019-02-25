package com.company;

import java.lang.invoke.SwitchPoint;
import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int passwordLength = 10;
    private int mailboxCapacity = 1_000;
    private String alternateEmail;
    private String companySuffix = "company.com";

    //Constructor to receive the first name and last name

    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        //Call a method asking for the department - return the department
        this.department = setDepartment();

        //Call a method that returns a random password;
        this.password = randomPassword(passwordLength);
        System.out.println("Password: " + this.password);

        //Combine element to generate email
        this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@";

        if (department.length() == 0) {
            this.email += companySuffix;
        } else {
            this.email += department.substring(0, Math.min(this.department.length(), 3)).toLowerCase() + "." + companySuffix;
        }
    }

    //Ask for the department
    private String setDepartment() {
        System.out.print("New Worker "+ this.firstName + "\nEnter Department Code:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for None\n Enter Department Code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();

        switch (depChoice) {
            case 1:
                return "Sales";
            case 2:
                return "Development";
            case 3:
                return "Accounting";
            default:
                return "";
        }
    }

    //Generate a random password
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    //Set the mailbox capacity
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    //Set the alternate email
    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    //Change the password
    public void setPassword(String password) {
        this.password = password;
    }

    //get mailbox Capacity
    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    //get alternate email
    public String getAlternateEmail() {
        return alternateEmail;
    }

    //get password
    public String getPassword() {
        return password;
    }

    //get info
    public String getInfo() {
        return "Display Name: "+ this.firstName + " " + this.lastName +
                "\nCompany Email: " + this.email + " " +
                "\nMailbox Capacity: " + this.mailboxCapacity+"mb";
    }
}
