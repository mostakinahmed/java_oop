package Store;

import java.util.Scanner;

//------Authentication Class------
class Authentication {

    private String[][] users = new String[10][2];
    private int userInx = -1;

    private String userName;
    private String password;

    // -------Sign Up---------
    protected void signup() {

        this.userInx = userInx + 1;
        users[userInx][0] = userName;
        users[userInx][1] = password;
    }

    // -----setter---------
    public String setName(String name) {
        this.userName = name;
        return userName;
    }

    // -----setter---------
    public String setPass(String pass) {
        this.password = pass;
        return password;
    }

    // -------Sign In---------
    protected String signin() {

        for (String[] user : users) {
            if (user[0].equals(userName) && user[1].equals(password)) {
                return userName;
            }
        }
        return null;
    }

    // --------display users-------
    // public void display() {
    // System.out.println("\n--------All User---------");
    // for (String[] user : users) {
    // System.out.println("Name: " + user[0]);
    // System.out.println("Pass: " + user[1]);
    // System.out.println("\n");
    // }
    // }

    protected void display() {
        System.out.println("\n--------All Registered Users---------");
        if (userInx >= 0) {
            for (int i = 0; i <= userInx; i++) { // Only loop through users actually added
                System.out.println("SN: " + (i + 1));
                System.out.println("Name: " + users[i][0]);
                System.out.println("Pass: " + users[i][1]);
                System.out.println("-------------------------");
            }
        } else {
            System.out.println("No User found!");
        }

    }
}

// -------Product management Class-------
class Product {

    String[][] productList = new String[10][3];
    int inx = -1;
    String pId;
    String pName;
    String price;

    public void addProduct(String id, String name, String price) {

        this.inx = inx + 1;
        productList[inx][0] = id;
        productList[inx][1] = name;
        productList[inx][2] = price;
    }
}

// ---- Main Class--------
public class Main {

    // -----------home-----------
    public static void home(Authentication obj) {
        Scanner input = new Scanner(System.in);

        System.out.println("\n--------Super Store---------");
        System.out.println("1. Registration");
        System.out.println("2. Sign In");
        System.out.println("3. Display All user");

        System.out.print("Choose option: ");
        int choice = input.nextInt();

        switch (choice) {
            case 1:
                registration(obj);

                break;
            case 2:
                signin(obj);
                System.out.println("2");
                break;
            case 3:
                obj.display();
                home(obj);
                break;
            default:
                System.out.println("\nWrong Option! try again");
                home(obj);
        }

        input.close();
    }

    // ----------registration---------------
    public static void registration(Authentication obj) {
        Scanner input = new Scanner(System.in);

        System.out.println("\n--------Regitration--------");
        System.out.print("Enter Username: ");
        String name = input.nextLine();
        System.out.print("Enter Password: ");
        String pass = input.nextLine();

        // Authentication obj data set
        obj.setName(name);
        obj.setPass(pass);
        obj.signup();

        home(obj);
        input.close();
    }

    // ----------Sign In---------------
    public static void signin(Authentication obj) {
        Scanner input = new Scanner(System.in);

        System.out.println("\n--------Sign In--------");
        System.out.print("Username: ");
        String name = input.nextLine();
        System.out.print("Password: ");
        String pass = input.nextLine();

        // Authentication object data set
        obj.setName(name);
        obj.setPass(pass);
        String res = obj.signin();

        if (res == null) {
            System.out.println("Error credential!");
            signin(obj);
        } else {
            dashboard(res, obj);
        }

        input.close();
    }

    // ----------Dashboard---------------
    public static void dashboard(String name, Authentication obj) {
        Scanner input = new Scanner(System.in);
        Product proObj = new Product();

        System.out.println("\n--------Dashboard-------");
        System.out.println("\n   Welcome , " + name + "\n");

        System.out.println("1. Add product");
        System.out.println("2. View All product\n");
        System.out.print("press 0 to logout........");
        int choice = input.nextInt();

        switch (choice) {
            case 0:
                home(obj);
                break;

            case 1:
                addProduct(proObj);
            default:
                System.out.println("\nWrong Option! try again");
                dashboard(name, obj);
        }

        input.close();

    }

    // ----------Add Product---------------
    public static void addProduct(Product proObj) {
        Scanner input = new Scanner(System.in);

        System.out.println("\n--------Add Product-------");

        // System.out.println("1. Add product");
        // System.out.println("2. View All product\n");
        // System.out.print("press 0 to logout........");
        // int choice = input.nextInt();

        // switch (choice) {
        // case 0:
        // home(obj);
        // break;

        // case 1:
        // proObj.addProduct("1", "Mobile", "3500");
        // default:
        // System.out.println("\nWrong Option! try again");
        // dashboard(name, obj);
        // }

        // input.close();

    }

    public static void main(String[] args) {
        System.out.println("------------Home------------");

        Authentication obj = new Authentication();

        home(obj);

    }
}
