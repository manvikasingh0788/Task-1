import java.util.Scanner;
public class atmsystem {
    private double balance;
    private String accountnumber;
    private String pin;
    public atmsystem(String accountnumber , String pin , double initialbalance) {
        this.accountnumber = accountnumber;
        this.pin = pin;
        this.balance = initialbalance;
    }
    public void displaymenu() {
        System.out.println("Welcome to the atmsystem");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }
    public void checkBalance() {
        System.out.println("Your balance is:$"+ balance);
    }
    public void deposit(double amount) {
        balance += amount;
        System.out.println("$" + amount + "has been deposited.Your new balance is: $" + balance);
    }
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("$" + amount +"has been withdraw.Your new balance is: $" + balance);
        } else {
            System.out.println("Insufficient funds.");
        }

    }
    public static void main(String[] args) {
        atmsystem atm = new atmsystem("1210211091","4520",1000.0);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your account number:");
        String enteredAccountNumber = scanner.nextLine();
        System.out.println("Enter your PIN:");
        String enteredPin = scanner.nextLine();
        if (enteredAccountNumber.equals(atm.accountnumber)&& enteredPin.equals(atm.pin)) {
            int choice;
            do {
                atm.displaymenu();
                System.out.println("Enter your choice:");
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                    atm.checkBalance();
                    break;
                    case 2:
                    System.out.println("Enter the amount to deposit: $");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                    case 3:
                    System.out.println("Enter the amount to withdraw: $");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                    case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                    default:
                    System.out.println("Invaild choice. Please try again.");
                }
            } while (choice != 4);
        } else {
            System.out.println("Invalid account number or PIN.Exiting...");
        }
        scanner.close();
    }

}