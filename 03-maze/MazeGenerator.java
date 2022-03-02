public class MazeGenerator{
  int[][] coor = {{0,1},{0,-1},{1,0},{-1,0}};
  public static void generate(char[][]maze,startrow,startcol){
    int openSpaces = 0;
    for (int i = 0; i < coor.length; i++){
      for (int a = 0; a < 2; a++){
        if(maze[startrow + coor[i][a]][startcol])
      }
    }
  }
}
