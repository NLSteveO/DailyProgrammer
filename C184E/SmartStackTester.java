import java.util.Random;

public class SmartStackTester{

	public static void main(String[] args){
		SmartStack stack = new SmartStack();
		Random rand = new Random();
		int max = 1000;
		int min = -1000;
		int size = rand.nextInt(40)+1;
		System.out.println("Stack size: " + size);
		System.out.println("Generating Stack!");
		for (int i = 0; i < size; i++){
			int num = rand.nextInt((max-min)+1)+min;
			stack.push(num);
			//System.out.println("push(" + num + ")");
		}
		System.out.print("Print stack: " + stack.displayStack());
		System.out.print("Print ordered: " + stack.displayOrdered());
		/**int x = rand.nextInt((max-min)+1)+min;
		stack.removeGreater(x);
		System.out.print("Removing all greater than " + x + "!");
		System.out.print("Print stack: " + stack.displayStack());
		System.out.print("Print ordered: " + stack.displayOrdered());
		System.out.print("Removing half the stack!");
		for (int i = 0; i < size/2; i++){
			stack.pop();
		}
		System.out.print("Print stack: " + stack.displayStack());
		System.out.print("Print ordered: " + stack.displayOrdered());*/
	}
}
