package ru.itis.inf304;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class MainSecond {
    public static void main(String[] args) {
        try {
            String[] lst = {"аарррарии"};
            OutputStream str1 = new FileOutputStream("num2.txt");
            for (String s : lst) {
                str1.write(s.getBytes(StandardCharsets.UTF_8));
            }
            str1.flush();

            FileReader reader = new FileReader("C:\\Java\\infSecond\\num2.txt");
            Map<Character, Integer> map = new HashMap<>();
            int i;
            while ((i = reader.read()) != -1) {
                if (map.containsKey((char) i)) {
                    int count = map.get((char) i);
                    map.put((char) i, count + 1);
                } else {
                    map.put((char) i , 1);
                }
            }

            Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Character, Integer> elem = iterator.next();
                String key = String.valueOf(elem.getKey());
                String value = String.valueOf(elem.getValue());
                System.out.println(key + ":" + value);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
