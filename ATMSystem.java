import java.util.Scanner;

class BankAccount {
    private double balance;
    public BankAccount(double initialBalance) {
        if (initialBalance < 0) {
            System.out.println("Initial balance cannot be negative. Setting balance to 0.");
            this.balance = 0;
        } else {
            this.balance = initialBalance;
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited " + amount);
        } else {
            System.out.println("Invalid deposit amount. Please enter a positive value.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew " + amount);
            return true;
        } else if (amount > balance) {
            System.out.println("Insufficient balance! Your current balance is " + balance);
            return false;
        } else {
            System.out.println("Invalid withdrawal amount. Please enter a positive value.");
            return false;
        }
    }

    public double getBalance() {
        return balance;
    }
}

class ATM {
    private BankAccount userAccount;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.userAccount = account;
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() {
        while (true) {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Withdraw Money");
            System.out.println("2. Deposit Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    performWithdrawal();
                    break;
                case 2:
                    performDeposit();
                    break;
                case 3:
                    displayBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using our ATM. Have a great day!");
                    return;
                default:
                    System.out.println("Invalid choice! Please select a valid option.");
            }
        }
    }

    private void performWithdrawal() {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        userAccount.withdraw(amount);
    }

    private void performDeposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        userAccount.deposit(amount);
    }

    private void displayBalance() {
        System.out.println("Your current balance is: " + userAccount.getBalance());
    }
}

public class ATMSystem {
    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount(5000); 
        ATM atm = new ATM(myAccount);
        atm.showMenu();
    }
}