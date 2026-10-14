public final class ImmutablePerson {      // choice 1

    private final String name;            // choice 2
    private final int age;

    public ImmutablePerson(String name, int age) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name required");
        }
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        this.name = name;
        this.age = age;
    }

    // getters only: choice 3 (no setters)
    public String getName() { return name; }
    public int getAge()     { return age; }

    // "changing" a person creates a NEW object instead
    public ImmutablePerson withAge(int newAge) {
        return new ImmutablePerson(name, newAge);
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }

    public static void main(String[] args) {
        ImmutablePerson p1 = new ImmutablePerson("Tendai", 20);
        ImmutablePerson p2 = p1.withAge(21);

        System.out.println(p1);    // still 20
        System.out.println(p2);    // new object with 21
        
    }
}
