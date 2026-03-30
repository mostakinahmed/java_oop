package Lab_2;

class Mostakin {
    // --------make private variable-------
    public String fullName;
    public int age;
    public String techStack;

    private String phone;
    private String email;
    private String website;
    private String passportNo;

    // ------constructor work like setter--------------
    Mostakin(String fullName, int age, String phone,
            String techStack, String email, String website,
            String passportNo) {
        this.fullName = fullName;
        this.age = age;
        this.phone = phone;
        this.techStack = techStack;
        this.email = email;
        this.website = website;
        this.passportNo = passportNo;
    }

    // All getter method
    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getWebsite() {
        return website;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void showPublicData() {
        System.out.println("\n--------------Profile----------------");
        System.out.println("Name: " + fullName);
        System.out.println("Age: " + age);
        System.out.println("Teach Stack: " + techStack);
    }
}

public class Main {
    
    public static void main(String[] args) {
        // Make object using constructor
        Mostakin profile = new Mostakin("Mostakin Ahmed",
                23, "01773-820336", "MERN Developer",
                "mostakin@victusbyte.com", "wwww.mostakinahmed.com",
                "A03542977");

        // display public data
        profile.showPublicData();

        // display private data
        System.out.println("Phone: " + profile.getPhone());
        System.out.println("Passport No: " + profile.getPassportNo());
        System.out.println("E-mail: " + profile.getEmail());
        System.out.println("Website: " + profile.getWebsite());

    }
}