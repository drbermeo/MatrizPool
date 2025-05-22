/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentacion;

import Logica.GestorHilos;  // Importa la clase que gestiona la ejecución concurrente de hilos
import Logica.Utilidades;   // Importa la clase con métodos auxiliares, como generar matrices

/**
 *
 * @author Diana Bermeo C
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Genera una matriz de 12 filas x 12 columnas con números aleatorios entre 0 y 20
        int[][] matriz = Utilidades.generateMatrix(12, 12);

        // Crea una instancia de GestorHilos que controla el procesamiento concurrente
        GestorHilos gestor = new GestorHilos();

        // Ejecuta el método que suma filas en paralelo usando un pool de hilos y retorna la suma total
        int sumaTotal = gestor.ejecutarPool(matriz);

        // Imprime el resultado total de la suma de todos los elementos de la matriz
        System.out.println("Suma total de la matriz: " + sumaTotal);
    }
}

