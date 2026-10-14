public class ShapeDemo {
    public static void main(String[] args) {
        Shape[] shapes = {
            new Circle(5),
            new Rectangle(4, 6),
            new Square(3)
        };

        for (Shape s : shapes) {
            System.out.printf("%-10s area = %.2f, perimeter = %.2f%n",
                    s.getClass().getSimpleName(), s.area(), s.perimeter());
        }

         //Shape s = new Shape();    // Error: Shape is abstract, cannot be instantiated
    }
}
