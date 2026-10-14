interface EnglishGreeter {
    default void hello() {
        System.out.println("Hello!");
    }
}

interface ShonaGreeter {
    default void hello() {
        System.out.println("Mhoroi!");
    }
}

// one class, two interfaces, the SAME default method in both
class Greeter implements EnglishGreeter, ShonaGreeter {

    // the conflict must be resolved here, by overriding hello()
    @Override
    public void hello() {
        EnglishGreeter.super.hello();      // call the English version
        ShonaGreeter.super.hello();      // call the Shona version
    }
}

public class InterfaceConflict {
    public static void main(String[] args) {
        Greeter g = new Greeter();
        g.hello();
    }
}
