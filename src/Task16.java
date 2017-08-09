/*В файле содержится совокупность строк. Найти номера строк, совпадающих с заданной строкой. Имя
файла и строка для поиска – аргументы командной строки. Вывести строки файла и номера строк,
совпадающих с заданной.*/

import helpers.FileDataToStringMapper;
import interfaces.TaskInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Task16 implements TaskInterface {


    public List<Integer> complete(String string) {
        List<Integer> result = new ArrayList<>();
        String stringPath = "";
        String lineToFind = "";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Enter path to the file: ");
            stringPath = reader.readLine();

            System.out.println("Enter a line to find: ");
            lineToFind = reader.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }


        String data = FileDataToStringMapper.map(stringPath);

        if (data == null || data.isEmpty()) {
            System.err.println("File is empty or doesn't exist");
            return null;
        }


        if (!data.contains(lineToFind)) {
            System.out.println("There is no such line in the life");
            return null;
        }

        String[] lines = data.split("\n");

        for (int i = 0; i < lines.length; i++) {
            if (lines[i].equals(lineToFind))
                result.add(i);
        }

        System.out.println("Next lines match given line: " + result + 1);

        return result;
    }


}
