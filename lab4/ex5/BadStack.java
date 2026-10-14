import java.util.ArrayList;

public class BadStack extends ArrayList<String> {

    public void push(String item) {
        add(item);
    }

    public String pop() {
        return remove(size() - 1);
    }

    public String peek() {
        return get(size() - 1);
    }
}
