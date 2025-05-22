package Logica;
// Define que esta clase pertenece al paquete Logica (organización del proyecto)

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// Comentarios automáticos del IDE (NetBeans)

import Clases.Fila;
import java.sql.SQLException;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;
// Importa la clase Fila, las excepciones SQL y clases para control de concurrencia y logging

/**
 *
 * @author Diana Bermeo
 */
// Comentario de autoría

public class HiloSumaFilas implements Runnable {// Clase que implementa Runnable, lo que permite que sus instancias se ejecuten en hilos independientes
    private final int[] fila; // Arreglo de enteros que representa los datos de la fila que se va a procesar en este hilo
    private final int indice;// Índice que indica la posición en el arreglo de resultados donde se guardará la suma calculada
    private final int[] sumas;// Arreglo compartido donde cada hilo guarda la suma calculada para su fila
    private final CountDownLatch latch;
    // Objeto de sincronización que permite controlar cuándo todos los hilos han terminado su tarea
    public HiloSumaFilas(int[] fila, int indice, int[] sumas, CountDownLatch latch) {
        // Constructor que inicializa las variables necesarias para el procesamiento
        this.fila = fila;
        this.indice = indice;
        this.sumas = sumas;
        this.latch = latch; }
    @Override
    public void run() {
        // Método que se ejecuta cuando el hilo inicia

        int suma = 0;
        // Variable para acumular la suma de los elementos de la fila
        for (int val : fila) {
            suma += val;
            // Suma cada valor dentro del arreglo fila
        }
        sumas[indice] = suma;
        // Guarda la suma calculada en la posición indicada del arreglo compartido de sumas
        String nombreHilo = Thread.currentThread().getName();
        // Obtiene el nombre del hilo actual que está ejecutando esta tarea
        int nroProcesador = Integer.parseInt(nombreHilo.split("-")[1]);
        // Extrae el número del procesador/hilo a partir del nombre del hilo
        // Se espera un formato de nombre como "Thread-1", "Thread-2", etc.
        Fila filaObj = new Fila(fila, nombreHilo, nroProcesador, suma);
        // Crea un objeto Fila con los datos procesados para insertar en la base de datos
        new GestorInsercion().insertarFila(filaObj);
        // Llama al gestor encargado de insertar el objeto Fila en la base de datos
        latch.countDown();
        // Disminuye el contador del latch, señalando que este hilo ha terminado su trabajo
    }}
