public class Dog extends Animal {

    public Dog(String name) {
        super(name);                 // calls Animal(String name)
        System.out.println("Dog created: " + name);
    }
}