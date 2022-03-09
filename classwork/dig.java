public class dig{
  public static int dug(char[][] a, int startRow, int startCol, int max){
    int total = 0;
    if (startRow >= 0 && startRow < a.length && startCol >= 0 && startCol < a[0].length){
      if(a[startRow][startCol] == 'E'){
        return 1;
      }
      if(a[startRow][startCol] == '.' && max != 0){
        total += dug(a, startRow - 1, startCol, max - 1);
        total += dug(a, startRow, startCol - 1, max - 1);
        total += dug(a, startRow + 1, startCol, max - 1);
        total += dug(a, startRow, startCol + 1, max - 1);
      }
    }
    return total;
  }
  public static void main(String[] args){
    char[][] a = new char[4][5];
    for (char[] b : a){
      for (int i = 0; i < b.length; i++){
        b[i] = '.';
      }
    }
    a[0][3] = '*';
    a[1][3] = '*';
    a[1][0] = 'E';
    String ans = "";
    for (char[] b : a){
      for (char c : b){
        ans += c;
      }
      ans += "\n";
    }
    System.out.println(dug(a,0,2,3));
  }
}
