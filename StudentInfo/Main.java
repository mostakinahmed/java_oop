package StudentInfo;

import java.util.Scanner;

class Student {

    String ID;
    String Name;
    String Dep;
    String Phone;

    public void add() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter ID: ");
        ID = input.next();
        input.nextLine();
        System.out.println("Enter Name: ");
        Name = input.nextLine();

        System.out.println("Enter Dep: ");
        Dep = input.next();

        System.out.println("Enter Phone: ");
        Phone = input.next();

        System.out.println("\n--------Student Details--------");
        System.out.println(ID);
        System.out.println(Name);
        System.out.println(Dep);
        System.out.println(Phone);

        input.close();
    }
}

public class Main {
    public static void main(String[] args) {

        Student st = new Student();

        st.add();

    }
}
