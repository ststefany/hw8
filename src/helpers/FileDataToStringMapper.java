package helpers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static helpers.SpecialCharacters.LINE_SEPARATOR;

public class FileDataToStringMapper {

    public static String map(String stringPath) {
        Path path = Paths.get(stringPath);
        if (Files.notExists(path)) {
            return null;
        }

        StringBuffer buffer = new StringBuffer();
        String result = "";

        try (Stream<String> stream = Files.lines(path)) {
            stream.forEach(s -> {
                buffer.append(s);
                buffer.append(LINE_SEPARATOR.getValue());
            });
            result = buffer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
