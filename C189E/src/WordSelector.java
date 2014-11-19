// Import classes
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

public class WordSelector{

    // Variables
    private static final String filename = "lib/wordlist.txt";
    private File file;
    private ArrayList<String> wordList;

    public WordSelector(){
            file = new File(filename);
            loadList();
    }

    public void loadList(){
        try {
            wordList = new ArrayList<String>();
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String word = reader.readLine();
            while (word != null) {
                wordList.add(word);
                word = reader.readLine();
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("Something went terribly wrong!");
            System.out.println(e);
            System.exit(1);
        }
        catch(Exception e) {
            System.out.println("Something went terribly wrong!");
            System.out.println(e);
            System.exit(1);
        }
    }

    public String getWord(String difficulty){
        int minLen, maxLen;
        if (difficulty.equalsIgnoreCase("hard")) {
            minLen = 7;
            maxLen = 100;
        }
        else if (difficulty.equalsIgnoreCase("medium")) {
            minLen = 5;
            maxLen = 7;
        }
        else {
            minLen = 3;
            maxLen = 5;
        }
        Random ranNum = new Random();
        String word = "";
        boolean fit = false;
        while (!fit) {
            int wordPos = ranNum.nextInt(wordList.size());
            String temp = wordList.get(wordPos);
            word = temp.replaceAll("[^a-zA-Z]", "");
            if (word.length() >= minLen && word.length() <= maxLen) {
                fit = true;
            }
        }
        return word;
    }

    public static void main(String[] args) {
        WordSelector test = new WordSelector();
        System.out.println(test.getWord("hard"));
    }
}
