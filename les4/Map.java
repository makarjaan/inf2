package ru.itis.inf304.les4;

import ru.itis.inf304.EmptyElementException;

import java.util.*;

public class Map<K,V> implements MapInf304<K,V> {

    //Set<K> и List<V>
    private Object[] masK;
    private Object[] masV;
    private int size;

    public Map() {
        masK = new Object[6];
        masV = new Object[6];
        size = 0;
    }

    @Override
    public V put(K key, V value) throws EmptyElementException{
        if (key == null || value == null) throw new EmptyElementException();
        if (size == masK.length ) {
            Object[] tempK = new Object[masK.length * 3];
            Object[] tempV = new Object[masK.length * 3];
            System.arraycopy(masK, 0, tempK,0,masK.length);
            masK = tempK;
            System.arraycopy(masV, 0, tempV,0,masV.length);
            masV = tempV;
        }
        if (size == 0) {
            masK[0] = key;
            masV[0] = value;
            size++;
            return null;
        }
        if (!unic(key)) {
            for (int i = 0; i < size; i++) {
                if (masK[i].equals(key)) {
                    V current = (V) masV[i];
                    masV[i] = value;
                    return current;
                }
            }
        } else {
            masV[size] = value;
            masK[size] = key;
            size++;
            return null;
        }
        return null;
    }

    @Override
    public String toString() {
        return "Map{" +
                "masK=" + Arrays.toString(masK) +
                ", masV=" + Arrays.toString(masV) +
                ", size=" + size +
                '}';
    }

    public boolean unic(K key){
        for (int i = 0; i < size; i++){
            if (masK[i].equals(key)){
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        K that = (K) o;
        return that == this;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (masK[i].equals(key)) {
               return (V) masV[i];
            }
        }
        return null;
    }

    @Override
    public V remove(K key) {
        for (int i = 0; i < size; i++) {
            if (key.equals(masK[i])) {
                V current = (V) masV[i];
                masV[i] = null;
                masK[i] = null;
                size--;
                return current;
            }
        }
        return null;
    }

    @Override
    public boolean containsKey(K key) {
        for (int i = 0; i < size; i++) {
            if (key.equals(masK[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Collection<V> values() {
        List<V> list = new ArrayList<>();
        Collections.addAll(list, (V) masV);
        return list;
    }

    @Override
    public Set<K> keySet() {
        Set<V> list = new HashSet<>();
        Collections.addAll(list, (V) masK);
        return (Set<K>) list;
    }
}
