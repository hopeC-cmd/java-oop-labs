public class Temperature {

    // the ONLY place the unit is decided: kelvin
    private final double kelvin;

    // private constructor: validation is written once, here
    private Temperature(double kelvin) {
        if (kelvin < 0) {      // absolute zero
            throw new IllegalArgumentException("Temperature below absolute zero");
        }
        this.kelvin = kelvin;
    }

    // factories convert whatever the caller has into kelvin
    public static Temperature fromKelvin(double k) {
        return new Temperature(k);
    }

    public static Temperature fromCelsius(double c) {
        return new Temperature(c + 273.15);
    }

    public static Temperature fromFahrenheit(double f) {
        // formula: C = (F - 32) * 5 / 9, then K = C + 273.15
        return new Temperature((f - 32) * 5 / 9 + 273.15);
    }

    // getters convert kelvin back out
    public double getKelvin() {
        return kelvin;
    }

    public double getCelsius() {
        return kelvin - 273.15;
    }

    public double getFahrenheit() {
        return getCelsius() * 9 / 5 + 32;
    }
}