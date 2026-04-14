package Basic.jum;

import java.util.ArrayList;
import java.util.Scanner;


abstract class Transaction {
    protected String name;
    protected double cash;

    public Transaction(String name, double cash) {
        this.name = name;
        this.cash = cash;
    }

    public abstract void showInfo();

    public abstract double getChange();
}

// Inheritance
class Income extends Transaction {
    public Income(String name, double cash) {
        super(name, cash);
    }

    public void showInfo() {
        System.out.println("[+] Received from: " + name + " | Amount: $" + cash);
    }

    public double getChange() {
        return cash;
    }
}

// Inheritance
class Expense extends Transaction {
    public Expense(String name, double cash) {
        super(name, cash);
    }

    public void showInfo() {
        System.out.println("[-] Spent on: " + name + " | Amount: $" + cash);
    }

    public double getChange() {
        return -cash;
    }
}

// Encapsulation
class Wallet {
    private double moneyLeft;
    private ArrayList<Transaction> allItems;

    public Wallet(double startMoney) {
        this.moneyLeft = startMoney;
        this.allItems = new ArrayList<>();
    }

    public void addNewItem(Transaction t) {
        // Check if we have enough money
        if (t instanceof Expense && Math.abs(t.getChange()) > moneyLeft) {
            System.out.println("Sorry! Not enough money in your balance.");
        } else {
            allItems.add(t);
            moneyLeft += t.getChange();
            System.out.println("Done! Added to your list.");
        }
    }

    public void printFullReport() {
        System.out.println("\n MY WALLET REPORT ");

        System.out.println("AVAILABLE BALANCE: $" + moneyLeft);
        System.out.println("Items in list: " + allItems.size());
        System.out.println("\nAll Details:");

        for (Transaction t : allItems) {
            t.showInfo();
        }
        System.out.println("------------------------\n");
    }
}

public class FinanceTrackerApp {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Wallet myWallet = new Wallet(0.0);
        boolean run = true;

        System.out.println("Welcome to My Simple Finance App");

        while (run) {
            System.out.println("1. Add Money (Income)");
            System.out.println("2. Spend Money (Expense)");
            System.out.println("3. Check Available Balance");
            System.out.println("4. Stop and Exit");
            System.out.print("Pick a number: ");

            int pick = reader.nextInt();
            reader.nextLine();

            switch (pick) {
                case 1:
                    System.out.print("Where did this money come from? ");
                    String inName = reader.nextLine();
                    System.out.print("How much? ");
                    double inCash = reader.nextDouble();
                    myWallet.addNewItem(new Income(inName, inCash));
                    break;
                case 2:
                    System.out.print("What did you buy? ");
                    String outName = reader.nextLine();
                    System.out.print("How much did it cost? ");
                    double outCash = reader.nextDouble();
                    myWallet.addNewItem(new Expense(outName, outCash));
                    break;
                case 3:
                    myWallet.printFullReport();
                    break;
                case 4:
                    run = false;
                    System.out.println("Closing app. Bye!");
                    break;
                default:
                    System.out.println("That is not a valid option.");
            }
        }
        reader.close();
    }
}