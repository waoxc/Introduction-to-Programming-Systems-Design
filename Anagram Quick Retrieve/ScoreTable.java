
public class ScoreTable {
	public static int[]score=new int[26];
	public static final int SCORE1 = 1;
	public static final int SCORE2 = 2;
	public static final int SCORE3 = 3;
	public static final int SCORE4 = 4;
	public static final int SCORE5 = 5;
	public static final int SCORE6 = 8;
	public static final int SCORE7 = 10;
	
	public static int scoreOf(char c) {
		score['a'-'a']=SCORE1;
		score['e'-'a']=SCORE1;
		score['i'-'a']=SCORE1;
		score['o'-'a']=SCORE1;
		score['u'-'a']=SCORE1;
		score['l'-'a']=SCORE1;
		score['n'-'a']=SCORE1;
		score['s'-'a']=SCORE1;
		score['t'-'a']=SCORE1;
		score['r'-'a']=SCORE1;
		score['d'-'a']=SCORE2;
		score['g'-'a']=SCORE2;
		score['b'-'a']=SCORE3;
		score['c'-'a']=SCORE3;
		score['m'-'a']=SCORE3;
		score['p'-'a']=SCORE3;
		score['f'-'a']=SCORE4;
		score['h'-'a']=SCORE4;
		score['v'-'a']=SCORE4;
		score['w'-'a']=SCORE4;
		score['y'-'a']=SCORE4;
		score['k'-'a']=SCORE5;
		score['j'-'a']=SCORE6;
		score['x'-'a']=SCORE6;
		score['q'-'a']=SCORE7;
		score['z'-'a']=SCORE7;
		
		if(Character.isUpperCase(c)) {
			return score[Character.toLowerCase(c)-'a'];
		}
		else return score[c-'a'];
	}
	public static int totalScore(String s) {
		int total=0;
		for(int i=0; i<s.length(); i++) {
			total+=scoreOf(s.charAt(i));
		}
		return total;
	}
	
	
	
}
 