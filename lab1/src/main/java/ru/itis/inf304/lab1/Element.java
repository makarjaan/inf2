package ru.itis.inf304.lab1;

public class Element<T> {
    public T value;
    public Element<T> next;

    public Element(T value){
        this.value = value;
    }
}
