class Parent {
    String label = "Parent field";

    String who() {
        return "Parent method";
    }
}

class Child extends Parent {
    String label = "Child field";        // hides the parent's field, does not override it

    @Override
    String who() {
        return "Child method";
    }
}

public class FieldVsMethod {
    public static void main(String[] args) {
        Parent p = new Child();          // Parent variable, Child object

        System.out.println(p.who());     // method call
        System.out.println(p.label);     // field access

        Child c = (Child) p;             // same object, seen through a Child variable
        System.out.println(c.label);
    }
}
// The 3 lines of output are:
// Child method
// Parent field
// Child field