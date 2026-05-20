
import java.util.Iterator;

public class SimpleArrayList <T > implements ListInterface <T > {
    private T [] array ;
    private int n = 0;
    private int defaultSize = 100;

    public SimpleArrayList () {
        array = ( T []) new Object [ defaultSize ];
        n=0;

    }
    public SimpleArrayList ( int capacity ) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity must be non-negative");
        }
        array = (T[]) new Object[capacity];
        n = 0;

    }
    public void add (T data ) {
        if(array == null){
            array[0] = data;
        }else {
            array[n] = data;
        }
        n++;
    }
    public T get (int i ) {
        if(i < 0 || i >= n){
            throw new IndexOutOfBoundsException();
        } 
        return array[i];
    }
    public void set (int i , T data ) {
         if(i < 0 || i >= n){
            throw new IndexOutOfBoundsException();
        }
        array[i] = data;
    }
    public void remove(T data) {
    if (array == null) {
        throw new IndexOutOfBoundsException("Array is null");
    }
    int index = -1;
    for (int i = 0; i < n; i++) {
        if (array[i].equals(data)) {
            index = i;
            break;
        }
    }
    if (index == -1) {
        return;
    }
    for (int i = index + 1; i < n; i++) {
        array[i - 1] = array[i];
    }
    n--;
    array[n] = null;
}
     public int indexOf(T data){
        for(int i=0; i < n;i++){
            if(array[i].equals(data)){
                return i;
            }
        }
        return -1;
    }

    public boolean isContain ( T data ) {
        for(int index =0; index < n;index++){
            if(array[index].equals(data)){
                return true;
            }
        }
        return false ;
    }
    public int size () {
        return n;
    }
    public boolean isEmpty () {
        return n==0 ;
    }
    public Iterator <T > iterator () {
        return null;
    }
 }