public abstract class Account {

    private final String accountNumber;
    private double balance;

    public Account(String accountNumber, double openingBalance) {
        this.accountNumber = accountNumber;
        this.balance = openingBalance;
    }

    public String getAccountNumber() { return accountNumber; }
    public double getBalance()       { return balance; }

    // concrete: written once, shared by every account type
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit must be positive");
        }
        balance += amount;
    }

    // abstract: no body, every subclass MUST decide its own fee
    public abstract double monthlyFee();

    // concrete, but it relies on the abstract method
    public void applyMonthlyFee() {
        balance -= monthlyFee();
    }
}