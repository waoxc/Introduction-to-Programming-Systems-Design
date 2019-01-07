// Name: Chengzhe Xue
// USC NetID: 5117556482
// CS 455 PA1
// Spring 2018

// we included the import statements for you
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

/**
 * Bar class
 * A labeled bar that can serve as a single bar in a bar graph.
 * The text for the label is centered under the bar.
 * 
 * NOTE: we have provided the public interface for this class. Do not change
 * the public interface. You can add private instance variables, constants,
 * and private methods to the class. You will also be completing the
 * implementation of the methods given.
 * 
 */
public class Bar {
	private int barbottom;
	private int barleft;
	private int barwidth;
	private int barbarHeight;
	private double barscale;
	private Color barcolor;
	private String barlabel;//initialize all variables I will use


   /**
      Creates a labeled bar.  You give the height of the bar in application
      units (e.g., population of a particular state), and then a scale for how
      tall to display it on the screen (parameter scale). 
  
      @param bottom  location of the bottom of the label
      @param left  location of the left side of the bar
      @param width  width of the bar (in pixels)
      @param barHeight  height of the bar in application units
      @param scale  how many pixels per application unit
      @param color  the color of the bar
      @param label  the label at the bottom of the bar
   */
   public Bar(int bottom, int left, int width, int barHeight,
              double scale, Color color, String label) {
	   
	   barbottom = bottom;
	   barleft = left;
	   barwidth = width;
	   barbarHeight = barHeight;
	   barscale = scale;
	   barcolor = color;
	   barlabel = label;

   }
   
   /**
      Draw the labeled bar. 
      @param g2  the graphics context
   */
   public void draw(Graphics2D g2) {
	   Font font = g2.getFont();
	   FontRenderContext context = g2.getFontRenderContext();
	   Rectangle2D labelBounds = font.getStringBounds(barlabel, context);
	   int widthOfLabel = (int) labelBounds.getWidth();//get the width of the label
	   int heightOfLabel = (int) labelBounds.getHeight();//get the height of the label
	   
	   Rectangle bar = new Rectangle(barleft, (int)(barbottom - heightOfLabel - barbarHeight*barscale), barwidth, (int)(barbarHeight*barscale));
//put the bar at the desired place by using the variables above
	   g2.setColor(barcolor);
	   g2.fill(bar);//draw and color the bar with the set color
	   g2.setColor(Color.BLACK);//always color the label with black color
	   g2.drawString(barlabel, barleft + barwidth/2 - widthOfLabel/2, barbottom);//print the label of the bar
   }
}
