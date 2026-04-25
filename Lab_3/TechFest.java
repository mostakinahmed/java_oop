import java.util.ArrayList;

public class TechFest {
    public static void main(String[] args) {
        // 1. Create two ArrayLists and add participants
        ArrayList<String> sweParticipants = new ArrayList<>();
        sweParticipants.add("Alice");
        sweParticipants.add("Bob");
        sweParticipants.add("Charlie");

        ArrayList<String> cseParticipants = new ArrayList<>();
        cseParticipants.add("David");
        cseParticipants.add("Eva");
        cseParticipants.add("Frank");

        // 2. Combine both lists into a single FinalList
        ArrayList<String> finalList = new ArrayList<>();
        finalList.addAll(sweParticipants);
        finalList.addAll(cseParticipants);
        System.out.println("Initial FinalList: " + finalList);

        // 3. Replace the first occurrence of "Alice" with "Grace"
        int aliceIndex = finalList.indexOf("Alice");
        if (aliceIndex != -1) {
            finalList.set(aliceIndex, "Grace");
        }
        System.out.println("After replacing Alice: " + finalList);

        // 4. Display the first and last participants
        if (!finalList.isEmpty()) {
            System.out.println("First participant: " + finalList.get(0));
            System.out.println("Last participant: " + finalList.get(finalList.size() - 1));
        }

        // 5. Find the last occurrence of "David"
        int lastDavid = finalList.lastIndexOf("David");
        if (lastDavid != -1) {
            System.out.println("Last index of David: " + lastDavid);
        } else {
            System.out.println("David is not in the list.");
        }

        // 6. Remove all CSE participants from the FinalList
        finalList.removeAll(cseParticipants);
        System.out.println("After removing CSE participants: " + finalList);

        // 7. Display the size of the FinalList
        System.out.println("Size of FinalList: " + finalList.size());

        // 8. Clear the FinalList
        
        finalList.clear();

        // 9. Check if the FinalList is empty
        if (finalList.isEmpty()) {
            System.out.println("The list is empty!");
        } else {
            System.out.println("The list is not empty!");
        }
    }
}