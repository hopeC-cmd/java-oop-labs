public class BankTransfer extends Payment {
    private String accountNumber;

    public BankTransfer(String accountNumber, double amount) {
        super(amount);
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() { return accountNumber; }

    @Override
    public void process() {
        System.out.println("Bank transfer to account " + accountNumber + ": $" + getAmount());
    }
}