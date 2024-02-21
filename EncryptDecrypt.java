package person;

import java.util.Scanner;

public class EncryptDecrypt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char key = 2;
        
        System.out.println("Welcome to the Caesar-Encrypt/Decrypt program!");
        
        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Encrypt a message");
            System.out.println("2. Decrypt a message");
            System.out.println("3. Quit");
            System.out.print("Enter your choice (1/2/3): ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            
            if (choice == 1) {
                System.out.print("Enter the message to encrypt: ");
                String text = scanner.nextLine();
                String encrypted = encrypt(text, key);
                System.out.println("Encrypted message: " + encrypted);
            } else if (choice == 2) {
                System.out.print("Enter the message to decrypt: ");
                String text = scanner.nextLine();
                String decrypted = decrypt(text, key);
                System.out.println("Decrypted message: " + decrypted);
            } else if (choice == 3) {
                System.out.println("Goodbye!");
                break; // Exit the program
            } else {
                System.out.println("Invalid choice. Please choose 1, 2, or 3.");
            }
        }
        
        scanner.close(); // Close the scanner when done
    }

    // Function to encrypt a message
    public static String encrypt(String text, char key) {
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] += key;
        }
        return new String(chars);
    }

    // Function to decrypt a message
    public static String decrypt(String text, char key) {
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] -= key;
        }
        return new String(chars);
    }
}
