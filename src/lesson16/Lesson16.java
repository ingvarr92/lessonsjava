package lesson16;

import java.io.*;

public class Lesson16 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        File file = new File("stat.bin");
//        LaunchStat stat;
//        if (!file.exists()){
//            stat = new LaunchStat();
//        } else {
//            try (ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(file))){
//                stat = (LaunchStat) objIn.readObject();
//            }
//        }
//        if (stat.isFirstLaunch()){
//            System.out.println("Первый запуск!");
//        } else {
//            System.out.println(stat);
//        }
//        stat.update();
//
//        // сохранение
//
//        try (ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(file))){
//            objOut.writeObject(stat);
//        }

        File file = new File ("stat2.bin");
        LaunchStatExternalizable stat;
        if (!file.exists()){
            stat = new LaunchStatExternalizable();
        } else {
            try (ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(file))){
                stat = (LaunchStatExternalizable) objIn.readObject();
            }
        }
        if (stat.isFirstLaunch()){
           System.out.println("Первый запуск!");
       } else {
           System.out.println(stat);
        }

        stat.update();

        // сохранение
        try (ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(file))) {
            objOut.writeObject(stat);
        }


    }


}
