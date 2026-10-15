public class AccountDemo {
    public static void main(String[] args) {
        Account[] accounts = {
            new SavingsAccount("SAV-001", 1200),
            new SavingsAccount("SAV-002", 300),
            new CurrentAccount("CUR-001", 500)
        };

        for (Account a : accounts) {
            a.deposit(100);
            double fee = a.monthlyFee();
            a.applyMonthlyFee();
            System.out.printf("%s (%s): fee %.2f, balance now %.2f%n",
                    a.getAccountNumber(), a.getClass().getSimpleName(), fee, a.getBalance());
        }

        try {
            accounts[0].deposit(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }

        //Account a = new Account("X", 0);    // Error
    }
}
