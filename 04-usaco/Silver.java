import java.util.*;
import java.io.*;
public class Silver{
  public static final int[][] coor = {{1,0},{-1,0},{0,1},{0,-1}};
  public static long[][] copy(long[][] a){
    long[][] ans = new long[a.length][a[0].length];
    for (int i = 0; i < a.length; i++){
      for (int c = 0; c < a[i].length; c++){
        ans[i][c] = a[i][c];
      }
    }
    return ans;
  }
  // public static void dug(int[][] a, int startRow, int startCol, int max){
  //   if (startRow >= 0 && startRow < a.length && startCol >= 0 && startCol < a[0].length){
  //     if(max == 0){
  //       a[startRow][startCol] += 1;
  //     } else {
  //
  //       dug(a, startRow - 1, startCol, max - 1);
  //       dug(a, startRow, startCol - 1, max - 1);
  //       dug(a, startRow + 1, startCol, max - 1);
  //       dug(a, startRow, startCol + 1, max - 1);
  //     }
  //   }
  public static long solve(String filename) throws FileNotFoundException{
    File file = new File(filename);
    Scanner input = new Scanner(file);
    int rows = input.nextInt();
    int cols = input.nextInt();
    int time = input.nextInt();
    char[][] findTrees = new char[rows][];
    for (int i = 0; i < rows; i++){
      findTrees[i] = input.next().toCharArray();
    }
    long[][] field = new long[rows][cols];
    for (int i = 0; i < rows; i++){
      for (int a = 0; a < cols; a++){
        if(findTrees[i][a] == '*'){
          field[i][a] = -1l;
        }
      }
    }

    long[][] ref = copy(field);
    long[][] touch = copy(field);
    ref[input.nextInt() - 1][input.nextInt() - 1] = 1l;
    for (int i = 0; i < time; i++){
      for (int row = 0; row < rows; row++){
        for (int col = 0; col < cols; col++){
          if (ref[row][col] == 0l){
            for (int a = 0; a < coor.length; a++){
              if(row + coor[a][0] >= 0 && row + coor[a][0] < field.length && col + coor[a][1] >= 0 && col + coor[a][1] < field[0].length){
                if(ref[row + coor[a][0]][col + coor[a][1]] > 0l){
                  touch[row][col] += ref[row + coor[a][0]][col + coor[a][1]];
                }
              }
            }
          }
        }
      }
      ref = copy(touch);
      touch = copy(field);
    }
    long ans = ref[input.nextInt() - 1][input.nextInt() - 1];
    // String ans = "";
    // for (long[] plot : ref){
    //   for (int i = 0; i < plot.length; i++){
    //     ans += plot[i] + " ";
    //   }
    //   ans += "\n";
    // }
    return ans;
  }
  public static void main(String[] args){
    try{
      System.out.println(solve("ctravel.2.in"));
    } catch (FileNotFoundException e){
      ;
    }
    // int[][] a = new int[11][11];
    // for (int[] b : a){
    //   for (int i = 0; i < b.length; i++){
    //     b[i] = 0;
    //   }
    // }
    // dug(a,5,5,4);
    // String ans = "";
    // for (int[] b : a){
    //   for (int c : b){
    //     ans += (" " + c);
    //   }
    //   ans += "\n";
    // }
    // System.out.println(ans);
  }
}
