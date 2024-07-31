import java.util.Scanner;

abstract class Account {
    protected double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public abstract void deposit(double amount);

    public abstract boolean withdraw(double amount);
}

class BankAccount extends Account {

    public BankAccount(double balance) {
        super(balance);
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(("-").repeat(40));

            System.out.println("₹" + amount + " deposited successfully");
            System.out.println(("-").repeat(40));

        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(("-").repeat(40));

            System.out.println("₹" + amount + " withdrawn successfully");
            System.out.println(("-").repeat(40));

            return true;
        } else {
            System.out.println(("-").repeat(40));

            System.out.println("Insufficient balance or invalid amount");
            System.out.println(("-").repeat(40));

            return false;
        }
    }
}

public class SimpleBankingApplication{
    private Account account;

    public SimpleBankingApplication(Account account) {
        this.account = account;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Options:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.println(("=").repeat(500));

            System.out.print("Select an option: ");


            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit(scanner);
                    break;
                case 3:
                    withdraw(scanner);
                    break;
                case 4:
                    System.out.println("Exiting ATM, have a nice day");
                    System.out.println(("=").repeat(500));

                    return;
                default:
                    System.out.println("Invalid option, select again");
            }
        }
    }

    private void checkBalance() {
        double balance = account.getBalance();
        System.out.println(("-").repeat(40));
        System.out.println("Your current balance is ₹" + balance);
        System.out.println(("-").repeat(40));


    }

    private void deposit(Scanner scanner) {
        System.out.println(("=").repeat(500));

        System.out.print("Enter deposit amount: ");

        double amount = scanner.nextDouble();
        account.deposit(amount);
    }

    private void withdraw(Scanner scanner) {
        System.out.println(("=").repeat(500));

        System.out.print("Enter withdrawal amount: ");

        double amount = scanner.nextDouble();
        boolean success = account.withdraw(amount);

        if (success) {

            System.out.println("Please collect your cash");
            System.out.println(("-").repeat(40));

        }
    }

    public static void main(String[] args) {
        Account bankAccount = new BankAccount(25000.0);
        SimpleBankingApplication atm = new SimpleBankingApplication(bankAccount);
        atm.start();
    }
}

