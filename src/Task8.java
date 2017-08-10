/*Прочитать текст Java-программы и удалить из него все “лишние” (повторяющиеся) пробелы, оставив
только необходимые для разделения операторов.*/

import interfaces.TaskInterface;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Task8 implements TaskInterface {

    public Boolean complete(String stringPath) {
        StringBuffer buffer = new StringBuffer();
        String result = "";

        try (Stream<String> stream = Files.lines(Paths.get(stringPath))) {
            stream.forEach(s -> {
                buffer.append(s);
                //This is not a big deal, but for line separator character it is better to use System.getProperties("line.separator"); instead of "\n"
                buffer.append("\n");
            });
            result = buffer.toString();
            //please, use curly brackets after "while".
            //You could use constant for ".."
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
        return true;
    }
}
