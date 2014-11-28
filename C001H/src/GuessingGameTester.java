// Import classes
import java.util.Scanner;

public class GuessingGameTester {

    // Main method
    public static void main(String[] args) {
        GuessingGame game = new GuessingGame(); // Creates object for the game
        Scanner in = new Scanner(System.in); // To take in user input

        // Just a introduction to the game
        System.out.println("Welcome to NLSteveO's Guessing Game!");
        System.out.println("The idea of the game is you pick a number between 1 and 100,");
        System.out.println("and the program will try to guess your number based on your");
        System.out.println("input of lower or higher. When correct just answer yes.\n");
        boolean play = false;
        while (!play) {
            System.out.print("When you are ready to begin type play and hit enter!");
            String throwaway = in.next();
            if (throwaway.equalsIgnoreCase("play")) {
                play = true;
                continue;
            }
        }

        boolean gameover = false; // Set boolean variable for the game loop
        int guess = game.guess(); // Set the first guess
        String reply = ""; // Create variable for user replies
        // Game loop
        while (!gameover) {
            // Guessing and taking reply
            System.out.print("Is your number " + guess + "?\n>>>");
            reply = in.next();
            // If reply is lower guess new number that is lower than previous
            if (reply.equalsIgnoreCase("lower")) {
                guess = game.lower(guess);
                continue;
            }
            // If reply is higher guess new number that is higher than previous
            else if (reply.equalsIgnoreCase("higher")) {
                guess = game.higher(guess);
                continue;
            }
            // If reply is yes game is over
            else if (reply.equalsIgnoreCase("yes")) {
                System.out.println("Thank you for playing!");
                gameover = true;
                continue;
            }
            // If the reply doesn't match any proper response
            else {
                System.out.println("Sorry but what you typed did not match any appropriate response.");
                System.out.println("Please try again but make sure you type either lower, higher, or yes.");
                continue;
            }
        }
    }
}
