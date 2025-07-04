package org.example;
import java.util.*;

public class Main {

    static ArrayList<BankAccount> accounts = new ArrayList<>();


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int accountNumber;
        System.out.println("==== BANK MENU ====");
        System.out.println("1. Create Account \n2. View All Accounts \n3. Check Balance \n4. Deposit \n5. Withdraw \n6. Exit");

        while (true){

            System.out.print("\nEnter Chosen Option: ");
            int userChoice;
            try{
                userChoice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("> [ERR: Please Enter a Number]");
                continue;
            }

            switch(userChoice){
                case 1:
                    System.out.println("\n==== Create Account ====");
                    System.out.print("Enter Account Number: ");
                    try {
                        accountNumber = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("> [ERR: Invalid Account Number Format]");
                        continue;
                    }

                    // check for duplicate account number
                    if (findAccount(accountNumber) != null) {
                        System.out.println("> [ERR: Account Number Already Exists]");
                        return;
                    }

                    System.out.print("Enter Holder Name: ");
                    String name = scanner.nextLine();

                    System.out.print("> [Do you want to enter an Initial Deposit? (y/n)]: ");
                    String depositChoice = scanner.nextLine().toLowerCase();

                    double initialDeposit = 0;
                    if (depositChoice.equals("y")) {
                        System.out.print("Enter Initial Deposit Amount: ");
                        try {
                            initialDeposit = Double.parseDouble(scanner.nextLine());
                            if (initialDeposit <= 0) {
                                System.out.println("> [ERR: Deposit must be > $0.00]");
                                return;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("> [ERR: Invalid Deposit Input]");
                            return;
                        }
                    } else {
                        System.out.println("> [No Initial Deposit Made]");
                    }
                    createAccount(accountNumber,  name, initialDeposit);
                    break;


                case 2:
                    System.out.println("==== View All Accounts ====");
                    viewAllAccounts();
                    break;
                case 3:
                    System.out.println("==== Check Balance ====");
                    System.out.print("Enter Account Number: ");
                    try{
                        accountNumber = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("> [ERR: Invalid Account Number]");
                        return;
                    }

                    checkBalance(accountNumber);
                    break;
                case 4:
                    System.out.println("==== Deposit ====");

                    System.out.print("Enter Account Number: ");
                    try{
                        accountNumber = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.print("> [ERR: Invalid Account Number Input]");
                        continue;
                    }
                    // get deposit amount
                    System.out.print("Enter Amount to Deposit: ");
                    double newDeposit;

                    try{
                        newDeposit = Double.parseDouble(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("> [ERR: Invalid Deposit Input]");
                        break;
                    }

                    deposit(accountNumber, newDeposit);
                    break;
                case 5:
                    System.out.println("==== Withdraw ====");

                    System.out.print("Enter Account Number: ");
                    try{
                        accountNumber = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.print("> [ERR: Invalid Account Number Input]");
                        continue;
                    }
                    // get deposit amount
                    System.out.print("Enter Amount to Withdraw: ");
                    double withdrawAmount;

                    try{
                        withdrawAmount = Double.parseDouble(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("> [ERR: Invalid Withdrawal Input]");
                        break;
                    }

                    withdraw(accountNumber, withdrawAmount);
                    break;
                case 6:
                    System.out.println("> [EXITING: Thank you for using Bank!]");
                    return;
                default:
                    System.out.println("> [ERR: Invalid Choice Input]");
            }
        }
    }


    // create account method
    public static void createAccount(int accountNumber, String name, double initialDeposit){
        BankAccount account = new BankAccount(accountNumber, name, initialDeposit);
        accounts.add(account);
        System.out.println("> [SUCCESS: Account Created]");
    }

    // find account method
    public static BankAccount findAccount(int accountNumber) {
        for (BankAccount acc : accounts) {
            if (acc.getAccountNumber() == accountNumber) {
                return acc;
            }
        }
        return null;
    }

    // view all accounts method
    public static void viewAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("> [No accounts found]");
            return;
        }
        for (BankAccount acc : accounts) {
            acc.displayInfo();
        }
    }

    // check balance method
    public static void checkBalance(int accountNumber){
        BankAccount account = findAccount(accountNumber);
        if(account != null){
            System.out.println("Account Holder Name: " + account.getName());
            System.out.println("Current Balance: $" + account.getBalance());
        }else{
            System.out.println("> [ERR: Account Not Found]");
        }
    }

    // deposit method
    public static void deposit(int accountNumber, double newDeposit){
        BankAccount account = findAccount(accountNumber);
        if(account != null){
            if(account.deposit(newDeposit)){
                System.out.println("New Balance: $" + account.getBalance());
                System.out.println("> [SUCCESS: Deposit]");
            }else{
                System.out.println("> [ERR: Deposit Must be > $0.00]");
            }
        }else{
            System.out.println("> [ERR: Account Not Found]");
        }
    }

    // withdraw method
    public static void  withdraw(int accountNumber, double withdrawAmount) {
        BankAccount account = findAccount(accountNumber);
        if (account != null) {
            if (account.withdraw(withdrawAmount)) {
                System.out.println("New Balance: $" + account.getBalance());
                System.out.println("> [SUCCESS: Withdrawal]");
            } else {
                double Balance = account.getBalance();
                System.out.println("> [ERR: Withdrawal Must be > $0.00 and <= $" + Balance + "]");
            }
        } else {
            System.out.println("> [ERR: Account Not Found]");
        }

    }

}