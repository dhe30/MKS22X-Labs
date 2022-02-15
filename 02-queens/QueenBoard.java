public class QueenBoard{
  private int[][]board;
  public QueenBoard(int size){
    board = new int[size][size];
  }
  /**
  *@return The output string formatted as follows:
  *All numbers that represent queens are replaced with 'Q'
  *all others are displayed as underscores '_'
  *There are spaces between each symbol:
  *_ _ Q _
  *Q _ _ _
  *_ _ _ Q
  *_ Q _ _
  *excludes the characters up to the comment(*)
  */
  public String toString(){
    String ans = "";
    for (int i = 0; i < board.length; i++){
      for (int a = 0; a < board.length; a++){
        if (board[i][a] == -1){
          ans += "Q ";
        } else{
          ans += "_ ";
        }

      }
      ans += "\n";
    }
    return ans;
  }

  /**
  *@return true when the queen added correctly, false Otherwise
  *@precondition r and c are valid indices of the board array
  *@postcondition the board is only changed when the function returns true
  * in which case the queen is added and all it's threatened positions are incremented
  */
  private boolean addQueen(int r, int c){
    if(board[r][c] == 0){
      board[r][c] = -1;
      int a = 1;
      for(int i = r + 1; i < board.length; i++){
        board[i][c] = board[i][c] + 1;
        if (c + a < board.length){
          board[i][c + a] = board[i][c + a] + 1;
        }
        if (c - a >= 0){
          board[i][c - a] = board[i][c - a] + 1;
        }
        a++;
      }
      return true;
    } else {
      return false;
    }
  }

  /**Remove the queen that was added to r,c
  *@precondition r and c are valid indices of the board array and there is a queen at position r,c
  *@postcondition the board is modified to remove that queen and all it's
  *threatened positions are decremented
  */
  private void removeQueen(int r, int c){
    board[r][c] = 0;
    int a = 1;
    for(int i = r + 1; i < board.length; i++){
      board[i][c] = board[i][c] - 1;
      if (c + a < board.length){
        board[i][c + a] = board[i][c + a] - 1;
      }
      if (c - a >= 0){
        board[i][c - a] = board[i][c - a] - 1;
      }
      a++;
    }
  }

  /**Find the first solution configuration possible for this size board. Start by placing
  *  the 1st queen in the top left corner, and each new queen in the next ROW. When backtracking
  *  move the previous queen to the next valid space. This means everyone will generate the same
  *  first solution.
  *@postcondition: the board remains in a solved state.
  *@return false when the board is not solveable and leaves the board filled with zeros;
  *        returns true when the board is solveable, and leaves the board in a solved state
  *@throws IllegalStateException when the board starts with any non-zero value (e.g. you solved a 2nd time.)
  */
  public boolean solve(){
    return solve(0);
  }

  public boolean solve(int row){
    if (row == board.length){
      return true;
    } else {
      for (int i = 0; i < board.length; i++){
        if(addQueen(row, i)){
          System.out.println(Text.go(1,1));
         System.out.println(this);//can change this to your debug print as well
         Text.wait(1500);//change the delay 1000 = 1 second
          if (solve(row + 1)){
            System.out.println("true");
            return true;
          }
          removeQueen(row, i);
          System.out.println(Text.go(1,1));
         System.out.println(this);//can change this to your debug print as well
         Text.wait(1500);//change the delay 1000 = 1 second
        }
      }
      return false;
    }
  }
  //
  // /**Find all possible solutions to this size board.
  // *@return the number of solutions found, and leaves the board filled with only 0's
  // *@throws IllegalStateException when the board starts with any non-zero value (e.g. you ran solve() before this method)
  // */
  // public int countSolutions(){}
  public static void main(String[] args){
    QueenBoard a = new QueenBoard(8);
    System.out.println(Text.CLEAR_SCREEN);
          System.out.println(Text.HIDE_CURSOR);
          System.out.println(Text.go(1,1));
          a.solve();
          System.out.println(Text.RESET);


  }
}
