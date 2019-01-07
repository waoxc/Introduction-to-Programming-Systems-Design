// Name: Chengzhe Xue
// USC NetID: chengzhx
// CS 455 PA3
// Spring 2018


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFrame;


/**
 * MazeViewer class
 * 
 * Program to read in and display a maze and a path through the maze. At user
 * command displays a path through the maze if there is one.
 * 
 * How to call it from the command line:
 * 
 *      java MazeViewer mazeFile
 * 
 * where mazeFile is a text file of the maze. The format is the number of rows
 * and number of columns, followed by one line per row, followed by the start location, 
 * and ending with the exit location. Each maze location is
 * either a wall (1) or free (0). Here is an example of contents of a file for
 * a 3x4 maze, with start location as the top left, and exit location as the bottom right
 * (we count locations from 0, similar to Java arrays):
 * 
 * 3 4 
 * 0111
 * 0000
 * 1110
 * 0 0
 * 2 3
 * 
 */

public class MazeViewer {
   
   private static final char WALL_CHAR = '1';
   private static final char FREE_CHAR = '0';
   private static boolean[][] data;

   public static void main(String[] args)  {

      String fileName = "";

      try {

         if (args.length < 1) {
            System.out.println("ERROR: missing file name command line argument");
         }
         else {
            fileName = args[0];
            
            JFrame frame = readMazeFile(fileName);

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.setVisible(true);
         }

      }
      catch (FileNotFoundException exc) {
         System.out.println("ERROR: File not found: " + fileName);
      }
      catch (IOException exc) {
         exc.printStackTrace();
      }
   }

   /**
    readMazeFile reads in maze from the file whose name is given and 
    returns a MazeFrame created from it.
   
   @param fileName
             the name of a file to read from (file format shown in class comments, above)
   @returns a MazeFrame containing the data from the file.
        
   @throws FileNotFoundException
              if there's no such file (subclass of IOException)
   @throws IOException
              (hook given in case you want to do more error-checking --
               that would also involve changing main to catch other exceptions)
   */
   private static MazeFrame readMazeFile(String fileName) throws IOException {
      
	   File inFile = new File(fileName);
	   Scanner in = new Scanner(inFile);
	   int rows = in.nextInt();//read the first int as the row of the array
	   int cols = in.nextInt();//read the second int as the column of the array
	   data=new boolean[rows][cols];
	   for(int i=0;i<rows;i++) {
		   String s=in.next();
		   for(int j=0;j<cols;j++) {
			   data[i][j]=s.charAt(j)==WALL_CHAR;
		   }
	   }//the elemnt is true if the input is '1', false if the input is '0'
	   return new MazeFrame(data,new MazeCoord(in.nextInt(),in.nextInt()),new MazeCoord(in.nextInt(),in.nextInt()));
   }//the read the last four elements as the MazeCoord of entry and exit

}
