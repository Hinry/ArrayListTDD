/**
 * Created by mrhri on 10.11.2016.
 */
//    Реализация ArrayList через TDD: реализовать методы set(index,value),
//    add(index,value), remove(index), get(index), size() через написание тестов с требованиями к методам.
//    Наследоваться от java.util.AbstractList. В качестве технического задания выступит
//    http://docs.oracle.com/javase/8/docs/api/java/util/List.html.
//    Сложный уровень. Реализация ArrayList через TDD без наследования от AbstractList.
public class ArrayList<T> {

    private Object[] array;
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 16;

    public ArrayList(){
        this.array = new Object[DEFAULT_CAPACITY];
    }

    public ArrayList(int capacity) {

        this.array = new Object[capacity];
    }
    public T get(int index) {
        return  (T) array[index];
    }
    public T set(int index, T element){
        checkIndex(index);

        T oldValue = (T) array[index];
        array[index] = element;
        return oldValue;
    }
    public boolean add(T e) {
        array[size++] = e;
        return true;
    }

    public void add(int index, T element) {

        checkIndexForSize(index);
        System.arraycopy(array, index, array, index + 1,
                size - index);
        array[index] = element;
        size++;
    }

    public int size(){
        return size;
    }

    public T remove(int index){

        checkIndex(index);

        T oldValue = (T) array[index];

        int numMoved = size - index - 1;

        if (numMoved > 0)
            System.arraycopy(array, index+1, array, index,
                    numMoved);
        array[--size] = null; // clear to let GC do its work

        return oldValue;
    }

    private void checkIndex(int index){
        if(index>=size){
            throw new IndexOutOfBoundsException();
        }
    }
    private void checkIndexForSize(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException("Указаный индекс ("+index+") неверный. Размер Массива ("+size+")");
    }


}
