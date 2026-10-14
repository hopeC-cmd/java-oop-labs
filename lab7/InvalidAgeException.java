public class InvalidAgeException extends Exception {

    private final int age;

    public InvalidAgeException(String message, int age) {
        super(message);          // pass the message up to Exception
        this.age = age;
    }

    public int getAge() { return age; }
}