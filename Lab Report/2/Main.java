class Developer {
    String name, id, department, phone, email, website;
    int batch;

    Developer() {
        this.name = "Unknown";
    }

    Developer(String name, String id) {
        this.name = name;
        this.id = id;
    }

    Developer(String name, String id, String department, int batch, String phone, String email, String website) {
        this.name = name;
        this.id = id;
        this.department = department;
        this.batch = batch;
        this.phone = phone;
        this.email = email;
        this.website = website;
    }

    void showIdentity() {
        System.out.println("Developer: " + name + " | ID: " + id + " | Batch: " + batch);
    }
}

public class Main {
    public static void main(String[] args) {

        System.out.println("\n\n");
        Developer dev = new Developer();
        dev.showIdentity();

        Developer dev1 = new Developer(
                "Mostakin Ahmed",
                "242-35-831",
                "Software Engineering",
                43,
                "017738250336",
                "me@mostakinahmed.com",
                "mostakinahmed.com");

        dev1.showIdentity();
    }
}