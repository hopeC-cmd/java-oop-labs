public class RectangleRef {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle();
        r1.width = 10;
        r1.height = 5;

        Rectangle r2 = r1;      // copies the reference, not the object
        r2.width = 20;        // changes the object that both r1 and r2 refer to

        System.out.println("r1.width = " + r1.width);
    }
}
