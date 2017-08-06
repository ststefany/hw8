import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Task5 {

    public static void main(String[] args) {
        writeSurnamesWith7OrHigherInUpperCase();
    }


    public static void writeSurnamesWith7OrHigherInUpperCase() {
        final int SURNAME = 0;
        final int MARK = 1;
        StringBuffer buffer = new StringBuffer();

        try (Stream<String> stream = Files.lines(Paths.get("src/resources/Task5.csv"), StandardCharsets.UTF_8)) {
            stream.forEach(s -> {
                String[] student = s.split(",");
                if (Integer.parseInt(student[MARK]) >= 7) student[SURNAME] = student[SURNAME].toUpperCase();
                buffer.append(student[SURNAME]);
                buffer.append(", ");
                buffer.append(student[MARK]);
                buffer.append("\n");
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter writer = new FileWriter("src/resources/Task5.csv")) {
            writer.write(buffer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
