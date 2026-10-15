import java.util.ArrayList;
import java.util.List;

public enum Coin {
    PENNY(1), NICKEL(5), DIME(10), QUARTER(25);

    private final int value;

    // an enum constructor is always private
    Coin(int value) {
        this.value = value;
    }

    public int getValue() { return value; }

    public static List<Coin> fewestCoins(int amount) {
        List<Coin> result = new ArrayList<>();
        Coin[] all = Coin.values();            // declared order: smallest to largest

        for (int i = all.length - 1; i >= 0; i--) {      // start from the largest coin
            while (amount >= all[i].getValue()) {
                result.add(all[i]);
                amount -= all[i].getValue();
            }
        }
        return result;
    }
}