/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentacion;

import Logica.GestorHilos;  // Importa la clase que gestiona la ejecución concurrente de hilos
import Logica.Utilidades;   // Importa la clase con métodos auxiliares, como generar matrices
import java.util.concurrent.ExecutionException;

/**
 *
 * @author Diana Bermeo C
 */
public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
            int[][] matriz = Utilidades.generateMatrix(12, 12); // Matriz 12x12 aleatoria
            GestorHilos gestor = new GestorHilos();
            int sumaTotal = gestor.ejecutarPool(matriz); // Ejecuta con pool de hilos
            System.out.println("Suma total de la matriz: " + sumaTotal);
    }
}
