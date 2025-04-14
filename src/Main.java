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

        System.out.println("Enter a number in its original base (integer values only, no floats or negative numbers: ");
        int originalNum = scanner.nextInt();
        System.out.println("Enter the base of the input number (between 2 and 16): ");
        int originalBase = scanner.nextInt();
        System.out.println("Enter the desired base to convert this number to (between 2 and 16): ");
        int desiredBase = scanner.nextInt();


    }
}