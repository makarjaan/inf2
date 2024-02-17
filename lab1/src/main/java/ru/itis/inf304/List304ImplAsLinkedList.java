package ru.itis.inf304;

import java.util.Arrays;

public class List304ImplAsLinkedList implements List304{
    private int size;
    private Element current;
    private Element head;
    @Override
    public void add(Integer e) throws EmptyElementException {
        if (e == null) throw new EmptyElementException();

        if (head == null) {
            head = new Element(e);
            head.next = null;
            size = 1;
        } else {
            current = head;
            for (int i = 0; i < size - 1; i++) {
              current = current.next;
            }
            current.next = new Element(e);
            size++;
        }
    }

    @Override
    public String toString() {
        int[] lincked_list = new int[size];
        current = head;
        for (int i = 0; i < size; i++) {
            lincked_list[i] = current.value;
            current = current.next;
        }
        return "связный список : " + Arrays.toString(lincked_list);
    }

    @Override
    public Integer get(int index) throws IndexOutOfBoundsException{
        if (index >= size) throw new IndexOutOfBoundsException();
        current = this.head;
        int count = 0;
        while (count < index) {
            current = current.next;
            count ++;
        }
        return current.value;
    }

    @Override
    public void delete(int index) throws IndexOutOfBoundsException{
        if (index >= size) throw new IndexOutOfBoundsException();
        if (index == (size - 1)) {
            size--;
        }
        if (index < (size - 2)) {
            current = this.head;
            int count = 0;
            while (count < index - 2) {
                current = current.next;
                count++;
            }
            current.next = current.next.next;
            size--;
        }
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public Integer pop(){
        current = this.head;
        for (int i = 0; i < (size - 1); i++) {
            current = current.next;
        }
        size--;
        return current.value;
    }


}
