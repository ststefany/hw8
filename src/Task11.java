/*Ввести из текстового файла, связанного с входным потоком, последовательность строк. Выбрать и
сохранить m последних слов в каждой из последних n строк.*/

import helpers.FileDataToStringMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task11 {

    public static String saveMWordsInNLines(int m, int n, String stringPath) {
        StringBuilder builder = new StringBuilder();
        Pattern word = Pattern.compile("[а-яА-ЯёЁa-zA-Z]+");

        String data = FileDataToStringMapper.map(stringPath);

        if(data == null || data.isEmpty()) {
            System.err.println("File is empty");
            return null;
        }


        String[] lines = data.split("\n");

        for (int i = lines.length-n; i < lines.length; i++) {
            if (lines[i] == null || lines[i].isEmpty()) {
                builder.append("...");
                builder.append("\n");
                continue;}
            Matcher matcher = word.matcher(lines[i]);

            List<String> words = new ArrayList<>();

            while (matcher.find()) {
                words.add(matcher.group());
            }


            for (int j = words.size()-m; j < words.size(); j++) {
                    builder.append(words.get(j));
                    builder.append(" ");
                }
            builder.append("\n");
        }
        System.out.println(builder);

        return builder.toString();
    }

}
