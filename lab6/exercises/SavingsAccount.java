public class SavingsAccount extends Account {

    public SavingsAccount(String accountNumber, double openingBalance) {
        super(accountNumber, openingBalance);
    }

    // free if the balance is 1000 or more, otherwise 5.00
    @Override
    public double monthlyFee() {
        if (getBalance() >= 1000) {
            return 0.0;
        }
        return 5.0;
    }
}