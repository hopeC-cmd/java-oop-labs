public class Car extends Vehicle {

    private int doors;

    public Car(String brand, int doors) {
        super(brand);                  // pass brand up to Vehicle
        this.doors = doors;
        System.out.println("Car constructor: " + doors + " doors");
    }

    public int getDoors() { return doors; }
}
