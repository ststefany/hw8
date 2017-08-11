import interfaces.TaskInterface;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static helpers.SpecialCharacters.LINE_SEPARATOR;
/*5. В файле, содержащем фамилии студентов и их оценки, записать прописными буквами фамилии тех
студентов, которые имеют средний балл более “7”.*/

public class Task5 implements TaskInterface {
    private final static int SURNAME = 0;
    private final static int MARK = 1;
    private final static int CRITICAL_NUMBER = 7;


    public Boolean complete(String stringPath) {
        StringBuffer buffer = new StringBuffer();

        try (Stream<String> stream = Files.lines(Paths.get(stringPath))) {
            stream.forEach(s -> {
                String[] student = s.split(",");
                if (Integer.parseInt(student[MARK]) >= CRITICAL_NUMBER) {
                    student[SURNAME] = student[SURNAME].toUpperCase(); }
                buffer.append(student[SURNAME]);
                buffer.append(", ");
                buffer.append(student[MARK]);
                buffer.append(LINE_SEPARATOR.getValue());
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter writer = new FileWriter("src/resources/Task5.csv")) {
            writer.write(buffer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
