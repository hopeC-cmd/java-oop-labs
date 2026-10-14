public class MobileMoneyPayment extends Payment {
    private String phoneNumber;

    public MobileMoneyPayment(String phoneNumber, double amount) {
        super(amount);
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() { return phoneNumber; }

    @Override
    public void process() {
        System.out.println("Sending mobile money request to " + phoneNumber + ": $" + getAmount());
    }
}
