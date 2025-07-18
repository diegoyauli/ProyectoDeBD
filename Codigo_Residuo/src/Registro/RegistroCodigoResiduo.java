package Registro;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class RegistroCodigoResiduo {
    private final Connection con;

    public RegistroCodigoResiduo() {
        con = Conexion.getConnection();
    }

    public boolean create(CodigoResiduo codigoResiduo) throws SQLException {
        String sql = "INSERT INTO CODIGO_RESIDUO (CodResCod, CodResDesc, CodResEstReg) VALUES (?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, codigoResiduo.getCodResCod());
            ps.setString(2, codigoResiduo.getCodResDesc());
            ps.setString(3, codigoResiduo.getCodResEstReg());
            return ps.executeUpdate() > 0;
        }
    }

    public DefaultTableModel getDatos() {
        String[] columnas = {"Código", "Descripción", "Estado"};
        DefaultTableModel dtm = new DefaultTableModel(null, columnas);
        String sql = "SELECT CodResCod, CodResDesc, CodResEstReg FROM CODIGO_RESIDUO ORDER BY CodResCod";
        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Object[] fila = new Object[3];
                fila[0] = rs.getString("CodResCod");
                fila[1] = rs.getString("CodResDesc");
                fila[2] = rs.getString("CodResEstReg");
                dtm.addRow(fila);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar códigos de residuo: " + e.getMessage());
        }
        return dtm;
    }

    public boolean update(CodigoResiduo codigoResiduo) throws SQLException {
        String sql = "UPDATE CODIGO_RESIDUO SET CodResDesc = ? WHERE CodResCod = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, codigoResiduo.getCodResDesc());
            ps.setString(2, codigoResiduo.getCodResCod());
            return ps.executeUpdate() > 0;
        }
    }
    
    public boolean updateEstado(String codResCod, String estado) throws SQLException {
        String sql = "UPDATE CODIGO_RESIDUO SET CodResEstReg = ? WHERE CodResCod = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, estado);
            ps.setString(2, codResCod);
            return ps.executeUpdate() > 0;
        }
    }

    public boolean delete(String codResCod) throws SQLException {
        // Eliminación lógica (marcar como eliminado)
        String sql = "UPDATE CODIGO_RESIDUO SET CodResEstReg = '*' WHERE CodResCod = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, codResCod);
            return ps.executeUpdate() > 0;
        }
    }

    public boolean existeCodigoResiduo(String codResCod) throws SQLException {
        String sql = "SELECT 1 FROM CODIGO_RESIDUO WHERE CodResCod = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, codResCod);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }
}  
