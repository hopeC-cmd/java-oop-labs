public class BlockOrder {

    static {
        System.out.println("static block 1");
    }

    {
        System.out.println("instance block 1");
    }

    BlockOrder() {
        System.out.println("constructor");
    }

    static {
        System.out.println("static block 2");
    }

    {
        System.out.println("instance block 2");
    }
    //runs static blocks first, then instance blocks, then constructor. Static blocks run only once, when the class is loaded. Instance blocks run every time an object is created, before the constructor.
    public static void main(String[] args) {
        System.out.println("--- main starts ---");
        new BlockOrder();
        System.out.println("--- second object ---");
        new BlockOrder();
    }
}
// Prediction - The lines that will run are: Static block 1, Static block 2, --- main starts ---, instance block 1, instance block 2, constructor, --- second object ---, instance block 1, instance block 2, constructor.