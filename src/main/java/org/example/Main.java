package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("==== BANK MENU ====");
        System.out.println("1. Create Account \n2.View All Accounts \n3. Check Balance \n4. Deposit \n5. Withdraw \n6. Exit");

        while (true){
            System.out.println("\nEnter Chosen Option: ");
            int userChoice;
            try{
                userChoice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("> [ERR: Please Enter a Number]");
                continue;
            }

            switch(userChoice){
                case 1:
                    System.out.println("==== Create Account ====");
                    break;
                case 2:
                    System.out.println("==== View All Accounts ====");
                    break;
                case 3:
                    System.out.println("==== Check Balance ====");
                    break;
                case 4:
                    System.out.println("==== Deposit ====");
                    break;
                case 5:
                    System.out.println("==== Withdraw ====");
                    break;
                case 6:
                    System.out.println("> [EXITING: Thank you for using Bank!]");
                    return;
                default:
                    System.out.println("> [ERR: Invalid Choice Input]");


            }

        }
    }
}