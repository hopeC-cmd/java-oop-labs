public class CardPayment extends Payment {
    private String last4;           // last 4 digits only, never the full number

    public CardPayment(String last4, double amount) {
        super(amount);
        this.last4 = last4;
    }

    public String getLast4() { return last4; }

    @Override
    public void process() {
        System.out.println("Charging card ending " + last4 + ": $" + getAmount());
    }
}
