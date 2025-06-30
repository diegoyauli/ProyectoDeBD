package Registro;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class RegistroRegion {
    private final Connection con;

    public RegistroRegion() {
        con = Conexion.getConnection();
    }

    public boolean create(Region region) throws SQLException {
        String sql = "INSERT INTO REGION (RegCod, RegNom) VALUES (?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, region.getRegCod());
            ps.setString(2, region.getRegNom());
            return ps.executeUpdate() > 0;
        }
    }

    public DefaultTableModel getDatos() {
        String[] columnas = {"Código", "Nombre"};
        DefaultTableModel dtm = new DefaultTableModel(null, columnas);
        String sql = "SELECT RegCod, RegNom FROM REGION ORDER BY RegCod";
        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Object[] fila = new Object[2];
                fila[0] = rs.getInt("RegCod");
                fila[1] = rs.getString("RegNom");
                dtm.addRow(fila);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar regiones: " + e.getMessage());
        }
        return dtm;
    }

    public boolean update(Region region) throws SQLException {
        String sql = "UPDATE REGION SET RegNom = ? WHERE RegCod = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, region.getRegNom());
            ps.setInt(2, region.getRegCod());
            return ps.executeUpdate() > 0;
        }
    }

    public boolean delete(int regCod) throws SQLException {
        String sql = "DELETE FROM REGION WHERE RegCod = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, regCod);
            return ps.executeUpdate() > 0;
        }
    }
    
    public boolean existeRegion(int regCod) throws SQLException {
        String sql = "SELECT 1 FROM REGION WHERE RegCod = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, regCod);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }
}
