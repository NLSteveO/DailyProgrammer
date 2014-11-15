public class VersionSortTester{

    /* 
     * Main class checks to make sure it takes 
     * in argument containing input file and 
     * gives it to the Version Sort class.
     */
	public static void main(String[] args){
		if (args[0] != null){
		    VersionSort sort = new VersionSort(args[0]);
		}
		else {
		    System.out.println("Sorry but you must provide a file.");
		    System.out.println("%java VersionSort filename");
		    System.exit(1);
		}
	}
}
