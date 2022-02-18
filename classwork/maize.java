import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class maize{
  public static char[][] masePutterInner(String filee) throws FileNotFoundException{
    ArrayList<String> store = new ArrayList<String>();
    File file = new File(filee);
    Scanner input = new Scanner(file);
    while (input.hasNextLine()){
      store.add(input.nextLine());
    }
    input.close();
  }
  public static void masePrinter(String filee) throws FileNotFoundException{
    File file = new File(filee);
    Scanner input = new Scanner(file);
    while (input.hasNextLine()){
      System.out.println(input.nextLine());
    }
    input.close();
  }
  public static void main(String[] args){
    try{
      mase("maze.txt");
    } catch(FileNotFoundException e){

    }
  }
}
