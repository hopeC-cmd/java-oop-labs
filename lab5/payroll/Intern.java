public class Intern extends Employee {

    private double stipend;

    public Intern(String name, double baseSalary, double stipend) {
        super(name, baseSalary);
        this.stipend = stipend;
    }

    @Override
    public double calculatePay() {
        return baseSalary + stipend;
    }
}
