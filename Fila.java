/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// Comentarios automáticos de NetBeans sobre las plantillas de archivo y clase

package Clases;
// Define que esta clase pertenece al paquete Clases

/**
 *
 * @author Diana Bermeo C
 */
// Comentario de autoría

public class Fila {
    // Declaración de la clase pública Fila

    private int[] fila;
    // Arreglo de enteros que representa una fila con varios valores (esperado: 12 elementos)

    private String nombreHilo;
    // Nombre del hilo (thread) que está trabajando con esta fila, útil para identificar procesos concurrentes

    private int nroProcesador;
    // Número de procesador o identificador lógico del hilo/proceso que procesó la fila

    private int sumaFila;
    // Suma total de los valores contenidos en la fila

    public Fila(int[] fila, String nombreHilo, int nroProcesador, int sumaFila) {
        // Constructor de la clase, inicializa todos los atributos

        this.fila = fila;
        this.nombreHilo = nombreHilo;
        this.nroProcesador = nroProcesador;
        this.sumaFila = sumaFila;
    }

    public int[] getFila() {
        return fila;
        // Método getter: retorna el arreglo de enteros que representa la fila
    }

    public String getNombreHilo() {
        return nombreHilo;
        // Retorna el nombre del hilo asociado a esta fila
    }

    public int getNroProcesador() {
        return nroProcesador;
        // Retorna el número del procesador o identificador del hilo
    }

    public int getSumaFila() {
        return sumaFila;
        // Retorna la suma total de la fila
    }

    public void setFila(int[] fila) {
        this.fila = fila;
        // Permite modificar el arreglo de enteros que representa la fila
    }

    public void setNombreHilo(String nombreHilo) {
        this.nombreHilo = nombreHilo;
        // Permite cambiar el nombre del hilo asociado
    }

    public void setNroProcesador(int nroProcesador) {
        this.nroProcesador = nroProcesador;
        // Permite cambiar el número de procesador asociado
    }

    public void setSumaFila(int sumaFila) {
        this.sumaFila = sumaFila;
        // Permite modificar el valor de la suma de la fila
    }
}
