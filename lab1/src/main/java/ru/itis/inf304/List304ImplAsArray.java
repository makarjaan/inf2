package ru.itis.inf304;

import java.util.Arrays;

public class List304ImplAsArray implements List304{
    private Integer[] mass;
    private int size;

    public List304ImplAsArray(){
        mass = new Integer[6];
        size = 0;
    }
    @Override
    public void add(Integer e) throws EmptyElementException {
        if (e == null) throw new EmptyElementException();
        if (size == mass.length) {
            Integer[] temp = new Integer[mass.length * 3];
            System.arraycopy(mass, 0, temp, 0, mass.length);
            mass = temp;
            mass[size++] = e;
        } else {
            mass[size] = e;
            size++;
        }
    }

    @Override
    public Integer get(int index) throws IndexOutOfBoundsException{
        if (index >= mass.length) throw new IndexOutOfBoundsException();
        return mass[index];
    }
    @Override
    public void delete(int index) throws IndexOutOfBoundsException{
        if (index >= size) throw new IndexOutOfBoundsException();
        Integer[] mas2 = new Integer[mass.length - 1];
        System.arraycopy(mass, 0, mas2, 0, index);
        for (int i = index; i < mas2.length; i++) {
            mas2[i] = mass[i+1];
        }
        mass = mas2;
        size--;
    }
    @Override
    public int size(){
        return size;
    }
    @Override
    public Integer pop(){
        Integer[] mas2 = new Integer[mass.length - 1];
        System.arraycopy(mass, 0, mas2, 0, mass.length - 1);
        int a =  mass[mass.length - 1];
        mass = mas2;
        size--;
        return a;
    }

    @Override
    public String toString(){
        return Arrays.toString(mass);
    }
}
