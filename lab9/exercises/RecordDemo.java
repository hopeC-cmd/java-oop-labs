record Student(String name, int age) { }

public class RecordDemo {
    public static void main(String[] args) {
        Student s1 = new Student("Tariro", 20);
        Student s2 = new Student("Tariro", 20);
        Student s3 = new Student("Farai", 21);

        System.out.println(s1);
        System.out.println("s1 equals s2? " + s1.equals(s2));
        System.out.println("s1 == s2? " + (s1 == s2));
        System.out.println("s1 equals s3? " + s1.equals(s3));
        System.out.println("Name: " + s1.name());
        System.out.println("Age: " + s1.age());
    }
}