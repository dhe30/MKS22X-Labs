public class dig{
  public static void dug(char[][] a, int startRow, int startCol, int max){
    if (startRow >= 0 && startRow < a.length && startCol >= 0 && startCol < a[0].length){
      if(max == 0){
        a[startRow][startCol] += 1;
      }
      if(a[startRow][startCol] == '.' && max != 0){
        dug(a, startRow - 1, startCol, max - 1);
        dug(a, startRow, startCol - 1, max - 1);
        dug(a, startRow + 1, startCol, max - 1);
        dug(a, startRow, startCol + 1, max - 1);
      }
    }
  }
  public static void main(String[] args){
    char[][] a = new char[3][3];
    for (char[] b : a){
      for (int i = 0; i < b.length; i++){
        b[i] = '.';
      }
    }
    dug(a,0,1,1);
    String ans = "";
    for (char[] b : a){
      for (char c : b){
        ans += c;
      }
      ans += "\n";
    }

  }
}
