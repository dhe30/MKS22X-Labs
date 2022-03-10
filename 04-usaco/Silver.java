public class Silver{
  public static void dug(int[][] a, int startRow, int startCol, int max){
    if (startRow >= 0 && startRow < a.length && startCol >= 0 && startCol < a[0].length){
      if(max == 0){
        a[startRow][startCol] += 1;
      } else {

        dug(a, startRow - 1, startCol, max - 1);
        dug(a, startRow, startCol - 1, max - 1);
        dug(a, startRow + 1, startCol, max - 1);
        dug(a, startRow, startCol + 1, max - 1);
      }
    }
  }
  public static void main(String[] args){
    int[][] a = new int[11][11];
    for (int[] b : a){
      for (int i = 0; i < b.length; i++){
        b[i] = 0;
      }
    }
    dug(a,5,5,2);
    String ans = "";
    for (int[] b : a){
      for (int c : b){
        ans += (" " + c);
      }
      ans += "\n";
    }
    System.out.println(ans);
  }
}
