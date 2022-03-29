public class tester{
  public static void main(String[] args){
    // MyDeque<Integer> a = new MyDeque<Integer>();
    // for (int i = 0; i < 15; i++){
    //   a.addLast(i);
    //   System.out.println(a + " start: " + a.getStart() + " end: " + a.getEnd());
    // }
    // System.out.println(a + " start: " + a.getStart() + " end: " + a.getEnd());
    MyDeque<Integer> a = new MyDeque<Integer>(0);
    System.out.println(a + " " + a.toStringTest() + " start: " + a.getStart() + " end: " + a.getEnd());
    a.addLast(4);
    System.out.println(a + " " + a.toStringTest() + " start: " + a.getStart() + " end: " + a.getEnd());
    a.addLast(4);
    System.out.println(a + " " + a.toStringTest() + " start: " + a.getStart() + " end: " + a.getEnd());
    a.addLast(4);
    System.out.println(a + " " + a.toStringTest() + " start: " + a.getStart() + " end: " + a.getEnd());
    a.addLast(4);
    System.out.println(a + " " + a.toStringTest() + " start: " + a.getStart() + " end: " + a.getEnd());
    a.addFirst(4);
    System.out.println(a + " " + a.toStringTest() + " start: " + a.getStart() + " end: " + a.getEnd());
  }
}
