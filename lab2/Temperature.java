public class Temperature {

    private final double celsius;     // store one unit internally

    // private constructor: only code inside this class can call it
    private Temperature(double celsius) {
        this.celsius = celsius;
    }

    // static factory method 1
    public static Temperature fromCelsius(double c) {
        return new Temperature(c);
    }

    // static factory method 2: convert F to C first
    // formula: C = (F - 32) * 5 / 9
    public static Temperature fromFahrenheit(double f) {
        return new Temperature((f - 32) * 5 / 9);
    }

    public double getCelsius() {
        return celsius;
    }

    public double getFahrenheit() {
        return celsius * 9 / 5 + 32;      // formula: F = C * 9 / 5 + 32
    }
    //“fromCelsius(25) and fromFahrenheit(25) both take one double, so two constructors would have the same signature, which Java doesn't allow. A factory method has its own descriptive name, so the reader knows what the number means.”

    public static void main(String[] args) {
        Temperature t1 = Temperature.fromCelsius(25);
        Temperature t2 = Temperature.fromFahrenheit(98.6);

        System.out.println("t1: " + t1.getCelsius() + " C = " + t1.getFahrenheit() + " F");
        System.out.println("t2: " + t2.getCelsius() + " C = " + t2.getFahrenheit() + " F");

        //new Temperature(30);   // compile error if called from another class: Temperature(double) has private access

    }
}
