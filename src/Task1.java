import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task1 {
    Random random = new Random();

    public static void main(String[] args) {
        Task1 task1 = new Task1();
        Path path = Paths.get("src/resources/file.txt");
        task1.fillFile(path);
        task1.sortFile(path);
    }

    public Path fillFile(Path path) {
        try (FileWriter writer = new FileWriter(path.toString(), true)) {
            for (int i = 0; i < 10; i++) {
                writer.write(random.nextInt() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }

    public List<Integer> sortFile(Path path) {
        List<Integer> result = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(path.toString()), StandardCharsets.UTF_8)) {
            result = stream.map(Integer::parseInt)
                    .sorted().collect(Collectors.toList());
            Files.delete(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter writer = new FileWriter(path.toString(), true)) {
            for (Integer i : result) {
                writer.append(i + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        result.forEach(System.out::println);

        return result;
    }
}