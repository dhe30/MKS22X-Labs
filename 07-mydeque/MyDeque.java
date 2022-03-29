public class MyDeque<E>{
  private E[] data;
  private int size;
  private int start, end;

  public MyDeque(){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[10];
    data = d;
    size = 0;
    start = -1;
    end = -1;
  }
  public MyDeque(int initialCapacity){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[initialCapacity];
    data = d;
    size = 0;
    start = -1;
    end = -1;
  }
  public int size(){
    return size;
  }
  private void resize(){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[(data.length * 2) + 1];
    int a = 0;
    if(start <= end){
      for(int i = start; i <= end; i++){
        d[a] = data[i];
        a++;
      }
    } else {
      for(int i = start; i < data.length; i++){
        d[a] = data[i];
        a++;
      }
      for(int i = 0; i <= end; i++){
        d[a] = data[i];
        a++;
      }
    }
    start = 0;
    end = size();
    data = d;
  }
  public String toString(){
    //Test
    String a = "[";
    if (size() == 0){
      return a + "]";
    }
    for(int i = 0; i < data.length; i++){
      a += data[i] + ", ";
    }
    return a.substring(0, a.length() - 2) + "]";
  }
  public void addFirst(E element){
    if (size() == data.length){
      resize();
    }
    if (size == 0){
      data[0] = element;
      start = 0;
      end = 0;
    } else {
      if (start - 1 < 0){
        data[data.length - 1] = element;
        start = data.length - 1;
      } else {
        data[start - 1] = element;
        start -= 1;
      }
      size += 1;
    }
  }
  public void addLast(E element){
    if (size() == data.length){
      resize();
    }
    if (size == 0){
      data[0] = element;
      start = 0;
      end = 0;
    } else {
      if (end + 1 > data.length - 1){
        data[0] = element;
        end = 0;
      } else {
        data[end + 1] = element;
        end += 1;
      }
      size += 1;
    }
  }
  // public E removeFirst(){ }
  // public E removeLast(){ }
  // public E getFirst(){ }
  // public E getLast(){ }
}
