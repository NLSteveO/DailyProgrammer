public class TipCalc{

    public static void main(String[] args) {
        if (args.length == 3) {
            if (args[0].equals("-t")) {
                double total = Double.parseDouble(args[1]);
                double percent = Double.parseDouble(args[2])/100;
                System.out.println("If you wish to tip " + percent*100 + "% on your $" + total + " bill,");
                System.out.println("you should tip $" + total*percent);
            }
            else if (args[0].equals("-p")) {
                double total = Double.parseDouble(args[1]);
                double paid = Double.parseDouble(args[2]);
                System.out.println("If your total was $" + total + " and you paid $" + paid + ",");
                System.out.println("then you tipped " + ((paid-total)/total)*100 + "%");
            }
            else if (args[0].equals("-o")) {
                double paid = Double.parseDouble(args[1]);
                double percent = Double.parseDouble(args[2]);
                System.out.println("If your total paid was $" + paid + " and you tip was " + percent + "%,");
                System.out.println("then your original total is $" + paid/((percent+100)/100));
            }
            else {
                System.out.println("Sorry you did not supply enough arguments!");
                System.out.println("Try one of the following: ");
                System.out.println("%java TipCalc -help");
                System.out.println("   ---OR---   ");
                System.out.println("%java TipCalc -option arg1 arg2");
                System.exit(1);
            }
        }
        else if (args.length == 1) {
            if (args[0].equals("-help")) {
                System.out.println("Welcome to NLSteveO's TipCalc!");
                System.out.println("This is the help screen. The following is a listing of options");
                System.out.println("to be used with the program.\n");
                System.out.println("\t-t\t%java TipCalc -p total tip-percent \n\t  \tThis option is used for calculating");
                System.out.println("\t  \t how much(dollar amount) to tip.\n");
                System.out.println("\t-p\t%java TipCalc -p total paid \n\t  \tThis option tells you what percent you tipped");
                System.out.println("\t  \tbased off your total before tip and total paid\n");
                System.out.println("\t-help\tDisplays this help screen.\n");
            }
            else {
                System.out.println("Sorry you did not supply enough arguments!");
                System.out.println("Try one of the following: ");
                System.out.println("%java TipCalc -help");
                System.out.println("   ---OR---   ");
                System.out.println("%java TipCalc -option arg1 arg2");
                System.exit(1);
            }
        }
        else {
            System.out.println("Sorry you did not supply enough arguments!");
            System.out.println("Try one of the following: ");
            System.out.println("%java TipCalc -help");
            System.out.println("   ---OR---   ");
            System.out.println("%java TipCalc -option arg1 arg2");
            System.exit(1);
        }
    }
}
