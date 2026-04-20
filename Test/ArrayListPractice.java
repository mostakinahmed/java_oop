import java.util.ArrayList;
import java.util.List;

public class ArrayListPractice {
  public static void main(String[] args) {

    ArrayList<String> fruits = new ArrayList<>();

    fruits.add("Apple");
    fruits.add("Banana");
    fruits.add("Cherry");
    fruits.add("Apple");

    System.out.println("\nInitial List: " + fruits);

    System.out.println("\nSize of list: " + fruits.size());

    String secondFruit = fruits.get(1);
    System.out.println("\nElement at index 1: " + secondFruit);

    fruits.set(2, "Blueberry");
    System.out.println("\nAfter set(2, 'Blueberry'): " + fruits);

    System.out.println("\nFirst index of 'Apple': " + fruits.indexOf("Apple"));
    System.out.println("\nLast index of 'Apple': " + fruits.lastIndexOf("Apple"));

    fruits.remove("Apple");
    System.out.println("\nAfter removals: " + fruits);

    ArrayList<String> tropical = new ArrayList<>();

    tropical.add("Mango");
    tropical.add("Papaya");

    fruits.addAll(tropical);

    System.out.println("\nAfter addAll(tropical): " + fruits);

    List<String> sub = fruits.subList(1, 5);

    System.out.println("\nSubList (index 1 to 2): " + sub);
  }
}   a