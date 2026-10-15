import java.util.Iterator;

public class MyLinkedList implements Iterable<String> {

    // static nested: a Node does not need the list object
    private static class Node {
        String value;
        Node next;

        Node(String value) {
            this.value = value;
        }
    }

    private Node head;
    private int size;

    public void add(String value) {
        Node n = new Node(value);
        if (head == null) {
            head = n;                      // first item
        } else {
            Node cur = head;
            while (cur.next != null) {
                cur = cur.next;             // walk to the last node
            }
            cur.next = n;
        }
        size++;
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<String> iterator() {
        return new ListIter();
    }

    // inner class: reads the outer object's head field
    private class ListIter implements Iterator<String> {
        private Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public String next() {
            String v = current.value;
            current = current.next;
            return v;
        }
    }
}
