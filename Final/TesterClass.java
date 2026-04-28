package Final;

abstract class Instrument {

    abstract void play();

    abstract void adjust();

    void compose() {
    }

}

class Guitar extends Instrument {
    void play() {
        System.out.println("In the playing method of Guitar");
    }

    void adjust() {
        System.out.println("Adjusting the string of Guitar");
    }

    void compose() {
        System.out.println("Composing musinc for Guitar");
    }
}

class Keyboard extends Instrument {
    void play() {
        System.out.println("In the playing method of Keyboard");
    }

    void adjust() {
        System.out.println("Adjusting the string of Keyboard");
    }

    void compose() {
        System.out.println("Composing musinc for Keyboard");
    }
}

class Violin extends Instrument {
    void play() {
        System.out.println("In the playing method of Violin");
    }

    void adjust() {
        System.out.println("Adjusting the string of Violin");
    }

    void compose() {
        System.out.println("Composing musinc for Violin");
    }
}

public class TesterClass {
    public static void main(String[] args) {

        System.out.println("Guitar Class:");
        Guitar gtr = new Guitar();
        gtr.play();
        gtr.adjust();
        gtr.compose();

        System.out.println("Keyboard Class:");
        Keyboard key = new Keyboard();
        key.play();
        key.adjust();
        key.compose();

        System.out.println("Violin Class:");
        Violin vio = new Violin();
        vio.play();
        vio.adjust();
        vio.compose();
    }
}
