/*Входной файл хранит квадратную матрицу по принципу: строка представляет собой число.
Определить размерность. Построить 2-мерный массив, содержащий матрицу. Вывести исходную
матрицу и результат ее поворота на 90 градусов по часовой стрелке.*/

import helpers.FileDataToStringMapper;
import helpers.MatrixFromFileReader;
import interfaces.TaskInterface;

import java.util.Arrays;

public class Task15 implements TaskInterface {

    public int[][] complete(String stringPath) {
        return turnMatrixFor90Degrees(saveSquareMatrixAsArray(stringPath));
    }


    private static int[][] saveSquareMatrixAsArray(String stringPath) {

        int[][] matrix = MatrixFromFileReader.read(stringPath, "\n");

        for (int[] a : matrix){
            for (int i : a)
                System.out.print(i + " ");
            System.out.println();}

        return matrix;
    }

    private static int[][] turnMatrixFor90Degrees(int[][] matrix) {
        int[][] resultMatrix = new int[matrix.length][matrix.length];

        for (int i=0; i<matrix.length; i++)
        {
            for (int j=0; j<matrix.length; j++){
                resultMatrix[i][j]=matrix[matrix.length-j-1][i];}}


        for (int[] i : resultMatrix){
            for(int j : i)
                System.out.print(j +" ");
            System.out.println();}


        return resultMatrix;

    }



}
