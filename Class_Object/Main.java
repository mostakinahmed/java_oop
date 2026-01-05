package Class_Object;

class MathCalculate {

    // sum
    public void sum(int a, int b) {
        int res = a + b;
        System.out.println(res);
    }

    // minus
    public int subs(int a, int b) {
        int res = a - b;
        return res;
    }

    // multiply
    public int multiply(int a, int b) {
        int res = a * b;
        return res;
    }

    // division
    public int div(int a, int b) {
        int res = a / b;
        return res;
    }
}

public class Main {
    public static void main(String[] args) {

        System.out.println("\n-----------Math-------------");
        MathCalculate s = new MathCalculate();

        s.sum(10, 20);

    }
}
