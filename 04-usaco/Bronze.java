import java.util.*;
import java.io.*;
public class Bronze{
  public static long solve(String filename) throws FileNotFoundException{
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
    long depth = 0l;
    for (int[] plot : land){
      for(int i = 0; i < plot.length; i++){
        if (controls[2] - plot[i] > 0){
          depth += (controls[2] - plot[i]);
        }
      }


    }

    return depth * 72l * 72l;

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
      System.out.println(solve("makelake.2.in"));
    } catch (FileNotFoundException e){
      ;
    }
  }
}
