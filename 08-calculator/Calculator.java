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
    double first, second, porcupine;
    while(input.hasNext()){
      String part = input.next();
      switch (part) {
        case "+" : if (a.size() < 2){
                      throw new IllegalArgumentException("too many operands");
                    }
                    second = a.removeLast();
                    first = a.removeLast();
                    porcupine = first + second;
                    a.addLast(porcupine);
                    break;
                   case "-" : if (a.size() < 2){
                                throw new IllegalArgumentException("too many operands");
                              }
                              second = a.removeLast();
                              first = a.removeLast();
                              porcupine = first - second;
                              a.addLast(porcupine);
                              break;
                             case "*" : if (a.size() < 2){
                                          throw new IllegalArgumentException("too many operands");
                                        }
                                        second = a.removeLast();
                                        first = a.removeLast();
                                        porcupine = first * second;
                                        a.addLast(porcupine);
                                        break;
                                       case "/" : if (a.size() < 2){
                                                    throw new IllegalArgumentException("too many operands");
                                                  }
                                                  second = a.removeLast();
                                                  first = a.removeLast();
                                                  porcupine = first / second;
                                                  a.addLast(porcupine);
                                                  break;
                                                 case "%" : if (a.size() < 2){
                                                               throw new IllegalArgumentException("too many operands");
                                                             }
                                                             second = a.removeLast();
                                                             first = a.removeLast();
                                                             porcupine = first % second;
                                                             a.addLast(porcupine);
                                                             break;
                                                            default : if(part.indexOf(".") > 0){
                                                                        a.addLast(Double.parseDouble(part));
                                                                      } else {
                                                                        a.addLast((double)Integer.parseInt(part));
                                                                      }
      }
    }

    //   if (part.equals("+")){
    //     if (a.size() < 2){
    //       throw new IllegalArgumentException("too many operands");
    //     }
    //     first = a.removeLast();
    //     second = a.removeLast();
    //     porcupine = first + second;
    //     a.addLast(porcupine);
    //   } else if(part.equals("-")){
    //
    //   } else if(part.equals("*")){
    //
    //   } else if(part.equals("/")){
    //
    //   } else if(part.equals("%")){
    //
    //   } else if(part.indexOf(".") > 0){
    //     a.addLast(Double.parseDouble(part));
    //   } else {
    //     a.addLast((double)Integer.parseInt(part));
    //   }
    // }
    if (a.size() > 1 || a.size() < 1){
      throw new IllegalArgumentException("too few operands");
    }
    return a.getLast();
  }
  public static void main(String[] args){
    //System.out.println(eval("8 2 + 99 9 - * 2 + 9 -"));
  }
}
