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
    double density = 0.05;
    int size = 1000;
    int n = 100;
    for(int i = 0; i < 19; i++){
      System.out.println("Density: " + density + " repetitions: " + n + " Boardsize: " + size + " result: " + averageOfNRuns(n, size, density));
      density += 0.05;
    }
  }
}
