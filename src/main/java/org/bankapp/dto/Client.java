//This is DTO class file Contains all the universal variables

package org.bankapp.dto;

public class Client {
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String phone;
    private String govIdeName;
    private int govIdeNumber;
    private Boolean isCurrentAccount = false;
    private Boolean isSavingsAccount = false;
    private int pin;
    private double totalBalance = 5000;
    private double currentBalance = 5000;
    private double savingsBalance = 0;
    private long accountNumber;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGovIdeName() {
        return govIdeName;
    }

    public void setGovIdeName(String govIdeName) {
        this.govIdeName = govIdeName;
    }

    public int getGovIdeNumber() {
        return govIdeNumber;
    }

    public void setGovIdeNumber(int govIdeNumber) {
        this.govIdeNumber = govIdeNumber;
    }

    public Boolean getCurrentAccount() {
        return isCurrentAccount;
    }

    public void setCurrentAccount(Boolean currentAccount) {
        isCurrentAccount = currentAccount;
    }

    public Boolean getSavingsAccount() {
        return isSavingsAccount;
    }

    public void setSavingsAccount(Boolean savingsAccount) {
        isSavingsAccount = savingsAccount;
    }

    public int getPin() {
        return pin;
    }

    public static final long ACCOUNT_NUMBER = 533095871;

    public void setPin(int pin) {
        this.pin = pin;
    }

    public double getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(double totalBalance) {
        this.totalBalance = totalBalance;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public void setSavingsBalance(double savingsBalance) {
        this.savingsBalance = savingsBalance;
    }

    public long getAccountNumber() {
        if (getCurrentAccount()) return accountNumber;
        else return 0;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }
}
