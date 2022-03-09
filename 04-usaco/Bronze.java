import java.util.*;
import java.io.*;
public class Bronze{
  public static int solve(String filename) throws FileNotFoundException{
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
      System.out.println("row: " + row + " col: " + col + " stomps: " + stomps);
      int maxi = 0;
      ArrayList<Integer> findMax = new ArrayList<Integer>();
      for (int a = 0; a < 3; a++){
        findMax.add(land[row - 1][col - 1 + a]);
        findMax.add(land[row][col - 1 + a]);
        findMax.add(land[row + 1][col - 1 + a]);
      }
      for (int b = 0; b < 9; b++){

        if(findMax.get(b) > maxi){
          maxi = findMax.get(b);
        }
      }
      System.out.println("max: " + maxi);
      // String ans = "";
      // for (int b = 0; b < 9; b++){
      //   ans += findMax.get(b);
      // }
      // System.out.println(ans);
      for (int untilStomps = 0; untilStomps < stomps; untilStomps++){
        for (int plots = 0; plots < 3; plots++){
          if(land[row - 1][col - 1 + plots] == maxi){
            land[row - 1][col - 1 + plots] -= 1;
          }
          if(land[row][col - 1 + plots] == maxi){
            land[row][col - 1 + plots] -= 1;
          }
          if(land[row + 1][col - 1 + plots] == maxi){
            land[row + 1][col - 1 + plots] -= 1;
          }
        }
        maxi -= 1;
      }
    }
    int depth = 0;
    String ans = "";
    for (int[] plot : land){
      for(int i = 0; i < plot.length; i++){
        ans += plot[i] + " ";
        if (controls[2] - plot[i] > 0){
          depth += (controls[2] - plot[i]);
        }
      }
      ans += "\n";
    }
    System.out.println(ans);
    System.out.println(depth);
    return depth * 72 * 72;

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
      System.out.println(solve("makelake.in"));
    } catch (FileNotFoundException e){
      ;
    }
  }
}
