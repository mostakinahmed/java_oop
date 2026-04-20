import java.util.Scanner;

public class Exception {
    public static void main(String[] args) {

        int a, b, sum;
        int arr[] = new int[5];

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter A = ");
        a = sc.nextInt();

        System.out.print("Enter B = ");
        b = sc.nextInt();

        try {
            int res = a / b;
            System.out.println("res = " + res);

            try {
                arr[8] = 10;
                System.out.println(arr);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("ArrayIndexOutOfBoundsException");
            }

        } catch (ArithmeticException e) {
            System.out.println("Arithmatic EXception Found");
        } finally {
            System.out.println("Program Completed");
        }

    }
}
