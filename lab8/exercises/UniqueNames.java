import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.LinkedHashSet;

public class UniqueNames {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(
            List.of("Tariro", "Farai", "Tariro", "Rudo", "Farai", "Kuda"));

        Set<String> unique = new LinkedHashSet<>(names);

        System.out.println("Original: " + names + " (" + names.size() + ")");
        System.out.println("Unique: " + unique + " (" + unique.size() + ")");
    }
}
