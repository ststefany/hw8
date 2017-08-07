/*Прочитать строки из файла и поменять местами первое и последнее слова в каждой строке.*/

import helpers.FileDataToStringMapper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task10 {
    private static final String PATH = "src/Task10.java";

    public static void main(String[] args) {
        switchFirstAndLastWordInLine();
    }


    public static void switchFirstAndLastWordInLine(){

        String result = FileDataToStringMapper.map(PATH);
        if (result == null || result.isEmpty()) {
            System.err.println("File contains no data.");
            return;
        }
        System.out.println(result);
        String[] strings = result.split("\n");


        Pattern pattern = Pattern.compile("[а-яА-ЯёЁa-zA-Z]+");


        Matcher matcher;
        String first = "";
        String last = "";

        StringBuffer buffer = new StringBuffer();

        for(String s : strings) {
            matcher = pattern.matcher(s);
            if (matcher.find()) {
            first = matcher.group();}
            matcher.reset(s);
            while (matcher.find()) {last = matcher.group();}
            s = s.replace(first, "THISSHOULDBELAST");
            s = s.replace(last, first);
            s = s.replace("THISSHOULDBELAST", last);
            buffer.append(s);
            buffer.append("\n");
            matcher.reset();
        }

        System.out.println(buffer);

    }

}
