package ru.itis.inf304;

public class Main {
    public static void main(String[] args) throws EmptyElementException {
        List304ImplAsLinkedList list = new List304ImplAsLinkedList();
        list.add(3);
        list.add(6);
        list.add(2);
        list.add(8);
        list.add(3);
        System.out.println(list.toString());
        System.out.println("элемент связного списка с индексом 3: " + list.get(3));
        System.out.println("размер списка: " + list.size());
        list.delete(2);
        System.out.println(list.toString());
        System.out.println("последний элемент в списке: " + list.pop());
        System.out.println(list.toString());

        System.out.println();

        List304ImplAsArray list2 = new List304ImplAsArray();
        list2.add(2);
        list2.add(6);
        list2.add(4);
        list2.add(7);
        list2.add(8);
        list2.add(3);
        System.out.println(list2.toString());
        System.out.println("элемент в списке под индексом 3: " + list2.get(3));
        list2.delete(3);
        System.out.println(list2.toString());
        System.out.println("последний элемент в списке массива: " + list2.pop());
        System.out.println(list2.toString());
        System.out.println("размер = " + list2.size());

    }
}
