import java.util.*;
import java.io.*;
public class Bronze{
  public static void solve(String filename) throws FileNotFoundException{
    File file = new File(filename);
    Scanner input = new Scanner(file);
    int[] controls = new int[4];
    for (int i = 0; i < 4; i++){
      controls[i] = (input.nextInt());
    }
    int[][] land = new int[controls[0]][controls[1]];
    for (int[] plot : land){
      for(int i = 0; i < plot.length; i++){
        plot[i] = input.nextInt();
      }
    }
    for (int i = 0; i < controls[3]; i++){
      int row = input.nextInt();
      int col = input.nextInt();
      int stomps = input.nextInt();
      int maxi = 0;
      ArrayList<Integer> findMax = new ArrayList<Integer>()
      for (int i = 0; i < 3; i++){
        findMax.add(land[row - 1][col - 1 + i]);
        findMax.add(land[row][col - 1 + i]);
        findMax.add(land[row + 1][col - 1 + i]);
      }
    }
    // String ans = "";
    // for (int[] plot : land){
    //   for(int i = 0; i < plot.length; i++){
    //     ans += plot[i];
    //   }
    //   ans += "\n";
    // }
    // System.out.println(ans);
  }
  public static void main(String[] args){
    try{
      solve("makelake.in");
    } catch (FileNotFoundException e){
      ;
    }
  }
}
