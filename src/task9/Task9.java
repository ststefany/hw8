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
        //by the Nine Gods!!! Don't use full path, with packages! Just import class!!!
        String result = helpers.FileDataToStringMapper.map(stringPath);
        if (result == null || result.isEmpty()) {
            System.err.println("File is empty");
            //brackets and lines :-) Please, use auto-format: Ctrl+Alt+L
            return false;}

        Pattern pattern = Pattern.compile(Patterns.COMMENTS_PATTERN); //stupid comment
        Matcher matcher = pattern.matcher(result);
        while (matcher.find()){
            //brackets and lines :-) Please, use auto-format: Ctrl+Alt+L
            result = result.replace(matcher.group(), "");}
        StringToFileWriter.write(stringPath, result);
        return true;
    }

}
