// Name: Chengzhe Xue
// USC NetID: 5117556482
// CS 455 PA1
// Spring 2018

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.JComponent;

public class CoinSimComponent extends JComponent{
	
	private int bottom;
	private int left1;
	private int left2;
	private int left3;
	private int width;
	private int barHeight1;
	private int barHeight2;
	private int barHeight3;
	private int numOfTrails;
	private double scale;
	private Color color1;
	private Color color2;
	private Color color3;
	private String label1;
	private String label2;
	private String label3;//initialize all the variables I will use
	private static final int BAR_WIDTH = 40;
	private static final int VERTICAL_BUFFER = 20;
	private static final int LABEL_HEIGHT = 16;
	private static final Color COLOR_OF_TWOHEADS = Color.RED ;
	private static final Color COLOR_OF_HEADTAILS = Color.GREEN ;
	private static final Color COLOR_OF_TWOTAILS = Color.BLUE;//set all constant I will use
	
	public CoinSimComponent(int numOfTrails) {
		
		this.numOfTrails =numOfTrails;
		
		CoinTossSimulator toss = new CoinTossSimulator();
		toss.run(numOfTrails);//do numOfTrails times toss trails
		
		barHeight1 = toss.getTwoHeads();//set barHeight1 with the value of the times two heads show
		barHeight2 = toss.getHeadTails();//set barHeight2 with the value of the times one head and one tail show
		barHeight3 = toss.getTwoTails();//set barHeight3 with the value of the times two tails show
		
	}
	
	public void paintComponent(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		
		int x = getWidth();
		int y = getHeight();
		
		scale = (double)(y - 2*VERTICAL_BUFFER - LABEL_HEIGHT)/numOfTrails;//the scale should be the largest possible pixels a bar can be shown divided by the largest possible times one result would occur (i.e. input trail number)
		bottom = y - VERTICAL_BUFFER;//set the y coordinate of bottom location of the bottom of the label
		int w = (x - 3*BAR_WIDTH)/4;//calculate the interval between bars and bar between window
		width = BAR_WIDTH;//set the value of bar width with a constant
		left1 = w;//set the x coordinate of left side of bar
		color1 = COLOR_OF_TWOHEADS;//set the displayed color of the bar
		label1 = "Two Heads: " + barHeight1 +" (" + Math.round((float)barHeight1*100/numOfTrails) +"%)";//print the lable and calculate the percentage of each situation
		Bar bar1 = new Bar(bottom, left1, width, barHeight1, scale, color1, label1);//create a new bar with the above parameters
		
		left2 = 2*w + width;
		color2 = COLOR_OF_HEADTAILS;
		label2 = "A Head and a Tail: " + barHeight2 +" (" + Math.round((float)barHeight2*100/numOfTrails) +"%)";
		Bar bar2 = new Bar(bottom, left2, width, barHeight2, scale, color2, label2);
		
		left3 = 3*w + 2*width;
		color3 = COLOR_OF_TWOTAILS;
		label3 = "Two Tails: " + barHeight3 +" (" + Math.round((float)barHeight3*100/numOfTrails) +"%)";
		Bar bar3 = new Bar(bottom, left3, width, barHeight3, scale, color3, label3);
		
		
		bar1.draw(g2);
		bar2.draw(g2);
		bar3.draw(g2);//draw all 3 labeled bars
	}
}
