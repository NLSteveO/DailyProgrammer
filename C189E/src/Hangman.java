// Import classes
import java.util.ArrayList;
import java.util.Scanner;

public class Hangman{

    public Hangman(){}

    public static void Draw(int n) {
        String gallows = "   _\n  | |\n  |\n  |\n  |\n  |\n__|____\n";
        String head = "   _\n  | |\n  | O\n  |\n  |\n  |\n__|____\n";
        String body = "   _\n  | |\n  | O\n  | |\n  | |\n  |\n__|____\n";
        String lArm = "   _\n  | |\n  | O\n  |\\|\n  | |\n  |\n__|____\n";
        String rArm = "   _\n  | |\n  | O\n  |\\|/\n  | |\n  |\n__|____\n";
        String lLeg = "   _\n  | |\n  | O\n  |\\|/\n  | |\n  |/\n__|____\n";
        String rLeg = "   _\n  | |\n  | O\n  |\\|/\n  | |\n  |/ \\ \n__|____\n";
        if (n == 0){
            System.out.println(gallows);
        }
        else if (n==1) {
            System.out.println(head);
        }
        else if (n==2) {
            System.out.println(body);
        }
        else if (n==3) {
            System.out.println(lArm);
        }
        else if (n==4) {
            System.out.println(rArm);
        }
        else if (n==5) {
            System.out.println(lLeg);
        }
        else if (n==6) {
            System.out.println(rLeg);
        }
    }

    public static void main(String[] args){
        ArrayList<Character> guesses = new ArrayList<Character>();
        ArrayList<Character> printout = new ArrayList<Character>();
        char[] word;
        int wordSize;
        int[] guessCount = {0, 0}; //[0] = right, [1] = wrong
        boolean gameover = false;
        Scanner scan = new Scanner(System.in);
        WordSelector wordSelect = new WordSelector();
        String difficulty = "";
        System.out.println("Hello and welcome to Steve~O's Hangman game!");
        System.out.print("Please choose your difficulty:\n   1: Easy\n   2: Medium\n   3: Hard\n\n>>>");
        int temp = scan.nextInt();
        if (temp == 1) {
            difficulty = "easy";
        }
        else if (temp == 2) {
            difficulty = "medium";
        }
        else if (temp == 3) {
            difficulty = "hard";
        }
        word = (wordSelect.getWord(difficulty)).toCharArray();
        wordSize = word.length;
        System.out.println("Your word has " + wordSize + " letters.");
        for (int i=0; i<wordSize; i++) {
            printout.add((new String("_").toCharArray())[0]);
        }
        while (!gameover) {
            String newPrint = "";
            for (int i=0; i<wordSize; i++) {
                newPrint = newPrint + printout.get(i) + " ";
            }
            Draw(guessCount[1]);
            System.out.print(newPrint);
            System.out.println("\nGuess a letter: ");
            char charTemp = scan.next().charAt(0);
            if (guesses.contains(charTemp)) {
                System.out.println("Sorry but you have already guessed that. Please try again.\n");
                continue;
            }
            else {
                guesses.add(charTemp);
            }
            boolean found = false;
            for (int i=0; i<wordSize; i++) {
                if (Character.toLowerCase(word[i]) == Character.toLowerCase(charTemp)) {
                    if (!found) {
                        guessCount[0]++;
                        System.out.println("Correct!");
                        found = true;
                    }                    
                    printout.set(i, word[i]);
                }
                else if (i==wordSize-1 && word[i] != charTemp && !found) {
                    guessCount[1]++;
                    System.out.println("Incorrect!");
                }
            }
            if (guessCount[0] == wordSize) {
                System.out.println("Congratulations, you win!");
                gameover = true;
            }
            if (guessCount[1] == 6) {
                Draw(guessCount[1]);
                System.out.println("Sorry, you lose! Gameover!");
                String answer = new String(word);
                System.out.println("The word was: " + answer);
                gameover = true;
            }
        }
    }
}
