package helpers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileDataToStringMapper {

    public static String map(String stringPath) {
        Path path = Paths.get(stringPath);
        //please, use curly bracket after "if"
        if(Files.notExists(path)) return null;

        StringBuffer buffer = new StringBuffer();
        String result = "";

        try (Stream<String> stream = Files.lines(path)) {
            stream.forEach(s -> {
                buffer.append(s);
                //This is not a big deal, but for line separator character it is better to use System.getProperties("line.separator"); instead of "\n"
                //Bracket and lines
                buffer.append("\n");});
            result = buffer.toString();
        }
        //I see a bit of shit with brackets and lines right here
        catch (IOException e) {
        e.printStackTrace();}
        return result;
    }

}
