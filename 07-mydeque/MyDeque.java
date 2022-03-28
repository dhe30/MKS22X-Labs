public class MyDeque<E>{
      private E[] data;
      private int size;
      private int start, end;

      public MyDeque(){
        @SuppressWarnings("unchecked")
        E[] d = (E[])new Object[10];
        data = d;
        size = 0;
        start = 0;
        end = 0;
      }
      public MyDeque(int initialCapacity){
        @SuppressWarnings("unchecked")
        E[] d = (E[])new Object[initialCapacity];
        data = d;
        size = 0;
        start = 0;
        end = 0;
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
        for(int i = 0; i < data.length; i++){
          a += data[i] + ", ";
        }
      }
      public void addFirst(E element){ }
      public void addLast(E element){ }
      public E removeFirst(){ }
      public E removeLast(){ }
      public E getFirst(){ }
      public E getLast(){ }
    }
