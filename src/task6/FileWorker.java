package task6;

import helpers.FileDataToStringMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileWorker {
    //Does this really should be package-local privacy?
    String stringPath;

    FileWorker(String stringPath) {
        this.stringPath = stringPath;
    }

    //and this?
    Pattern findPattern(Types type) {
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

    //privacy
    void printAllMatchingData(Pattern pattern) {
        String data = FileDataToStringMapper.map(stringPath);
        int counter = 0;
        Matcher matcher = pattern.matcher(data);
        while (matcher.find()) {
            System.out.println(matcher.group());
            counter++;
        }
        if (counter == 0)
            System.out.println("No matches found");
    }


    //privacy
    Types chooseType() {
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
