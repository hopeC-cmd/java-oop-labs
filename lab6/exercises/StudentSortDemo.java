import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentSortDemo {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>(List.of(
            new Student("Kuda", 65),
            new Student("Ada", 90),
            new Student("Lynn", 72),
            new Student("Blessing", 58)
        ));

        // 1) natural order, from Comparable (by name)
        Collections.sort(list);
        System.out.println("By name: " + list);

        // 2) Comparator: an outside ordering by marks, highest first
        Comparator<Student> byMarks = Comparator.comparingInt(Student::getMarks).reversed();
        list.sort(byMarks);
        System.out.println("By marks (high to low): " + list);

        // 3) the same Comparator idea, lowest first
        list.sort(Comparator.comparingInt(Student::getMarks));
        System.out.println("By marks (low to high): " + list);
    }
}