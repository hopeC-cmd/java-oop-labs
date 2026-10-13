public class Person {
    String name;
    Address address;     // a field that holds a reference to another object

    public static void main(String[] args) {
        // Person WITH an address
        Address a1 = new Address();
        a1.street = "12 Samora Machel Ave";
        a1.city = "Harare";

        Person p1 = new Person();
        p1.name = "Tendai";
        p1.address = a1;

        // chained dot: person -> address -> city
        System.out.println(p1.name + " lives in " + p1.address.city);

        // Person WITHOUT an address
        Person p2 = new Person();
        p2.name = "Chipo";
        // p2.address was never set, so it is null

        // Step A: check for null first (safe)
        if (p2.address == null) {
            System.out.println(p2.name + " has no address yet");
        } else {
            System.out.println(p2.name + " lives in " + p2.address.city);
        }

        // Step B: this will crash because p2.address is null
        System.out.println(p2.address.city);

        

    }
}