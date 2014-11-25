// Import classes
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class CaesarCipher{

    // Variable
    private static final ArrayList<Character> alpha = new ArrayList<Character>();
    private int shift;

    // Constructor sets shift amount and fills variable alpha
	public CaesarCipher(int s) {
        shift = s; // Sets shift to given shift amount
        char c = 'a';
        // Fills alpha list with lower case letters
        for (int i=0; i<26; i++) {
            alpha.add((char)(c+i));
        }
        // Adds to alpha list the upper case letters
        char d = 'A';
        for (int i=0; i<26; i++) {
            alpha.add((char)(d+i));
        }
    }

    // Shifts the given character by shift amount along list alpha
    public char shiftChar(char c) {
        int a = alpha.indexOf(c);
        // If shift doesn't extend past the end of the list
        if (a+shift < alpha.size()) {
            return alpha.get(a+shift);
        }
        // If shift passes end of list, then wrap around.
        else {
            int b = (a+shift) - alpha.size();
            return alpha.get(b);
        }
    }

    // Unshifts the given character by shift amount along list alpha
    public char unShift(char c) {
        int a = alpha.indexOf(c);
        // If unshifting doesn't extend past the start of the list
        if (a-shift >= 0) {
            return alpha.get(a-shift);
        }
        // If unshifting passes start of list, then wrap around.
        else {
            int b = (a-shift) + (alpha.size());
            return alpha.get(b);
        }
    }

    // Encrypts file from given filename
	public void encrypt(String filename) {
        try {
            File file =  new File(filename); // Create File object with given filename
            String saveFile = filename.replace("txt", "dat"); // Create save filename from given filename
            // Create BufferedReader/Writer
	    	BufferedReader reader = new BufferedReader(new FileReader(file));
            BufferedWriter writer = new BufferedWriter(new FileWriter(saveFile));
            String line = reader.readLine(); // Read first line
            // While line is not null loop through file
            while (line != null) {
                // Loop through each character from charArray created from line
                for (char c : line.toCharArray()) {
                    // Check if letter and call shiftChar
                    if (Character.isLetter(c)) {
                        writer.write(shiftChar(c));
                    }
                    // Otherwise just write
                    else {
                        writer.write(c);
                    }

                }
                writer.newLine(); // Write new line
                line = reader.readLine(); // Read next line
                writer.flush(); // Flush writer
            }
            // Close buffers
            reader.close();
            writer.close();
	    }
        // Error catches
        catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
        catch (Exception e) {
            System.out.println("Error1: " + e.getMessage());
        }
    }

    // Decrypts file from given filename
    public void decrypt(String filename) {
        try {
            File file = new File(filename.replace("txt", "dat")); // Create File object with given filename
            String saveFile = filename.replace(".txt", "2.txt"); // Create save filename from given filename
            // Create BufferedReader/Writer
	    	BufferedReader reader = new BufferedReader(new FileReader(file));
            BufferedWriter writer = new BufferedWriter(new FileWriter(saveFile));
            String line = reader.readLine(); // Read first line
            // While line is not null loop through file
            while (line != null) {
                // Loop through each character from charArray created from line
                for (char c : line.toCharArray()) {
                    // Check if letter and call shiftChar
                    if (Character.isLetter(c)) {
                        writer.write(unShift(c));
                    }
                    // Otherwise just write
                    else {
                        writer.write(c);
                    }

                }
                writer.newLine(); // Write new line
                line = reader.readLine(); // Read next line
                writer.flush(); // Flush writer
            }
            // Close buffers
            reader.close();
            writer.close();
        }
        // Error catches
        catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
        catch (Exception e) {
            System.out.println("Error2: " + e.getMessage());
        }
    }
}
