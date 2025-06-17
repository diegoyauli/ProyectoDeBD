
package Registro;
import Conexion.Conexion;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class RegistritoResiduos {

    // Conexión a la base de datos ResiduosToxicos
    Conexion cx = new Conexion("ResiduosToxicos");

    private DefaultTableModel DT;

    public RegistritoResiduos() {
    }

    // Método para configurar los títulos de las columnas de la tabla
    private DefaultTableModel setTitulos() {
        DT = new DefaultTableModel();
        DT.addColumn("ResCod");
        DT.addColumn("ResNom");
        DT.addColumn("ResDes");
        DT.addColumn("ResEstReg");
        return DT;
    }

    // Método para insertar un nuevo residuo en la tabla R1M_RESIDUO
    public boolean create(Residuos residuo) {
        String sqlInsert = "INSERT INTO R1M_RESIDUO (ResCod, ResNom, ResDes, ResEstReg) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = cx.conectar().prepareStatement(sqlInsert)) {
            // Establecemos los valores de los campos en la tabla
            ps.setInt(1, residuo.getResCod()); // Ingresar el ResCod manualmente
            ps.setString(2, residuo.getResNom()); // Nombre del residuo
            ps.setString(3, residuo.getResDes()); // Descripción del residuo
            ps.setString(4, residuo.getResEstReg()); // Estado del registro (Activo/Inactivo)
            // Ejecutamos el INSERT
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(RegistritoResiduos.class.getName()).log(Level.SEVERE, "Error al insertar el residuo", ex);
            return false;
        } finally {
            cx.desconectar();  // Aseguramos que siempre se desconecte después de ejecutar la consulta
        }
    }

    // Método para obtener los datos y mostrarlos en el JTable (con el modelo DefaultTableModel)
    public DefaultTableModel getDatos() {
        try {
            setTitulos();  // Configuramos los títulos de las columnas
            String sqlSelect = "SELECT ResCod, ResNom, ResDes, ResEstReg FROM R1M_RESIDUO";  // Corrección en la consulta SELECT
            try (PreparedStatement ps = cx.conectar().prepareStatement(sqlSelect); ResultSet rs = ps.executeQuery()) {
                Object[] fila = new Object[4];
                while (rs.next()) {
                    fila[0] = rs.getInt("ResCod");
                    fila[1] = rs.getString("ResNom");
                    fila[2] = rs.getString("ResDes");
                    fila[3] = rs.getString("ResEstReg");
                    DT.addRow(fila);  // Añadimos la fila al modelo
                }
            }
        } catch (SQLException e) {
            System.out.print("Error al mostrar los datos..." + e.getMessage());
        } finally {
            cx.desconectar();  // Aseguramos que siempre se desconecte después de ejecutar la consulta
        }
        return DT;
    }

    public boolean actualizarResiduo(int ResCod, String ResNom, String ResDes, String ResEstReg) {
        String sqlUpdate = "UPDATE R1M_RESIDUO SET ResNom = ?, ResDes = ?, ResEstReg = ? WHERE ResCod = ?";
        try (PreparedStatement ps = cx.conectar().prepareStatement(sqlUpdate)) {
            ps.setString(1, ResNom);
            ps.setString(2, ResDes);
            ps.setString(3, ResEstReg); // Cambia el estado a "A" (Activo) o "I" (Inactivo)
            ps.setInt(4, ResCod);  // El código del residuo para identificarlo
            // Ejecutar la consulta
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;  // Retorna true si se actualizó correctamente
        } catch (SQLException ex) {
            Logger.getLogger(RegistritoResiduos.class.getName()).log(Level.SEVERE, "Error al actualizar el residuo", ex);
            return false;  // Hubo un error al actualizar el residuo
        } finally {
            cx.desconectar();  // Aseguramos que se desconecte siempre
        }
    }

    public boolean eliminarResiduo(int ResCod) {
        String sqlDelete = "DELETE FROM R1M_RESIDUO WHERE ResCod = ?";
        try (PreparedStatement ps = cx.conectar().prepareStatement(sqlDelete)) {
            ps.setInt(1, ResCod);  // El código del residuo que se desea eliminar
            // Ejecutar la consulta
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;  // Retorna true si se eliminó correctamente
        } catch (SQLException ex) {
            Logger.getLogger(RegistritoResiduos.class.getName()).log(Level.SEVERE, "Error al eliminar el residuo", ex);
            return false;  // Hubo un error al eliminar el residuo
        } finally {
            cx.desconectar();  // Aseguramos que se desconecte siempre
        }
    }

    public boolean inactivarResiduo(int ResCod) {
        String sqlUpdate = "UPDATE R1M_RESIDUO SET ResEstReg = 'I' WHERE ResCod = ?";
        try (PreparedStatement ps = cx.conectar().prepareStatement(sqlUpdate)) {
            ps.setInt(1, ResCod);  // El código del residuo que se desea inactivar
            // Ejecutar la consulta
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;  // Retorna true si se actualizó correctamente
        } catch (SQLException ex) {
            Logger.getLogger(RegistritoResiduos.class.getName()).log(Level.SEVERE, "Error al inactivar el residuo", ex);
            return false;  // Hubo un error al inactivar el residuo
        } finally {
            cx.desconectar();  // Aseguramos que se desconecte siempre
        }
    }

    public boolean reactivarResiduo(int ResCod) {
        String sqlUpdate = "UPDATE R1M_RESIDUO SET ResEstReg = 'A' WHERE ResCod = ?";
        try (PreparedStatement ps = cx.conectar().prepareStatement(sqlUpdate)) {
            ps.setInt(1, ResCod);  // El código del residuo que se desea reactivar
            // Ejecutar la consulta
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;  // Retorna true si se actualizó correctamente
        } catch (SQLException ex) {
            Logger.getLogger(RegistritoResiduos.class.getName()).log(Level.SEVERE, "Error al reactivar el residuo", ex);
            return false;  // Hubo un error al reactivar el residuo
        } finally {
            cx.desconectar();  // Aseguramos que se desconecte siempre
        }
    }
public boolean actualizarEstadoResiduo(int ResCod, String nuevoEstado) {
    // Verificar que el nuevo estado sea válido (activo o inactivo)
    if (!nuevoEstado.equals("A") && !nuevoEstado.equals("I")) {
        System.out.println("Estado no válido. Debe ser 'A' para Activo o 'I' para Inactivo.");
        return false;
    }

    // Consulta SQL para actualizar el estado del residuo
    String sqlUpdate = "UPDATE R1M_RESIDUO SET ResEstReg = ? WHERE ResCod = ?";

    try (PreparedStatement ps = cx.conectar().prepareStatement(sqlUpdate)) {
        ps.setString(1, nuevoEstado);  // Asignar el nuevo estado ("A" o "I")
        ps.setInt(2, ResCod);           // El código del residuo a actualizar

        // Ejecutar la actualización
        int filasAfectadas = ps.executeUpdate();

        // Verificar si se actualizó alguna fila
        if (filasAfectadas > 0) {
            System.out.println("Residuo actualizado a estado: " + nuevoEstado);
            return true;  // Se actualizó correctamente
        } else {
            System.out.println("No se encontró el residuo con el código: " + ResCod);
            return false;  // No se encontró el residuo
        }
    } catch (SQLException ex) {
        Logger.getLogger(RegistritoResiduos.class.getName()).log(Level.SEVERE, "Error al actualizar el estado del residuo", ex);
        return false;  // Hubo un error en la actualización
    } finally {
        cx.desconectar();  // Aseguramos que se desconecte siempre
    }
}

    public void actualizarResiduo(int ResCod, String inactivo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}


