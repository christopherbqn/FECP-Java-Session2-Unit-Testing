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

    // deposit method
    public boolean deposit(double amount){
        if(amount>0){
            this.balance += amount;
            return true;
        } return false;
    }

    // withdraw method
    public boolean withdraw(double amount){
        if(amount>0 && amount <= this.balance){
            this.balance -= amount;
            return true;
        } return false;
    }

    //display all info of an account
    public void displayInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + Name);
        System.out.println("Balance: $" + balance);
        System.out.println("-----------------------");
    }

}
