import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordFrequency {
    public static void main(String[] args) {
        String text = "The cat sat on the mat. The dog sat on the log. A cat and a dog met.";

        // Step 1: count each word
        Map<String, Integer> freq = new HashMap<>();
        for (String w : text.toLowerCase().split("[^a-z]+")) {
            if (!w.isEmpty()) {
                freq.merge(w, 1, Integer::sum);      // add 1, or start at 1
            }
        }

        // Step 2: copy the entries into a list and sort it
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(freq.entrySet());

        entries.sort((a, b) -> {
            int byCount = b.getValue().compareTo(a.getValue());    // highest count first
            if (byCount != 0) {
                return byCount;
            }
            return a.getKey().compareTo(b.getKey());      // ties: alphabetical
        });

        for (Map.Entry<String, Integer> e : entries) {
            System.out.println(e.getKey() + ": " + e.getValue());
        }
    }
}