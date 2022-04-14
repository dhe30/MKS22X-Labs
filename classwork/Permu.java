public class Permu{
  public static void perma(String a, String answer){
    if(a.length() == 0){
      System.out.println(answer);
    } else{
      for (int i = 0; i < a.length(); i++){
        perma(a.substring(0, i) + a.substring(i + 1, a.length()), answer + a.charAt(i));
      }
    }
  }
  public static void main(String[] args){
    perma("ACB", "");
  }
}
