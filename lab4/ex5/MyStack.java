import java.util.ArrayList;

public class MyStack {

    // HAS-A: the list is hidden inside
    private final ArrayList<String> items = new ArrayList<>();

    public void push(String item) {
        items.add(item);
    }

    public String pop() {
        if (items.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return items.remove(items.size() - 1);
    }

    public String peek() {
        if (items.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return items.get(items.size() - 1);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}