/*Из файла удалить все слова, содержащие от трех до пяти символов, но при этом из каждой строки
должно быть удалено только максимальное четное количество таких слов.*/

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Task7 {

    public static void main(String[] args) {

        delete3to5MaxEvenWords();

    }

    public static void delete3to5MaxEvenWords() {
        Pattern pattern = Pattern.compile("[a-zA-Z]{3,5}");
        StringBuffer buffer = new StringBuffer();
        String result = "";
        int counter = 0;

        try (Stream<String> stream = Files.lines(Paths.get("src/resources/Task7.txt"), StandardCharsets.UTF_8)) {
            stream.forEach(buffer::append);
            Matcher matcher = pattern.matcher(buffer.toString());
            while (matcher.find()) {
                counter++;
            }
            counter = (counter % 2 == 0) ? counter : counter - 1;
            System.out.println(result);
            matcher.reset();
            matcher = pattern.matcher(buffer.toString());
            for (int i = 0; i < counter; i++) {
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
    }


}
