package task6;/*Файл содержит символы, слова, целые числа и числа с плавающей запятой. Определить все данные,
тип которых вводится из командной строки.*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class FileWorker {

    public static void main(String[] args) {
        FileWorker worker = new FileWorker();
        worker.start();
    }

    public void start() {
        printAllMatchingData(findPattern(chooseType()));

    }

    private Pattern findPattern(Types type) {
        Pattern pattern;
        switch (type) {
            case DOUBLE:
                pattern = Pattern.compile("[-]?[0-9]*\\.{1}[0-9]++");
                break;
            case STRING:
                pattern = Pattern.compile("[a-zA-Z]+");
                break;
            case SYMBOL:
                pattern = Pattern.compile("[^\\w\\.\\s]");
                break;
            case INTEGER:
                pattern = Pattern.compile("[0-9]++");
                break;
            default:
                pattern = Pattern.compile("");
        }
        return pattern;
    }

    private void printAllMatchingData(Pattern pattern) {
        String data = getDataFromFile();
        int counter = 0;
        Matcher matcher = pattern.matcher(data);
        while (matcher.find()) {
            System.out.println(matcher.group());
            counter++;
        }
        if (counter == 0)
            System.out.println("No matches found");
    }


    private String getDataFromFile() {
        StringBuffer buffer = new StringBuffer();

        try (Stream<String> stream = Files.lines(Paths.get("src/Task7/Task7.txt"), StandardCharsets.UTF_8)) {
            stream.forEach(buffer::append);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }

    private Types chooseType() {
        System.out.println("Please, write a type of data you are interested in. Available types: ");
        for (Types t : Types.values()) {
            System.out.println(t);
        }
        String type = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            type = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Types.valueOf(type);
    }

}
