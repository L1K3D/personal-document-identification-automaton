public class VerifyRg {

    /**
     * Validates a given string to check if it is a valid RG (Registro Geral).
     * The function supports both formatted (xx.xxx.xxx-X) and unformatted (xxxxxxxxX) RG inputs.
     *
     * @param value the document string entered by the user
     */
    public static void verifyRG(String value) {

        // Case 1: RG with punctuation (formatted as xx.xxx.xxx-X, 12 characters)
        if (value.length() == 12) { 

            // --- Calculate the check digit ---
            int finalDigitChecker = (Character.getNumericValue(value.charAt(0)) * 9)
                    + (Character.getNumericValue(value.charAt(1)) * 8)
                    + (Character.getNumericValue(value.charAt(3)) * 7)
                    + (Character.getNumericValue(value.charAt(4)) * 6)
                    + (Character.getNumericValue(value.charAt(5)) * 5)
                    + (Character.getNumericValue(value.charAt(7)) * 4)
                    + (Character.getNumericValue(value.charAt(8)) * 3)
                    + (Character.getNumericValue(value.charAt(9)) * 2);

            finalDigitChecker = finalDigitChecker % 11;

            // If result is 10, the check digit becomes "X", otherwise it's the number itself
            String finalDigitCheckerStr = (finalDigitChecker == 10) ? "X" : String.valueOf(finalDigitChecker);

            // --- Validate format and check digit ---
            if (GeneralFunctions.isDigit(value.charAt(0))
                    && GeneralFunctions.isDigit(value.charAt(1))
                    && value.charAt(2) == '.'
                    && GeneralFunctions.isDigit(value.charAt(3))
                    && GeneralFunctions.isDigit(value.charAt(4))
                    && GeneralFunctions.isDigit(value.charAt(5))
                    && value.charAt(6) == '.'
                    && GeneralFunctions.isDigit(value.charAt(7))
                    && GeneralFunctions.isDigit(value.charAt(8))
                    && GeneralFunctions.isDigit(value.charAt(9))
                    && value.charAt(10) == '-'
                    && String.valueOf(value.charAt(11)).equalsIgnoreCase(finalDigitCheckerStr)) {

                System.out.println("Everything looks fine! Your document is a RG");
            } else {
                // If any condition fails, it's not a valid RG
                throw new IllegalArgumentException("Invalid RG");
            }
        }

        // Case 2: RG without punctuation (xxxxxxxxX, 9 characters)
        else if (value.length() == 9) {

            // --- Calculate the check digit ---
            int finalDigitChecker = (Character.getNumericValue(value.charAt(0)) * 9)
                    + (Character.getNumericValue(value.charAt(1)) * 8)
                    + (Character.getNumericValue(value.charAt(2)) * 7)
                    + (Character.getNumericValue(value.charAt(3)) * 6)
                    + (Character.getNumericValue(value.charAt(4)) * 5)
                    + (Character.getNumericValue(value.charAt(5)) * 4)
                    + (Character.getNumericValue(value.charAt(6)) * 3)
                    + (Character.getNumericValue(value.charAt(7)) * 2);

            finalDigitChecker = finalDigitChecker % 11;

            // If result is 10, the check digit becomes "X", otherwise it's the number itself
            String finalDigitCheckerStr = (finalDigitChecker == 10) ? "X" : String.valueOf(finalDigitChecker);

            // --- Validate digits only and check digit ---
            if (GeneralFunctions.isDigit(value.charAt(0))
                    && GeneralFunctions.isDigit(value.charAt(1))
                    && GeneralFunctions.isDigit(value.charAt(2))
                    && GeneralFunctions.isDigit(value.charAt(3))
                    && GeneralFunctions.isDigit(value.charAt(4))
                    && GeneralFunctions.isDigit(value.charAt(5))
                    && GeneralFunctions.isDigit(value.charAt(6))
                    && GeneralFunctions.isDigit(value.charAt(7))
                    && String.valueOf(value.charAt(8)).equalsIgnoreCase(finalDigitCheckerStr)) {

                System.out.println("Everything looks fine! Your document is a RG");
            } else {
                // If check fails, throw an exception
                throw new IllegalArgumentException("Invalid RG");
            }
        } 
        
        // Case 3: Not an RG (wrong length)
        else {
            throw new IllegalArgumentException("Not a RG");
        }
    }
}