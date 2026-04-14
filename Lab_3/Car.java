abstract class Vehicle {

    // Constructor in an abstract class
    public Vehicle() {
        System.out.println("Vehicle is Created.");
    }

    // Abstract method (no body)
    public abstract void move();

    // Non-abstract (concrete) method
    public void carry() {
        System.out.println("All Vehicle carry loads");
    }

}

public class Car extends Vehicle {

    // Implementing the abstract method from Vehicle
    public void move() {
        System.out.println("Car moves faster.");
    }

    public static void main(String[] args) {
        // Creating an instance of the concrete subclass
        Car c1 = new Car();

        c1.move();
        c1.carry();
    }
}