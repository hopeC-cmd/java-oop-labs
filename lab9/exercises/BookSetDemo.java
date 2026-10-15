import java.util.HashSet;
import java.util.Set;

public class BookSetDemo {
    public static void main(String[] args) {
        Set<Book> set = new HashSet<>();

        Book b1 = new Book("978-0132350884", "Clean Code");
        Book b2 = new Book("978-0132350884", "Clean Code (second copy)");
        Book b3 = new Book("978-0134685991", "Effective Java");

        System.out.println("add b1: " + set.add(b1));
        System.out.println("add b2: " + set.add(b2));
        System.out.println("add b3: " + set.add(b3));
        System.out.println("Set size: " + set.size());

        System.out.println("b1.equals(b2)? " + b1.equals(b2));
        System.out.println("b1 == b2? " + (b1 == b2));
        System.out.println("contains lookalike? "
                + set.contains(new Book("978-0134685991", "anything")));
    }
}
