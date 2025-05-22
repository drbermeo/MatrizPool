/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// Comentarios automáticos generados por NetBeans sobre la plantilla de archivo y edición

package BD;
// Indica que esta clase pertenece al paquete BD (carpeta donde se encuentra el archivo)

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
// Importa clases necesarias para manejar la conexión con bases de datos MySQL

/**
 *
 * @author Diana Bermeo C
 */
// Comentario que indica el autor del código

public class Conexiones {
    // Declaración de la clase pública llamada Conexiones
    // Conectarse a la BDD
    public Connection con;
    // Variable pública de tipo Connection que representa la conexión con la base de datos
    public Connection getConnection () throws ClassNotFoundException, SQLException {
        // Método público que devuelve una conexión a la base de datos
        // Puede lanzar excepciones si no se encuentra el driver o hay errores de SQL
        String driver = "com.mysql.cj.jdbc.Driver";
        // Nombre del driver JDBC para conectarse a bases de datos MySQL (versión moderna)
        // También existía una versión antigua: "com.mysql.jdbc.Driver"
        String url = "jdbc:mysql://localhost:3306/matrizpooldb";
        // URL de conexión al servidor MySQL que se ejecuta en localhost (puerto 3306)
        // Se conecta a la base de datos llamada "matrizpooldb"
        Class.forName(driver);
        // Carga la clase del driver JDBC (obligatorio para establecer la conexión)

        return DriverManager.getConnection(url,"root","drbermeo");
        // Establece y devuelve la conexión usando el URL, usuario ("root") y contraseña ("drbermeo")
    }
    public Connection AbrirConexion() throws ClassNotFoundException, SQLException {
        // Método público para abrir la conexión y guardarla en la variable 'con'
        con = getConnection();
        // Llama al método anterior para obtener la conexión
        return con;
        // Retorna la conexión abierta
    }
    public void CerrarConexion() throws SQLException {
        // Método público que cierra la conexión con la base de datos
        con.close();
        // Cierra la conexión previamente abierta
    }
}
