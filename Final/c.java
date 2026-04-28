package Final;

class Student {

    private String name;
    public static int numberOfStudent = 0;

    Student() {
        this.name = "No Name";
        numberOfStudent += 1;
    }

    Student(String name) {
        this.name = name;
        numberOfStudent += 1;
    }

    public String getName() {
        return name;
    }

}

public class c {
    public static void main(String[] args) {

        Student s1 = new Student();
        System.out.println(s1.getName());

        Student s2 = new Student("Elizabeth");
        System.out.println(s2.getName());

        Student s3 = new Student("Teylor");
        System.out.println(s3.getName());

        System.out.println(Student.numberOfStudent);
    }
}
