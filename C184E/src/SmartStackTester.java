// Import classes
import java.util.Random;

public class SmartStackTester{

    // Main class to test the program
	public static void main(String[] args){
		SmartStack stack = new SmartStack(); // Create stack
		Random rand = new Random(); // Create random number generator
		
		// Setting min and max size of possible numbers
		int max = 1000;
		int min = -1000;
		
		// Setting size
		int size = rand.nextInt(40)+1;
		System.out.println("Stack size: " + size);
		
		// Filling stack
		System.out.println("Generating Stack!");
		for (int i = 0; i < size; i++){
			int num = rand.nextInt((max-min)+1)+min;
			stack.push(num);
			System.out.println("push(" + num + ")");
		}
		
		// Printing the stack both sorted and unsorted
		System.out.println("Print stack: \n" + stack.displayStack());
		System.out.println("Print ordered stack: \n" + stack.displayOrdered());
		
		// Pick random number and remove all greater than it
		int x = rand.nextInt((max-min)+1)+min;
		stack.removeGreater(x);
		System.out.print("Removing all greater than " + x + "!");
		
		// Printing the stack both sorted and unsorted
		System.out.println("\nsize: " + stack.size() + "\n");
		System.out.println("Print stack: \n" + stack.displayStack());
		System.out.println("Print ordered stack: \n" + stack.displayOrdered());
		
		// Remove half the stack
		int l = stack.size()/2;
		System.out.println("Removing half the stack!");
		for (int i = 0; i < l; i++){
			Node t = stack.pop();
			System.out.println(i + " pop(" + t.getElement() + ")");
		}
		
		// Printing the stack both sorted and unsorted
		System.out.println("\nsize: " + stack.size() + "\n");
		System.out.println("Print stack: " + stack.displayStack());
		System.out.println("Print ordered: " + stack.displayOrdered());
	}
}
