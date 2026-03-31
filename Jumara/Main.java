package Jumara;

import java.util.ArrayList;
import java.util.Scanner;

// Using Abstraction and encapsulation for foodItem 
abstract class FoodItem {
    private int id;
    private String name;
    private double price;

    public FoodItem(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public abstract void displayInfo();
}

// Using Inheritance
class Burger extends FoodItem {
    private String patty;

    public Burger(int id, String name, double price, String patty) {
        super(id, name, price);
        this.patty = patty;
    }

    public void displayInfo() {
        System.out.println("---------------------------");
        System.out.println("Category: Burger");
        System.out.println("Item ID : " + getId());
        System.out.println("Name    : " + getName());
        System.out.println("Patty   : " + patty);
        System.out.println("Price   : $" + getPrice());
        System.out.println("---------------------------");
    }
}

class Pizza extends FoodItem {
    private String size;

    public Pizza(int id, String name, double price, String size) {
        super(id, name, price);
        this.size = size;
    }

    public void displayInfo() {
        System.out.println("---------------------------");
        System.out.println("Category: Pizza");
        System.out.println("Item ID : " + getId());
        System.out.println("Name    : " + getName());
        System.out.println("Size    : " + size);
        System.out.println("Price   : $" + getPrice());
        System.out.println("---------------------------");
    }
}

class Drink extends FoodItem {
    private int volume;

    public Drink(int id, String name, double price, int vol) {
        super(id, name, price);
        this.volume = vol;
    }

    public void displayInfo() {
        System.out.println("---------------------------");
        System.out.println("Category: Drink");
        System.out.println("Item ID : " + getId());
        System.out.println("Name    : " + getName());
        System.out.println("Volume  : " + volume + "ml");
        System.out.println("Price   : $" + getPrice());

    }
}

// User Class with Order History
class User {
    private String username;
    private String password;
    private ArrayList<String> orderHistory = new ArrayList<>();

    public User(String u, String p) {
        this.username = u;
        this.password = p;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void addOrder(String order) {
        orderHistory.add(order);
    }

    public ArrayList<String> getOrderHistory() {
        return orderHistory;
    }
}

// Main Class

public class Main {
    public static ArrayList<Burger> burgerList = new ArrayList<>();
    public static ArrayList<Pizza> pizzaList = new ArrayList<>();
    public static ArrayList<Drink> drinkList = new ArrayList<>();
    public static ArrayList<User> customerList = new ArrayList<>();

    public static User currentUser = null;
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Set Default Data
        burgerList.add(new Burger(101, "Cheese Burger", 5.0, "Beef"));
        pizzaList.add(new Pizza(201, "Chicken Pizza", 15.0, "Large"));
        drinkList.add(new Drink(301, "Coca Cola", 2.0, 500));

        new Main().welcomePage();
    }

    public void welcomePage() {
        while (true) {

            System.out.println("\n\n\n    Jum's FOOD ORDERING SYSTEM     ");
            System.out.println("--------------------------------------");
            System.out.println("1. Registration");
            System.out.println("2. Login");
            System.out.println("3. Admin Login");
            System.out.println("4. Exit");

            System.out.print("Choice: ");
            int choice = sc.nextInt();

            if (choice == 1)
                register();
            else if (choice == 2)
                login();
            else if (choice == 3)
                adminLogin();
            else
                System.exit(0);
        }
    }

    void register() {
        System.out.print("Username: ");
        String u = sc.next();
        System.out.print("Password: ");
        String p = sc.next();
        customerList.add(new User(u, p));
        System.out.println("Success! Please Login.");
    }

    void login() {
        System.out.print("Username: ");
        String u = sc.next();
        System.out.print("Password: ");
        String p = sc.next();
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getUsername().equals(u) && customerList.get(i).getPassword().equals(p)) {
                currentUser = customerList.get(i);
                break;
            }
        }
        if (currentUser != null)
            customerMenu();
        else
            System.out.println("Invalid Login!");
    }

    void adminLogin() {
        System.out.print("Admin Phone: ");
        String phn = sc.next();
        System.out.print("Admin Pass: ");
        String pass = sc.next();
        if (phn.equals("01711111111") && pass.equals("12345"))
            adminPanel();
    }

    void adminPanel() {
        while (true) {
            System.out.println("\n--- ADMIN PANEL ---");
            System.out.println("1. Add Burger");
            System.out.println("2. Add Pizza");
            System.out.println("3. Add Drink");
            System.out.println("4. View All Inventory");
            System.out.println("5. Logout");

            int op = sc.nextInt();
            if (op == 5)
                break;

            if (op == 4) {
                for (int i = 0; i < burgerList.size(); i++)
                    burgerList.get(i).displayInfo();
                for (int i = 0; i < pizzaList.size(); i++)
                    pizzaList.get(i).displayInfo();
                for (int i = 0; i < drinkList.size(); i++)
                    drinkList.get(i).displayInfo();
                continue;
            }

            System.out.print("ID: ");
            int id = sc.nextInt();
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Price: ");
            double price = sc.nextDouble();

            if (op == 1) {
                System.out.print("Patty: ");
                burgerList.add(new Burger(id, name, price, sc.next()));
            } else if (op == 2) {
                System.out.print("Size: ");
                pizzaList.add(new Pizza(id, name, price, sc.next()));
            } else if (op == 3) {
                System.out.print("Vol: ");
                drinkList.add(new Drink(id, name, price, sc.nextInt()));
            }
        }
    }

    void customerMenu() {
        while (true) {
            System.out.println("\n CUSTOMER MENU ");
            for (int i = 0; i < burgerList.size(); i++)
                burgerList.get(i).displayInfo();
            for (int i = 0; i < pizzaList.size(); i++)
                pizzaList.get(i).displayInfo();
            for (int i = 0; i < drinkList.size(); i++)
                drinkList.get(i).displayInfo();

            System.out.print("\nEnter ID to Buy (0 to Logout, 00 for Profile): ");
            String input = sc.next();

            if (input.equals("0")) {
                currentUser = null;
                break;
            }
            if (input.equals("00")) {
                showProfile();
                continue;
            }

            int searchId = Integer.parseInt(input);
            FoodItem selected = null;

            for (int i = 0; i < burgerList.size(); i++)
                if (burgerList.get(i).getId() == searchId)
                    selected = burgerList.get(i);
            for (int i = 0; i < pizzaList.size(); i++)
                if (pizzaList.get(i).getId() == searchId)
                    selected = pizzaList.get(i);
            for (int i = 0; i < drinkList.size(); i++)
                if (drinkList.get(i).getId() == searchId)
                    selected = drinkList.get(i);

            if (selected != null) {
                System.out.print("Quantity: ");
                int q = sc.nextInt();
                double total = selected.getPrice() * q;
                System.out.println("TOTAL COST: $" + total);
                System.out.println("1. Confirm | 2. Cancel");
                if (sc.nextInt() == 1) {
                    currentUser.addOrder(selected.getName() + " x" + q + " ($" + total + ")");
                    System.out.println("Order Success!");
                }
            } else
                System.out.println("Not Found!");
        }
    }

    void showProfile() {
        System.out.println("\n--- MY PROFILE ---");
        System.out.println("Username: " + currentUser.getUsername());
        System.out.println("Password: " + currentUser.getPassword());
        System.out.println("--- ORDER HISTORY ---");
        ArrayList<String> history = currentUser.getOrderHistory();
        if (history.isEmpty()) {
            System.out.println("No orders yet!");
        } else {
            for (int i = 0; i < history.size(); i++) {
                System.out.println((i + 1) + ". " + history.get(i));
            }
        }

    }
}