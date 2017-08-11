/*Прочитать строки из файла и поменять местами первое и последнее слова в каждой строке.*/

import helpers.FileDataToStringMapper;
import interfaces.TaskInterface;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static helpers.SpecialCharacters.LINE_SEPARATOR;

public class Task10 implements TaskInterface {
    private static final String PLACEHOLDER = "This should be changed";

    public Boolean complete(String stringPath) {

        String result = FileDataToStringMapper.map(stringPath);
        if (result == null || result.isEmpty()) {
            System.err.println("File contains no data.");
            return false;
        }
        System.out.println(result);
        String[] strings = result.split(LINE_SEPARATOR.getValue());

        Pattern pattern = Pattern.compile("[а-яА-ЯёЁa-zA-Z]+");

        Matcher matcher;
        String first = "";
        String last = "";

        StringBuffer buffer = new StringBuffer();

        for (String s : strings) {
            matcher = pattern.matcher(s);
            if (matcher.find()) {
                first = matcher.group();
            }
            matcher.reset(s);
            while (matcher.find()) {
                last = matcher.group();
            }
            s = s.replace(first, PLACEHOLDER);
            s = s.replace(last, first);
            s = s.replace(PLACEHOLDER, last);
            buffer.append(s);
            buffer.append(LINE_SEPARATOR.getValue());
            matcher.reset();
        }

        System.out.println(buffer);
        return true;
    }
}
