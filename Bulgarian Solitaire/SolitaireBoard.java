// Name: Chengzhe Xue
// USC NetID: chengzhx
// CSCI455 PA2
// Spring 2018

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

 /*
   class SolitaireBoard
   The board for Bulgarian Solitaire. You can change what the total number of cards is for the game
   by changing NUM_FINAL_PILES, below.  Don't change CARD_TOTAL directly, because there are only some values
   for CARD_TOTAL that result in a game that terminates.
   (See comments below next to named constant declarations for more details on this.)
 */


public class SolitaireBoard {
   
   public static final int NUM_FINAL_PILES = 9;
   // number of piles in a final configuration
   // (note: if NUM_FINAL_PILES is 9, then CARD_TOTAL below will be 45)
   
   public static final int CARD_TOTAL = NUM_FINAL_PILES * (NUM_FINAL_PILES + 1) / 2;
   // bulgarian solitaire only terminates if CARD_TOTAL is a triangular number.
   // see: http://en.wikipedia.org/wiki/Bulgarian_solitaire for more details
   // the above formula is the closed form for 1 + 2 + 3 + . . . + NUM_FINAL_PILES

    // Note to students: you may not use an ArrayList -- see assgt description for details.
   
   
   /**
      Representation invariant:
      
      <put rep. invar. comment here>
      
      1. for 0<= i<= numOfPiles-1, card[i]>0;
      2. card[1] + card[2] + card[3] + ... + card[numOfPiles-1] = 45;

    */
   
   int card[] = new int [CARD_TOTAL+1];
   int numOfPiles;
    /* 
    * two instance variables are add here;
    * card[] is the list to store card number of each pile;
    * e.g. card[i]=j, which means the (i+1)th pile has the card number of j;
    * here the array length is (CARD_TOTAL+1) because for the most situation, which is the input is 
    45 ones, we take one card from each pile and put them at the 46th pile, than remove the first 45 empty piles;
    * numOfPiles is the real-time number of non-empty piles.
   */
 
   /**
     Creates a solitaire board with the configuration specified in piles.
     piles has the number of cards in the first pile, then the number of cards in the second pile, etc.
     PRE: piles contains a sequence of positive numbers that sum to SolitaireBoard.CARD_TOTAL
   */
   public SolitaireBoard(ArrayList<Integer> piles) {
	   
	   numOfPiles = piles.size();//numOfPiles is the size of the arraylist
	   
	   for (int i=0; i<numOfPiles; i++) {
		   card[i]=piles.get(i);
	   }//copy each number from ArrayList to an array
	   
	   assert isValidSolitaireBoard();
   }
 
   
   /**
      Creates a solitaire board with a random initial configuration.
   */
   public SolitaireBoard() {
	   
	   ArrayList<Integer>ran= new ArrayList<Integer>();
	   Random generator = new Random();
	   int remaining = CARD_TOTAL;
	   
	   while(remaining!=0) {
		   
		   int r = generator.nextInt(remaining)+1;
		   ran.add(r);
		   remaining = remaining - r;
	   
	   }//generate a random initial configuration
	   
	   numOfPiles = ran.size();//numOfPile is the size of the ArrayList
	   
	   for (int i=0; i<numOfPiles; i++) {
		   card[i]=ran.get(i);
	   }//copy each number from ArrayList to an array
	   
	   assert isValidSolitaireBoard();
   }
  
   
   /**
      Plays one round of Bulgarian solitaire.  Updates the configuration according to the rules
      of Bulgarian solitaire: Takes one card from each pile, and puts them all together in a new pile.
      The old piles that are left will be in the same relative order as before, 
      and the new pile will be at the end.
    */
   public void playRound() {
	   
	   for(int i=0; i<numOfPiles; i++) {
		   card[i]--;
	   }//take one card from each non-empty pile
	   card[numOfPiles]= numOfPiles;//put the taken cards to the end of array
	   numOfPiles++;
	   //the number of non-empty pile increase 1 
	   //now has not considered the newly-becoming-empty piles (i.e. those piles from 1 to 0)
	   
	   for (int i=0; i<numOfPiles; i++){
		   if (card[i]==0) {
			   remove(i);
			   numOfPiles--;//consider the newly-becoming-empty piles, every time remove, numOfPiles decrease 1 
			   i--;
			   //every time remove, all of the value after card[i] move forward, 
			   //we need to start a new loop at card[i] again because this is actually the former card[i+1], 
			   //so by doing i--, we maintain the i value unchanged
		   }
	   }
	   //remove the newly-becoming-empty piles;
	   //to do this, I create a private method at the end of this code;
	   //remove all the piles with the value of 0 (empty);
	   //move the new non-empty pile at the end forward until all empty piles are eliminated;
	   
	   assert isValidSolitaireBoard(); 
	   
   }
   
   /**
      Returns true iff the current board is at the end of the game.  That is, there are NUM_FINAL_PILES
      piles that are of sizes 1, 2, 3, . . . , NUM_FINAL_PILES, in any order.
    */
   
   public boolean isDone() {
	   
	   boolean flag = true;
	   for(int i=1; i<=NUM_FINAL_PILES; i++) {
		   flag= flag&&lookup(i);
	   }
	   assert isValidSolitaireBoard(); 
	   
       return flag;
       //I create a private method lookup(i) to see if value i is in the array;
       //iff 1 to 9 are all found, this method would return true
   }

   
   /**
      Returns current board configuration as a string with the format of
      a space-separated list of numbers with no leading or trailing spaces.
      The numbers represent the number of cards in each non-empty pile.
    */
   public String configString() {
	   String numOfEach = new String();
	   numOfEach = String.valueOf(card[0]);//transfer card[0] to String and put it at the first of String numOfEach
	   for(int i=1; i<numOfPiles; i++) {
		   numOfEach = numOfEach + " " + String.valueOf(card[i]);//transfer the rest into String and put them into numOfEach with a space separating them
	   }
	   return numOfEach;
   }
   
   
   /**
      Returns true iff the solitaire board data is in a valid state
      (See representation invariant comment for more details.)
    */
   private boolean isValidSolitaireBoard() {
	   
	   boolean greaterThan0=true;
	   int sum=0;
	   
	   for(int i=0; i<numOfPiles; i++) {
		   greaterThan0 = greaterThan0 && (card[i]>0);
		   sum = sum + card[i];   
	   }
	   
	   return (sum==45)&&greaterThan0;
	   // return true iff the sum of non-empty piles is 45 and each non-empty pile is greater than 0, as the before "Representation invariant" part says
   }
   

    // <add any additional private methods here>
   private void remove(int target) {
	   
	   for (int i=target; i<card.length-1; i++) {
		   card[i]=card[i+1];
	   }
	   card[card.length-1]=0;
   }
   //remove the (target+1)th element and move the remaining elements forward by 1, the end of the array is still 0
   
   private boolean lookup(int target) {
	   for (int i=0; i<card.length; i++) {
		   if(card[i]==target) {
			   return true;
		   }
	   }
	   return false;
   }
   //lookup the value target to see if target is in the array, if yes, return true; if no, return false
}
