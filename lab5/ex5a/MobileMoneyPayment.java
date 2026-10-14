public class MobileMoneyPayment extends Payment {

    private String phoneNumber;

    public MobileMoneyPayment(String phoneNumber, double amount) {
        super(amount);
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() { return phoneNumber; }
}