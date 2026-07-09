

package TourManagement;
// File: InputHelper.java
import java.util.Scanner;

public class InputHelper {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getInt(String message) {
        int num;
        while (true) {
            try {
                System.out.print(message);
                num = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println(" Please enter a valid number.");
            }
        }
        return num;
    }

    public static String getString(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    public static boolean getBoolean(String message) {
        while (true) {
            System.out.print(message + " (yes/no): ");
            String input = scanner.nextLine().toLowerCase();
            if (input.equals("yes")) return true;
            if (input.equals("no")) return false;
            System.out.println("Invalid input. Please type 'yes' or 'no'.");
        }
    }

    public static double getDouble(String message) {
        double num;
        while (true) {
            try {
                System.out.print(message);
                num = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println(" Please enter a valid decimal number.");
            }
        }
        return num;
    }
}
