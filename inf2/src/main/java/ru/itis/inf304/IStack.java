package ru.itis.inf304;

public interface IStack<T> {
    void pop();
    void add(T e) throws EmptyElementException;
    int size();
}
