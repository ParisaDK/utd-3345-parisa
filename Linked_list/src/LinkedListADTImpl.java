package Linked_list.src;

public class LinkedListADTImpl<T> implements ListADT<T> {

    private final SinglyLinkedList<T> list = new SinglyLinkedList<>();

    @Override
    public T access(int i) {
        return list.get(i); // O(n)
    }

    @Override
    public void replace(T x, int i) {
        list.set(i, x);     // O(n)
    }

    @Override
    public void insert(T x, int i) {
        list.insertAt(i, x); // O(n) in general, O(1) at head
    }

    @Override
    public void remove(int i) {
        list.removeAt(i);    // O(n) in general, O(1) at head
    }

    @Override
    public int size() {
        return list.size();
    }
}
