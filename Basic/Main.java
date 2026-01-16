package Basic;

class X {

    void test() {
        int[] data = { 4, 2, 8, 3, 7, 5 };

        for (int item : data) {

            if (item == 8) {
                return;
            }
            System.out.println(item);
        }

    }

}

public class Main {
    public static void main(String[] args) {
        System.out.println("--------------------------------------");
        System.out.println("\n\nMostakin");

        X obj = new X();
        obj.test();

        System.out.println("\n\n");

    }
}
