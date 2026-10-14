public class FinallyDemo {

    // Test 1: return inside try, print inside finally
    static int test1() {
        try {
            System.out.println("in try");
            return 1;
        } finally {
            System.out.println("in finally");
        }
    }

    // Test 2: finally changes the variable AFTER return has picked its value
    static int test2() {
        int x = 10;
        try {
            return x;
        } finally {
            x = 99;
            System.out.println("finally set x to " + x);
        }
    }

    // Test 3: an exception, a catch with its own return, and a finally
    static int test3() {
        try {
            System.out.println("in try, about to divide");
            int r = 10 / 0;
            return r;
        } catch (ArithmeticException e) {
            System.out.println("Caught: " + e.getMessage());
            return -1;
        } finally {
            System.out.println("in finally");
        }
    }

    public static void main(String[] args) {
        System.out.println("--- test 1 ---");
        System.out.println("returned " + test1());

        System.out.println("--- test 2 ---");
        System.out.println("returned " + test2());

        System.out.println("--- test 3 ---");
        System.out.println("returned " + test3());
    }
}

//the lines that will print are:
// --- test 1 ---
// in try
// in finally
// returned 1
// --- test 2 ---
// in try
// finally set x to 99
// returned 10
// --- test 3 ---
// in try, about to divide
// Caught: / by zero
// in finally
// returned -1
