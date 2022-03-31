import java.util.*;
import java.io.*;
public class Calculator{
  /*Evaluate a postfix expression stored in s.
  *Assume valid postfix notation, of ints doubles and operators separated by spaces.
  *Valid operators are + - / * and % (remainder not modulo)
  *All results are doubles even if the operands are both int.
  *@throws IllegalArgumentException when there are too many or too few operands.
  *        Use the string parameter of your exception to indicate what happened.
  *        Either "too many operands" or "too few operands for operation _" replace _ with +,- etc.
  */
  public static double eval(String s){
    ArrayDeque<Double> a = new ArrayDeque<Double>();
    Scanner input = new Scanner(s);
    while(input.hasNext()){
      String part = input.next();
      if (part.equals("+")){
        if (a.size() < 2){
          //exception
        }
        double first = a.removeLast();
      } else if(part.equals("-")){

      } else if(part.equals("*")){

      } else if(part.equals("/")){

      } else if(part.equals("%")){

      } else if(part.indexOf(".") > 0){
        a.addLast(Double.parseDouble(part));
      } else {
        a.addLast((double)Integer.parseInt(part));
      }
    }
    return -1;
  }
  public static void main(String[] args){
    System.out.println((int)Double.parseDouble("3.0"));
  }
}
