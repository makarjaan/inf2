package ru.itis.inf304;

public interface ISet<T> {
    void add(T e) throws RecurringElementException;
    T Check(T e) throws RecurringElementException;
    Object[] asList();
    void delete(int index);
    boolean contains(Object e);

}
