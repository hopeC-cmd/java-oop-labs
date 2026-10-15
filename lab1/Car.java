public class Car {

    // fields (state)
    String brand;
    int year;
    int mileage;

    // method (behaviour)
    void display() {
        System.out.println("Brand: " + brand + ", Year: " + year + ", Mileage: " + mileage);
    }

    // Exercise 2
    boolean isAntique() {
        // hint: a car is antique if (2026 - year) is more than 25
        return (2026 - year) > 25;
    }

    public static void main(String[] args) {
        Car c1 = new Car();
        c1.brand = "Toyota Corolla";
        c1.year = 2010;
        c1.mileage = 150000;

        Car c2 = new Car();
        c2.brand = "Honda Fit";
        c2.year = 2020;
        c2.mileage = 50000;

        Car c3 = new Car();
        c3.brand = "Mazda 6";
        c3.year = 1998;
        c3.mileage = 200000;

        c1.display();
        c2.display();
        c3.display();
        System.out.println("Is c1 antique? " + c1.isAntique());
        System.out.println("Is c2 antique? " + c2.isAntique());
        System.out.println("Is c3 antique? " + c3.isAntique());
    }
}

// The lines that will run are:
// Car c1 = new Car();
// c1.brand = "Toyota Corolla";
// c1.year = 2010;
// c1.mileage = 150000;
//
// Car c2 = new Car();
// c2.brand = "Honda Fit";
// c2.year = 2020;
// c2.mileage = 50000;
//
// Car c3 = new Car();
// c3.brand = "Mazda 6";
// c3.year = 1998;
// c3.mileage = 200000;