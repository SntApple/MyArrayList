import java.util.*;

public class MyArrayList<E>{
    private int size;
    private int capacity = 10;
    private E[] elementData;

    public MyArrayList() {
        elementData = (E[]) new Object[capacity];
    }


    public MyArrayList(int initialCapacity) {
        if (initialCapacity >= 0) {
            this.capacity = initialCapacity;
            size = 0;
            elementData = (E[]) new Object[capacity];
        }
        else
            throw new IllegalArgumentException("Invalid size: " + size);
    }

    public MyArrayList(Collection<? extends E> c) {
        if (c == null)
            throw new NullPointerException("Collection in argument is null");
        else {
            elementData = (E[]) new Object[c.size()];
            int index = 0;
            for (E i:
                 c) {
                elementData[index++] = i;
            }
        }
        size = c.size();
    }


    public E get(int index) {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException("Index " + index + " is out of bound");
        else
            return elementData[index];
    }

    public int size() {
        return this.size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public boolean contains(Object o) {
        for (E it:
             elementData) {
            if (it.equals((E)o))
                return true;
        }
        return false;
    }
    public Iterator<E> iterator() {
        return (Iterator<E>) new Iterator<E>() {
            private int index = 0;
            public boolean hasNext() {
                return index < size && elementData[index] != null;
            }
            public E next() {
                return elementData[index++];
            }
        };
    }
    public Object[] toArray() {
        Object[] o = new Object[size];
        System.arraycopy(elementData, 0, o, 0, size);
        return o;
    }
    public boolean add(E o) {
        if (size < capacity)
            elementData[size++] = o;
        else {
            E[] newElementData = (E[]) new Object[++capacity];
            System.arraycopy(elementData, 0, newElementData, 0, size);
            newElementData[++size] = o;
            elementData = newElementData;
        }
        return false;
    }

    public void trimToSize() {
        E[] newElementData = (E[]) new Object[size];
        System.arraycopy(elementData, 0, newElementData, 0, size);
        elementData = newElementData;
    }

    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index " + index + " is out of bound");
        E tmp = elementData[index];
        if (size - 1 - index >= 0)
            System.arraycopy(elementData, index + 1, elementData, index, size - 1 - index);
        size--;
        if (capacity - size > 10)
            trimToSize();
        return tmp;
    }

    public boolean remove(Object o) {
        for (int i = 0; i < size; ++i){
            if (elementData[i].equals((E)o)) {
                while (i < size - 1)
                    elementData[i] = elementData[i++ + 1];
                size--;
                if (capacity - size > 10)
                    trimToSize();
                return true;
            }
        }
        return false;
    }
    public boolean addAll(Collection <? extends E> c) {
        if (c != null) {
            E[] newElementData = (E[]) new Object[size + c.size()];
            System.arraycopy(elementData, 0, newElementData, 0, size);
            int index = size;
            for (E it:
                 c) {
                newElementData[index++] = it;
            }
            size += c.size();
            elementData = newElementData;
        }
        else
            throw new NullPointerException("Collection is null");
        return false;
    }

    public boolean addAll(int index, Collection <? extends E> c) {
        if (c != null) {
            E[] newElementData = (E[]) new Object[size + c.size()];
            System.arraycopy(elementData, 0, newElementData, 0, index - 1);
            int i = index;
            for (E it:
                 c) {
                newElementData[i++] = it;
            }
            System.arraycopy(elementData, index, newElementData, i, size - index);
            size += c.size();
            elementData = newElementData;
        }
        else
            throw new NullPointerException("Collection is null");
        return false;
    }
    public void clear() {
        elementData = (E[]) new Object[0];
        size = 0;
        capacity = 0;
    }
    public E set(int index, E element) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index " + " is out of bound");
        E prev = elementData[index];
        elementData[index] = element;
        return prev;
    }
    public void add(int index, E element) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index " + " is out of bound");
        if (size >= capacity) {
            E[] newElementData = (E[]) new Object[++size];
            System.arraycopy(elementData, 0, newElementData, 0, index - 1);
            newElementData[index] = element;
            System.arraycopy(elementData, index, newElementData, index + 1, size - index);
            elementData = newElementData;
        }
        else {
            if (size + 1 - index >= 0) System.arraycopy(elementData, index - 1, elementData, index, size + 1 - index);
            elementData[index] = element;
        }
        size++;
    }
    public int indexOf(Object o) {
        for (int i = 0; i < size; ++i) {
            if (elementData[i].equals(o))
                return i;
        }
        return -1;
    }
    public int lastIndexOf(Object o) {
        for (int i = size - 1; size >= 0; --i)
            if (elementData[i].equals(o))
                return i;
        return -1;
    }
    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            a = (T[]) new Object[size];
        }
        for (int i = 0; i < size; ++i)
            a[i] = (T)elementData[i];
        return a;
    }

    private int partition(E[] arr, int begin, int end, Comparator<? super E> c) {
        E pivot = arr[end];
        int i = (begin - 1);
        for (int j = begin; j < end; j++) {
            if (c.compare(arr[j], pivot) < 0) {
                i++;

                E tmp = arr[j];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        E tmp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = tmp;
        return i + 1;
    }

    private void sort(E[] arr, int begin, int end, Comparator<? super E> c) {
        if (begin < end) {
            int partIndex = partition(arr, begin, end, c);
            sort(arr, begin, partIndex - 1, c);
            sort(arr, partIndex + 1, end, c);
        }
    }
    public void quicksort(Comparator<? super E> c) {
        sort(elementData, 0, size, c);
    }
}
