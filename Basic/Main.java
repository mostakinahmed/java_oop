package Basic;

// class X {

//     void test() {

//         String[] data = new String[3];

//         data[0] = "M";
//         data[1] = "O";
//         data[2] = "S";
//         for (String item : data) {
//             System.out.print(item);
//         }

//         // ----------Forech------------
//         // for (int item : data) {
//         // if (item == 8) {
//         // return;
//         // }
//         // System.out.println(item);
//         // }

//         // ----------For--------------
//         // for (int i = 0; i < data.length; i++) {
//         // System.out.println(data[i]);
//         // }

//         int mark = 20;

//         // if (mark >= 40) {
//         // System.out.println("Pass");
//         // } else {
//         // System.out.println("Failled");
//         // }

//         String res = (mark >= 40) ? "pass" : "Faill";
//         System.out.println("\nres is " + res);

//     }

// }

// // public class Main {
// // public static void main(String[] args) {
// // System.out.println("--------------------------------------");
// // System.out.println("\nOutput--------");

// // X obj = new X();
// // obj.test();

// // System.out.println("\n\n");

// // }
// // }

// public class Main {
//     public static void main(String[] args) {
//         System.out.println("mm");
//         // code to be executed
//     }
// }

class Mostakin {

    int id;
    String name;
    private String pass;

    // ----------getter--------
    String getPass() {
        return pass;
    }

    // -----------setter---------
    void setPass(String newPass) {
        this.pass = newPass;
    }
}

class Info extends Mostakin {

    void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Password: " + getPass());
    }

}

public class Main {

    public static void main(String[] args) {

        System.out.println("---------output----------");
        Info obj = new Info();
        obj.id = 831;
        obj.name = "Mostakin Ahmed";
        obj.setPass("abc12345");

        Info obj2 = new Info();
        obj2.id = 367;
        obj2.name = "Tonmoy";
        obj2.setPass("xyz54321");

        obj.display();
        obj2.display();

    }
}