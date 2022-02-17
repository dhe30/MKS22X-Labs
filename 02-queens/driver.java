public class driver{
  public static void main(String[] args){
    QueenBoard a = new QueenBoard(4);
    a.solve();
    System.out.println(a.countSolutions());

  }
}
