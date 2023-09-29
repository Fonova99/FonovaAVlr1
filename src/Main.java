import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        MyLinkedList linkedList1 = new MyLinkedList();
        MyLinkedList linkedList2 = new MyLinkedList();
        System.out.println("ДВУСВЯЗНЫЙ СПИСОК");

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Введите размерность первого списка: ");
        int sizeList1 = scanner.nextInt();
        for (int i = 0; i < sizeList1; i++) {
            int value = random.nextInt(10);
            linkedList1.add(value);
        }
        linkedList1.print();

        System.out.print("Введите размерность второго списка: ");
        int sizeList2 = scanner.nextInt();
        for (int i = 0; i < sizeList2; i++) {
            int value = random.nextInt(10);
            linkedList2.add(value);
        }
        linkedList2.print();

        int choice;
        int value;
        int index;
        int index1;
        int index2;
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1.Добавление в конец списка");
            System.out.println("2.Добавление в начало списка");
            System.out.println("3.Удаление последнего элемента");
            System.out.println("4.Удаление первого элемента");
            System.out.println("5.Добавление элемента по индексу");
            System.out.println("6.Получение элемента по индексу");
            System.out.println("7.Удаление элемента по индексу");
            System.out.println("8.Получение размера списка");
            System.out.println("9.Удаление всех элементов списка");
            System.out.println("10.Замена элемента по индексу на передаваемый элемент");
            System.out.println("11.Проверка на пустоту списка");
            System.out.println("12.Меняет порядок элементов в списке на обратный");
            System.out.println("13.Вставка другого списка в список, начиная с индекса");
            System.out.println("14.Вставка другого списка в конец");
            System.out.println("15.Вставка другого списка в начало");
            System.out.println("16.Проверка на содержание другого списка в списке");
            System.out.println("17.Поиск первого вхождения другого списка в список");
            System.out.println("18.Поиск последнего вхождения другого списка в список");
            System.out.println("19.Обмен двух элементов списка по индексам");
            System.out.println("20. Выйти из программы");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Добавление в конец списка\nВведите значение:");
                    value = sc.nextInt();
                    linkedList1.addLast(value);
                    break;
                case 2:
                    System.out.println("Добавление в начало списка\nВведите значение:");
                    value = sc.nextInt();
                    linkedList1.addFirst(value);
                    break;
                case 3:
                    System.out.println("Удаление последнего элемента:");
                    linkedList1.removeLast();
                    break;
                case 4:
                    System.out.println("Удаление первого элемента:");
                    linkedList1.removeFirst();
                    break;
                case 5:
                    System.out.println("Добавление элемента по индексу\nВведите индекс:\nВведите значение:");
                    index = sc.nextInt();
                    value = sc.nextInt();
                    linkedList1.addByIndex(index, value);
                    break;
                case 6:
                    System.out.println("Получение элемента по индексу\nВведите индекс:");
                    index = sc.nextInt();
                    linkedList1.getByIndex(index);
                    System.out.println("Время выполнения:");
                    break;
                case 7:
                    System.out.println("Удаление элемента по индексу\nВведите индекс:");
                    index = sc.nextInt();
                    linkedList1.removeByIndex(index);
                    break;
                case 8:
                    System.out.println("Получение размера списка:");
                    linkedList1.size();
                    break;
                case 9:
                    System.out.println("Удаление всех элементов списка:");
                    linkedList1.clear();
                    break;
                case 10:
                    System.out.println("Замена элемента по индексу на передаваемый элемент\nВведите индекс:\nВведите значение:");
                    index = sc.nextInt();
                    value = sc.nextInt();
                    linkedList1.replaceElementByIndex(index, value);
                    break;
                case 11:
                    System.out.println("Проверка на пустоту списка:");
                    linkedList1.isEmpty();
                    break;
                case 12:
                    System.out.println("Меняет порядок элементов в списке на обратный:");
                    linkedList1.reverse();
                    break;
                case 13:
                    System.out.println("Вставка другого списка в список, начиная с индекса\nВведите индекс:");
                    index = sc.nextInt();
                    linkedList1.insertListByIndex(index, linkedList2);
                    break;
                case 14:
                    System.out.println("Вставка другого списка в конец:");
                    linkedList1.addAllLast(linkedList2);
                    break;
                case 15:
                    System.out.println("Вставка другого списка в начало:");
                    linkedList1.addAllFirst(linkedList2);
                    break;
                case 16:
                    System.out.println("Проверка на содержание другого списка в списке:");
                    System.out.println(linkedList1.contains(linkedList2));
                    break;
                case 17:
                    System.out.println("Поиск первого вхождения другого списка в список:");
                    System.out.println(linkedList1.searchFirst(linkedList2));
                    break;
                case 18:
                    System.out.println("Поиск последнего вхождения другого списка в список:");
                    System.out.println(linkedList1.searchLast(linkedList2));
                    break;
                case 19:
                    System.out.println("Обмен двух элементов списка по индексам\nВведите первый индекс:\nВведите второй индекс:");
                    index1 = sc.nextInt();
                    index2 = sc.nextInt();
                    linkedList1.swap(index1, index2);
                    break;
                case 20:
                    System.exit(0);
                default:
                    System.out.println("Неправильный выбор");
            }
        }
    }
}