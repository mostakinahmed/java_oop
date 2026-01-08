package ClassObject;

class Student {

    String ID;
    String Name;
    String Dep;
    String Phone;

    public void add() {

        System.out.println("\n--------Student Details--------");
        System.out.println(ID);
        System.out.println(Name);
        System.out.println(Dep);
        System.out.println(Phone);

    }
}

public class Main {
    public static void main(String[] args) {

        Student st1 = new Student();
        Student st2 = new Student();

        st1.ID = "242-35-831";
        st1.Name = "Mostakin Ahmed";
        st1.Dep = "SWE";
        st1.Phone = "01773820336";

        st2.ID = "242-35-666";
        st2.Name = "Ahmed";
        st2.Dep = "EEE";
        st2.Phone = "01786357283";

        st1.add();
        st2.add();
    }
}

