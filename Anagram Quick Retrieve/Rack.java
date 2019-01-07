// Name: 
// USC NetID: 
// CS 455 PA4
// Spring 2018

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;


/**
 * A Rack of Scrabble tiles
 */

public class Rack {
	
	String rack;
	
	public Rack(String rack) {
		this.rack=rack;
	}
	
	public static ArrayList<String>sub(String s){
		TreeMap<Character, Integer>map = new TreeMap<Character, Integer>();
		for(int i=0; i<s.length(); i++) {
			char letter = s.charAt(i);
			if(map.containsKey(letter)) {
				int count = map.get(letter);
				map.put(letter, count+1);
			}
			else {
				map.put(letter, 1);
			}
		}
		ArrayList<Character>alc=new ArrayList<Character>();
		ArrayList<Integer>ali=new ArrayList<Integer>();
		
		for(Map.Entry<Character, Integer> entry : map.entrySet()) {
			alc.add(entry.getKey());
			ali.add(entry.getValue());
		}
		
		String unique="";
		int[] mult= new int[map.size()];
		for(int i=0; i<map.size(); i++) {
			unique+=alc.get(i);
			mult[i]=ali.get(i);
		}
		return allSubsets(unique, mult, 0);
	}
	
   /**
    * Finds all subsets of the multiset starting at position k in unique and mult.
    * unique and mult describe a multiset such that mult[i] is the multiplicity of the char
    *      unique.charAt(i).
    * PRE: mult.length must be at least as big as unique.length()
    *      0 <= k <= unique.length()
    * @param unique a string of unique letters
    * @param mult the multiplicity of each letter from unique.  
    * @param k the smallest index of unique and mult to consider.
    * @return all subsets of the indicated multiset
    * @author Claire Bono
    */
   private static ArrayList<String> allSubsets(String unique, int[] mult, int k) {
      ArrayList<String> allCombos = new ArrayList<>();
      
      if (k == unique.length()) {  // multiset is empty
         allCombos.add("");
         return allCombos;
      }
      
      // get all subsets of the multiset without the first unique char
      ArrayList<String> restCombos = allSubsets(unique, mult, k+1);
      
      // prepend all possible numbers of the first char (i.e., the one at position k) 
      // to the front of each string in restCombos.  Suppose that char is 'a'...
      
      String firstPart = "";          // in outer loop firstPart takes on the values: "", "a", "aa", ...
      for (int n = 0; n <= mult[k]; n++) {   
         for (int i = 0; i < restCombos.size(); i++) {  // for each of the subsets 
                                                        // we found in the recursive call
            // create and add a new string with n 'a's in front of that subset
            allCombos.add(firstPart + restCombos.get(i));  
         }
         firstPart += unique.charAt(k);  // append another instance of 'a' to the first part
      }
      
      return allCombos;
   }

}
