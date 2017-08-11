package helpers;

import interfaces.TaskInterface;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StringToFileWriter {

    public static void write(String stringPath, String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(stringPath))) {
            writer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
