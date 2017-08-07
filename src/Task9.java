/*Из текста Java-программы удалить все виды комментариев.*/
//Comment sample

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Documentation comments sample
 **/

public class Task9 {

    static String path = "src/Task9.java";

    public static void deleteAllComments() {
        String result = FileDataToStringMapper.map(path);
        if (result == null || result.isEmpty()) {
            System.err.println("File is empty");
            return;}

        Pattern pattern = Pattern.compile("(/\\*([^*]|[\\r\\n]|(\\*+([^*/]|[\\r\\n])))*\\*+/)|(//.*)");
        Matcher matcher = pattern.matcher(result);
        while (matcher.find()){
            result = result.replace(matcher.group(), "");}
        StringToFileWriter.write(path, result);

    }

}
