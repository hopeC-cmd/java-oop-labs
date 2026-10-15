import java.util.List;

record Student(String name, int marks) { }

public class AboveAverage {
    public static void main(String[] args) {
        List<Student> students = List.of(
            new Student("Tariro", 72),
            new Student("Farai", 58),
            new Student("Rudo", 85),
            new Student("Kuda", 64),
            new Student("Ada", 91),
            new Student("Blessing", 49),
            new Student("Lynn", 77)
        );

        // pass 1: the class average
        double average = students.stream()
            .mapToInt(Student::marks)
            .average()
            .orElse(0);

        System.out.printf("Class average: %.2f%n", average);

        // pass 2: filter, map, sort, print
        students.stream()
            .filter(s -> s.marks() > average)
            .map(Student::name)
            .sorted()
            .forEach(System.out::println);
    }
}
