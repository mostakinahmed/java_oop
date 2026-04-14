import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String fileName = "practice.txt";

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("Hello Java!\n");

        } catch (IOException e) {
            System.out.println("An error occurred during writing.");
        }

        try (FileWriter appendWriter = new FileWriter(fileName, true)) {
            appendWriter.write("This line was appended later.\n");

        } catch (IOException e) {
            System.out.println("An error occurred during appending.");
        }

        // 3. Reading and Searching for Content
        System.out.println("\n--- Reading & Searching ---");
        String searchTerm = "Java";
        boolean found = false;

        try (Scanner reader = new Scanner(new File(fileName))) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine();

                if (line.contains(searchTerm)) {
                    found = true;
                }
            }

            if (found) {
                System.out.println("\nSearch result: Found '" + searchTerm + "' in the file!");
            }
        } catch (IOException e) {
            System.out.println("An error occurred during reading.");
        }
    }
}