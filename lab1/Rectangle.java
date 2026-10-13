public class Rectangle {

    double width;
    double height;

    double area() {
        return width*height;        // width times height
    }

    double perimeter() {
        return 2 * (width + height);        // 2 times (width + height)
    }

    public static void main(String[] args) {
        // Exercise 3: array of 5 rectangles
        Rectangle[] rects = new Rectangle[5];

        // fill each one, e.g.
        rects[0] = new Rectangle();
        rects[0].width = 4;
        rects[0].height = 5;
        

        rects[1] = new Rectangle();
        rects[1].width = 2;
        rects[1].height = 3;

        rects[2] = new Rectangle();
        rects[2].width = 6;
        rects[2].height = 4;

        rects[3] = new Rectangle();
        rects[3].width = 3;
        rects[3].height = 7;

        rects[4] = new Rectangle();
        rects[4].width = 5;
        rects[4].height = 5;

        // finding the largest area using a loop
        Rectangle largest = rects[0];
        for (int i = 1; i < rects.length; i++) {
            if (rects[i].area() > largest.area()) {
                largest = rects[i];
            }
        }
        System.out.println("Largest rectangle: " + largest.width + " x " + largest.height);
        System.out.println("Area: " + largest.area());
        System.out.println("Perimeter: " + largest.perimeter());
    }
}