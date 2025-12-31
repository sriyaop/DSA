import java.util.Scanner;

public class butterflypattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int num = sc.nextInt();

        // Upper half of the butterfly
        for (int row = 1; row <= num; row++) {
            // Left wing
            for (int col = 1; col <= row; col++) {
                System.out.print("* ");
            }
            // Spaces in the middle
            for (int col = 1; col <= (2 * num - 2 * row); col++) {
                System.out.print("  ");
            }
            // Right wing
            for (int col = 1; col <= row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        // Lower half of the butterfly
        for (int row = num; row >= 1; row--) {
            // Left wing
            for (int col = 1; col <= row; col++) {
                System.out.print("* ");
            }
            // Spaces in the middle
            for (int col = 1; col <= (2 * num - 2 * row); col++) {
                System.out.print("  ");
            }
            // Right wing
            for (int col = 1; col <= row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        sc.close();
    }
}
