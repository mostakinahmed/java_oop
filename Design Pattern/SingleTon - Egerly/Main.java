
//singleTon class
class SingleTon {
    private static SingleTon instance = new SingleTon();

    // make private for create only one obj
    SingleTon() {
    };

    public static SingleTon getInstance() {
        return instance;

    }

}

public class Main {
    public static void main(String[] args) {

        SingleTon obj = SingleTon.getInstance();
        SingleTon obj2 = SingleTon.getInstance();

        System.out.println("Output: " + obj);
        System.out.println("Output: " + obj2);

    }
}
