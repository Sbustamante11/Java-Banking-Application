import java.util.Scanner;       // imported scanner class to enable user input
import java.util.ArrayList;     // imported arraylist class to use data structure

public class Main {

    public static void main(String[] args) {

        String cname = "Customer";      // displays in console
        String cid = "######";          // displays in console


        BankAccount optionOne = new BankAccount(cname, cid);
        optionOne.showMenu();

    }
}


        class BankAccount {
            // data types and variables
            double balance;
            double previousTransaction;
            String customerName;
            String customerId;
            ArrayList<String> accountNumbers = new ArrayList<String>();  // array lists stores bank account numbers

            BankAccount(String cname, String cid) {
                customerName = cname;
                customerId = cid;
            }

            // deposit money into account function
            void deposit(double amount) {
                if (amount > 0) {
                    balance += amount;
                    previousTransaction = amount;
                }
            }

            // withdraw money from account function
            void withdraw(double amount) {
                if (amount != 0) {
                    balance -= amount;
                    previousTransaction = -amount;
                }
            }

            // user switches account function, requires new account number input
            void changeAccount(String numberNew) {
                accountNumbers.add(numberNew);
            }

            // gets most recent transaction function
            void getPreviousTransaction() {
                if (previousTransaction > 0) {
                    System.out.println("Deposited: $" + previousTransaction);
                } else if (previousTransaction < 0) {
                    System.out.println("Withdrawn: $" + Math.abs(previousTransaction));
                } else {
                    System.out.println("No transaction occurred");
                }

            }

            void showMenu() {
                char option = '\0';
                Scanner scanner = new Scanner(System.in);

                System.out.println("Welcome " + customerName);
                System.out.println("Your ID is " + customerId);
                System.out.println("\n");
                System.out.println("A. Check Balance");
                System.out.println("B. Deposit");
                System.out.println("C. Withdrawal");
                System.out.println("D. Previous transaction");
                System.out.println("E. Switch bank account");
                System.out.println("F. Exit");

                do {
                    System.out.println("----------------------------------------");
                    System.out.println("Enter an option");
                    System.out.println("----------------------------------------");
                    option = scanner.next().charAt(0);
                    System.out.println("\n");

                    switch (option) {
                        case 'A','a':
                            System.out.println("----------------------------------------");
                            System.out.println("Balance =  $" + balance);
                            System.out.println("----------------------------------------");
                            break;

                        case 'B','b':
                            System.out.println("----------------------------------------");
                            System.out.println("Enter an amount to deposit");
                            System.out.println("----------------------------------------");
                            double amount = scanner.nextDouble();
                            deposit(amount);
                            System.out.println("\n");
                            break;

                        case 'C','c':
                            System.out.println("----------------------------------------");
                            getPreviousTransaction();
                            System.out.println("----------------------------------------");
                            double amount2 = scanner.nextDouble();
                            withdraw(amount2);
                            System.out.println("\n");
                            break;

                        case 'D','d':
                            System.out.println("----------------------------------------");
                            getPreviousTransaction();
                            System.out.println("----------------------------------------");
                            System.out.println("\n");
                            break;

                        case 'E', 'e':
                            System.out.println("----------------------------------------");
                            System.out.println("What is your account number? ");
                            String numberNew = scanner.next();
                            changeAccount(numberNew);
                            System.out.println("Accessing account "+ numberNew);
                            System.out.println("\n");
                            break;


                        case 'F','f':
                            System.out.println("----------------------------------------");
                            break;

                        default:
                            System.out.println("Invalid selection. Please select another option.");
                            break;

                    }
                } while (option != 'F');

                System.out.println("Thank you for using our banking services");

            }
        }
