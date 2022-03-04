import java.io.*;
import java.util.*;

public class MazeGenerator{
  public static final int[][] coor = {{0,1},{0,-1},{1,0},{-1,0}};
  public static void generate(char[][]maze,int startrow,int startcol){
    if(startrow > 0 && startrow < maze.length - 1 && startcol > 0 && startcol < maze[0].length - 1){
      int openSpaces = 0;
      for (int i = 0; i < coor.length; i++){
        if(maze[startrow + coor[i][0]][startcol + coor[i][1]] == ' '){
          openSpaces += 1;
        }
      }
      if (openSpaces <= 2){
        maze[startrow][startcol] = ' ';
        int row = (int)(Math.random()*4);
        //generate(maze, startrow + coor[row][0], startcol + coor[row][1]);
        //if(maze[startrow + coor[row][0]][startcol + coor[row][1]])
        generate(maze, startrow + coor[row][0], startcol + coor[row][1]);
        if(maze[startrow + coor[row][0]][startcol + coor[row][1]] != ' '){
            maze[startrow][startcol] = '.';
        }
        // int[] maths = [3];
        // for (int i = 0; i < 4; i++){
        //   if(i == row){
        //     i--
        //   }
        // }
        // row = (int)(Math.random()*3);
        // generate(maze, startrow + coor[maths.get(row)][0], startcol + coor[maths.get(row)][1]);
        // if(maze[startrow + coor[maths.get(row)][0]][startcol + coor[maths.get(row)][1]] != ' '){
        //     maze[startrow][startcol] = '.';
        // }
      }
    }
  }
  public static void main (String[] args){
    char[][] c = new char[8][8];
    for (int i = 0; i < c.length; i++){
      System.out.println((int)(Math.random()*4));
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
