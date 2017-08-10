/*Прочитать строки из файла и поменять местами первое и последнее слова в каждой строке.*/

import helpers.FileDataToStringMapper;
import interfaces.TaskInterface;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task10 implements TaskInterface {

    public Boolean complete(String stringPath) {

        String result = FileDataToStringMapper.map(stringPath);
        if (result == null || result.isEmpty()) {
            System.err.println("File contains no data.");
            return false;
        }
        System.out.println(result);
        //This is not a big deal, but for line separator character it is better to use System.getProperties("line.separator"); instead of "\n"
        String[] strings = result.split("\n");

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
            //Why not to use constant?
            s = s.replace(first, "THISSHOULDBELAST");
            s = s.replace(last, first);
            s = s.replace("THISSHOULDBELAST", last);
            buffer.append(s);
            //This is not a big deal, but for line separator character it is better to use System.getProperties("line.separator"); instead of "\n"
            buffer.append("\n");
            matcher.reset();
        }

        System.out.println(buffer);
        return true;
    }
}
