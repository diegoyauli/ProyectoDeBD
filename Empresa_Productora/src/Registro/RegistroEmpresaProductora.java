package Registro;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class RegistroEmpresaProductora {
    private final Connection con;

    public RegistroEmpresaProductora() {
        con = Conexion.getConnection();
    }

    public boolean create(EmpresaProductora empresa) throws SQLException {
        String sql = "INSERT INTO EMPRESA_PRODUCTORA (EmpNom, EmpRUC, EmpDir, EmpAct, RegCod) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, empresa.getEmpNom());
            ps.setString(2, empresa.getEmpRUC());
            ps.setString(3, empresa.getEmpDir());
            ps.setString(4, empresa.getEmpAct());
            ps.setInt(5, empresa.getRegCod());
            
            int result = ps.executeUpdate();
            
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    empresa.setEmpCod(generatedKeys.getInt(1));
                }
            }
            
            return result > 0;
        }
    }

    public DefaultTableModel getDatos() {
        String[] columnas = {"Código", "Nombre", "RUC", "Dirección", "Actividad", "Código Región"};
        DefaultTableModel dtm = new DefaultTableModel(null, columnas) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 0 || columnIndex == 5 ? Integer.class : String.class;
            }
        };
        
        String sql = "SELECT EmpCod, EmpNom, EmpRUC, EmpDir, EmpAct, RegCod FROM EMPRESA_PRODUCTORA ORDER BY EmpCod";
        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Object[] fila = new Object[6];
                fila[0] = rs.getInt("EmpCod");
                fila[1] = rs.getString("EmpNom");
                fila[2] = rs.getString("EmpRUC");
                fila[3] = rs.getString("EmpDir");
                fila[4] = rs.getString("EmpAct");
                fila[5] = rs.getInt("RegCod");
                dtm.addRow(fila);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar empresas productoras: " + e.getMessage());
        }
        return dtm;
    }

    public boolean update(EmpresaProductora empresa) throws SQLException {
        String sql = "UPDATE EMPRESA_PRODUCTORA SET EmpNom = ?, EmpRUC = ?, EmpDir = ?, EmpAct = ?, RegCod = ? WHERE EmpCod = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, empresa.getEmpNom());
            ps.setString(2, empresa.getEmpRUC());
            ps.setString(3, empresa.getEmpDir());
            ps.setString(4, empresa.getEmpAct());
            ps.setInt(5, empresa.getRegCod());
            ps.setInt(6, empresa.getEmpCod());
            return ps.executeUpdate() > 0;
        }
    }

    public boolean delete(int empCod) throws SQLException {
        String sql = "DELETE FROM EMPRESA_PRODUCTORA WHERE EmpCod = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, empCod);
            return ps.executeUpdate() > 0;
        }
    }
}
