public class Duck extends Animal {

    Duck(String name) {
        super(name);
    }

    @Override
    String sound() {
        return "Quack";
    }
}