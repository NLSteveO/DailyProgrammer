// Import classes
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class VersionSort{	
	
	// Variables
	private File file;
	private int listSize;
	private ArrayList<String> list = new ArrayList<String>();

    /* 
     * Constructor takes in filename and creates File and calls 
     * get List then calls sort on list and returns list.
     */
	public VersionSort(String s){
	    try {
    		file = new File(s); // Creates file from given filename
	    	getList();  // Gets the list from the file
	    	
	    	// Shows the given list
	    	System.out.println("Here is the list given to be sorted:");
	    	for (int i=0; i<listSize; i++){
	    	    System.out.println(list.get(i));
	    	}
	    	
	    	list = sort(list); // Calls sort on the list which returns the list sorted
	    	
	    	// Shows the sorted list
	    	System.out.println("\nHere is the list sorted from newest to oldest:");
	    	for (int i=0; i<listSize; i++){
	    	    System.out.println((list.get(i)));
	    	}
	    }
	    catch (Exception e) {
	        System.out.println(e);
	    }
	}
	
	/*
	 * Takes in an ArrayList of type String array and concats the 
	 * string array into strings and returns the Arraylist of type String
	 */
	public ArrayList<String> returnList(ArrayList<String[]> old){
        ArrayList<String> newList = new ArrayList<String>();
	    for (int i=0; i<listSize; i++){
	        String[] sa = old.get(i); // Gets the String arrays from the Arraylist
	        String s = "";
	        
	        // Concats the array into a string and adds to the new ArrayList
	        for (int j=0; j<sa.length ; j++){
	            s = s + (sa[j]);
	        }
	        newList.add(s);
	    }
	    return newList;
	}
	
	/*
	 * This takes the file we were given in the beginning and reads it in.
	 * The first line contains the number of lines to follow, we store it 
	 * as listSize and we store those remaining lines in an ArrayList
	 */
	public void getList() throws FileNotFoundException{
		Scanner in = new Scanner(file);
		listSize = Integer.parseInt(in.nextLine());
		while(in.hasNextLine()){
			list.add(in.nextLine());
		}
	}

    /*
     * This ugly lump of code is my function to sort the given strings
     * which contain software version numbers into ascending order by
     * specific guidelines. When finished sorting the String ArrayList we
     * get a String array ArrayList which we then give to returnList to
     * give us back a String ArrayList to return.
     */
	public ArrayList<String> sort(ArrayList<String> old){
		ArrayList<String[]> newList = new ArrayList<String[]>();
		// Takes each string from ArrayList and splits on each . - and + 
		// but keeps them in the array and adds each array to the new ArrayList.
		for (int i=0; i<listSize; i++){
			String[] s = (old.get(i)).split("((?<=\\.|\\-|\\+)|(?=\\.|\\-|\\+))");
			newList.add(s);
		}
		// This loops through the new ArrayList of String arrays
		for (int i=0; i<listSize-1; i++){
		    // Checks the first number to sort base on that
		    if (Integer.parseInt((newList.get(i))[0]) > Integer.parseInt((newList.get(i+1))[0])){
		        String[] s = newList.get(i);
		        newList.set(i, newList.get(i+1));
		        newList.set(i+1, s);
		        // If a swap happens checks against previous numbers
		        for (int j=i; j>0; j--){
    		        if (Integer.parseInt((newList.get(j))[0]) < Integer.parseInt((newList.get(j-1))[0])){
	    	            String[] s2 = newList.get(j-1);
	    	            newList.set(j-1, newList.get(j));
	    	            newList.set(j, s2);
	    	        }
	    	    }
		    }
		    // If the first numbers match now checks against second number
		    else if (Integer.parseInt((newList.get(i))[0]) == Integer.parseInt((newList.get(i+1))[0])){
		        if (Integer.parseInt((newList.get(i))[2]) > Integer.parseInt((newList.get(i+1))[2])){
		            String[] s = newList.get(i);
		            newList.set(i, newList.get(i+1));
		            newList.set(i+1, s);
		            // Again if swap happens checks aginst previous numbers
		            for (int j=i; j>0; j--){
    		            if (Integer.parseInt((newList.get(j))[2]) < Integer.parseInt((newList.get(j-1))[2])){
	    	                String[] s2 = newList.get(j-1);
	    	                newList.set(j-1, newList.get(j));
	    	                newList.set(j, s2);
	    	            }
	    	        }
		        }
		        // If the second numbers match we now check against third number
		        else if (Integer.parseInt((newList.get(i))[2]) == Integer.parseInt((newList.get(i+1))[2])){
		            if (Integer.parseInt((newList.get(i))[4]) > Integer.parseInt((newList.get(i+1))[4])){
		                String[] s = newList.get(i);
        		        newList.set(i, newList.get(i+1));
		                newList.set(i+1, s);
		                // If swap happens checks aginst previous numbers
		                for (int j=i; j>0; j--){
    		                if (Integer.parseInt((newList.get(j))[4]) < Integer.parseInt((newList.get(j-1))[4])){
    		                    if (Integer.parseInt((newList.get(j))[0]) <= Integer.parseInt((newList.get(j-1))[0])){
	        	                    String[] s2 = newList.get(j-1);
        	    	                newList.set(j-1, newList.get(j));
	            	                newList.set(j, s2);
	            	            }
	            	        }
	            	    }
		            }
		            // Now if all numbers match we check for label(starts with -) and if it has label it goes 
		            // before one without. metadata(starts with +) is ignored
		            else if (Integer.parseInt((newList.get(i))[4]) == Integer.parseInt((newList.get(i+1))[4])){
		                if ((newList.get(i)[5]).equals("+") && (newList.get(i+1)[5]).equals("-")){
		                    String[] s = newList.get(i);
            		        newList.set(i, newList.get(i+1));
    		                newList.set(i+1, s);
    		            }
    		        }
		        }
		    }
		}
		return returnList(newList);
	}	
}
