public class GeneralFunctions {

    /**
     * Checks if a given character is a numeric digit (0–9).
     * 
     * @param c the character to be checked
     * @return true if the character is a digit, false otherwise
     */
    public static boolean isDigit(char c) {
        // A digit in ASCII is represented by characters '0' (48) to '9' (57).
        // This condition ensures that the character is within that range.
        return c >= '0' && c <= '9';
    }
}