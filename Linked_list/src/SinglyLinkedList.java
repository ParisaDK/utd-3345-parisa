package Linked_list.src;

import java.util.NoSuchElementException;

public class SinglyLinkedList<T> {

    private static class Node<E> {
        E data;
        Node<E> next;
        Node(E d, Node<E> n) { data = d; next = n; }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    private void checkIndexInclusive(int i) {
        if (i < 0 || i >= size) throw new IndexOutOfBoundsException("Index: " + i);
    }

    private void checkIndexExclusive(int i) {
        if (i < 0 || i > size) throw new IndexOutOfBoundsException("Index: " + i);
    }

    private Node<T> nodeAt(int i) {
        Node<T> x = head;
        for (int k = 0; k < i; k++) x = x.next;
        return x;
    }

    // --- Access and Replace ---
    public T get(int i) {
        checkIndexInclusive(i);
        return nodeAt(i).data;
    }

    public void set(int i, T x) {
        checkIndexInclusive(i);
        nodeAt(i).data = x;
    }

    // --- Insert ---
    public void insertAt(int i, T x) {
        checkIndexExclusive(i);
        if (i == 0) {
            head = new Node<>(x, head);
            if (size == 0) tail = head;
        } else if (i == size) {
            Node<T> n = new Node<>(x, null);
            if (isEmpty()) head = tail = n;
            else { tail.next = n; tail = n; }
        } else {
            Node<T> prev = nodeAt(i - 1);
            prev.next = new Node<>(x, prev.next);
        }
        size++;
    }

    // --- Remove ---
    public T removeAt(int i) {
        checkIndexInclusive(i);
        if (i == 0) {
            T val = head.data;
            head = head.next;
            if (--size == 0) tail = null;
            return val;
        }
        Node<T> prev = nodeAt(i - 1);
        Node<T> doomed = prev.next;
        prev.next = doomed.next;
        if (doomed == tail) tail = prev;
        size--;
        return doomed.data;
    }
}
