public interface ListADT<T> {
    T access(int i);
    void replace(T x, int i);
    void insert(T x, int i);
    void remove(int i);
    int size();

    default boolean isEmpty() { return size() == 0; }
}
