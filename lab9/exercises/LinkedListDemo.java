public class LinkedListDemo {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.add("Tariro");
        list.add("Farai");
        list.add("Rudo");

        // works because MyLinkedList implements Iterable<String>
        for (String name : list) {
            System.out.println(name);
        }

        System.out.println("Size: " + list.size());

        //MyLinkedList.Node n = null;    // Error: Node has a private class in MyLinkedList
    }
}
