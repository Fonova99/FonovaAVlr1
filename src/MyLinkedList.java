import java.util.Random;
import java.util.Scanner;

public class MyLinkedList {
    private Node head;
    private Node tail;
    private int size = 0;
    private static class Node {
        int data;
        Node next;
        Node previous;
        public Node(int data) {
            this.data = data;
        }
    }
    public void add(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
        size++;
    }
    public void addLast(int data) {
        Node newNode = new Node(data);
        // Если список пустой
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
        size++;
        print();
    }
    public void addFirst(int data) {
        Node newNode = new Node(data);
        // Если список пустой
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head; // Устанавливаем ссылку next нового узла на текущую голову списка
            head.previous = newNode; // Устанавливаем ссылку prev текущей головы списка на новый узел
            head = newNode; // Новый узел становится новой головой списка
        }
        size++;
        print();
    }
    public void removeLast() {
        if (head == null) {
            System.out.println("Список пуст.");
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
            return;
        }
        tail = tail.previous;
        tail.next = null;
        size--;
        print();
    }
    public void removeFirst() {
        if (head == null) {
            System.out.println("Список пуст.");
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
            return;
        }
        head = head.next;
        head.previous = null;
        size--;
        print();
    }
    public void addByIndex(int index, int data) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node newNode = new Node(data);
        if (index == 0) {
            add(data);
        }
        if (index == size) {
            tail = newNode;
            tail.next = newNode;
        }
        Node oldNode = head;
        for (int i = 0; i < index; i++) {
            oldNode = oldNode.next;
        }
        Node oldPrevious = oldNode.previous;
        oldPrevious.next = newNode;
        oldNode.previous = newNode;

        newNode.previous = oldPrevious;
        newNode.next = oldNode;
        size++;
        print();
    }
    public int getByIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node current = head;
        int counter = 0;

        while (current != null && counter != index) {
            current = current.next;
            counter++;
        }
        System.out.println(current.data);
        return current.data;

    }
    public void removeByIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            head = head.next;
            if (head == null) {
                tail = null;
            } else {
                head.previous = null;
            }
        } else if (index == size - 1) {
            tail = tail.previous;
            tail.next = null;
        } else {
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            current.previous.next = current.next;
            current.next.previous = current.previous;
        }
        size--;
        print();
    }
    public int size() {
        System.out.println(size);
        return size;
    }
    public void clear() {
        head = null;
        tail = null;
        size = 0;
        System.out.println("The list is empty");
    }
    public void replaceElementByIndex(int index, int value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node current = head;
        int count = 0;
        while (current != null) {
            if (count != index) {
                current = current.next;
                count++;
            } else {
                current.data = value;
                break;
            }
        }
        print();
    }
    public boolean isEmpty() {
        if (size != 0) {
            System.out.println("The list is not empty");
            return false;
        } else {
            System.out.println("The list is empty");
            return true;
        }
    }
    public void reverse() {
        if (head == null) {
            return;
        }
        Node current = head;
        Node temp = null;

        while (current != null) {
            temp = current.previous;
            current.previous = current.next;
            current.next = temp;
            current = current.previous;
        }
        // Обмен головы и хвоста
        temp = head;
        head = tail;
        tail = temp;
        print();
    }
    public void insertListByIndex(int index, MyLinkedList list) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        if (list.head == null) {
            return; // если вставляемый список пустой, нет действий
        }
        Node listHead = list.head;
        Node listTail = list.tail;

        if (index == 0) {
            addAllFirst(list);
        } else if (index == size) {
            addAllLast(list);
        } else { // Вставка в середину списка. Найдем узел, после которого будем вставлять другой список
            Node currentNode = head;
            int count = 0;
            while (currentNode != null) {
                if (count != index) {
                    currentNode = currentNode.next;
                    count++;
                } else {
                    Node nextNode = currentNode.next;

                    currentNode.next = listHead;
                    listHead.previous = currentNode;

                    listTail.next = nextNode;
                    nextNode.previous = listTail;

                    break;
                }
            }
        }
        size += list.size;
        print();
    }
    public void addAllLast(MyLinkedList list) {
            if (list.head == null) {
                return;
            }
            Node listHead = list.head;
            if (head == null) {
                head = listHead;
                tail = list.tail;
            } else {
                listHead.previous = null;
                list.tail.next = head;
                head.previous = list.tail;
                head = listHead;
            }
            print();
            size += list.size;
        }
    public void addAllFirst(MyLinkedList list) {
        if (list.head == null) {
            return;
        }

        Node listHead = list.head;
        if (head == null) {
            head = listHead;
            tail = list.tail;
        } else {
            tail.next = listHead;
            listHead.previous = tail;
            tail = list.tail;
        }
        print();
        size += list.size;
    }
    public boolean contains(MyLinkedList list) {
        Node current = head;
        Node subCurrent = list.head;
        while (current != null && subCurrent != null) {
            if (current.data != subCurrent.data) {
                current = current.next;
            } else {
                current = current.next;
                subCurrent = subCurrent.next;
            }
        }
        return subCurrent == null;
    }
    public int searchFirst(MyLinkedList list) {
        Node current = head;
        Node secCurrent = list.head;

        while (current != null) {
            if (current.data == secCurrent.data) {
                Node tempFirst = current;
                Node tempSecond = secCurrent;

                while (tempFirst != null && tempSecond != null) {
                    if (tempFirst.data != tempSecond.data) {
                        break;
                    }
                    tempFirst = tempFirst.next;
                    tempSecond = tempSecond.next;
                }
                if (tempSecond == null) {
                    return current.data;
                }
            }
            current = current.next;
        }
        System.out.println("Список не найден");
        return -1;
    }
    public int searchLast(MyLinkedList list) {
        Node current = head;
        Node secCurrent = list.tail;

        while (current != null) {
            if (current.data == secCurrent.data) {
                Node tempFirst = current;
                Node tempSecond = secCurrent;

                while (tempFirst != null && tempSecond != null) {
                    if (tempFirst.data != tempSecond.data) {
                        break;
                    }
                    tempFirst = tempFirst.next;
                    tempSecond = tempSecond.next;
                }
                if (tempSecond == null && tempFirst == null) {
                    return current.data;
                }
            }
            current = current.next;
        }
        System.out.println("Список не найден");
        return -1;
    }
    public void swap(int index1, int index2) {
        // Проверяем, что список не пуст и индексы валидны
        if (head == null || index1 < 0 || index1 >= size || index2 < 0 || index2 >= size) {
            return;
        }
        // Если индексы одинаковые, ничего не делаем
        if (index1 == index2) {
            return;
        }
        // Находим первый элемент для обмена
        Node currNode1 = head;
        for (int i = 0; i < index1; i++) {
            currNode1 = currNode1.next;
        }
        // Находим второй элемент для обмена
        Node currNode2 = head;
        for (int i = 0; i < index2; i++) {
            currNode2 = currNode2.next;
        }
        // Обмениваем значения элементов
        Object temp = currNode1.data;
        currNode1.data = currNode2.data;
        currNode2.data = (int) temp;
        print();
    }
    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data);
            current = current.next;
        }
        System.out.println();
    }
}
