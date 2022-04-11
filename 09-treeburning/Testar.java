public class Testar{
  public static double averageOfNRuns(int n, int size, double density){
    int total = 0;
    for (int i = 0; i < n; i++){
      BurnTrees acre = new BurnTrees(size, size, density);
      total += acre.run();
    }
    return (double)total/n;
  }
  public static void main(String[] args){
    // String ans = "";
    // double density = 0.05;
    // int size = 150;
    // int n = 300;
    // for(int i = 0; i < 19; i++){
    //   ans += density + "|" + averageOfNRuns(n,size,density) + "\n";
    //   density += 0.05;
    // }
    // System.out.println(ans);
    // ans = "";
    // density = 0.5;
    // size = 150;
    // n = 300;
    // for(int i = 0; i < 26; i++){
    //   ans += density + "|" + averageOfNRuns(n,size,density) + "\n";
    //   density += 0.01;
    // }
    // System.out.println(ans);
    int siz = 20;
    double anna = averageOfNRuns(300,10,0.6);
    for (int i = 1; i < 6; i++){
      System.out.println(averageOfNRuns(300,siz,0.6)/anna);
      siz *= 2;
    }
  }
}
