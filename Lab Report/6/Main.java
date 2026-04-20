// Parent Class (Superclass)
class Person {
    String name;
    String phone;
    String email;
}

class Developer extends Person {
    String id;
    String department;
    int batch;
    String website;

    void showDevDetails() {

        System.out.println("Name  : " + name);
        System.out.println("Phone : " + phone);
        System.out.println("Email : " + email);
        System.out.println("ID    : " + id);
        System.out.println("Dept  : " + department);
        System.out.println("Batch : " + batch);
        System.out.println("Web   : " + website);
    }
}

public class Main {
    public static void main(String[] args) {

        Developer dev = new Developer();

        dev.name = "Mostakin Ahmed";
        dev.phone = "017738250336";
        dev.email = "me@mostakinahmed.com";

        dev.id = "242-35-831";
        dev.department = "Software Engineering";
        dev.batch = 43;
        dev.website = "mostakinahmed.com";

        System.out.println("\n\n");
        dev.showDevDetails();

    }
}