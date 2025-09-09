public class LinkedListADTImpl<T> implements ListADT<T> {
    private final SinglyLinkedList<T> list = new SinglyLinkedList<>();

    @Override
    public T access(int i) { return list.get(i); }

    @Override
    public void replace(T x, int i) { list.set(i, x); }

    @Override
    public void insert(T x, int i) { list.insertAt(i, x); }

    @Override
    public void remove(int i) { list.removeAt(i); }

    @Override
    public int size() { return list.size(); }
}
