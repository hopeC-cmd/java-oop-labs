import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListStats {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        int[] values = {12, 7, 25, 3, 18, 9, 30, 4, 21, 15};
        for (int v : values) {
            nums.add(v);
        }

        int sum = 0;
        for (int n : nums) {
            sum += n;
        }

        int max = nums.get(0);
        for (int n : nums) {
            if (n > max) {
                max = n;
            }
        }

        // copy first, so the original list keeps its order
        List<Integer> reversed = new ArrayList<>(nums);
        Collections.reverse(reversed);

        System.out.println("List: " + nums);
        System.out.println("Sum: " + sum);
        System.out.println("Max: " + max);
        System.out.println("Reversed: " + reversed);
    }
}