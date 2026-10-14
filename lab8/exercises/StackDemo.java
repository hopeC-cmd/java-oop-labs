public class StackDemo {
    public static void main(String[] args) {

        // a stack of Strings
        Stack<String> words = new Stack<>();
        words.push("A");
        words.push("B");
        words.push("C");
        System.out.println("pop: " + words.pop());
        System.out.println("peek: " + words.peek());
        System.out.println("empty? " + words.isEmpty());

        // the SAME class, now a stack of Integers
        Stack<Integer> nums = new Stack<>();
        nums.push(10);
        nums.push(20);
        int top = nums.pop();            // no cast needed
        System.out.println("popped int: " + top);
        nums.pop();
        System.out.println("empty? " + nums.isEmpty());

        try {
            nums.pop();                  // popping an empty stack
        } catch (IllegalStateException e) {
            System.out.println("Caught: " + e.getMessage());
        }

        //words.push(42);               // incompatible types: int can't be converted to string
    }
}