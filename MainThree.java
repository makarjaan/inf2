package ru.itis.inf304;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class MainThree {
    public static void main(String[] args) {
        String mes = "hello my name arina";
        try (OutputStream os = new FileOutputStream("three.txt");
            DataOutputStream dos = new DataOutputStream(os)) {
            byte[] b = mes.getBytes();

            dos.writeInt(b.length);

            for (int n : b) {
                dos.write(n);
            }
            dos.flush();

            System.out.println("всё");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (FileInputStream is = new FileInputStream("three.txt");
             DataInputStream dis = new DataInputStream(is)) {

            int messageLength = dis.readInt();
            System.out.println("Длина сообщения: " + messageLength);

            byte[] messageBytes = new byte[messageLength];
            dis.readFully(messageBytes);

            String message = new String(messageBytes);
            System.out.println("Прочитанное сообщение: " + message);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
