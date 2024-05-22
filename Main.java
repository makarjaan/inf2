package makarova.kontr;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String folderPath = "C:\\Java\\infSecond\\Kontrolnaya\\src\\main\\java\\makarova\\kontr\\cw2\\v14";
        File folder = new File(folderPath);
        List<String> fileNames = new ArrayList<>();

        if (folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        fileNames.add(file.getName());
                    }
                }
            } else {
                throw new FileNotFoundException("файл не найден");
            }
        } else {
            throw new FileNotFoundException("папка не найдена");
        }


        List<Thread> fileThread = new ArrayList<>();
        for (int i = 0; i < fileNames.size(); i++) {
            fileThread.add(new Thread(new ReadThread(fileNames.get(i))));
        }

        for (int i = 0; i < fileNames.size(); i++) {
            fileThread.get(i).start();
        }


    }
}