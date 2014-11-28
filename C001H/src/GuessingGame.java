// Import classes
import java.util.Random;

public class GuessingGame {

    // Variables
    private int upperLimit = 101;
    private int lowerLimit = 1;
    private Random rand = new Random();

    // Empty constructor
    public GuessingGame(){}

    // Guess a number lower than previous guess
    public int lower(int lastGuess) {
        upperLimit = lastGuess-1;
        return guess();
    }

    // Guess a number higher than previous guess
    public int higher(int lastGuess) {
        lowerLimit = lastGuess+1;
        return guess();
    }

    // Guess a number between the upper and lower limits
    public int guess() {
        return (rand.nextInt((upperLimit-lowerLimit)+1)+lowerLimit);
    }
}
