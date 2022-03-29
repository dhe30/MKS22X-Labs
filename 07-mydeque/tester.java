import java.util.*;
public class tester{
  public static void main(String[] args){
    // MyDeque<Integer> a = new MyDeque<Integer>();
    // for (int i = 0; i < 15; i++){
    //   a.addLast(i);
    //   System.out.println(a + " start: " + a.getStart() + " end: " + a.getEnd());
    // }
    // System.out.println(a + " start: " + a.getStart() + " end: " + a.getEnd());
    MyDeque<Integer> a = new MyDeque<Integer>(0);
    try {
      a.addFirst(null);
    } catch (NoSuchElementException e){
      System.out.println("uyes");
    }
  }
}
