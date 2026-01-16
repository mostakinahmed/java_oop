package MultipleObject;

import java.util.Scanner;

//class for user defined data type 
class Data {

    int id;
    String name;

    Data(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class Main {
    public static void main(String[] args) {

        // ----All Declaration---------
        Scanner input = new Scanner(System.in);

        // ----------main form---------
        System.out.println("\n\n-----Student Management System-------");
        System.out.print("Enter num of student: ");
        int size = input.nextInt();

        // --------define array--------------
        Data[] student = new Data[size];

        // data input---------------
        int inx = 1;
        for (int i = 0; i < size; i++) {

            // info input
            System.out.println("SN: " + inx++);
            System.out.print("Student ID: ");
            int id = input.nextInt();
            input.nextLine();
            System.out.print("Student Name: ");
            String name = input.nextLine();

            student[i] = new Data(id, name);
        }

        // data output---------
        System.out.println("\n---------Student List-----------");
        inx = 1;
        for (Data data : student) {
            System.out.println("SN: " + inx++);
            System.out.println("ID: " + data.id);
            System.out.println("Name: " + data.name);
            System.out.println("\n");
        }

        input.close();
    }
}
