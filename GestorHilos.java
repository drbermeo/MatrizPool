package Logica;

import java.util.concurrent.CountDownLatch;

/**
 *
 * @author Diana Bermeo C
 */
public class GestorHilos {

    /**
     * Método que ejecuta un pool de hilos para sumar filas de la matriz en paralelo
     * @param matriz matriz de enteros a procesar
     * @return suma total de todos los elementos de la matriz
     * @throws InterruptedException si ocurre una interrupción en la espera de los hilos
     */
    public int ejecutarPool(int[][] matriz) throws InterruptedException {
        int filas = matriz.length;              // Número de filas en la matriz
        int[] sumasParciales = new int[filas]; // Arreglo para almacenar la suma de cada fila
        CountDownLatch latch = new CountDownLatch(filas); // Latch para sincronizar la terminación de todos los hilos

        // Crear y lanzar un hilo para cada fila
        for (int i = 0; i < filas; i++) {
            Runnable tarea = new HiloSumaFilas(matriz[i], i, sumasParciales, latch);
            Thread hilo = new Thread(tarea, "Hilo-" + i);
            hilo.start();
        }

        // Esperar hasta que todos los hilos terminen su ejecución
        latch.await();

        // Sumar todas las sumas parciales para obtener la suma total
        int sumaTotal = 0;
        for (int suma : sumasParciales) {
            sumaTotal += suma;
        }

        return sumaTotal; // Retornar la suma total
    }
}

