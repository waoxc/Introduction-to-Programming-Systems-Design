// Name: Chengzhe Xue
// USC NetID: chengzhx
// CS 455 PA3
// Spring 2018

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.util.LinkedList;
import javax.swing.JComponent;

/**
   MazeComponent class
   
   A component that displays the maze and path through it if one has been found.
*/
public class MazeComponent extends JComponent
{

   private static final int START_X = 10; // top left of corner of maze in frame
   private static final int START_Y = 10;
   private static final int BOX_WIDTH = 20;  // width and height of one maze "location"
   private static final int BOX_HEIGHT = 20;
   private static final int INSET = 2;
                    // how much smaller on each side to make entry/exit inner box
   private boolean[][]mazeData;
   private MazeCoord entry;
   private MazeCoord exit;
   private Maze maze;
   private LinkedList<MazeCoord> path=new LinkedList<MazeCoord>();
   

   
   /**
      Constructs the component.
      @param maze   the maze to display
   */
   public MazeComponent(Maze maze)
   {
	   this.maze=maze;
	   mazeData=maze.mazeData();
	   entry=maze.getEntryLoc();
	   exit=maze.getExitLoc();
	   
   }

   
   /**
     Draws the current state of maze including the path through it if one has
     been found.
     @param g the graphics context
   */
   public void paintComponent(Graphics g)
   {
	   Graphics2D g2 = (Graphics2D) g;
	   Rectangle border = new Rectangle(START_X,START_Y,mazeData[0].length*BOX_WIDTH,mazeData.length*BOX_HEIGHT);
	   g2.setColor(Color.BLACK);
	   g2.draw(border);//draw the black border of the given maze
	   for(int i=0;i<mazeData.length;i++) {
		   for(int j=0;j<mazeData[0].length;j++) {
			   Rectangle box = new Rectangle(START_X+j*BOX_WIDTH,START_Y+i*BOX_HEIGHT,BOX_WIDTH,BOX_HEIGHT);
			   if(mazeData[i][j]) {g2.setColor(Color.BLACK);}
			   else {g2.setColor(Color.WHITE);}
			   g2.fill(box);
		   }
	   }//draw each element in the 2D array, if true, fill black, if false, fill white
	   g2.setColor(Color.YELLOW);
	   Rectangle recEntry=new Rectangle(START_X+entry.getCol()*BOX_WIDTH+INSET,START_Y+entry.getRow()*BOX_HEIGHT+INSET,BOX_WIDTH-2*INSET,BOX_HEIGHT-2*INSET);
	   g2.fill(recEntry);//draw the entry of the maze
	   
	   g2.setColor(Color.GREEN);
	   Rectangle recExit=new Rectangle(START_X+exit.getCol()*BOX_WIDTH+INSET,START_Y+exit.getRow()*BOX_HEIGHT+INSET,BOX_WIDTH-2*INSET,BOX_HEIGHT-2*INSET);
	   g2.fill(recExit);//draw the exit of the maze
	   
	   path=new LinkedList<MazeCoord>(maze.getPath());
	   g2.setColor(Color.BLUE);
	   for(int i=0;i<path.size()-1;i++) {
		   Line2D.Double segment=new Line2D.Double(START_X+(path.get(i).getCol())*BOX_WIDTH+BOX_WIDTH/2,START_X+(path.get(i).getRow())*BOX_HEIGHT+BOX_HEIGHT/2,START_X+(path.get(i+1).getCol())*BOX_WIDTH+BOX_WIDTH/2,START_X+(path.get(i+1).getRow())*BOX_HEIGHT+BOX_HEIGHT/2);
		   g2.draw(segment); 
	   }//draw the final path one by one, from the first coordinate to the last coordinate in the LinkedList
	   
   }
}



