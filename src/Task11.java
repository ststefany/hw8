/*Ввести из текстового файла, связанного с входным потоком, последовательность строк. Выбрать и
сохранить m последних слов в каждой из последних n строк.*/

import helpers.FileDataToStringMapper;
import interfaces.TaskInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task11 implements TaskInterface {

    public String complete(String stringPath) {
        int words = 0;
        int lines = 0;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("How many last words would you like to find?");
            words = Integer.parseInt(reader.readLine());
            System.out.println("How many last lines would you like to parse?");
            lines = Integer.parseInt(reader.readLine());
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
            System.out.println("Try again");
        }

        return saveMWordsInNLines(words, lines, stringPath);
    }

    private String saveMWordsInNLines(int m, int n, String stringPath) {
        StringBuilder builder = new StringBuilder();
        Pattern word = Pattern.compile("[а-яА-ЯёЁa-zA-Z]+");

        String data = FileDataToStringMapper.map(stringPath);

        if (data == null || data.isEmpty()) {
            System.err.println("File is empty");
            return null;
        }

        //This is not a big deal, but for line separator character it is better to use System.getProperties("line.separator"); instead of "\n"
        String[] lines = data.split("\n");

        for (int i = lines.length - n; i < lines.length; i++) {
            if (lines[i] == null || lines[i].isEmpty()) {
                builder.append("...");
                //This is not a big deal, but for line separator character it is better to use System.getProperties("line.separator"); instead of "\n"
                builder.append("\n");
                continue;
            }
            Matcher matcher = word.matcher(lines[i]);

            List<String> words = new ArrayList<>();

            while (matcher.find()) {
                words.add(matcher.group());
            }


            for (int j = words.size() - m; j < words.size(); j++) {
                builder.append(words.get(j));
                builder.append(" ");
            }
            //This is not a big deal, but for line separator character it is better to use System.getProperties("line.separator"); instead of "\n"
            builder.append("\n");
        }
        System.out.println(builder);

        return builder.toString();
    }
}
