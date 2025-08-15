import java.util.Scanner;

public class DocumentVerifier {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Write the document you want to verify: ");
        String valueCollected = scanner.nextLine();

        try {
            verifyRG(valueCollected);
        } catch (IllegalArgumentException e) {
            try {
                verifyCPF(valueCollected);
            } catch (IllegalArgumentException ex) {
                System.out.println("Invalid document to RG or CPF");
            }
        }

        scanner.close();
    }

    // Verificação de RG
    public static void verifyRG(String value) {
        
        if (value.length() == 12) { // Corrigido para RG com pontos e hífen
            int finalDigitChecker = (Character.getNumericValue(value.charAt(0)) * 9)
                    + (Character.getNumericValue(value.charAt(1)) * 8)
                    + (Character.getNumericValue(value.charAt(3)) * 7)
                    + (Character.getNumericValue(value.charAt(4)) * 6)
                    + (Character.getNumericValue(value.charAt(5)) * 5)
                    + (Character.getNumericValue(value.charAt(7)) * 4)
                    + (Character.getNumericValue(value.charAt(8)) * 3)
                    + (Character.getNumericValue(value.charAt(9)) * 2); // Corrigido: incluiu penúltimo dígito

            finalDigitChecker = finalDigitChecker % 11;
            String finalDigitCheckerStr = (finalDigitChecker == 10) ? "X" : String.valueOf(finalDigitChecker);

            if (isDigit(value.charAt(0))
                    && isDigit(value.charAt(1))
                    && value.charAt(2) == '.'
                    && isDigit(value.charAt(3))
                    && isDigit(value.charAt(4))
                    && isDigit(value.charAt(5))
                    && value.charAt(6) == '.'
                    && isDigit(value.charAt(7))
                    && isDigit(value.charAt(8))
                    && isDigit(value.charAt(9))
                    && value.charAt(10) == '-'
                    && String.valueOf(value.charAt(11)).equalsIgnoreCase(finalDigitCheckerStr)) {

                System.out.println("Everything looks fine! Your document is a RG");
                System.out.println("Final Digit Calculated: " + finalDigitCheckerStr);
            } else {
                System.out.println("Final Digit Calculated: " + finalDigitCheckerStr);
                throw new IllegalArgumentException("Invalid RG");
            }
        }

        else if (value.length() == 9) { // RG sem pontuação
            int finalDigitChecker = (Character.getNumericValue(value.charAt(0)) * 9)
                    + (Character.getNumericValue(value.charAt(1)) * 8)
                    + (Character.getNumericValue(value.charAt(2)) * 7)
                    + (Character.getNumericValue(value.charAt(3)) * 6)
                    + (Character.getNumericValue(value.charAt(4)) * 5)
                    + (Character.getNumericValue(value.charAt(5)) * 4)
                    + (Character.getNumericValue(value.charAt(6)) * 3)
                    + (Character.getNumericValue(value.charAt(7)) * 2);

            finalDigitChecker = finalDigitChecker % 11;
            String finalDigitCheckerStr = (finalDigitChecker == 10) ? "X" : String.valueOf(finalDigitChecker);

            if (isDigit(value.charAt(0))
                    && isDigit(value.charAt(1))
                    && isDigit(value.charAt(2))
                    && isDigit(value.charAt(3))
                    && isDigit(value.charAt(4))
                    && isDigit(value.charAt(5))
                    && isDigit(value.charAt(6))
                    && isDigit(value.charAt(7))
                    && String.valueOf(value.charAt(8)).equalsIgnoreCase(finalDigitCheckerStr)) {

                System.out.println("Everything looks fine! Your document is a RG");
                System.out.println("Final Digit Calculated: " + finalDigitCheckerStr);
            } else {
                System.out.println("Final Digit Calculated: " + finalDigitCheckerStr);
                throw new IllegalArgumentException("Invalid RG");
            }
        } else {
            System.out.println("The value collected isn't a RG!");
            throw new IllegalArgumentException("Invalid RG!");
        }
    }

    // 440.523.188-54
    public static void verifyCPF(String value) {

        if (value.length() == 14) {
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

            if (firstFinalDigitChecker <= 1) {
                firstFinalDigitChecker = 0;
            } 
            else {
                firstFinalDigitChecker = firstFinalDigitChecker;
            }

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

            if (secondFinalDigitChecker < 2) {
                secondFinalDigitChecker = 0;
            }
            else {
                secondFinalDigitChecker = 11 - secondFinalDigitChecker;
            }

        }

    }

    // Função auxiliar para verificar se é dígito
    private static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
}