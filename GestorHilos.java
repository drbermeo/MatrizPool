package Logica;

import BD.DBFila;
import Clases.Fila;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author Diana Bermeo C
 */
public class GestorHilos {
    public int ejecutarPool(int[][] matriz) throws ExecutionException {
        int sumaTotal = 0;
        // Crear un pool de hilos con un número fijo de hilos
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        Future<Integer>[] resultados = new Future[matriz.length];

        for (int i = 0; i < matriz.length; i++) {
            final int filaIndex = i;
            resultados[i] = executor.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws SQLException {
                    int[] filaDatos = matriz[filaIndex];
                    int suma = 0;
                    for (int val : filaDatos) {
                        suma += val;
                    }

                    String nombreHilo = Thread.currentThread().getName();
                    int nroProcesador = (int) (Thread.currentThread().getId());

                    Fila fila = new Fila(filaDatos, nombreHilo, nroProcesador, suma);

                    System.out.println("Insertando fila: " + nombreHilo);
                    try {
                        System.out.println("Intentando insertar fila en la base de datos...");
                        DBFila db = new DBFila();
                        int res = db.InsertarFila(fila);
                        if (res > 0) {
                            System.out.println("Fila insertada correctamente.");
                        }
                    } catch (ClassNotFoundException | SQLException e) {
                        System.out.println("Error al insertar fila: " + e.getMessage());
                    }

                    return suma;
                }
            });
        }

        // Esperar a que todos los hilos terminen y acumular la suma total
        for (Future<Integer> futuro : resultados) {
            try {
                sumaTotal += futuro.get();
            } catch (InterruptedException | ExecutionException e) {
                System.out.println("Error al obtener resultado del hilo: " + e.getMessage());
            }
        }

        executor.shutdown();
        return sumaTotal;
    }
}

