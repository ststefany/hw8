/*Прочитать текст Java-программы и удалить из него все “лишние” (повторяющиеся) пробелы, оставив
только необходимые для разделения операторов.*/

import interfaces.TaskInterface;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static helpers.SpecialCharacters.LINE_SEPARATOR;
import static helpers.SpecialCharacters.DOUBLE_SPACE;
import static helpers.SpecialCharacters.SPACE;

public class Task8 implements TaskInterface {

    public Boolean complete(String stringPath) {
        StringBuffer buffer = new StringBuffer();
        String result = "";

        try (Stream<String> stream = Files.lines(Paths.get(stringPath))) {
            stream.forEach(s -> {
                buffer.append(s);
                buffer.append(LINE_SEPARATOR.getValue());
            });
            result = buffer.toString();
            while (result.contains(DOUBLE_SPACE.getValue())) {
                result = result.replace(DOUBLE_SPACE.getValue(), SPACE.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/Task8.java"))) {
            writer.write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
