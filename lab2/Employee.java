public class Employee {

    private static int nextId = 1;        // shared counter

    private final int employeeId;
    private String name;
    private String department;
    private double salary;

    // Constructor 1: full
    public Employee(String name, String department, double salary) {
        this.employeeId = nextId++;       // use the current number, then add 1
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Constructor 2: name and department only, salary defaults to 0
    public Employee(String name, String department) {
        this(name, department, 0.0);   // reuse the constructor above
    }

    // Constructor 3: no arguments
    public Employee() {
        this("Unknown", "Unassigned");
    }

    // Copy constructor: same details, but a NEW id
    public Employee(Employee other) {
        this(other.name, other.department, other.salary);
    }

    public void display() {
        System.out.println("#" + employeeId + " " + name + ", " + department + ", $" + salary);
    }

    public static void main(String[] args) {
        Employee e1 = new Employee("Tendai", "IT", 1500);
        Employee e2 = new Employee("Chipo", "HR");
        Employee e3 = new Employee();
        Employee e4 = new Employee(e1);      // copy of e1

        e1.display();
        e2.display();
        e3.display();
        e4.display();
    }
}
