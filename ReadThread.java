package makarova.kontr;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ReadThread implements Runnable {
    public String FileName;

    public ReadThread(String fileName) throws FileNotFoundException {
        this.FileName = "C:\\Java\\infSecond\\Kontrolnaya\\src\\main\\java\\makarova\\kontr\\cw2\\v14\\" + fileName;
    }


    int k; // размер в байтах строки в формате UTF-8
    String s; // строка с данными
    int d; // контрольное число - количество символов в строке с данными
    int p; // номер части
    int count;

    public void readFile() {

        try (FileInputStream is = new FileInputStream(FileName);
             DataInputStream dis = new DataInputStream(is)) {

            k = dis.readInt();

            byte[] messageBytes = new byte[k];
            dis.readFully(messageBytes);

            s = new String(messageBytes);

            d = dis.readInt();

            p = dis.readInt();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


    @Override
    public void run() {
        readFile();
        count = s.length();
        if (d != count) {
            System.out.println("несоответсвие количества символов в файле");
        }
        writeLog();
    }


    FileOutputStream outputStream = new FileOutputStream("v14.txt");
    public void writeLog() {
        synchronized (ReadThread.class) {
            try (FileWriter writer = new FileWriter("v14.log", true)) {
                writer.write("Прочитали файл " + FileName + " кол-во байт данных: " + k + " кол-во считанных символов: " +
                        count + " контрольное число: " + d + " номер части: " + p + "\n");
                writer.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                outputStream.write(s.getBytes());
                outputStream.write("\n".getBytes());
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}




