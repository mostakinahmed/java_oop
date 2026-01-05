package Test_2;

class MathCalculate {

    // sum
    public int sum(int a, int b) {
        int res = a + b;
        return res;
    }

    // minus
    public int subs(int a, int b) {
        int res = a + b;
        return res;
    }

    // multiply
    public int multiply(int a, int b) {
        int res = a + b;
        return res;
    }

    // division
    public int div(int a, int b) {
        int res = a + b;
        return res;
    }
}

public class Main {
    public static void main(String[] args) {

        System.out.println("\n-----------Math-------------");

        MathCalculate s = new MathCalculate();

        int res = s.sum(10, 20);
        System.out.println(res);

    }
}
