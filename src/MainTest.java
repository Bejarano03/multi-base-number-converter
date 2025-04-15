import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    void testBinaryToHexadecimal() {
        // Binary 1010 to Hexadecimal
        String originalNum = "1010";
        int originalBase = 2;
        int desiredBase = 16;

        String expected = "A";
        String actual = convertBase(originalNum, originalBase, desiredBase);

        assertEquals(expected, actual);
    }

    @Test
    void testDecimalToBinary() {
        // Decimal 255 to Binary
        String originalNum = "255";
        int originalBase = 10;
        int desiredBase = 2;

        String expected = "11111111";
        String actual = convertBase(originalNum, originalBase, desiredBase);

        assertEquals(expected, actual);
    }

    @Test
    void testHexadecimalToOctal() {
        // Hexadecimal 1F to Octal
        String originalNum = "1F";
        int originalBase = 16;
        int desiredBase = 8;

        String expected = "37";
        String actual = convertBase(originalNum, originalBase, desiredBase);

        assertEquals(expected, actual);
    }

    @Test
    void testMinimumInputValue() {
        // Decimal 0 to Binary
        String originalNum = "0";
        int originalBase = 10;
        int desiredBase = 2;

        String expected = "0";
        String actual = convertBase(originalNum, originalBase, desiredBase);

        assertEquals(expected, actual);
    }

    @Test
    void testMaximumBase() {
        // Hexadecimal FFFF to Decimal
        String originalNum = "FFFF";
        int originalBase = 16;
        int desiredBase = 10;

        String expected = "65535";
        String actual = convertBase(originalNum, originalBase, desiredBase);

        assertEquals(expected, actual);
    }

    @Test
    void testInvalidInputForBase() {
        // Invalid input: 123 in base 2
        String originalNum = "123";
        int originalBase = 2;
        int desiredBase = 10;

        assertThrows(NumberFormatException.class, () -> {
            convertBase(originalNum, originalBase, desiredBase);
        });
    }

    /**
     * Helper method to perform base conversion.
     * This is a simplified version of the logic from your program.
     */
    private String convertBase(String originalNum, int originalBase, int desiredBase) {
        // Convert the input number from the original base to decimal
        int decimalNumber = Integer.parseInt(originalNum, originalBase);

        // Convert the decimal number to the desired base
        String digits = "0123456789ABCDEF";
        StringBuilder convertedNumber = new StringBuilder();

        if (decimalNumber == 0) {
            return "0";
        }

        while (decimalNumber > 0) {
            int remainder = decimalNumber % desiredBase;
            convertedNumber.insert(0, digits.charAt(remainder));
            decimalNumber /= desiredBase;
        }

        return convertedNumber.toString();
    }
}