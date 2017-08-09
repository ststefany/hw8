/*Из текстового файла ввести последовательность строк. Выделить отдельные слова, разделяемые
пробелами. Написать метод поиска слова по образцу-шаблону. Вывести найденное слово в другой
файл.*/
import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import helpers.FileDataToStringMapper;
import helpers.StringToFileWriter;
import interfaces.TaskInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class Task12 implements TaskInterface{
    final static String OUTPUT = "src/resources/Task12Output.txt";


    public Boolean complete(String stringPath) {
        String template = "";
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Enter template for a word you're looking for");
             template = reader.readLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        if (template == null || template.isEmpty()) {
            System.err.println("Nothing to search for");
            return false;}

        findWordsWithTemplate(stringPath, template);
        return true;
    }

    static void findWordsWithTemplate(String stringPath, String template) {
        String data = FileDataToStringMapper.map(stringPath);
        if (data == null || data.isEmpty()) {
            System.err.println("File is empty");
            return;
        }

        Pattern templatePattern = Pattern.compile(template);
        Pattern wordPattern = Pattern.compile("[а-яА-ЯёЁa-zA-Z]+");

        Matcher matcher = wordPattern.matcher(data);

        StringBuilder builder = new StringBuilder();

        while (matcher.find()) {
            builder.append(matcher.group());
            builder.append(" ");}

        matcher = templatePattern.matcher(builder.toString());

        if (matcher.find()) {
            StringToFileWriter.write(OUTPUT, matcher.group()); }
    }


}
