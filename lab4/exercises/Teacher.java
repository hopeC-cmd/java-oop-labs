public class Teacher extends Person {
    private String subject;

    public Teacher(String name, int age, String subject) {
        super(name,age);        // pass name and age up to Person
        this.subject = subject;
    }

    public String getSubject() { return subject; }
}