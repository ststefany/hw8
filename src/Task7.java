/*Из файла удалить все слова, содержащие от трех до пяти символов, но при этом из каждой строки
должно быть удалено только максимальное четное количество таких слов.*/

import interfaces.TaskInterface;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Task7 implements TaskInterface {

    public Boolean complete(String stringPath) {
        Pattern pattern = Pattern.compile("[a-zA-Z]{3,5}");
        StringBuffer buffer = new StringBuffer();
        String result = "";
        int counter = 0;

        try (Stream<String> stream = Files.lines(Paths.get(stringPath))) {
            stream.forEach(buffer::append);
            result = buffer.toString();
            Matcher matcher = pattern.matcher(result);
            while (matcher.find()) {
                counter++;
            }

            if (counter <= 0) return false;

            counter = (counter % 2 == 0) ? counter : counter - 1;
            matcher.reset(result);

            for (int i = 0; i < counter; i++) {
                matcher.find();
                result = result.replace(matcher.group(), "");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/resources/Task7.txt"))) {
            writer.write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
