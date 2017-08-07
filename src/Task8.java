/*Прочитать текст Java-программы и удалить из него все “лишние” (повторяющиеся) пробелы, оставив
только необходимые для разделения операторов.*/

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Task8 {

    public static void main(String[] args) {
        deleteExcessTabsAndSpaces();

    }

    public static void deleteExcessTabsAndSpaces() {
        StringBuffer buffer = new StringBuffer();
        String result = "";

        try (Stream<String> stream = Files.lines(Paths.get("src/Task8.java"), StandardCharsets.UTF_8)) {
            stream.forEach(s -> {
                                buffer.append(s);
                                buffer.append("\n");});

            result = buffer.toString();
            while (result.contains("  "))
                result = result.replace("  ", " ");

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/Task8.java"))) {
            writer.write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
