public class Main {
    public static void main(String[] args) {
        ListADT<Integer> list = new ArrayListADTImpl<>(2);

        list.insert(10, 0); // [10]
        list.insert(20, 1); // [10, 20]
        list.insert(30, 2); // [10, 20, 30] (resize)
        list.insert(15, 1); // [10, 15, 20, 30]

        System.out.println(list);           // [10, 15, 20, 30]
        System.out.println(list.access(2)); // 20

        list.replace(99, 1);                // [10, 99, 20, 30]
        System.out.println(list);

        list.remove(2);                     // remove 20 -> [10, 99, 30]
        System.out.println(list);

        System.out.println("size = " + list.size()); // 3
    }
}
