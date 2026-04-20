
class Person {
    String name = "Mostakin Ahmed";

    void display() {
        System.out.println("Name: " + name);
    }
}

class Developer extends Person {
    String dept = "Software Engineering";

    void display() {
        System.out.println("\n\nDeveloper Profile: " + name + "\n Dept: " + dept);
    }
}

public class Main {
    public static void main(String[] args) {

        Developer d = new Developer();
        d.display();
    }
}