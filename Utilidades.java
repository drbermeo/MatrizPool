package Logica;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Diana Bermeo
 */

import java.util.Random;

public class Utilidades {
    // Variable estática para generar números aleatorios
    private static Random random = new Random();

    // Método estático para generar una matriz de enteros aleatorios
    public static int[][] generateMatrix(int rows, int cols) {
        int[][] output = new int[rows][cols]; // Crear matriz con tamaño filas x columnas

        // Rellenar matriz con valores aleatorios entre 0 y 20 (inclusive)
        for (var i = 0; i < rows; i++) {
            for (var j = 0; j < cols; j++) {
                output[i][j] = random.nextInt(21); // nextInt(21) genera 0 a 20
            }
        }

        return output; // Retornar matriz generada
    }

    // Método privado para imprimir matriz en consola (para uso interno)
    private static void printMatrix(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            // El segundo for debe iterar sobre mat[i].length, no mat.length
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + " , ");
            }
            System.out.println(); // Salto de línea después de cada fila
        }
    }

    // Método privado para imprimir un arreglo (fila de sumas) en consola
    private static void printRow(int[] sums) {
        // El ciclo debe recorrer sums.length, no <=
        for (int i = 0; i < sums.length; i++) {
            System.out.print(sums[i] + " , ");
        }
        System.out.println(); // Salto de línea después de imprimir la fila
    }
}
