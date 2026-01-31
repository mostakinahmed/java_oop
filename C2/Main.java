package C2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int[] a = { 2, 3, 6, 9, 13, 17, 90 };
        Scanner input = new Scanner(System.in);

        int l = 0;
        int h = a.length - 1;
        int mid = (l + h) / 2;

        System.out.print("Enter Search: ");
        int search = input.nextInt();

        while (l <= h) {
            mid = (l + h) / 2;

            if (a[mid] == search) {
                System.out.println(search + " found at " + (mid + 1));
                break;
            } else if (a[mid] > search) {
                h = mid - 1;
            }

            else if (a[mid] < search) {
                l = mid + 1;
            }

            if (l > h) {
                System.out.println("Element not found");
            }
        }

    }
}
