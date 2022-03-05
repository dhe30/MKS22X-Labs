import java.io.*;
import java.util.*;
public class MazeGenerator{
  public static final int[][] coor = {{0,1},{0,-1},{1,0},{-1,0}};
  public static int[] fromFour(){
    // wrapper
    ArrayList<Integer> a = new ArrayList<Integer>();
    for (int i = 0; i < 4; i++){
      a.add(i);
    }
    int[] b = new int[4];
    return fromFour(a,b,0);
  }
  public static int[] fromFour(ArrayList<Integer> a, int[] b, int c){
    // returns an int array with 0-3 in a random order
    if(a.size() == 0){
      return b;
    } else {
      int r = (int)(Math.random()*a.size());
      b[c] = a.get(r);
      a.remove(r);
      return fromFour(a,b,c+1);
    }
  }
  public static void work(char[][]maze,int startrow,int startcol){
    if(startrow > 0 && startrow < maze.length - 1 && startcol > 0 && startcol < maze[0].length - 1){
      int openSpaces = 0;
      for (int i = 0; i < coor.length; i++){
        if(maze[startrow + coor[i][0]][startcol + coor[i][1]] == ' '){
          openSpaces += 1;
        }
      }
      if (openSpaces < 2){
        maze[startrow][startcol] = ' ';
        int[] row = fromFour();

        generate(maze, startrow + coor[row[0]][0], startcol + coor[row[0]][1]);
        generate(maze, startrow + coor[row[1]][0], startcol + coor[row[1]][1]);
        generate(maze, startrow + coor[row[2]][0], startcol + coor[row[2]][1]);
        generate(maze, startrow + coor[row[3]][0], startcol + coor[row[3]][1]);

      }
    }
  }
  public static void generate(char[][]maze,int startrow,int startcol){
    work(maze,startrow,startcol);
  }
  public static void main (String[] args){
    char[][] c = new char[12][12];
    for (int i = 0; i < c.length; i++){
      for (int a = 0; a < c[i].length; a++){
        c[i][a] = '#';
      }
    }
    generate(c, 6, 6);
    String ans = "";
    for (int i = 0; i < c.length; i++){
      for (int a = 0; a < c[i].length; a++){
        ans += c[i][a];
        }
        ans += "\n";
      }
      System.out.println(ans);
  }
}
