public class VehicleDemo {
    public static void main(String[] args) {
        System.out.println("Creating an ElectricCar...");
        ElectricCar e = new ElectricCar("Nissan Leaf", 5, 40);

        System.out.println("---");
        System.out.println("Brand: " + e.getBrand());      // from Vehicle
        System.out.println("Doors: " + e.getDoors());      // from Car
        System.out.println("Battery: " + e.getBatteryKwh() + " kWh");  // from ElectricCar
    }
}
