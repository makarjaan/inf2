package ru.itis.inf304.les4;
import ru.itis.inf304.EmptyElementException;

public class Main {
    public static void main(String[] args) {
        try{
            Map<Integer, String> list = new Map<>();
            list.put(2,"s");
            list.put(4, "a");
            list.put(7, "c");
            list.put(7, "w");
            list.put(8, "z");
            list.put(4, "i");
            list.put(1, "t");
            list.put(2, "p");
            list.put(9, "l");
            System.out.println(list.toString());
            System.out.println(list.get(8));
            System.out.println(list.remove(2));
            System.out.println(list.toString());
            System.out.println(list.containsKey(3));

        } catch (EmptyElementException e){
            System.err.println(e.getMessage());
        }
    }
}
