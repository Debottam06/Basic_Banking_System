import java.util.HashMap;
import java.util.Map;

class Bank {
    private Map<String, Account> accounts;

    public Bank() {
        this.accounts = new HashMap<>();
    }

    public void addAccount(String accountNumber, String customerName, double balance) {
        Account account = new Account(accountNumber, customerName, balance);
        accounts.put(accountNumber, account);
    }

    public void displayAccountInfo(String accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            Account account = accounts.get(accountNumber);
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Customer Name: " + account.getCustomerName());
            System.out.println("Balance: $" + account.getBalance());
        } else {
            System.out.println("Account not found!");
        }
    }

    // Deposit method
    public void deposit(String accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            Account account = accounts.get(accountNumber);
            if (amount > 0) {
                account.deposit(amount);
                System.out.println("Deposit successful. Updated balance: $" + account.getBalance());
            } else {
                System.out.println("Deposit amount must be positive.");
            }
        } else {
            System.out.println("Account not found!");
        }
    }

    // Withdraw method
    public void withdraw(String accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            Account account = accounts.get(accountNumber);
            if (amount > 0 && amount <= account.getBalance()) {
                account.withdraw(amount);
                System.out.println("Withdrawal successful. Updated balance: $" + account.getBalance());
            } else if (amount > account.getBalance()) {
                System.out.println("Insufficient funds.");
            } else {
                System.out.println("Withdrawal amount must be positive.");
            }
        } else {
            System.out.println("Account not found!");
        }
    }
}

class Account {
    private String accountNumber;
    private String customerName;
    private double balance;

    public Account(String accountNumber, String customerName, double balance) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        Bank bank = new Bank();

        // Adding a few accounts
        bank.addAccount("101", "John Doe", 1000.0);
        bank.addAccount("102", "Jane Smith", 1500.0);

        // Performing transactions
        bank.deposit("101", 500.0);
        bank.withdraw("101", 200.0);
        bank.withdraw("103", 200.0); // This account doesn't exist
        bank.withdraw("102", 2000.0); // Insufficient funds

        // Displaying account information
        bank.displayAccountInfo("101");
        bank.displayAccountInfo("102");
    }
}
