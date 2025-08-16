import java.util.Scanner;

public class DocumentVerifier {

    public static void main(String[] args) {
        // Create a Scanner object to read user input from the console
        Scanner scanner = new Scanner(System.in);

        // Ask the user to type a document (CPF or RG)
        System.out.print("Write the document you want to verify: ");
        String valueCollected = scanner.nextLine(); // Store the input as a String

        try {
            // First, try to validate the input as an RG
            VerifyRg.verifyRG(valueCollected);
        } catch (Exception e) {
            // If RG validation fails, catch the exception and try to validate as a CPF
            VerifyCpf.verifyCPF(valueCollected);
        }

        // Close the scanner to free system resources
        scanner.close();
    }
}