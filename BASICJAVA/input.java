import java.util.*;

public class input {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter an integer:");
        if (sc.hasNextInt()) { // Validate input is an integer
            int val = sc.nextInt();
            System.out.println("You entered: " + val);
        } else {
            System.out.println("Invalid input. Please enter an integer.");
        }
        
        // Uncomment these for testing string inputs:

        // System.out.println("Enter a single word:");
        // String input = sc.next();
        // System.out.println("You entered: " + input);

        // System.out.println("Enter a full line:");
        // sc.nextLine(); // Consume leftover newline from previous input
        // String name = sc.nextLine();
        // System.out.println("You entered: " + name);

        sc.close(); // Always close the Scanner to release resources
    }
}
