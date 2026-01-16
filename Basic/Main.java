package Basic;

class X {

    void test() {
        int[] data = { 4, 2, 8, 3, 7, 5 };

        // ----------Forech------------
        // for (int item : data) {
        // if (item == 8) {
        // return;
        // }
        // System.out.println(item);
        // }

        // ----------For--------------
        // for (int i = 0; i < data.length; i++) {
        // System.out.println(data[i]);
        // }

        int mark = 80;

        // if (mark >= 40) {
        // System.out.println("Pass");
        // } else {
        // System.out.println("Failled");
        // }

    }

}

public class Main {
    public static void main(String[] args) {
        System.out.println("--------------------------------------");
        System.out.println("\nOutput--------");

        X obj = new X();
        obj.test();

        System.out.println("\n\n");

    }
}
