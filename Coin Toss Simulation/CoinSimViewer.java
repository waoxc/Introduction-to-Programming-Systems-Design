// Name: Chengzhe Xue
// USC NetID: 5117556482
// CS 455 PA1
// Spring 2018

import java.util.Scanner;
import javax.swing.JFrame;

public class CoinSimViewer {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("How many trails do you want to simulate?");
		int numOfTrails = in.nextInt();
		
		while(numOfTrails <=0) {//error checking: if input<=0, error, until get a right int number
			System.out.println("ERROR: Number entered must be greater than 0.");
			System.out.println();
			System.out.println("How many trails do you want to simulate?");
			numOfTrails = in.nextInt();
		}
		
		JFrame frame = new JFrame();//create a new frame
		
		frame.setSize(800, 500);//set the frame size with width of 800 pixels and height of 500 pixels
		frame.setTitle("Coin Sim");//the title of the frame is "Coin Sim"
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		CoinSimComponent component = new CoinSimComponent(numOfTrails);//create a component doing numOfTrails times toss trails
		frame.add(component);//add all 3 labeled bars into the frame
		
		frame.setVisible(true);
	}
}
