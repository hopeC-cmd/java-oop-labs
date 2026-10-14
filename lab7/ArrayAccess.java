public class ArrayAccess {

    // returns the element, or -1 if the index is invalid
    static int getElement(int[] data, int index) {
        try {
            return data[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Bad index " + index + ": " + e.getMessage());
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] scores = {70, 85, 90};

        System.out.println(getElement(scores, 1));
        System.out.println(getElement(scores, 5));
        System.out.println(getElement(scores, -1));
    }
}