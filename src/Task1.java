import interfaces.TaskInterface;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*1. Создать и заполнить файл случайными целыми числами. Отсортировать содержимое файла по
возрастанию.*/

public class Task1 implements TaskInterface {

    @Override
    public Boolean complete(String stringPath) {
        fillFile(stringPath);
        sortFile(stringPath);
        return true;
    }

    //Why static?
    private static String fillFile(String stringPath) {
        Random random = new Random();
        try (FileWriter writer = new FileWriter(stringPath, true)) {
            for (int i = 0; i < 10; i++) {
                writer.write(random.nextInt() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringPath;
    }

    //Why static again?
    private static List<Integer> sortFile(String stringPath) {
        List<Integer> result = new ArrayList<>();
        //is there a reason, why you specify charset? Besides, UTF-8 is default charset
        try (Stream<String> stream = Files.lines(Paths.get(stringPath), StandardCharsets.UTF_8)) {
            result = stream.map(Integer::parseInt)
                    .sorted().collect(Collectors.toList());
            //What is reason of deleting file? Besides, FileWriter appends to the end of file, it can be used to rewrite the whole file
            Files.delete(Paths.get(stringPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter writer = new FileWriter(stringPath, true)) {
            for (Integer i : result) {
                writer.append(i.toString());
                writer.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        result.forEach(System.out::println);

        return result;
    }

}