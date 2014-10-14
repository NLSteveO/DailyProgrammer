import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class VersionSort{

	public static void main(String[] args){
		if (args[0] != null){
		    Sorter sort = new Sorter(args[0]);
		}
		else {
		    System.out.println("Sorry but you must provide a file.");
		    System.out.println("%java VersionSort filename");
		    System.exit(1);
		}
	}
}	
class Sorter{	
	
	private File file;
	private int listSize;
	private ArrayList<String> list = new ArrayList<String>();

	public Sorter(String s){
	    try {
    		file = new File(s);
	    	getList();
	    	for (int i=0; i<listSize; i++){
	    	    System.out.println(list.get(i));
	    	}
	    	list = returnList(sort(list));
	    	for (int i=0; i<listSize; i++){
	    	    System.out.println(list.get(i));
	    	}
	    }
	    catch (Exception e) {
	        System.out.println(e);
	    }
	}
	
	public ArrayList<String> returnList(ArrayList<String[]> old){
        ArrayList<String> list = new ArrayList<String>();
        /*for (int i=0; i<listSize; i++){
	        String[] sa = old.get(i);
            for (String s : sa){
	    	    System.out.print(s);
	    	}
	    	System.out.println();
	    }*/
	    for (int i=0; i<listSize; i++){
	        String[] sa = old.get(i);
	        String s = "";
	        for (String sp : sa){
	            s.concat(sp);
	        }
	        System.out.println(s);
	        list.add(s);
	    }
	    return list;
	}
	
	public void getList() throws FileNotFoundException{
		Scanner in = new Scanner(file);
		listSize = Integer.parseInt(in.nextLine());
		while(in.hasNextLine()){
			list.add(in.nextLine());
		}
	}

	public ArrayList<String[]> sort(ArrayList<String> old){
		ArrayList<String[]> newList = new ArrayList<String[]>();
		for (int i=0; i<listSize; i++){
			String[] s = (old.get(i)).split("\\.|\\-|\\+");
			newList.add(s);
		}
		for (int i=0; i<listSize-1; i++){
		    if (Integer.parseInt((newList.get(i))[0]) > Integer.parseInt((newList.get(i+1))[0])){
		        String[] s = newList.get(i);
		        newList.add(i, newList.get(i+1));
		        newList.add(i+1, s);
		    }
		    else if (Integer.parseInt((newList.get(i))[0]) == Integer.parseInt((newList.get(i+1))[0])){
		        if (Integer.parseInt((newList.get(i))[1]) > Integer.parseInt((newList.get(i+1))[1])){
		            String[] s = newList.get(i);
		            newList.add(i, newList.get(i+1));
		            newList.add(i+1, s);
		        }
		        else if (Integer.parseInt((newList.get(i))[1]) == Integer.parseInt((newList.get(i+1))[1])){
		            if (Integer.parseInt((newList.get(i))[2]) > Integer.parseInt((newList.get(i+1))[2])){
		                String[] s = newList.get(i);
        		        newList.add(i, newList.get(i+1));
		                newList.add(i+1, s);
		            }
		        }
		    }
		}
		return newList;
	}	
}
