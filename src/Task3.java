import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Task3 {
    public static void main(String[] args) {
        Task3.createFileWithReverseStrings();

    }

    public static void createFileWithReverseStrings() {
        try (Stream<String> stream = Files.lines(Paths.get("src/Task3.java"), StandardCharsets.UTF_8);
             FileWriter writer = new FileWriter("src/resources/Task3reverse.txt")) {

            StringBuffer s = new StringBuffer();
            stream.forEach(z -> {
                s.append(z);
                s.append("\n");
            });

            char[] array = s.toString().toCharArray();
            for (int i = 0; i < array.length / 2; i++) {
                char c = array[array.length - i - 1];
                array[array.length - i - 1] = array[i];
                array[i] = c;
            }
            writer.write(array);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
