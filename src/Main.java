import java.util.Scanner;

/**
 * This program shows you an input location
 * to enter a number, and then it converts it
 * to the desired numerical base.
 *
 * @author Marco Bejarano Oseguera
 * @version 04-14-2025
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Multi-Base Numerical Converter");
        System.out.println();

        // Input: Number, its base, and the desired base
        System.out.print("Enter a number in its original base (integer values only, no floats or negative numbers): ");
        String originalNum = scanner.next(); // Use String to handle numbers in any base
        System.out.print("Enter the base of the input number (between 2 and 16): ");
        int originalBase = scanner.nextInt();
        System.out.print("Enter the desired base to convert this number to (between 2 and 16): ");
        int desiredBase = scanner.nextInt();

        // Validate the bases
        if (originalBase < 2 || originalBase > 16) {
            System.out.println("Error: The original base must be between 2 and 16.");
            return;
        }
        if (desiredBase < 2 || desiredBase > 16) {
            System.out.println("Error: The desired base must be between 2 and 16.");
            return;
        }

        try {
            // Convert the input number from the original base to decimal
            int decimalNumber = Integer.parseInt(originalNum, originalBase);

            // Convert the decimal number to the desired base
            String digits = "0123456789ABCDEF";
            StringBuilder convertedNumber = new StringBuilder();

            if (decimalNumber == 0) {
                convertedNumber.append("0");
            } else {
                while (decimalNumber > 0) {
                    int remainder = decimalNumber % desiredBase;
                    convertedNumber.insert(0, digits.charAt(remainder));
                    decimalNumber /= desiredBase;
                }
            }

            // Output the result
            System.out.println("The number " + originalNum + " in base " + originalBase +
                    " is " + convertedNumber + " in base " + desiredBase + ".");
        } catch (NumberFormatException e) {
            System.out.println("Error: '" + originalNum + "' is not a valid number in base " + originalBase + ".");
        }

        scanner.close();
    }
}