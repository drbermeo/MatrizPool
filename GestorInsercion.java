/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import BD.DBFila;    // Importa la clase DBFila para manejo de inserciones en la base de datos
import Clases.Fila;  // Importa la clase Fila que representa una fila con sus datos
import java.sql.SQLException;

/**
 *
 * @author Diana Bermeo C
 */
public class GestorInsercion {
    // Método para insertar un objeto Fila en la base de datos
    public void insertarFila(Fila fila) {
        DBFila db = new DBFila();  // Crea una instancia de DBFila para manejar la base de datos
        try {
            db.InsertarFila(fila);  // Llama al método que realiza la inserción en la base de datos
        } catch (Exception e) {
            // Captura cualquier excepción y muestra un mensaje de error por consola estándar de errores
            System.err.println("Error al insertar fila en la base de datos: " + e.getMessage());
        }
    }
}
