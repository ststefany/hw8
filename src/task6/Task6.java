package task6;
/*Файл содержит символы, слова, целые числа и числа с плавающей запятой. Определить все данные,
тип которых вводится из командной строки.*/


import interfaces.TaskInterface;

public class Task6 implements TaskInterface {

    public  Boolean complete(String stringPath) {
        FileWorker fileWorker = new FileWorker(stringPath);
        fileWorker.printAllMatchingData(fileWorker.findPattern(fileWorker.chooseType()));
        return true;
    }

}
