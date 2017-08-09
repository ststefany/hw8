/*Сохранить в файл, связанный с выходным потоком, записи о телефонах и их владельцах. Вывести в
файл записи, телефоны которых начинаются на k и на j.*/

import interfaces.TaskInterface;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class Task13 implements TaskInterface {
    static private Map<String, String> map = new HashMap<>();


    static {
        map.put("John", "k3j");
        map.put("Paul", "jy");
        map.put("Col", "3j");
        map.put("Mary", "");
        map.put("Perry", "3j");
        map.put("Lucas", "j");
    }

    public Boolean complete(String stringPath) {
        writeDataInFile(map, stringPath);
        return true;
    }

    private static void writeDataInFile(Map<String, String> map, String stringPath) {

        try (FileOutputStream stream = new FileOutputStream(new File(stringPath))) {
            System.setOut(new PrintStream(stream));
            System.out.println("Owner name      Phone");
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (!entry.getValue().isEmpty() && (entry.getValue().charAt(0) == 'k' || entry.getValue().charAt(0) == 'j'))
                    System.out.println(entry.getKey() + "      " + entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
