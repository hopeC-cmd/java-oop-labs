public class AnimalDemo {
    public static void main(String[] args) {
        // upcasting: one array type holds three different subclasses
        Animal[] animals = {
            new Cat("Tom"),
            new Cow("Bessie"),
            new Duck("Donald")
        };

        for (Animal a : animals) {
            System.out.println(a.name + " says " + a.sound());
        }
    }
}
