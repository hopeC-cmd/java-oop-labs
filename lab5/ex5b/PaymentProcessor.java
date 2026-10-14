public class PaymentProcessor {

    // no instanceof and no if/else chain: each payment knows how to process itself
    public void pay(Payment p) {
        p.process();
    }

    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();
        processor.pay(new CardPayment("4417", 50));
        processor.pay(new MobileMoneyPayment("0771234567", 20));
        processor.pay(new BankTransfer("ACC-001", 100));
    }
}
