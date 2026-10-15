import java.util.List;

public class CoinDemo {
    public static void main(String[] args) {
        int[] amounts = {67, 30, 99, 0, 5};

        for (int a : amounts) {
            List<Coin> coins = Coin.fewestCoins(a);
            System.out.println(a + " -> " + coins.size() + " coins: " + coins);
        }
    }
}