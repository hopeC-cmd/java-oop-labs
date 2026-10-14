public class BankExceptionDemo {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount("ACC-001", "Tendai", 500.00);

        try {
            acc.withdraw(100);
            System.out.println("Withdrew 100, balance: " + acc.getBalance());
            acc.withdraw(5000);
            System.out.println("This line is never reached");
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
            System.out.println("Short by: " + e.getShortfall());
        }

        try {
            acc.withdraw(-20);
        } catch (InsufficientFundsException e) {
            System.out.println("Funds problem: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }
    }
}
