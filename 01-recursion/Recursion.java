public class Recursion{
  /*Print all words that are made of the letters a-e inclusive.
  *@param length : the length of the words that are to be printed
  */
  public static void printAllWords(int length){
    printAllWords(length,"");
  }

  /*Print all words that are made of the letters a-e inclusive.
  *@param length : either how many more letters or the total length depending on implementation
  *@param word   : the partial word so far.
  */
  public static void printAllWords(int length,String word){
    //WRITE THIS METHOD
    if (length == 0){
      System.out.println(word);
    } else {
      for (char c = 'a'; c <= 'e'; c++){
        printAllWords(length - 1, word + c);
      }
    }
  }

  /*Print all words that are made of the characters in the array of letters.
  *There may not be consecutive equal letters, so:
  *aax is not allowed, but axa is allowed.
  *@param length : the length of the words that are to be printed
  *@param letters: the letters you should be using,
  *@precondition: letters contains at least 2 characters, and has no duplicates.
  */
  public static void printNoDoubleLetterWords(int length,char[] letters){
    printNoDoubleLetterWords(length,"",letters);
  }

  /*Print all words that are made of the characters in letters. There may not be consecutive equal letters,
  *aax is not allowed, but axa is allowed.
  *@param length : either how many more letters need to be
  *@param word   : the partial word so far.
  *@param letters: the letters you should be using
  */
  public static void printNoDoubleLetterWords(int length,String word,char[]letters){
    //WRITE THIS METHOD

    if (length == 0){
      System.out.println(word);
    } else {
      for (int i = 0; i < letters.length; i++){
        char c = letters[i];
        if (word.length() != 0){
          if (c != word.charAt(word.length() - 1)){
            printNoDoubleLetterWords(length - 1, word + c, letters);
          }
        } else {
        printNoDoubleLetterWords(length - 1, word + c, letters);
      }
      }
    }
  }

  /*
          *@param s any string
          *@return a string that is the reversed version of s, do NOT use built in methods to do so, use recursion.
          */
  public static String reverse(String s){
    if (s.length() <= 1){
      return s;
    } else{
      int length = s.length();
      return s.substring(length-1, length) + reverse(s.substring(0, length-1));
    }
  }

  /*
  *@param length how long the words must be
  *param word the variable to store the partial solution (should start at "")
  *@return the number of words that have no adjacent matching letters using the letters a-z.
  *Repetition allowed except when letters are adjacent.
  */
  public static long countNoDoubleLetterWords(int length,String word){
    //Hint: not a wrapper method, but you must call it starting with "" as your word.
    long total = 0;
    if (length == 0){
      return 1l;
    } else{
      for(char c = 'a'; c <= 'z'; c++){
        if (word.length() != 0){
          if(c != word.charAt(word.length() - 1)){
            total += countNoDoubleLetterWords(length - 1, word + c);
          }
        } else{
          total += countNoDoubleLetterWords(length - 1, word + c);
        }
      }
    }
    return total;
  }
  /*
            *@param n any non-negative value you want to take the sqrt of
            *@return the approximate sqrt of n within a tolerance of 0.001%
            */
  public static double sqrt(double n){
    //Hint: This is a wrapper method.
    return sqrt(n, 1.0);
  }
  public static double sqrt(double n, double guess){
    if (n == 0.0){
      return 0.0;
    }
    if( (((guess*guess)-n)/n) * 100.0 <= 0.001 && (((guess*guess)-n)/n) * 100.0 > 0){
      return guess;
    } else {
      guess = (n / guess + guess) / 2.0;
      return sqrt(n, guess);
    }
  }

  public static void main(String[] args){
    System.out.println(sqrt(0));
  }
}
