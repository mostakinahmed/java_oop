
/* Object Adapter Pattern - Payment Gateway */

// Target Interface
interface Payment {
    void pay(double amount);
}

// Adaptee (Existing bKash API)
class BkashAPI {

    public void makePayment(double amount) {
        System.out.println("Payment of " + amount + " BDT using bKash.");
    }
}

// Adapter Class
class BkashAdapter implements Payment {

    // Composition (Has-A relationship)
    private BkashAPI bkash = new BkashAPI();

    @Override
    public void pay(double amount) {
        bkash.makePayment(amount);
    }
}

// Client Code
public class Main {

    public static void main(String[] args) {

        Payment payment = new BkashAdapter();

        payment.pay(1500);
    }
}
