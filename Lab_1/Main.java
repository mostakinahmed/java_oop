package Lab_1;

//---1st Class
class PersonalInfo {
    String name;
    String gender;
    String religion;
    int age;
    String occupation;
    String phone;
    String email;
    String address;

    // ---Take all the value from Main class
    PersonalInfo(String name, String gender, String religion, int age,
            String occupation, String phone, String email, String address) {

        this.name = name;
        this.gender = gender;
        this.religion = religion;
        this.age = age;
        this.occupation = occupation;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    // ----Display Study Info
    void displayPersonalInfo() {
        System.out.println("\n-------------------------------------------");
        System.out.println("            Personal Info");
        System.out.println("--------------------------------------------");
        System.out.println("Name: " + name + "\nGender: " + gender + "\nReligion: " + religion + "\nAge: " + age
                + "\nOccupation: " + occupation + "\nPhone: " + phone + "\nEmail: " + email + "\nAddress: " + address);
    }
}

// ---2nd Class
class StudyInfo {
    String department;
    String institute;
    int startYear;

    // ---Take all the value from Main class
    StudyInfo(String department, String institute, int startYear) {
        this.department = department;
        this.institute = institute;
        this.startYear = startYear;
    }

    // ----Display Study Info
    public void displayStudyInfo() {
        System.out.println("\n-------------------------------------------");
        System.out.println("            Study Info");
        System.out.println("--------------------------------------------");
        System.out.println(
                "Department: " + department +
                        "\nInstitute: " + institute +
                        "\nStart Year: " + startYear + "\n");

    }
}

// --Main Class
public class Main {
    public static void main(String[] args) {

        // ------Create Personal Info object
        PersonalInfo personal = new PersonalInfo("Mostakin Ahmed", "Male", "Islam", 22, "Student",
                "01773820336", "mostakin@victusbyte.com", "Dhaka, Bangladesh");

        // Create StudyInfo object
        StudyInfo study = new StudyInfo("Software Engineering", "Daffodil International University", 2024);

        // -- call all the function
        personal.displayPersonalInfo();
        study.displayStudyInfo();
    }
}
