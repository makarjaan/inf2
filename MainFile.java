package ru.itis.inf304.lab7;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class MainFile {

    public static void main(String[] args) {
        try {
            FileWriter pw1 = new FileWriter("textfile1.txt");
            pw1.write("всем здравствуйте");
            pw1.close();

            FileWriter pw2 = new FileWriter("textfile2.txt");
            pw2.write("всем до свидания");
            pw2.close();

            FileReader f1 = new FileReader("textfile1.txt");
            FileReader f2 = new FileReader("textfile2.txt");
            Merge2(f1, f2);


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String Merge1(FileInputStream first, FileInputStream second) {
        try {
            FileOutputStream fileResult = new FileOutputStream("result.txt");
            int x1;
            while ((x1 = first.read()) != -1) {
                fileResult.write(x1);
            }
            while ((x1 = second.read()) != -1) {
                fileResult.write(x1);
            }


            ArrayList<Character> list = new ArrayList<>();
            FileReader fr = new FileReader("result.txt");
            int x2;
            while ((x2 = fr.read()) != -1) {
                list.add((char) x2);
            }
            return list.toString();


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String Merge2(FileReader file1, FileReader file2) {
        try {
            FileWriter result = new FileWriter("result2.txt");
            int i;
            while ((i = file1.read()) != -1) {
                result.write(i);
            }
            while ((i = file2.read()) != -1) {
                result.write( i );
            }

            ArrayList<Character> list2 = new ArrayList<>();
            FileReader fr = new FileReader("result2.txt");
            int x3;
            while ((x3 = fr.read()) != -1) {
                list2.add((char) x3);
            }
            return list2.toString();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}


