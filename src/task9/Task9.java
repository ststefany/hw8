package task9;
/*Из текста Java-программы удалить все виды комментариев.*/
//Comment sample

import helpers.StringToFileWriter;
import interfaces.TaskInterface;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Documentation comments sample
 **/

public class Task9 implements TaskInterface {


    public Boolean complete(String stringPath) {
        String result = helpers.FileDataToStringMapper.map(stringPath);
        if (result == null || result.isEmpty()) {
            System.err.println("File is empty");
            return false;}

        Pattern pattern = Pattern.compile(Patterns.COMMENTS_PATTERN); //stupid comment
        Matcher matcher = pattern.matcher(result);
        while (matcher.find()){
            result = result.replace(matcher.group(), "");}
        StringToFileWriter.write(stringPath, result);
        return true;
    }

}
