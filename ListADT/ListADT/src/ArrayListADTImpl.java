import java.util.Arrays;

public class ArrayListADTImpl<T> implements ListADT<T> {
    private T[] A;
    private int length;
    private int capacity;

    @SuppressWarnings("unchecked")
    public ArrayListADTImpl(int initialCapacity) {
        if (initialCapacity <= 0) throw new IllegalArgumentException("capacity must be > 0");
        capacity = initialCapacity;
        A = (T[]) new Object[capacity];
        length = 0;
    }

    @Override
    public T access(int i) {
        checkIndex(i);
        return A[i];
    }

    @Override
    public void replace(T x, int i) {
        checkIndex(i);
        A[i] = x;
    }

    @Override
    public void insert(T x, int i) {
        if (i < 0 || i > length) throw new IndexOutOfBoundsException("Invalid index " + i);
        if (length == capacity) resize();
        for (int k = length - 1; k >= i; k--) {
            A[k + 1] = A[k];
        }
        A[i] = x;
        length++;
    }

    @Override
    public void remove(int i) {
        checkIndex(i);
        for (int k = i; k < length - 1; k++) {
            A[k] = A[k + 1];
        }
        A[length - 1] = null; // helps GC
        length--;
    }

    @Override
    public int size() { return length; }

    private void checkIndex(int i) {
        if (i < 0 || i >= length) throw new IndexOutOfBoundsException("No element at index " + i);
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        capacity *= 2;
        T[] B = (T[]) new Object[capacity];
        for (int i = 0; i < length; i++) B[i] = A[i];
        A = B;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(A, length));
    }
}
