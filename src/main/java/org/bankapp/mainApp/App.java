/*
Shri Ganesha Nam-ah
*/

package org.bankapp.mainApp;

import org.bankapp.service.BankAccount;

public class App {
    public static void main(String[] args) {
        System.out.println("\n-------------------------------");
        System.out.println("WELCOME TO THE BANK OF MONTREAL");
        System.out.println("-------------------------------\n");

        //bank-account class object created
        BankAccount bankAccount = new BankAccount();
        bankAccount.openAccount();

    }
}
