// Name: Chengzhe Xue
// USC NetID: chengzhx
// CS 455 PA3
// Spring 2018

import java.util.LinkedList;


/**
   Maze class

   Stores information about a maze and can find a path through the maze
   (if there is one).
   
   Assumptions about structure of the maze, as given in mazeData, startLoc, and endLoc
   (parameters to constructor), and the path:
     -- no outer walls given in mazeData -- search assumes there is a virtual 
        border around the maze (i.e., the maze path can't go outside of the maze
        boundaries)
     -- start location for a path is maze coordinate startLoc
     -- exit location is maze coordinate exitLoc
     -- mazeData input is a 2D array of booleans, where true means there is a wall
        at that location, and false means there isn't (see public FREE / WALL 
        constants below) 
     -- in mazeData the first index indicates the row. e.g., mazeData[row][col]
     -- only travel in 4 compass directions (no diagonal paths)
     -- can't travel through walls

 */

public class Maze {
   
   public static final boolean FREE = false;
   public static final boolean WALL = true;
   private boolean [][]maze;
   private boolean [][]mazePhantom;
   private int [][]visited;
   private int rows;
   private int cols;
   private MazeCoord startLoc;
   private MazeCoord exitLoc;
   private LinkedList<MazeCoord>path=new LinkedList<MazeCoord>();
   
   
   
   /**
      Constructs a maze.
      @param mazeData the maze to search.  See general Maze comments above for what
      goes in this array.
      @param startLoc the location in maze to start the search (not necessarily on an edge)
      @param exitLoc the "exit" location of the maze (not necessarily on an edge)
      PRE: 0 <= startLoc.getRow() < mazeData.length and 0 <= startLoc.getCol() < mazeData[0].length
         and 0 <= endLoc.getRow() < mazeData.length and 0 <= endLoc.getCol() < mazeData[0].length

    */
   public Maze(boolean[][] mazeData, MazeCoord startLoc, MazeCoord exitLoc) {
	   maze=mazeData;
	   this.startLoc=startLoc;
	   this.exitLoc=exitLoc;
	   rows=maze.length;
	   cols=maze[0].length;
	   
	   mazePhantom= new boolean[rows+2][cols+2];//create another phantom maze with one more longer in each side
	   for(int i=0;i<rows+2;i++) {
		   mazePhantom[i][0]=WALL;
		   mazePhantom[i][cols+1]=WALL;
	   }
	   for(int j=0;j<cols+2;j++) {
		   mazePhantom[0][j]=WALL;
		   mazePhantom[rows+1][j]=WALL;
	   }
	   for(int i=1;i<rows+1;i++) {
		   for(int j=1;j<cols+1;j++) {
			   mazePhantom[i][j]=maze[i-1][j-1];
		   }
	   }
	   //the border of the phantom maze is wall and the actual maze is in the border
	   visited= new int[rows+2][cols+2];//create a new 2D array to mark if particular element is visited, if visited, marked as 1, else as 0.
	   for(int i=0;i<rows+2;i++) {
		   visited[i][0]=1;
		   visited[i][cols+1]=1;
	   }
	   for(int j=0;j<cols+2;j++) {
		   visited[0][j]=1;
		   visited[rows+1][j]=1;
	   }
	   for(int i=1;i<rows+1;i++) {
		   for(int j=1;j<cols+1;j++) {
			   visited[i][j]=0;
		   }
	   }//the border of this visited array are 1(visited), the inner elements are 0 (unvisited) for now.
   }


   /**
      Returns the number of rows in the maze
      @return number of rows
   */
   public int numRows() {
      return rows;
   }

   
   /**
      Returns the number of columns in the maze
      @return number of columns
   */   
   public int numCols() {
      return cols;
   }
   
   public boolean[][] mazeData(){
	   return maze;
   }
 
   
   /**
      Returns true iff there is a wall at this location
      @param loc the location in maze coordinates
      @return whether there is a wall here
      PRE: 0 <= loc.getRow() < numRows() and 0 <= loc.getCol() < numCols()
   */
   public boolean hasWallAt(MazeCoord loc) {
	   if (maze[loc.getRow()][loc.getCol()]==WALL) {return true;}
	   else {return false;}// DUMMY CODE TO GET IT TO COMPILE
   }
   

   /**
      Returns the entry location of this maze.
    */
   public MazeCoord getEntryLoc() {
      return new MazeCoord(startLoc.getRow(),startLoc.getCol());   
   }
   
   
   /**
     Returns the exit location of this maze.
   */
   public MazeCoord getExitLoc() {
      return new MazeCoord(exitLoc.getRow(),exitLoc.getCol());   
   }

   
   /**
      Returns the path through the maze. First element is start location, and
      last element is exit location.  If there was not path, or if this is called
      before a call to search, returns empty list.

      @return the maze path
    */
   public LinkedList<MazeCoord> getPath() {

      return path;
      
   }


   /**
      Find a path from start location to the exit location (see Maze
      constructor parameters, startLoc and exitLoc) if there is one.
      Client can access the path found via getPath method.

      @return whether a path was found.
    */
   public boolean search()  {  
      
      return searchPath(startLoc.getRow(),startLoc.getCol());

   }
   
   private boolean searchPath(int r,int c) {//helper method to tell if there is a path from an coordinate(r,c) to the exit, if yes, return true.
	   
	   if(mazePhantom[r+1][c+1]==WALL) {return false;}
	   if(visited[r+1][c+1]==1) {return false;}
	   if(r==exitLoc.getRow()&&c==exitLoc.getCol()) {
		   path.add(0,new MazeCoord(r,c));
		   return true;
		   }
	   visited[r+1][c+1]=1;
	   if(searchPath(r-1,c)) {
		   path.add(0,new MazeCoord(r,c));
		   return true;
	   }
	   else if(searchPath(r+1,c)) {
		   path.add(0,new MazeCoord(r,c));
		   return true;
	   }
	   else if(searchPath(r,c-1)) {
		   path.add(0,new MazeCoord(r,c));
		   return true;
	   }
	   else if(searchPath(r,c+1)) {
		   path.add(0,new MazeCoord(r,c));
		   return true;
	   }//backtracking and recursive search the maze, if from (r,c) there is a path to the exit, add this MazeCoord into the LinkedList
   return false;
   }
}
