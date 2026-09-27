import java.util.ArrayList;
import java.util.Scanner;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void display() {
        System.out.println(name + " - $" + price);
    }
}

abstract class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public abstract void showMenu(Scanner scanner, ECommerceSystem system);
}

class Customer extends User {
    public Customer(String username, String password) {
        super(username, password);
    }

    public void showMenu(Scanner scanner, ECommerceSystem system) {
        System.out.println("\nWelcome, " + getUsername() + "!");
        system.displayProducts();
    }
}

class ECommerceSystem {
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Product> products = new ArrayList<>();

    public ECommerceSystem() {

        String[] names = { "Laptop", "Phone", "Headphones", "Smartwatch", "Keyboard",
                "Mouse", "Monitor", "Printer", "Tablet", "Speaker" };
        double[] prices = { 800, 500, 50, 150, 30, 20, 200, 120, 300, 80 };

        for (int i = 0; i < 10; i++) {
            products.add(new Product(names[i], prices[i]));
        }
    }

    public void register(String username, String password) {
        users.add(new Customer(username, password));
        System.out.println("Registration successful! You can now log in.");
    }

    public User login(String username, String password) {
        for (User u : users) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }

    public void displayProducts() {
        System.out.println("\nAvailable Products...........");
        for (int i = 0; i < products.size(); i++) {
            System.out.print((i + 1) + ". ");
            products.get(i).display();
        }
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ECommerceSystem system = new ECommerceSystem();

        while (true) {
            System.out.println("\n1. Register\n2. Login\n3. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Enter username: ");
                String u = scanner.nextLine();
                System.out.print("Enter password: ");
                String p = scanner.nextLine();
                system.register(u, p);
            } else if (choice == 2) {
                System.out.print("Enter username: ");
                String u = scanner.nextLine();
                System.out.print("Enter password: ");
                String p = scanner.nextLine();

                User loggedIn = system.login(u, p);
                if (loggedIn != null) {
                    loggedIn.showMenu(scanner, system);
                } else {
                    System.out.println("Invalid login info!");
                }
            } else {
                System.out.println("Bidai....!");
                break;
            }
        }
        scanner.close();
    }
}