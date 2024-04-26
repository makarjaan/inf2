package ru.itis.inf304;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class MainFirst {
    public static void main(String[] args) {

        //1
        String[] lst = {"привет", " hello "};
        String[] lst2 = {"пока", " bye "};

        try{
            OutputStream str1 = new FileOutputStream("out1.txt");
            for (String s : lst) {
                str1.write(s.getBytes(StandardCharsets.UTF_8));
            }
            str1.flush();
            OutputStream str2 = new FileOutputStream("out2.txt");
            for (String s : lst2) {
                str2.write(s.getBytes(StandardCharsets.UTF_8));
            }
            str2.flush();




            FileOutputStream one = new FileOutputStream(String.valueOf(args[0]));
            FileInputStream two = new FileInputStream(String.valueOf(args[1]));
            FileInputStream three = new FileInputStream(String.valueOf(args[2]));

            Merge(one, two, three);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    //1
    public static void Merge(FileOutputStream fileResult, FileInputStream first, FileInputStream second) {
        try {
            int x1;
            while ((x1 = first.read()) != -1) {
                fileResult.write(x1);
            }
            while ((x1 = second.read()) != -1) {
                fileResult.write(x1);
            }
            System.out.println("всё");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
