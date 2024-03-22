package ru.itis.inf304.les4;

import java.util.Collection;
import java.util.Set;
import ru.itis.inf304.EmptyElementException;

public interface MapInf304<K,V> {
    // перезаписываем значение KEY, put возвращаем старое значени, если Key повторяется и null если нет повторов
    V put(K key, V value) throws EmptyElementException; //
    V get(K key); //по индексу возвращаем значение элемента
    V remove(K key); //возвращаем удалённое значение
    boolean containsKey(K key);
    Collection<V> values(); //может дублироваться
    Set<K> keySet(); //Set ибо ключи не могут повторяться
}
