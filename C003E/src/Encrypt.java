public class Encrypt{

    // Main method
    public static void main(String[] args) {
        // Check for correct number of arguments
        if (args.length == 3) {
            String filename = args[1]; // Filename
            int shift = Integer.parseInt(args[2]); // Shift amount
            CaesarCipher cc = new CaesarCipher(shift); // Create CaesarCipher object with shift amount
            // Check options for encrypt or decrypt
            if (args[0].equals("-e")) { // Encrypt
	            cc.encrypt(filename);
            }
            if (args[0].equals("-d")) { // Decrypt
                cc.decrypt(filename);
            }
        }
        // If not enough aruments are passed in
        else {
            System.out.println("Invalid usage! Try %java Encrypt -option filename shift-number");
            System.exit(1);
        }
    }
}
