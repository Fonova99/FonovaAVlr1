public class Main {
    public static void main(String[] args) {

        MyLinkedList linkedList1 = new MyLinkedList();
        MyLinkedList linkedList2 = new MyLinkedList();
        System.out.println("ДВУСВЯЗНЫЙ СПИСОК");
        linkedList1.add(1);
        linkedList1.add(2);
        linkedList1.add(3);
        linkedList1.add(4);
        linkedList1.add(5);
        linkedList1.print();
        System.out.println("__________________");
        linkedList2.add(6);
        linkedList2.add(7);
        linkedList2.add(8);
        linkedList2.add(9);
        linkedList2.print();
        System.out.println("__________________");


        linkedList1.addAllLast(linkedList2);
        linkedList1.print();
        System.out.println("__________________");


//        linkedList.addFirst(7);
//        linkedList.print();
//        System.out.println("__________________");
//
//        linkedList.addLast(7);
//        linkedList.print();
//        System.out.println("__________________");
//
//        linkedList.removeLast();
//        linkedList.print();
//        System.out.println("__________________");
//
//        linkedList.removeFirst();
//        linkedList.print();
//        System.out.println("__________________");
//
//        linkedList.addForIndex(2, 5);
//        linkedList.print();
//        System.out.println("__________________");
//
//        System.out.println(linkedList.get(2));
//        System.out.println("__________________");
//
//        linkedList.removeAt(2);
//        linkedList.print();
//        System.out.println("__________________");
//
//        System.out.println(linkedList.size());
//        System.out.println("__________________");
//
//        linkedList.replaceElement(7,4);
//        linkedList.print();
//        System.out.println("__________________");
//
//        System.out.println(linkedList.isEmpty());
//        System.out.println("__________________");
//
//        linkedList.clear();
//        System.out.println(linkedList.isEmpty());
//        System.out.println("__________________");
    }
}