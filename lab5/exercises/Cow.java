public class Cow extends Animal {

    Cow(String name) {
        super(name);
    }

    @Override
    String sound() {
        return "Moo";
    }
}