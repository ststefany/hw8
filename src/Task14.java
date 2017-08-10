/*Входной файл содержит совокупность строк. Строка файла содержит строку квадратной матрицы.
Ввести матрицу в двумерный массив (размер матрицы найти). Вывести исходную матрицу и
результат ее транспонирования.*/

import helpers.MatrixFromFileReader;
import interfaces.TaskInterface;

public class Task14 implements TaskInterface {

    public int[][] complete(String stringPath) {
        int[][] result = saveSquareMatrixAsArray(stringPath);
        transMatrix(result);
        return result;
    }

    private int[][] saveSquareMatrixAsArray(String stringPath) {
        //This is not a big deal, but for line separator character it is better to use System.getProperties("line.separator"); instead of "\n"
        int[][] matrix = MatrixFromFileReader.read(stringPath, "\\s|\\n");
        //if the was empty? or it was corrupted?
        for (int[] a : matrix) {
            //curly brackets
            for (int i : a)
                System.out.print(i + " ");
            System.out.println();
        }
        return matrix;
    }

    private int[][] transMatrix(int[][] matrix) {
        //curly brackets
        if (matrix == null) return null;

        int[][] resultMatrix = new int[matrix.length][matrix.length];

        for (int i = 0; i < matrix.length; ++i)
            for (int j = 0; j < matrix.length; ++j) {
                resultMatrix[i][j] = matrix[j][i];
            }

        for (int[] a : resultMatrix) {
            for (int i : a) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        return resultMatrix;
    }
}
