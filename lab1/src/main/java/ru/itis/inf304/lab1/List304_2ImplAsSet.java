package ru.itis.inf304.lab1;

import java.util.Arrays;
import java.util.Objects;

public class List304_2ImplAsSet<T> implements ISet<T> {

    private Object[] mass;
    private int size;

    public List304_2ImplAsSet() {
        mass = new Object[4];
        size = 0;
    }

    public void add(T e) throws RecurringElementException {
        if (size == 0) mass[size] = (T) e;
        if (size == mass.length + 1) {
            Object[] temp = new Object[mass.length * 3];
            System.arraycopy(mass, 0, temp, 0, mass.length);
            mass = temp;
        }
        if (Check(e) != null) {
            mass[size++] = (T) e;
        }
    }

    public Object[] asList(){
        return mass;
    }

    //3681259
    public void delete(int index){
        Object[] temp = new Object[mass.length - 1];
        System.arraycopy(mass,0, temp,0, index - 1);
        System.arraycopy(mass, index , temp, index - 1, mass.length - index);
        mass = temp;
    }

    public T Check(T e) throws RecurringElementException {
        for (int i = 0; i < size; i++) {
            if (mass[i] == e) {
                throw new RecurringElementException();
            }
        }
        return e;
    }

    public String toString(){
        return Arrays.toString(mass);
    }

    public boolean contains(Object e){
        for (int i = 0; i < mass.length; i++) {
            if (mass[i].equals(e) ) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        T two = (T) o;
        return two == o;
    }


}