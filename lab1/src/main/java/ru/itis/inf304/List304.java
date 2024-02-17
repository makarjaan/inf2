package ru.itis.inf304;

public interface List304 {
    void add(Integer e) throws EmptyElementException;
    Integer get(int index) throws IndexOutOfBoundsException;
    int size();
    void delete(int index) throws IndexOutOfBoundsException;
    Integer pop(); //возвращаем последний элемент и удаляем его из списка

}
