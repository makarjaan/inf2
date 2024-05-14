package ru.itis.inf304;

import org.json.simple.JSONObject;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.*;
import java.util.*;

public class JsonMain {
    public static void main(String[] args) throws IOException {

        String path = "staples.json";
        String path2 = "staples2.json";
        JSONObject json = new JSONObject();
        JSONObject json2 = new JSONObject();

        json.put("staples", Arrays.asList("[", "{", "}", "]", "{", "}"));
        json2.put("staples2", Arrays.asList("斯会文 社 ═╬ ╬"));


        try (PrintWriter out = new PrintWriter(new FileWriter(path2))) {
            out.write(json2.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println(checkBrackets("C:\\Java\\infSecond\\staples2.json"));
        //System.out.println(checkBrackets("C:\\Java\\infSecond\\staples3.json"));
        //System.out.println(checkBrackets(""));


    }
    public static int checkBrackets(String filename) throws IOException{
        if (Objects.equals(filename, "")) throw new NullPointerException();
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filename))) {
            int c;
            Deque<Character> deque = new LinkedList<>();
            while ((c = dis.read()) != -1) {
                char chr = (char) c;
                if (!isTextSymbol(chr)) {
                    System.out.println(chr);
                    throw new RuntimeException("is not in the text format!");
                } else if (chr == '[' || chr == '{') {
                    deque.push(chr);
                } else if (chr == '}' || chr == ']') {
                    char tmp = deque.pop();
                    if (!(chr == '}' & tmp == '{' || chr == ']' & tmp == '[')) {
                        return 0;
                    }
                }
            }
            if (!deque.isEmpty()) {
                return 0;
            }
        } catch (IOException e) {
            throw new FileNotFoundException();
        }
        return 1;
    }

    private static boolean isTextSymbol(char symbol) {
        return String.valueOf(symbol).matches("^[A-Za-zА-Яа-яЁё0-9\\{\\}\\[\\].,:;\"\\r\\n ]$");
    }
}
