class Developer {

    String name;
    String id;
    String department;
    int batch;
    String phone;
    String email;
    String website;

    void showIdentity() {
        System.out.println(" Developer Profile ");
        System.out.println("Name       : " + name);
        System.out.println("ID         : " + id);
        System.out.println("Dept       : " + department);
        System.out.println("Batch      : " + batch);
        System.out.println("Phone      : " + phone);
        System.out.println("Email      : " + email);
        System.out.println("Website    : " + website);
    }
}

public class Main {
    public static void main(String[] args) {

    
        Developer dev1 = new Developer();
        dev1.name = "Mostakin Ahmed";
        dev1.id = "242-35-831";
        dev1.department = "Software Engineering";
        dev1.batch = 43;
        dev1.phone = "017738250336";
        dev1.email = "me@mostakinahmed.com";
        dev1.website = "mostakinahmed.com";

        
        Developer dev2 = new Developer();
        dev2.name = "Anika Tabassum";
        dev2.id = "242-35-999";
        dev2.department = "Software Engineering";
        dev2.batch = 43;
        dev2.phone = "014565154454";
        dev2.email = "anika@anika.com";
        dev2.website = "anika.dev";

        // output
        System.out.println("\n");
        dev1.showIdentity();
        System.out.println("\n");
        dev2.showIdentity();
        System.out.println("\n");
    }
}