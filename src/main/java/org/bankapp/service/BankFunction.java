package org.bankapp.service;

import org.bankapp.dto.Client;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BankFunction extends Client {
    //variable declaration
    int choice, pin;
    boolean flag = false;
    double totalAmount;

    //scanner class to get input from client
    Scanner scanner = new Scanner(System.in);

    //method to show main menu
    public void mainMenu() {
        do {
            System.out.println("\nMenu");
            System.out.println("1: Current Account");
            System.out.println("2: Savings Account");
            System.out.println("3: Change Pin");
            System.out.println("4: Deposit Money");
            System.out.println("5: Withdraw Money");
            System.out.println("6: Show Balance");
            System.out.println("7: Exit the Application");

            try {
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter correct choice and try again.");
            }

            switch (choice) {
                case 1:
                    getCurrentAccountDetails();
                    break;
                case 2:
                    getSavingsAccountDetails();
                    break;
                case 3:
                    changePin();
                    break;
                case 4:
                    depositMoney();
                    break;
                case 5:
                    withdrawMoney();
                    break;
                case 6:
                    showBalance();
                    break;
                case 7:
                    System.out.println("Exiting the app\nThank you:)");
                    break;
                default:
                    System.out.println("Please select the correct option\nThank you :)");
                    break;
            }
        } while (choice != 7);
    }

    //method to show basic account details in both current and savings
    private void basicAccountDetails() {
        System.out.println("Account number: " + getAccountNumber());
        System.out.println("Name: " + getFirstName() + " " + getLastName());
        System.out.println("Email: " + getEmail());
        System.out.println("Phone: " + getPhone());
        System.out.println("Government identity: " + getGovIdeName());
        System.out.println("Total Balance: " + getTotalBalance());
    }

    //method to show current account details
    private void getCurrentAccountDetails() {
        System.out.println("\nCurrent Account Details\n");
        basicAccountDetails();
        System.out.println("Current Balance: " + getCurrentBalance());
    }

    //get savings account details
    private void getSavingsAccountDetails() {
        if (getSavingsAccount()) {
            System.out.println("\nSavings Account Details\n");
            basicAccountDetails();
            System.out.println("Savings Balance: " + getCurrentBalance());
        } else System.out.println("You do not have savings account.");
    }

    //method to change pin of an account
    private void changePin() {
        System.out.print("Please enter your old pin number: ");
        pin = scanner.nextInt();
        if (pin == getPin()) {
            System.out.print("Enter new pin: ");
            if (getPin() == scanner.nextInt()) {
                System.out.println("Please enter different pin rather than old pin for the security purposes");
            } else {
                setPin(pin);
                System.out.println("New pin has been set successfully");
            }
        } else System.out.println("Wrong old pin number try again");
    }

    //method to deposit money into the account
    private void depositMoney() {
        System.out.print("\nEnter the amount you want to deposit: ");
        totalAmount = scanner.nextDouble();

        do {
            try {
                System.out.println("1: Current Account");
                System.out.println("2: Savings Account");
                System.out.print("Select the account you wish to choose: ");
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter option in correct format and try again");
            }

            switch (choice) {
                case 1:
                    setTotalBalance(getTotalBalance() + totalAmount);
                    setCurrentBalance(getTotalBalance());
                    System.out.println(totalAmount + " has been deposited to your current account");
                    break;
                case 2:
                    if (getSavingsAccount()) {
                        setTotalBalance(getTotalBalance() + totalAmount);
                        setSavingsBalance(getTotalBalance());
                        System.out.println(totalAmount + " has been deposited to your savings account");
                    } else System.out.println("You do not have savings account.");
                    break;
                default:
                    System.out.println("Please select the right option");
                    break;
            }
        } while (flag);
    }

    //method to withdraw money from the account
    private void withdrawMoney() {
        System.out.print("\nEnter the amount you want to withdraw: ");
        totalAmount = scanner.nextDouble();

        if (totalAmount < getTotalBalance()) {

            do {
                try {
                    System.out.println("1: Current Account");
                    System.out.println("2: Savings Account");
                    System.out.print("Select the account you wish to choose: ");
                    choice = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Please enter option in correct format and try again");
                }

                switch (choice) {
                    case 1:
                        setTotalBalance(getTotalBalance() - totalAmount);
                        setCurrentBalance(getTotalBalance());
                        System.out.println(totalAmount + " has been withdrawn from your current account");
                        break;
                    case 2:
                        if (getSavingsAccount()) {
                            setTotalBalance(getTotalBalance() - totalAmount);
                            setSavingsBalance(getTotalBalance());
                            System.out.println(totalAmount + " has been withdrawn from your current account");
                        } else System.out.println("You do not have savings account.");

                        break;
                    default:
                        System.out.println("Please select the right option");
                        break;
                }
            } while (flag);
        } else System.out.println("Not enough balance please check your balance and try again.");
    }

    //if client choose show balance option
    public void showBalance() {
        System.out.println("\nTotal Balance: " + getTotalBalance());
        System.out.println("Current Account Balance: " + getCurrentBalance());
        System.out.println("Savings Account Balance: " + getSavingsBalance());
    }

}
