import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class WordFinder {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String fileName = "";
		AnagramDictionary ad = null;
		
		try {
			if(args.length<1) {
				ad = new AnagramDictionary("sowpods.txt");
			}
			else {
				fileName = args[0];
				ad = new AnagramDictionary(fileName);
			}
		} 
		catch (FileNotFoundException exc) {
			System.out.println("ERROR: File not found: " + fileName);
		}
		
		System.out.println("Type . to quit.");
		System.out.print("Rack? ");
		Scanner sc =new Scanner(System.in);
		while(sc.hasNextLine()&&!sc.nextLine().contains(".")) {
			int count=0;
			ArrayList<String> allSub = new ArrayList<String>();
			String rack = sc.nextLine();
			allSub = Rack.sub(rack);
			TreeMap<Integer,ArrayList<String>> resultMap = new TreeMap<Integer, ArrayList<String>>();
			for(int j=0; j<allSub.size(); j++) {
				ArrayList<String> al = ad.getAnagramsOf(allSub.get(j));
				if (!al.isEmpty()) {
					for(int i=0; i<al.size();i++) {
						count++;
						if(resultMap.containsKey(ScoreTable.totalScore(al.get(i)))) {
							resultMap.get(ScoreTable.totalScore(al.get(i))).add(al.get(i));
						}
						else {
							ArrayList<String>arrl=new ArrayList<String>();
							arrl.add(al.get(i));
							resultMap.put(ScoreTable.totalScore(al.get(i)), arrl);
						}
					}
				}
			}
			
			System.out.println("We can make "+count+" words from \""+AnagramDictionary.sorted(rack)+"\"");
			if(count!=0) {	
				System.out.println("All of the words with their scores (sorted by score):");
			}
			while(!resultMap.isEmpty()) {
				int score = resultMap.lastKey();
				ArrayList<String> arrl = resultMap.get(score);
				String[]arr = new String[arrl.size()];
				for(int i=0; i<arrl.size(); i++) {
					arr[i]=arrl.get(i);
				}
				Arrays.sort(arr);
				for(int i=0; i<arrl.size(); i++) {
					System.out.println(score+": "+arr[i]);
				}
				resultMap.remove(score);
			}
			System.out.print("Rack? ");
		}
	}
}
