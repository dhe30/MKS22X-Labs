public class tester{
  public static void main(String[] args){
    MyDeque<Integer> a = new MyDeque<Integer>(1);
    a.addFirst(5);
    a.addFirst(5);
    System.out.println(a);
  }
}
