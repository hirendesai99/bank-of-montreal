package org.bankapp.service;

import org.bankapp.dto.Client;

import java.util.Scanner;

public class BankAccount extends Client {
    //global variables
    boolean verified = false;
    public int choice;
    long accNum;
    int pin;

    //scanner class to get input from client
    Scanner scanner = new Scanner(System.in);

    //Bank function class object created
    BankFunction bankFunction = new BankFunction();

    //program will function with this method
    public void openAccount() {
        System.out.println("1: Already have an account");
        System.out.println("2: Create an account");

        System.out.print("Enter choice: ");
        choice = scanner.nextInt();

        switch (choice) {
            case 1:
                do {
                    accountExists();
                } while (!verified);
                break;
            case 2:
                getDetails();
                break;
            default:
                System.out.println("Please enter option from menu");
        }
    }

    //this method will be called when client choose create an account for the first time
    public void getDetails() {
        try {
            System.out.print("\nEnter Your First Name: ");
            setFirstName(scanner.next());

            System.out.print("Enter Your Last Name: ");
            setLastName(scanner.next());

            System.out.print("Enter Your Age: ");
            setAge(scanner.nextInt());

            System.out.print("Enter Your Email: ");
            setEmail(scanner.next());

            System.out.print("Enter Your Phone: ");
            setPhone(scanner.next());

            System.out.print("Enter Your Government Identity Name: ");
            setGovIdeName(scanner.next());

            System.out.print("Enter Your Government Identity Number: ");
            setGovIdeNumber(scanner.nextInt());

            verified = true;

        } catch (Exception ex) {
            System.out.println("Wrong input format Try Again please!!");
        }

        if (verified) {
            System.out.print("\nSet up the pin number for your new account: ");
            setUpPin(scanner.nextInt());
            System.out.println("New Account has been created successfully!!");
//            bankFunction.mainMenu();

            setAccountNumber(530534909);
            setCurrentAccount(true);
            openAccount();
        }
    }

    //if client already have an account then this method will be called
    public void accountExists() {
        System.out.print("\nPlease enter account number: ");
        accNum = scanner.nextLong();

        System.out.print("Please enter pin: ");
        pin = scanner.nextInt();

        if (accNum == getAccountNumber() && pin == getPin()) {
            System.out.println("Logged in successfully!!");
            verified = true;
            bankFunction.mainMenu();
        } else System.out.println("Incorrect information please check your login credentials again");
    }

    //method to create pin for the first time
    public void setUpPin(int pinDigits) {
        setPin(pinDigits);
    }

}
