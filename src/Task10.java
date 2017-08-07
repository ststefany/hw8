/*Прочитать строки из файла и поменять местами первое и последнее слова в каждой строке.*/

import helpers.FileDataToStringMapper;

public class Task10 {
    private static final String PATH = "src/Task10.java";

    public static void main(String[] args) {
        switchFirstAndLastWordInLine();
    }


    public static void switchFirstAndLastWordInLine(){

        String result = FileDataToStringMapper.map(PATH);
        //if (result == null || result.isEmpty()) {
        //    System.err.println("File contains no data.");
        //    return;
        //}
        System.out.println(result);
        String[] strings = result.split("\n");

        for(String s : strings)
            System.out.println(s);

        }

}
