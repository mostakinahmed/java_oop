class Developer {

    void printProfile(String name) {
        System.out.println("Name: " + name);
    }

    void printProfile(String name, String id) {
        System.out.println("Name: " + name + " | ID: " + id);
    }

    void printProfile(String name, String id, String dept) {
        System.out.println("Name: " + name + " | ID: " + id + " | Dept: " + dept);
    }
}

public class Main {
    public static void main(String[] args) {
        Developer dev = new Developer();

        System.out.println("\n\n Method Overloading");
        dev.printProfile("Mostakin Ahmed");
        dev.printProfile("Mostakin Ahmed", "242-35-831");
        dev.printProfile("Mostakin Ahmed", "242-35-831", "Software Engineering");
    }
}