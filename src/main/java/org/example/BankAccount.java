package org.example;

public class BankAccount {

    private int accountNumber;
    private String Name;
    private double balance;

    public BankAccount(int accountNumber, String Name, double balance) {
        this.accountNumber = accountNumber;
        this.Name = Name;
        this.balance = balance;
    }

    //getters
    public int getAccountNumber() {
        return accountNumber;
    }
    public String getName() {
        return Name;
    }
    public double getBalance() {
        return balance;
    }

    //setters
    public void setBalance(double balance) {
        this.balance = balance;
    }

    //display all info of an account
    public void displayInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + Name);
        System.out.println("Balance: $" + balance);
        System.out.println("-----------------------");
    }

}
