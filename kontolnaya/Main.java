package ru.itis.inf304.kontolnaya;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("C:\\Java\\infSecond\\inf2\\src\\main\\java\\ru\\itis\\inf304\\kontolnaya\\schedule.txt"));
        List<String> list = new ArrayList<>();
        while (scanner.hasNext()) {
            list.add(scanner.nextLine());
        }
        scanner.close();

        Map<String, List<Program>> map = new HashMap<String, List<Program>>();
        for (int i = 0; i < list.size(); i++) {
            Program program = new Program();
            List<Program> aff = new ArrayList<>();
            if (list.get(i).contains("#")) {
                program.setChannelName(list.get(i));
                for (int j = i + 1; list.get(j).contains(":"); j++){
                    program.setTime(new BroadcastsTime(list.get(j)));
                    program.setChannelName(list.get(j+1));
                    aff.add(program);
                }
                map.put(program.getTime().toString(), aff);
            }
        }

        List<String> allPrograms = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).contains("#") && !list.get(i).contains(":")) {
                allPrograms.add(list.get(i));
            }
        }
        System.out.println(allPrograms);



        //программы, идущие сейчам
        List<String> currentPrograms = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("18:20")) {
                currentPrograms.add(list.get(i + 1));
            }
        }
        System.out.println(currentPrograms);


        //кол-во программ по названию
        int count = 0;
        String searchName = "Мужики!..";
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(searchName)) {
                count++;
            }
        }
        System.out.println(count);

        //программы определённого канала
        List<String> currentPrograms2 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("Матч!")){
                int j = i +1;
                if (!list.get(j).contains("#")){
                    if (list.get(j).equals("19:35")) {
                        currentPrograms2.add(list.get(j + 1));
                    }
                }
            }
        }
        System.out.println(currentPrograms2);


        String a = "13:45";
        String b = "18:23";
        List<String> newList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(a)) {
                int j = i +1;
                if (!list.get(j).contains("#")) {
                    if (!list.get(j).equals(b)) {
                        newList.add(list.get(j));
                    }
                }
            }
        }
        System.out.println(newList);


    }
}
