
public class MazeTester {
	
	public static void main(String args[]) {
		boolean[][]t1={{false,true,true},{false,false,false},{true,true,false}};
		Maze maze1=new Maze(t1,new MazeCoord(0,0),new MazeCoord(0,0));
		System.out.println(maze1.search());
		System.out.println(maze1.getPath());
	}

}
