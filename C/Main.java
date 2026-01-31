package C;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int[] a = new int[5];
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Size: ");
        int size = input.nextInt();

        for (int i = 0; i < size; i++) {
            System.out.print("array : " + i + " ");
            a[i] = input.nextInt();
        }

        System.out.print("Enter Search: ");
        int search = input.nextInt();

        int i = 0;
        boolean flag = false;
        for (i = 0; i < size; i++) {

            if (a[i] == search) {
                System.out.println(+search + " is found at " + i);
                flag = true;
            }

        }

        if (!flag) {
            System.out.println("Not Found" + size);
        }

        input.close();
    }
}
