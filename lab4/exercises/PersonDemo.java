public class PersonDemo {
    public static void main(String[] args) {
        Person p = new Person("Tendai", 40);
        Student s = new Student("Tariro", 20, "Computer Science");
        Teacher t = new Teacher("Mr Moyo", 45, "Mathematics");

        p.display();
        s.display();     // inherited, Student never wrote it
        System.out.println("Course: " + s.getCourse());
        t.display();     // inherited, Teacher never wrote it
        System.out.println("Subject: " + t.getSubject());
    }
}
