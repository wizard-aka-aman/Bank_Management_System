import java.util.ArrayList;
import java.util.Scanner;

class Account {
    private int accountId;
    private String accountHolderName;
    private double balance;

    public Account(int accountId, String accountHolderName, double balance) {
        this.accountId = accountId;
        this.accountHolderName = accountHolderName;
        this.balance = balance;

    }

    public int getAccountId() {
        return accountId;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful.The new balnace is:" + balance);
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("withdrawal successful.the new balance is:" + balance);
        } else {
            System.out.println("insufficient bank balance");
        }
    }
}

class Bank {
    private ArrayList<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();

    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void displayAllAccounts() {
        for (Account account : accounts) {
            System.out.println("Account Id:" + account.getAccountId());
            System.out.println("Account holder name:" + account.getAccountHolderName());
            System.out.println("Balance:" + account.getBalance());
            System.out.println("----------------------------");
            ;
        }
    }

    public Account getAccountById(int accountId) {
        for (Account account : accounts) {
            if (account.getAccountId() == accountId) {
                return account;
            }
        }
        return null;
    }
}

public class Bank_Management_System {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();
        Account account1 = new Account(1, "aman", 5000);
        Account account2 = new Account(2, "shyam", 2000);
        Account account3 = new Account(3, "seema", 8000);
        Account account4 = new Account(4, "rahul", 5000);

        bank.addAccount(account1);
        bank.addAccount(account2);
        bank.addAccount(account3);
        bank.addAccount(account4);
        while (true) {
            System.out.println("1. Deposit");
            System.out.println("2. withdraw");
            System.out.println("3. Display all accounts");
            System.out.println("4. Exit");
            System.out.println("Enter your choice");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("enter the account Id");
                    int depositAccountId = sc.nextInt();
                    Account depositAccount = bank.getAccountById(depositAccountId);
                    if (depositAccount != null) {
                        System.out.println("enter deposit amount");
                        double depositAmount = sc.nextDouble();
                        depositAccount.deposit(depositAmount);

                    } else {
                        System.out.println("invalid account id");
                    }
                    break;

                case 2:
                    System.out.println("enter the account Id");
                    int withdrawAccountId = sc.nextInt();
                    Account withdrawAccount = bank.getAccountById(withdrawAccountId);
                    if (withdrawAccount != null) {
                        System.out.println("enter the withdraw amount");
                        double withdrawAmount = sc.nextDouble();
                        withdrawAccount.withdraw(withdrawAmount);
                    } else {
                        System.out.println("Invalid account Id");
                    }
                    break;

                case 3:
                    bank.displayAllAccounts();
                    break;

                case 4:
                    System.out.println("Exiting.....");
                    System.exit(0);
                    break;

                default:
                    System.out.println("invalid choice");

            }
        }

    }
} 