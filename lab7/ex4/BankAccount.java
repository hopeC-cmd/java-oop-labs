import java.util.ArrayList;
import java.util.List;

public class BankAccount {

    // EXPLAIN: private -> no code outside this class can touch these directly
    private final String accountNumber;
    private String ownerName;
    private double balance;
    private final List<String> history = new ArrayList<>();

    public BankAccount(String accountNumber, String ownerName, double openingBalance) {
        if (openingBalance < 0) {
            throw new IllegalArgumentException("Opening balance cannot be negative");
        }
        this.accountNumber = accountNumber;
        setOwnerName(ownerName); // reuse validation in the setter
        this.balance = openingBalance;
    }

    // Getters: read-only access
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    // Setter with validation
    public void setOwnerName(String ownerName) {
        if (ownerName == null || ownerName.isBlank()) {
            throw new IllegalArgumentException("Owner name required");
        }
        this.ownerName = ownerName.trim();
    }

    // EXPLAIN: no setBalance() on purpose -> balance changes only via
    // deposit/withdraw
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit must be positive");
        }
        balance += amount;
        history.add("Deposit: " + amount);
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal must be positive");
        }
        if (amount > balance) {
            throw new InsufficientFundsException(
                    "Cannot withdraw " + amount + "; balance is " + balance, amount - balance);
        }
        balance -= amount;
        history.add("Withdrawal: " + amount);
    }

    public List<String> getHistory() {
        return List.copyOf(history); // makes an unmodifiable copy
    }

    @Override
    public String toString() {
        return String.format("%s [%s] balance: %.2f", accountNumber, ownerName, balance);
    }
}
