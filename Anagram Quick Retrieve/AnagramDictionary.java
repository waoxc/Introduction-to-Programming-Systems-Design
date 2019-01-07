// Name: 
// USC NetID: 
// CS 455 PA4
// Spring 2018

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Scanner;


/**
 * A dictionary of all anagram sets. 
 * Note: the processing is case-sensitive; so if the dictionary has all lower
 * case words, you will likely want any string you test to have all lower case
 * letters too, and likewise if the dictionary words are all upper case.
 */

public class AnagramDictionary {
	
	Hashtable<String, ArrayList<String>> anaDic = new Hashtable<String, ArrayList<String>>();
	
   /**
    * Create an anagram dictionary from the list of words given in the file
    * indicated by fileName.  
    * PRE: The strings in the file are unique.
    * @param fileName  the name of the file to read from
    * @throws FileNotFoundException  if the file is not found
    */
   public AnagramDictionary(String fileName) throws FileNotFoundException {
	   File inFile = new File(fileName);
	   Scanner in = new Scanner(inFile);
	   while(in.hasNext()) {
		   String s = in.next();
		   String sorted = sorted(s);
		   if(anaDic.keySet().contains(sorted)) {
			   anaDic.get(sorted).add(s);
		   }
		   else {
			   ArrayList<String>arrl=new ArrayList<String>();
			   arrl.add(s);
			   anaDic.put(sorted, arrl);
		   }
	   }
   }
   

   /**
    * Get all anagrams of the given string. This method is case-sensitive.
    * E.g. "CARE" and "race" would not be recognized as anagrams.
    * @param s string to process
    * @return a list of the anagrams of s
    * 
    */
   public ArrayList<String> getAnagramsOf(String s) {
       if(anaDic.keySet().contains(sorted(s))) {return anaDic.get(sorted(s));}
       else return new ArrayList<String>();
   }
   
   public static String sorted(String s) {
	   int length = s.length();
	   String sorted="";
	   char[]c = new char[length];
	   for(int i=0; i<length; i++) {
		   c[i] = s.charAt(i); 
	   }
	   Arrays.sort(c);
	   for(int i=0; i<length; i++) {
		   sorted = sorted + c[i];
	   }
	   return sorted;
   }
}
