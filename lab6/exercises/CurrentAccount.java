public class CurrentAccount extends Account {

    public CurrentAccount(String accountNumber, double openingBalance) {
        super(accountNumber, openingBalance);
    }

    // flat fee: always 15.00, whatever the balance
    @Override
    public double monthlyFee() {
        return 15.0;
    }
}
