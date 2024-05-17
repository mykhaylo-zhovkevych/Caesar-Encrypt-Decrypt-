package person;

import java.util.Scanner;

public class EncryptDecrypt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int key = 2; // Using int for flexibility with key
        
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
                break;
            } else {
                System.out.println("Invalid choice. Please choose 1, 2, or 3.");
            }
        }
        
        scanner.close();
    }

    public static String encrypt(String text, int key) {
        return shiftText(text, key);
    }

    public static String decrypt(String text, int key) {
        return shiftText(text, -key);
    }

    private static String shiftText(String text, int key) {
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'a' && chars[i] <= 'z') {
                chars[i] = (char)((chars[i] - 'a' + key + 26) % 26 + 'a');
            } else if (chars[i] >= 'A' && chars[i] <= 'Z') {
                chars[i] = (char)((chars[i] - 'A' + key + 26) % 26 + 'A');
            }
        }
        return new String(chars);
    }
}
