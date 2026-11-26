package com.sertti.tramites.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase encargada de gestionar la conexión con la base de datos MySQL mediante JDBC
 * para el sistema de gestión de trámites de SERTTI Tránsito La Jagua.
 */
public class ConexionBD {

    private static final String URL_CONEXION = "jdbc:mysql://localhost:3306/sertti_transito_db?useSSL=false&serverTimezone=UTC";
    private static final String USUARIO_BD = "root";
    private static final String CLAVE_BD = "";

    private ConexionBD() {
        // Constructor privado para evitar instanciación innecesaria
    }

    /**
     * Establece y retorna una conexión activa hacia la base de datos.
     *
     * @return objeto Connection activo
     * @throws SQLException si ocurre un error al conectar con el motor de base de datos
     */
    public static Connection obtenerConexion() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL_CONEXION, USUARIO_BD, CLAVE_BD);
        } catch (ClassNotFoundException ex) {
            throw new SQLException("No se encontró el controlador JDBC de MySQL en el proyecto.", ex);
        }
    }
}
