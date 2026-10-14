public class StackDemo {
    public static void main(String[] args) {

        // BAD version: the stack rules can be broken
        BadStack bad = new BadStack();
        bad.push("A");
        bad.push("B");
        bad.push("C");
        bad.add(0, "HACKED");        // inserts at the bottom, not allowed in a real stack
        bad.remove(1);               // removes from the middle
        System.out.println("BadStack contents: " + bad);

        // GOOD version: only the four stack methods exist
        MyStack good = new MyStack();
        good.push("A");
        good.push("B");
        good.push("C");
        System.out.println("MyStack pop: " + good.pop());
        System.out.println("MyStack peek: " + good.peek());

        // good.add(0, "HACKED");    // COMPILE ERROR, MyStack has no add method
    }
}
