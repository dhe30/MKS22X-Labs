import java.util.*;
import java.io.*;
public class Silver{
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
  public static void solve(String filename) throws FileNotFoundException{
    File file = new File(filename);
    Scanner input = new Scanner(file);
    int rows = input.nextInt();
    int cols = input.nextInt();
    int time = input.nextInt();
    char[][] findTrees = new char[rows][];
    for (int i = 0; i < rows; i++){
      findTrees[i] = input.next().toCharArray();
    }
    int[][] field = new int[rows][cols];
    for (int i = 0; i < rows; i++){
      for (int a = 0; a < cols; a++){
        if(findTrees[i][a] == '*'){
          field[i][a] = -1;
        }
      }
    }
    field[input.nextInt() - 1][input.nextInt() - 1] = 1;

    String ans = "";
    for (int[] plot : field){
      for (int i = 0; i < plot.length; i++){
        ans += plot[i];
      }
      ans += "\n";
    }
    System.out.println(ans);
  }
  public static void main(String[] args){
    try{
      solve("ctravel.1.in");
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
