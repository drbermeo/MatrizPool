/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// Comentarios automáticos generados por NetBeans al crear la clase

package BD;
// Define que esta clase pertenece al paquete BD (carpeta lógica del proyecto)

import Clases.Fila;
import java.sql.PreparedStatement;
import java.sql.SQLException;
// Importa la clase Fila del paquete Clases, y las clases necesarias para manejar sentencias SQL preparadas y excepciones SQL

/**
 *
 * @author Diana Bermeo C
 */
// Comentario de autoría

public class DBFila {
    // Clase pública DBFila encargada de interactuar con la tabla `hilo` de la base de datos
    Conexiones BLcon = new Conexiones();
    // Crea una instancia de la clase Conexiones para acceder a la base de datos
    public int InsertarFila(Fila objFila) throws ClassNotFoundException, SQLException {
        // Método público que recibe un objeto Fila y lo inserta en la base de datos
        // Puede lanzar excepciones si el driver no está disponible o hay un error SQL

        String Sentencia = """
            INSERT INTO hilo (
                fila1, fila2, fila3, fila4, fila5, fila6, fila7, fila8, fila9, fila10, fila11, fila12,
                nombre_hilo, nro_procesador, sumafila
            ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)
        """;
        // Cadena SQL para insertar los valores en la tabla `hilo`
        // Se utilizan signos de interrogación (?) como marcadores de posición para valores seguros
        PreparedStatement ps = BLcon.getConnection().prepareStatement(Sentencia);
        // Prepara la sentencia SQL con la conexión obtenida de la clase Conexiones
        // `PreparedStatement` permite insertar los valores de forma segura evitando inyecciones SQL
        // Inserta valores del arreglo fila[0] a fila[11]
        for (int i = 1; i <= 12; i++) {
            ps.setInt(i, objFila.getFila()[i - 1]);
            // Asigna cada valor del arreglo fila (posición 0 a 11) a los parámetros 1 a 12 de la sentencia SQL
        }
        ps.setString(13, objFila.getNombreHilo());
        // Asigna el valor del atributo `nombreHilo` al parámetro 13
        ps.setInt(14, objFila.getNroProcesador());
        // Asigna el número de procesador al parámetro 14
        ps.setInt(15, objFila.getSumaFila());
        // Asigna la suma de los valores de la fila al parámetro 15
        return ps.executeUpdate();
        // Ejecuta la sentencia de inserción y devuelve el número de filas afectadas (debería ser 1 si fue exitoso)
    }}
