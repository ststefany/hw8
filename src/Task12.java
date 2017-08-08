/*Из текстового файла ввести последовательность строк. Выделить отдельные слова, разделяемые
пробелами. Написать метод поиска слова по образцу-шаблону. Вывести найденное слово в другой
файл.*/
import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import helpers.FileDataToStringMapper;
import helpers.StringToFileWriter;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class Task12 {

    public static void findWordsWithTemplate(String stringFile, String outPutFile, String template) {
        Pattern templatePattern = Pattern.compile(template);
        Pattern wordPattern = Pattern.compile("[а-яА-ЯёЁa-zA-Z]+");

        String data = FileDataToStringMapper.map(stringFile);
        if (data == null || data.isEmpty()) {
            System.err.println("File is empty");
            return;
        }

        Matcher matcher = wordPattern.matcher(data);

        StringBuilder builder = new StringBuilder();

        while (matcher.find()) {
            builder.append(matcher.group());
            builder.append(" ");}

        matcher = templatePattern.matcher(builder.toString());

        if (matcher.find()) {
            StringToFileWriter.write(outPutFile, matcher.group()); }
    }


}
