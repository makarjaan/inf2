package ru.itis.inf304;


public class Main {
    public static void main(String[] args) {
        try {
            ISet<String> list = new List304_2ImplAsSet<>();
            list.add("3");
            list.add("6");
            list.add("8");
            list.add("1");
            list.asList();
            list.delete(4);
            System.out.println(list.contains(3));
            System.out.println(list);

            IStack<Integer> list2 = new List304_2ImplAsStack<>();
            list2.add(4);
            list2.add(5);
            list2.add(1);
            list2.add(8);
            list2.pop();
            System.out.println(list2.size());
            System.out.println(list2.toString());

        } catch (RecurringElementException e) {
            System.err.println(e.getMessage());
        } catch (EmptyElementException e) {
            System.err.println(e.getMessage());
        }
    }
}
