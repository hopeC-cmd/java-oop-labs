public class Student extends Person {

    private String course;

    public Student(String name, int age, String course) {
        super(name,age);        // pass name and age up to Person
        this.course = course;
    }

    public String getCourse() { return course; }
}