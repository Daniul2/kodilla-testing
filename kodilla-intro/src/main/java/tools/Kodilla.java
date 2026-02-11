package tools;
import java.util.HashSet;
import java.util.Set;

public class Kodilla {
    public static void main(String[] args) {
        // We use a HashSet instead of an ArrayList.
        // A HashSet automatically prevents duplicate values.
        Set<String> orderNumbers = new HashSet<>();

        // Adding order numbers (some are duplicates)
        orderNumbers.add("ORD/2026/001");
        orderNumbers.add("ORD/2026/002");
        orderNumbers.add("ORD/2026/001"); // Duplicate!
        orderNumbers.add("ORD/2026/003");
        orderNumbers.add("ORD/2026/002"); // Duplicate!

        // Verification: checking the size and printing the list
        System.out.println("Total unique orders in system: " + orderNumbers.size());

        System.out.println("List of orders to process:");
        for (String order : orderNumbers) {
            System.out.println("- " + order);
        }

        // Testing if a duplicate can be added
        boolean isAddedAgain = orderNumbers.add("ORD/2026/001");
        System.out.println("\nWas the duplicate ORD/2026/001 added again? " + isAddedAgain);
    }
}
