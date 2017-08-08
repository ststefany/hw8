/*Сохранить в файл, связанный с выходным потоком, записи о телефонах и их владельцах. Вывести в
файл записи, телефоны которых начинаются на k и на j.*/
package task13;

import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

        public class Task13 {
            static private Map<String, String> map = new HashMap<>();


            static {
                map.put("John", "k3j");
                map.put("Paul", "jy");
                map.put("Col", "3j");
                map.put("Mary", "");
                map.put("Perry", "3j");
                map.put("Lucas", "j");
            }


            public static void main(String[] args) {
                writeDataInFile(map, new File("src/resources/Task13"));
            }

            static void writeDataInFile(Map<String, String > map, File file) {

                try(FileOutputStream stream = new FileOutputStream(file)) {
                    System.setOut(new PrintStream(stream));
                    System.out.println("Owner name      Phone");
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        if (!entry.getValue().isEmpty() && (entry.getValue().charAt(0)=='k' || entry.getValue().charAt(0)=='j'))
                        System.out.println(entry.getKey() + "      " + entry.getValue());
                    }
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }


}
