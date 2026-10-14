public class AgeCheck {

    // 'throws' warns callers that this method may throw a checked exception
    static void validateAge(int age) throws InvalidAgeException {
        if (age < 0 || age > 120) {
            throw new InvalidAgeException("Age must be between 0 and 120", age);
        }
        System.out.println("Age " + age + " is valid");
    }

    public static void main(String[] args) {
        int[] tests = {25, 0, 120, -5, 121};

        for (int t : tests) {
            try {
                validateAge(t);
            } catch (InvalidAgeException e) {
                System.out.println("Invalid age " + e.getAge() + ": " + e.getMessage());
            }
        }
    }
}