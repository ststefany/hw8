package task9;
/*Из текста Java-программы удалить все виды комментариев.*/
//Comment sample

import helpers.StringToFileWriter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Documentation comments sample
 **/

public class Task9 {

    private static final String PATH = "src/task9/Task9.java";

    public static void deleteAllComments() {
        String result = helpers.FileDataToStringMapper.map(PATH);
        if (result == null || result.isEmpty()) {
            System.err.println("File is empty");
            return;}

        Pattern pattern = Pattern.compile(Patterns.COMMENTS_PATTERN); //stupid comment
        Matcher matcher = pattern.matcher(result);
        while (matcher.find()){
            result = result.replace(matcher.group(), "");}
        StringToFileWriter.write(PATH, result);

    }

}
