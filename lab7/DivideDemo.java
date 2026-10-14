import java.util.Scanner;

public class DivideDemo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        try {
            System.out.print("Enter first number: ");
            int a = Integer.parseInt(in.nextLine());

            System.out.print("Enter second number: ");
            int b = Integer.parseInt(in.nextLine());

            System.out.println(a + " / " + b + " = " + (a / b));

        } catch (NumberFormatException e) {
            System.out.println("That is not a whole number");
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero");
        } finally {
            in.close();
            System.out.println("Done");
        }
    }
}