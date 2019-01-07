import java.util.ArrayList;

public class SBTester {

	public static void main(String[] args) {
		ArrayList<Integer>arrl=new ArrayList<Integer>();
		SolitaireBoard sb = new SolitaireBoard(arrl);
		sb.playRound();
		System.out.println(sb.configString());
		System.out.println(sb.isDone());
		
		// TODO Auto-generated method stub

	}

}
