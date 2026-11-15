
class A {
    void test_A() {
        System.out.println("From A");
    }
}

class B extends A {
    void test_B() {
        System.out.println("From B");
    }
}

public class Main {
    public static void main(String[] args) {

        A a = new B();

        B b = (B) a;
        b.te
        System.out.println("\n_______________________________");
    }
}
