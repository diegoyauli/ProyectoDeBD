package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    private String bd = "ResiduosToxicos";
    private String url = "jdbc:postgresql://localhost:5432/";
    private String user = "hernan";
    private String password = "hernan";
    private String driver = "org.postgresql.Driver";
    private Connection cx;

    public Conexion(String bd) {
        this.bd = bd;
    }

    // Método para conectar con la base de datos
    public Connection conectar() {
        try {
            // Cargar el driver JDBC
            Class.forName(driver);
            // Establecer la conexión
            cx = DriverManager.getConnection(url + bd, user, password);
            System.out.println("SE CONECTÓ A LA BASE DE DATOS " + bd);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("NO SE CONECTÓ A LA BASE DE DATOS " + bd);
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cx;
    }

    // Método para desconectar la base de datos
    public void desconectar() {
        if (cx != null) {
            try {
                cx.close();
                System.out.println("CONEXIÓN CERRADA CORRECTAMENTE");
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    // Método principal para probar la conexión
    public static void main(String[] args) {
        Conexion conexion = new Conexion("ResiduosToxicos");
        conexion.conectar();  // Intentar conectar
        conexion.desconectar();  // Desconectar después de la prueba
    }
    public static Connection getConnection() {
        return new Conexion("ResiduosToxicos").conectar();
    }


}


