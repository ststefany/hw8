import interfaces.TaskInterface;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static helpers.SpecialCharacters.LINE_SEPARATOR;
import static helpers.SpecialCharacters.SPACE;
/*4. Прочитать текст Java-программы и в каждом слове длиннее двух символов все строчные символы
заменить прописными.*/

public class Task4 implements TaskInterface {

    public Boolean complete(String stringPath) {
        StringBuffer buffer = new StringBuffer();

        try (Stream<String> stream = Files.lines(Paths.get(stringPath))) {
            stream.forEach(s -> {
                String[] strings = s.split(SPACE.getValue());
                for (int i = 0; i < strings.length; i++) {
                    if (strings[i].length() > 2) strings[i] = strings[i].toLowerCase();
                    buffer.append(strings[i]);
                    if (i == strings.length - 1) {
                        buffer.append(LINE_SEPARATOR.getValue());
                    } else {
                        buffer.append(" ");
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter writer = new FileWriter("src/Task4.java")) {
            writer.write(buffer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}