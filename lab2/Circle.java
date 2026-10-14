public class Circle {

    // static: ONE shared copy for all circles (Exercise 2)
    private static int count = 0;

    // instance field: each circle has its own radius
    private double radius;

    // Exercise 1: constructor taking a radius
    public Circle(double radius) {
        this.radius = radius;     // field on the left, parameter on the right
        count++;            // a new circle exists
    }

    // Exercise 1: no-argument constructor, radius defaults to 1.0
    public Circle() {
        this(1.0);          // reuse the constructor above
    }

    // Exercise 2: static getter
    public static int getCount() {
        return count;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public static void main(String[] args) {
        Circle c1 = new Circle(5.0);
        Circle c2 = new Circle();
        Circle c3 = new Circle(2.5);

        System.out.println("c1 area: " + c1.area());
        System.out.println("c2 area: " + c2.area());
        System.out.println("c3 area: " + c3.area());
        System.out.println("Circles created: " + Circle.getCount());
    }
}
