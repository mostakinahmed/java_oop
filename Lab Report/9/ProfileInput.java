import java.util.Scanner;

public class ProfileInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {

            System.out.print("Enter Name: ");
            String name = scanner.nextLine();

       
            System.out.print("Enter ID: ");
            String idInput = scanner.nextLine();

            try {
    
                int idNumeric = Integer.parseInt(idInput);
                
                System.out.println("\n--- Profile Verified ---");
                System.out.println("Name: " + name);
                System.out.println("ID: " + idNumeric);
                System.out.println("Status: Student at DIU");

            } catch (NumberFormatException e) {
     
                System.out.println("Error! ID must be numeric characters.");
                System.out.println("Exception Detail: " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("A general error occurred.");
        } finally {
            scanner.close();
        }
    }
}