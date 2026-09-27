// 1. Interface Teacher provides eating() and sleeping()
interface Teacher {
    void eating();
    void sleeping();
}

// 2. Interface Assistant extends Teacher and adds assisting()
interface Assistant extends Teacher {
    void assisting();
}

// 3. Interface Student provides working()
interface Student {
    void working();
}

// 4. Human class implements all interfaces (Multiple Inheritance)
class Human implements Assistant, Student {
    @Override
    public void eating() {
        System.out.println("Teacher is eating.");
    }

    @Override
    public void sleeping() {
        System.out.println("Teacher is sleeping.");
    }

    @Override
    public void assisting() {
        System.out.println("Assistant is assisting.");
    }

    @Override
    public void working() {
        System.out.println("Student is working.");
    }
}

// 5. RoboHelper class to execute the methods
public class RoboHelper {
    public static void main(String[] args) {
        Human robo = new Human();
        
        robo.eating();
        robo.sleeping();
        robo.assisting();
        robo.working();
    }
}