public class Main {
    public static void main(String[] args) {
        ListADT<Integer> myList = new LinkedListADTImpl<>();

        myList.insert(10, 0);   // [10]
        myList.insert(20, 1);   // [10, 20]
        myList.insert(5, 0);    // [5, 10, 20]

        System.out.println("Element at index 1: " + myList.access(1)); // 10
        myList.replace(99, 1);   // [5, 99, 20]
        myList.remove(2);        // [5, 99]

        System.out.println("Size = " + myList.size()); // 2
    }
}
