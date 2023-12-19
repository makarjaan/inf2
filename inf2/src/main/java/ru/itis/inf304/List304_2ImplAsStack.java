package ru.itis.inf304;


public class List304_2ImplAsStack<T> implements IStack<T> {
    private Element<T> current;
    private Element<T> head;
    private int size;
    public void pop(){
        current = this.head;
        for (int i = 0; i < (size - 1); i++) {
            current = current.next;
        }
        size--;
    }

    public void add(T e) throws EmptyElementException {
        if (e == null) throw new EmptyElementException();

        if (head == null) {
            head = new Element<T>(e);
            head.next = null;
        } else {
            current = head;
            for (int i = 0; i < size - 1; i++) {
                current = current.next;
            }
            current.next = new Element<>(e);
        }
        size++;
    }

    public int size(){
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Element<T> current = head;
        for (int i = 0; i < size; i++) {
            if (i == size - 1) sb.append(current.value);
            else sb.append(current.value).append(", ");
            current = current.next;
        }
        return sb.toString();
    }
}
