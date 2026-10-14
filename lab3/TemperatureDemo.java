public class TemperatureDemo {
    public static void main(String[] args) {
        Temperature t1 = Temperature.fromCelsius(25);
        Temperature t2 = Temperature.fromFahrenheit(212);
        Temperature t3 = Temperature.fromKelvin(0);

        System.out.printf("t1: %.2f C, %.2f F%n", t1.getCelsius(), t1.getFahrenheit());
        System.out.printf("t2: %.2f C, %.2f F%n", t2.getCelsius(), t2.getFahrenheit());
        System.out.printf("t3: %.2f C, %.2f F%n", t3.getCelsius(), t3.getFahrenheit());

        try {
            Temperature.fromCelsius(-300);
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }
    }
}
