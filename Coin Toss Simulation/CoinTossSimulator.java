// Name: Chengzhe Xue
// USC NetID: 5117556482
// CS 455 PA1
// Spring 2018

import java.util.Random;

/**
 * class CoinTossSimulator
 * 
 * Simulates trials of repeatedly tossing two coins and allows the user to access the
 * cumulative results.
 * 
 * NOTE: we have provided the public interface for this class.  Do not change
 * the public interface.  You can add private instance variables, constants, 
 * and private methods to the class.  You will also be completing the 
 * implementation of the methods given. 
 * 
 * Invariant: getNumTrials() = getTwoHeads() + getTwoTails() + getHeadTails()
 * 
 */

public class CoinTossSimulator {
	private Random generator;
	private int coin1; 
	private int coin2;
	private int twoheads;
	private int twotails;
	private int headtails;
	private int totalTrials;


   /**
      Creates a coin toss simulator with no trials done yet.
   */
   public CoinTossSimulator() {
	   totalTrials = 0;
	   twoheads = 0;
	   twotails = 0;
	   headtails = 0;
	   coin1 = 0;
	   coin2 = 0;//initialize all parameter to 0 if no trials start
	   generator = new Random();//constructor
   }


   /**
      Runs the simulation for numTrials more trials. Multiple calls to this method
      without a reset() between them *add* these trials to the current simulation.
      
      @param numTrials  number of trials to for simulation; must be >= 1
    */
   public void run(int numTrials) {
		   totalTrials = totalTrials + numTrials;//add these trials together
		   for (int i = 1;i <= numTrials;i++) {// for loop, toss 2 coins for totalTrials times
			   coin1 = 1 + generator.nextInt(2);
			   coin2 = 1 + generator.nextInt(2);
			   if (coin1 == 1 && coin2 == 1) {// number 1 means head and number 2 means tail
				   twoheads++;//value of twoheads plus 1 if the result is two-head
			   }
			   else if (coin1 == 2 && coin2 == 2) {
				   twotails++;//value of twotails plus 1 if the result is two-tail
			   }
			   else {
				   headtails++;//value of headtails plus 1 if the result is neither two-head nor two-tail, i.e. head-tail
			   }
		   }
   }


   /**
      Get number of trials performed since last reset.
   */
   public int getNumTrials() {
       return totalTrials; 
   }


   /**
      Get number of trials that came up two heads since last reset.
   */
   public int getTwoHeads() {
       return twoheads; 
   }


   /**
     Get number of trials that came up two tails since last reset.
   */  
   public int getTwoTails() {
       return twotails; 
   }


   /**
     Get number of trials that came up one head and one tail since last reset.
   */
   public int getHeadTails() {
       return headtails; 
   }


   /**
      Resets the simulation, so that subsequent runs start from 0 trials done.
    */
   public void reset() {
	   totalTrials = 0;
	   coin1 = 0;
	   coin2 = 0;
	   twoheads = 0;
	   twotails = 0;
	   headtails = 0;//reset all parameters to 0 and wait for another new input
   }

}
