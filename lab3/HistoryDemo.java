import java.util.List;

public class HistoryDemo {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount("ACC-002", "Chipo", 100.00);
        acc.deposit(50);
        acc.withdraw(30);
        acc.withdraw(9999);      // fails, should NOT appear in history

        List<String> h = acc.getHistory();
        System.out.println(h);

        try {
            h.add("Deposit: 1000000");    // try to cheat
        } catch (UnsupportedOperationException e) {
            System.out.println("History cannot be modified from outside");
        }
    }
}
