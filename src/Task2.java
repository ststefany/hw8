import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Task2 {

    public void changePublicToPrivate() {
                    StringBuffer buffer = new StringBuffer();

        try (Stream<String> stream = Files.lines(Paths.get("src/Task2.java"), StandardCharsets.UTF_8)
        ) {
            stream.forEach(s -> {
                String z = s.replace("public", "private");
                buffer.append(z);
                buffer.append("\n");
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(FileWriter writer = new FileWriter("src/Task2.java")) {
            char[] chars = buffer.toString().toCharArray();
            writer.write(chars);
            writer.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
