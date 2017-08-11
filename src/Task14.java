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
        int[][] matrix = MatrixFromFileReader.read(stringPath, "\\s|\\n");

        if (matrix == null || matrix.length == 0) {
            System.err.println("Impossible to complete the task");
            return null;
        }

        for (int[] a : matrix) {
            for (int i : a) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        return matrix;
    }

    private int[][] transMatrix(int[][] matrix) {
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
