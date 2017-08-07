import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.stream.Stream;

public class FileDataToStringMapper {

    public static String map(String stringPath) {
        Path path = Paths.get(stringPath);
        if(Files.notExists(path)) return null;

        StringBuffer buffer = new StringBuffer();
        String result = "";

        try (Stream<String> stream = Files.lines(path, StandardCharsets.UTF_8)) {
            stream.forEach(s -> {
                buffer.append(s);
                buffer.append("\n");});
            result = buffer.toString();
        }
        catch (IOException e) {
        e.printStackTrace();}
        return result;
    }

}
