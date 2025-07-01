package Registro;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class RegistroResiduo {
    private final Connection con;

    public RegistroResiduo() {
        con = Conexion.getConnection();
    }

    public boolean create(Residuo residuo) throws SQLException {
        String sql = "INSERT INTO RESIDUO (ResNom, ResDes, CodResCod, EmpCod) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, residuo.getResNom());
            ps.setString(2, residuo.getResDes());
            ps.setString(3, residuo.getCodResCod());
            ps.setInt(4, residuo.getEmpCod());
            
            int result = ps.executeUpdate();
            
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    residuo.setResCod(generatedKeys.getInt(1));
                }
            }
            
            return result > 0;
        }
    }

    public DefaultTableModel getDatos() {
        String[] columnas = {"Código", "Nombre", "Descripción", "Código Residuo", "Código Empresa"};
        DefaultTableModel dtm = new DefaultTableModel(null, columnas) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return (columnIndex == 0 || columnIndex == 4) ? Integer.class : String.class;
            }
        };
        
        String sql = "SELECT ResCod, ResNom, ResDes, CodResCod, EmpCod FROM RESIDUO ORDER BY ResCod";
        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Object[] fila = new Object[5];
                fila[0] = rs.getInt("ResCod");
                fila[1] = rs.getString("ResNom");
                fila[2] = rs.getString("ResDes");
                fila[3] = rs.getString("CodResCod");
                fila[4] = rs.getInt("EmpCod");
                dtm.addRow(fila);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar residuos: " + e.getMessage());
        }
        return dtm;
    }

    public boolean update(Residuo residuo) throws SQLException {
        String sql = "UPDATE RESIDUO SET ResNom = ?, ResDes = ?, CodResCod = ?, EmpCod = ? WHERE ResCod = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, residuo.getResNom());
            ps.setString(2, residuo.getResDes());
            ps.setString(3, residuo.getCodResCod());
            ps.setInt(4, residuo.getEmpCod());
            ps.setInt(5, residuo.getResCod());
            return ps.executeUpdate() > 0;
        }
    }

    public boolean delete(int resCod) throws SQLException {
        String sql = "DELETE FROM RESIDUO WHERE ResCod = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, resCod);
            return ps.executeUpdate() > 0;
        }
    }
}
