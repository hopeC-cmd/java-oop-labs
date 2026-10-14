public class Cat extends Animal {

    Cat(String name) {
        super(name);
    }

    @Override
    String sound() {
        return "Meow";
    }
}
