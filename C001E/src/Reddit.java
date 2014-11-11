// Import classes
import java.util.Scanner;

public class Reddit{

    // Main class where this whole program is run from.
	public static void main(String[] args){
	
	    // Variables
		String name, user;
		int age;
		Scanner in = new Scanner(System.in); // Scanner to read console input
		
		// Ask name and save to variable
		System.out.print("Hello, what is your name? \n>>> ");
		name = in.nextLine();
		
		// Ask age and save to variable
		System.out.print("Well " + name + ", how old are you? \n>>> ");
		age = in.nextInt();
		
		// Ask reddit username and save to variable
		System.out.println("Alright " + name + ", one last question.");
		System.out.print("What is your Reddit username? \n>>> ");
		user = in.next();
		
		// Print all saved information and say goodbye
		System.out.println("\n\n\nHello, your name is " + name + ", you are " + age + " years old, and your username for Reddit is " + user +".");
		System.out.println("\nGoodbye.");
	}
}
