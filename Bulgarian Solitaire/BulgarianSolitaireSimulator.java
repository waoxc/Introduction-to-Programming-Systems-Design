// Name: Chengzhe Xue 
// USC NetID: chengzhx
// CSCI455 PA2
// Spring 2018

import java.util.ArrayList;
import java.util.Scanner;

/**
   <add main program comment here>
   This simulator has 4 possible modes:
   for random mode, the simulator will generate random initial piles;
   for user configuration mode, the user input initial piles and the error check is included;
   for single-step mode, the simulator stops after each round until user press "return" to next round;
   for automatic mode, the simulator will play rounds automatically until this game is done.
   To simplify and shorten codes in main method, I create several private static void methods in the end.
   
 */

public class BulgarianSolitaireSimulator {

   public static void main(String[] args) {
     
      boolean singleStep = false;
      boolean userConfig = false;

      for (int i = 0; i < args.length; i++) {
         if (args[i].equals("-u")) {
            userConfig = true;
         }
         else if (args[i].equals("-s")) {
            singleStep = true;
         }
      }

      if (!userConfig) {//default random mode
    	  	SolitaireBoard random = new SolitaireBoard();
    	  	initialCon(random);//print initial configuration
    	  	if(!singleStep) {//default automatic mode
    	  		autoMode(random);//run automatic mode
    	  	}
    	  	else {//single step mode
    	  		singleStepMode(random);//run single step mode
    	  	}
    	  }
      
      else {//user configuration mode
    	  	ArrayList<Integer>userInput = new ArrayList<Integer>();
    	  	startInput();//print "Number of total ..." "You will be ..."
    	  	enterIntegers();//print "Please enter a ..."
    	  	read(userInput);//read the user input
    	  	while(!isValidInput(userInput)) {//if not valid, prompt enter integers again
    	  		userInput.clear();//before another round of input, clear the last input before
    	  		error();//print "ERROR: Each pile ..."
    	  		enterIntegers();
    	  		read(userInput);
    	  	}
    	  	
    	  	SolitaireBoard userMode = new SolitaireBoard (userInput);
    	  	initialCon(userMode);
    	  	if(!singleStep) {
    	  		autoMode(userMode);
    	  	}
    	  	else {
    	  		singleStepMode(userMode);
    	  	}	
      }
    	  
      
   }
   
    // <add private static methods here>
      
   
   
   private static boolean isValidInput(ArrayList<Integer>check) {
	   
	   boolean greaterThan0=true;
	   int sum=0;
	   
	   for(int i=0; i<check.size(); i++) {
		   greaterThan0 = greaterThan0 && (check.get(i)>0);
		   sum = sum + check.get(i);   
	   }
	   
	   return (sum==45)&&greaterThan0;
   }
   // return true iff the sum of non-empty piles is 45 and each non-empty pile is greater than 0, as the before "Representation invariant" part says
   
   private static void read(ArrayList<Integer>piles) {
	   
	   Scanner in = new Scanner(System.in);
	   String line = in.nextLine();
	   Scanner linescanner = new Scanner(line);//read all numbers in a line
	   
	   while(linescanner.hasNextInt()) {
	   
		   piles.add(linescanner.nextInt());
		   
	   }
   }
   //read the input numbers in a line
   
   private static void singleStepMode(SolitaireBoard single) {
	   for(int i=1; !single.isDone(); i++) {//stop when it is done
		   single.playRound();//play one round of the game
		   System.out.println("["+i+"]"+"Current configuration: "+single.configString());
		   System.out.print("<Type return to continue>");
 		   Scanner scanner = new Scanner(System.in);
 		   scanner.nextLine();//press return to continue
 		}
 		System.out.println("Done!");
   }
   //how single mode works, give a SolitaireBoard class, output each round of the game(continue by press return) till the end
   
   private static void autoMode(SolitaireBoard auto) {
	   for(int i=1; !auto.isDone(); i++) {
		   auto.playRound();
		   System.out.println("["+i+"]"+"Current configuration: "+auto.configString());
 		}
 		System.out.println("Done!");
   }
   //how automatic mode works, give a SolitaireBoard class, automatically output each round of the game till the end
   
   private static void initialCon(SolitaireBoard initial) {
	   System.out.print("Initial configuration: ");
	   System.out.println(initial.configString());
   }
   
   private static void startInput() {
	   System.out.println("Number of total cards is "+ SolitaireBoard.CARD_TOTAL);
	   System.out.println("You will be entering the initial configuration of the cards (i.e., how many in each pile).");
   }
   
   private static void enterIntegers() {
	   System.out.println("Please enter a space-separated list of positive integers followed by newline:");
   }
   
   private static void error() {
	   System.out.println("ERROR: Each pile must have at least one card and the total number of cards must be 45");
   }
   //simple print method, simplify and shorten the codes
}
