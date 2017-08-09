import interfaces.TaskInterface;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/*2. Прочитать текст Java-программы и все слова public в объявлении атрибутов и методов класса
заменить на слово private.*/

public class Task2 implements TaskInterface {

    @Override
    public Boolean complete(String stringPath) {
        StringBuffer buffer = new StringBuffer();

        try (Stream<String> stream = Files.lines(Paths.get(stringPath), StandardCharsets.UTF_8)
        ) {
            stream.forEach(s -> {
                String z = s.replace("public", "private");
                buffer.append(z);
                buffer.append("\n");
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter writer = new FileWriter("src/Task2.java")) {
            char[] chars = buffer.toString().toCharArray();
            writer.write(chars);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
