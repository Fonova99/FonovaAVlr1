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
            newNode.next = null;
            newNode.previous = null;
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
    }
    public void addForIndex(int index, int data) {
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
    }
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }
    public void removeAt(int index) {
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
    }
    public int size() {
        return size;
    }
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }
    public void replaceElement(int index, int value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node current = head;

        for (int i = 0; i < size; i++) {
            if (i == index) {
                current.data = value;
                break;
            }
            current = current.next;
        }
    }
    public boolean isEmpty() {
        if (size != 0) {
            return false;
        } else {
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
    }
    public void addAllLast(MyLinkedList list) {
        if (list.head == null) {
            return; // Если второй список пуст, ничего не делаем
        }
        if (head == null) {
            // Если текущий список пуст, просто копируем второй список
            head = list.head;
            tail = list.tail;
        } else {
            // Устанавливаем следующий элемент последнего узла текущего списка на голову второго списка
            tail.next = list.head;
            list.head.previous = tail;
            tail = list.tail;
        }
        size += list.size();
    }
    public void addAllFirst(MyLinkedList list) {
        if (list.head == null) {
            return; // Если второй список пуст, ничего не делаем
        }
        if (head == null) {
            // Если текущий список пуст, просто копируем второй список
            head = list.head;
            tail = list.tail;
        }
        // Находим последний узел первого списка
        Node lastNode = head;
        while(lastNode.next != null) {
            lastNode = lastNode.next;
        }
        // Присваиваем последнему узлу первого списка ссылку на первый узел второго списка
        lastNode.next = list.head;
        list.head.previous = lastNode;
    }


    public void print() {
        Node currentNode = head;

        if (head != null) {
            System.out.println(head.data);
        }

        while(currentNode.next != null) {
            currentNode = currentNode.next;
            System.out.println(currentNode.data);
        }
    }

}
