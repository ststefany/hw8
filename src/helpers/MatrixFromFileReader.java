package helpers;

import java.util.Arrays;

public class MatrixFromFileReader {

    public static int[][] read(String stringPath, String ruleToSplit) {
        String input = FileDataToStringMapper.map(stringPath);
        if (input == null || input.isEmpty()) {
            System.err.println("Invalid input data");
            return null;
        }

        String[] data = input.split(ruleToSplit);

        double size = Math.sqrt(data.length);
        int matrixSize = (int) size;

        if (size - matrixSize != 0) {
            System.err.println("Invalid input data");
            return null;
        }

        int[] array = Arrays.stream(data).mapToInt(Integer::parseInt).toArray();

        int[][] resultArray = new int[matrixSize][matrixSize];
        int[] lineArray = new int[matrixSize];

        for (int i = 0, z = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                lineArray[j] = array[z];
                z++;
            }

            resultArray[i] = lineArray;
            lineArray = new int[matrixSize];
        }

        return resultArray;

    }
}
