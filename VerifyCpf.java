public class VerifyCpf {

    /**
     * Validates a given string to check if it is a valid CPF (Cadastro de Pessoa Física).
     * The function supports both formatted (xxx.xxx.xxx-xx) and unformatted (xxxxxxxxxxx) CPF inputs.
     *
     * @param value the document string entered by the user
     */
    public static void verifyCPF(String value) {

        // Case 1: CPF with punctuation (formatted as xxx.xxx.xxx-xx, 14 characters)
        if (value.length() == 14) {

            // --- Calculate the first check digit ---
            int firstFinalDigitChecker = (Character.getNumericValue(value.charAt(0)) * 10)
                    + (Character.getNumericValue(value.charAt(1)) * 9)
                    + (Character.getNumericValue(value.charAt(2)) * 8)
                    + (Character.getNumericValue(value.charAt(4)) * 7)
                    + (Character.getNumericValue(value.charAt(5)) * 6)
                    + (Character.getNumericValue(value.charAt(6)) * 5)
                    + (Character.getNumericValue(value.charAt(8)) * 4)
                    + (Character.getNumericValue(value.charAt(9)) * 3)
                    + (Character.getNumericValue(value.charAt(10)) * 2);

            firstFinalDigitChecker = firstFinalDigitChecker % 11;
            firstFinalDigitChecker = 11 - firstFinalDigitChecker;

            // If result is 10 or 11, it becomes 0
            if (firstFinalDigitChecker <= 1) {
                firstFinalDigitChecker = 0;
            }

            // --- Calculate the second check digit ---
            int secondFinalDigitChecker = (Character.getNumericValue(value.charAt(0)) * 11)
                    + (Character.getNumericValue(value.charAt(1)) * 10)
                    + (Character.getNumericValue(value.charAt(2)) * 9)
                    + (Character.getNumericValue(value.charAt(4)) * 8)
                    + (Character.getNumericValue(value.charAt(5)) * 7)
                    + (Character.getNumericValue(value.charAt(6)) * 6)
                    + (Character.getNumericValue(value.charAt(8)) * 5)
                    + (Character.getNumericValue(value.charAt(9)) * 4)
                    + (Character.getNumericValue(value.charAt(10)) * 3)
                    + (Character.getNumericValue(value.charAt(12)) * 2);

            secondFinalDigitChecker = secondFinalDigitChecker % 11;

            // If result is 10 or 11, it becomes 0
            if (secondFinalDigitChecker < 2) {
                secondFinalDigitChecker = 0;
            } else {
                secondFinalDigitChecker = 11 - secondFinalDigitChecker;
            }

            // --- Validate format and check digits ---
            if (GeneralFunctions.isDigit(value.charAt(0))
                    && GeneralFunctions.isDigit(value.charAt(1))
                    && GeneralFunctions.isDigit(value.charAt(2))
                    && value.charAt(3) == '.'
                    && GeneralFunctions.isDigit(value.charAt(4))
                    && GeneralFunctions.isDigit(value.charAt(5))
                    && GeneralFunctions.isDigit(value.charAt(6))
                    && value.charAt(7) == '.'
                    && GeneralFunctions.isDigit(value.charAt(8))
                    && GeneralFunctions.isDigit(value.charAt(9))
                    && GeneralFunctions.isDigit(value.charAt(10))
                    && value.charAt(11) == '-'
                    && (Character.getNumericValue(value.charAt(12)) == firstFinalDigitChecker)
                    && (Character.getNumericValue(value.charAt(13)) == secondFinalDigitChecker)) {

                System.out.println("Everything looks fine! Your document is a CPF!");
            } else {
                System.out.println("The value collected isn't a CPF!");
                throw new IllegalArgumentException("Invalid CPF!");
            }
        }

        // Case 2: CPF without punctuation (11 digits)
        else if (value.length() == 11) {

            // --- Calculate the first check digit ---
            int firstFinalDigitChecker = (Character.getNumericValue(value.charAt(0)) * 10)
                    + (Character.getNumericValue(value.charAt(1)) * 9)
                    + (Character.getNumericValue(value.charAt(2)) * 8)
                    + (Character.getNumericValue(value.charAt(3)) * 7)
                    + (Character.getNumericValue(value.charAt(4)) * 6)
                    + (Character.getNumericValue(value.charAt(5)) * 5)
                    + (Character.getNumericValue(value.charAt(6)) * 4)
                    + (Character.getNumericValue(value.charAt(7)) * 3)
                    + (Character.getNumericValue(value.charAt(8)) * 2);

            firstFinalDigitChecker = firstFinalDigitChecker % 11;
            firstFinalDigitChecker = 11 - firstFinalDigitChecker;

            // If result is 10 or 11, it becomes 0
            if (firstFinalDigitChecker <= 1) {
                firstFinalDigitChecker = 0;
            }

            // --- Calculate the second check digit ---
            int secondFinalDigitChecker = (Character.getNumericValue(value.charAt(0)) * 11)
                    + (Character.getNumericValue(value.charAt(1)) * 10)
                    + (Character.getNumericValue(value.charAt(2)) * 9)
                    + (Character.getNumericValue(value.charAt(3)) * 8)
                    + (Character.getNumericValue(value.charAt(4)) * 7)
                    + (Character.getNumericValue(value.charAt(5)) * 6)
                    + (Character.getNumericValue(value.charAt(6)) * 5)
                    + (Character.getNumericValue(value.charAt(7)) * 4)
                    + (Character.getNumericValue(value.charAt(8)) * 3)
                    + (Character.getNumericValue(value.charAt(9)) * 2);

            secondFinalDigitChecker = secondFinalDigitChecker % 11;

            // If result is 10 or 11, it becomes 0
            if (secondFinalDigitChecker < 2) {
                secondFinalDigitChecker = 0;
            } else {
                secondFinalDigitChecker = 11 - secondFinalDigitChecker;
            }

            // --- Validate digits only and check digits ---
            if (GeneralFunctions.isDigit(value.charAt(0))
                    && GeneralFunctions.isDigit(value.charAt(1))
                    && GeneralFunctions.isDigit(value.charAt(2))
                    && GeneralFunctions.isDigit(value.charAt(3))
                    && GeneralFunctions.isDigit(value.charAt(4))
                    && GeneralFunctions.isDigit(value.charAt(5))
                    && GeneralFunctions.isDigit(value.charAt(6))
                    && GeneralFunctions.isDigit(value.charAt(7))
                    && GeneralFunctions.isDigit(value.charAt(8))
                    && (Character.getNumericValue(value.charAt(9)) == firstFinalDigitChecker)
                    && (Character.getNumericValue(value.charAt(10)) == secondFinalDigitChecker)) {

                System.out.println("Everything looks fine! Your document is a CPF!");
            } else {
                System.out.println("The value collected isn't a CPF!");
                throw new IllegalArgumentException("Invalid CPF!");
            }
        }

        // Case 3: Not a CPF (wrong length or invalid format)
        else {
            System.out.println("Your input isn't a RG or a CPF!");
        }
    }
}