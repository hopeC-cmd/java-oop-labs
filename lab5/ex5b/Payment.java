public abstract class Payment {
    private double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    public double getAmount() { return amount; }

    // the contract: every payment type MUST say how it is processed
    public abstract void process();
}
