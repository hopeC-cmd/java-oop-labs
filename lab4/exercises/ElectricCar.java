public class ElectricCar extends Car {

    private int batteryKwh;

    public ElectricCar(String brand, int doors, int batteryKwh) {
        super(brand, doors);        // pass brand and doors up to Car, which passes brand up to Vehicle
        this.batteryKwh = batteryKwh;
        System.out.println("ElectricCar constructor: " + batteryKwh + " kWh");
    }

    public int getBatteryKwh() { return batteryKwh; }
}
