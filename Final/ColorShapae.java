package Final;

interface Shape {

}

interface Colorable {

    public void fillColor();
}

public class ColorShapae implements Shape, Colorable {
    @Override
    public void fillColor() {
        System.out.println("Fill the shape with color.");

    }

    public static void main(String[] args) {

        ColorShapae m = new ColorShapae();
        m.fillColor();
    }
}