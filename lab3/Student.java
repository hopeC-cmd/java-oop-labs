public class Student {

    // private: no outside code can touch these directly
    private String name;
    private int marks;

    // the constructor reuses the setters, so validation is written once
    public Student(String name, int marks) {
        this.name = name;
        setMarks(marks);
    }

    public String getName() { return name; }
    public int getMarks()   { return marks; }

    // Exercise 1: reject invalid marks
    public void setMarks(int marks) {
        if (marks < 0 || marks > 100) {
            throw new IllegalArgumentException("Marks must be between 0 and 100");
        }
        this.marks = marks;
    }

    // Exercise 2: grade is worked out from marks, NOT stored in a field
    // I chose A at 75+, B at 60+ and C at 50+, F below that
    public String getGrade() {
        if (marks >= 75) {
            return "A";
        } else if (marks >= 60) {
            return "B";
        } else if (marks >= 50) {
            return "C";
        } else {
            return "F";
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student( "Tariro",  82);
        System.out.println(s1.getName() + ": " + s1.getMarks() + " -> " + s1.getGrade());

        s1.setMarks( 58);
        System.out.println(s1.getName() + ": " + s1.getMarks() + " -> " + s1.getGrade());

        // invalid marks must be rejected
        try {
            s1.setMarks( 150);
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }
    }
}