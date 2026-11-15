
//singleTon class - Lazy Class
class SingleTon {
    private static SingleTon instance = null;

    // make private for create only one obj
    private SingleTon() {
    };

    public static SingleTon getInstance() {
        if (instance == null) {
            instance = new SingleTon();
        }
        return instance;

    }

}

public class Main {
    public static void main(String[] args) {

        SingleTon obj = SingleTon.getInstance();
        SingleTon objs = SingleTon.getInstance();

        if (obj.equals(objs)) {
            System.out.println("same obj");
        }

    }
}
