// Name: Chengzhe Xue
// USC NetID: 5117556482
// CS 455 PA1
// Spring 2018


public class CoinTossSimulatorTester {

	public static void main(String[] args) {
		CoinTossSimulator toss = new CoinTossSimulator();//constructor
		
		System.out.println("After constructor:");
		System.out.println("Number of trials [exp:0]: " + toss.getNumTrials());
		System.out.println("Two-head tosses: " + toss.getTwoHeads());
		System.out.println("Two-tail tosses: " + toss.getTwoTails());
		System.out.println("One head one tail tosses: " + toss.getHeadTails());
		System.out.print("Tosses add up correctly? ");
		if (toss.getNumTrials() == toss.getTwoHeads() + toss.getTwoTails() + toss.getHeadTails()) {//determine if toss up right
			System.out.println("True");
		}
		else {
			System.out.println("False");
		}
		
		toss.run(1);
		System.out.println("After run(1):");
		System.out.println("Number of trials [exp:1]: " + toss.getNumTrials());
		System.out.println("Two-head tosses: " + toss.getTwoHeads());
		System.out.println("Two-tail tosses: " + toss.getTwoTails());
		System.out.println("One head one tail tosses: " + toss.getHeadTails());
		System.out.print("Tosses add up correctly? ");
		if (toss.getNumTrials() == toss.getTwoHeads() + toss.getTwoTails() + toss.getHeadTails()) {
			System.out.println("True");
		}
		else {
			System.out.println("False");
		}
		
		toss.run(10);
		System.out.println("After run(10):");
		System.out.println("Number of trials [exp:11]: " + toss.getNumTrials());
		System.out.println("Two-head tosses: " + toss.getTwoHeads());
		System.out.println("Two-tail tosses: " + toss.getTwoTails());
		System.out.println("One head one tail tosses: " + toss.getHeadTails());
		System.out.print("Tosses add up correctly? ");
		if (toss.getNumTrials() == toss.getTwoHeads() + toss.getTwoTails() + toss.getHeadTails()) {
			System.out.println("True");
		}
		else {
			System.out.println("False");
		}
		
		toss.run(100);
		System.out.println("After run(100):");
		System.out.println("Number of trials [exp:111]: " + toss.getNumTrials());
		System.out.println("Two-head tosses: " + toss.getTwoHeads());
		System.out.println("Two-tail tosses: " + toss.getTwoTails());
		System.out.println("One head one tail tosses: " + toss.getHeadTails());
		System.out.print("Tosses add up correctly? ");
		if (toss.getNumTrials() == toss.getTwoHeads() + toss.getTwoTails() + toss.getHeadTails()) {
			System.out.println("True");
		}
		else {
			System.out.println("False");
		}
		
		toss.run(500);//add another number 
		System.out.println("After run(1):");
		System.out.println("Number of trials [exp:611]: " + toss.getNumTrials());
		System.out.println("Two-head tosses: " + toss.getTwoHeads());
		System.out.println("Two-tail tosses: " + toss.getTwoTails());
		System.out.println("One head one tail tosses: " + toss.getHeadTails());
		System.out.print("Tosses add up correctly? ");
		if (toss.getNumTrials() == toss.getTwoHeads() + toss.getTwoTails() + toss.getHeadTails()) {
			System.out.println("True");
		}
		else {
			System.out.println("False");
		}
		
		toss.reset();//reset and start a new round
		System.out.println("After reset:");
		System.out.println("Number of trials [exp:0]: " + toss.getNumTrials());
		System.out.println("Two-head tosses: " + toss.getTwoHeads());
		System.out.println("Two-tail tosses: " + toss.getTwoTails());
		System.out.println("One head one tail tosses: " + toss.getHeadTails());
		System.out.print("Tosses add up correctly? ");
		if (toss.getNumTrials() == toss.getTwoHeads() + toss.getTwoTails() + toss.getHeadTails()) {
			System.out.println("True");
		}
		else {
			System.out.println("False");
		}
		
		toss.run(1000);
		System.out.println("After run(1000):");
		System.out.println("Number of trials [exp:1000]: " + toss.getNumTrials());
		System.out.println("Two-head tosses: " + toss.getTwoHeads());
		System.out.println("Two-tail tosses: " + toss.getTwoTails());
		System.out.println("One head one tail tosses: " + toss.getHeadTails());
		System.out.print("Tosses add up correctly? ");
		if (toss.getNumTrials() == toss.getTwoHeads() + toss.getTwoTails() + toss.getHeadTails()) {
			System.out.println("True");
		}
		else {
			System.out.println("False");
		}
	}
}
