public class FlyDemo {
    public static void main(String[] args) {
        // the variable type is the interface, not the class
        Flyable[] things = { new Bird(), new Aeroplane() };

        for (Flyable f : things) {
            f.fly();
        }
    }
}
