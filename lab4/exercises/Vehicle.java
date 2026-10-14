public class Vehicle {

    private String brand;

    public Vehicle(String brand) {
        this.brand = brand;
        System.out.println("Vehicle constructor: " + brand);
    }

    public String getBrand() { return brand; }
}
