public class tester{
  public static void main(String[] args){
    MyDeque<Integer> a = new MyDeque<Integer>(5);
    for (int i = 0; i < 4; i++){
      a.addFirst(5);
    }
    a.addLast(5);
    System.out.println(a);
    a.removeFirst();
    System.out.println(a);
    a.removeLast();
    a.removeLast();
    a.removeLast();
    a.removeLast();
    System.out.println(a + " start: " + a.getStart() + " end: " + a.getEnd());
    a.addFirst(1);
    System.out.println(a + " start: " + a.getStart() + " end: " + a.getEnd());
    a.addLast(2);
    System.out.println(a + " start: " + a.getStart() + " end: " + a.getEnd());
  }
}
