package Registro;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class RegistroEmpresaTransportista {
    private final Connection con;

    public RegistroEmpresaTransportista() {
        con = Conexion.getConnection();
    }

    public boolean create(EmpresaTransportista empresa) throws SQLException {
        String sql = "INSERT INTO EMPRESA_TRANSPORTISTA (TrsNom, TrsRUC, TrsDir, TrsCap, RegCod, EstReg) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, empresa.getTrsNom());
            ps.setString(2, empresa.getTrsRUC());
            ps.setString(3, empresa.getTrsDir());
            
            if (empresa.getTrsCap() != null) {
                ps.setBigDecimal(4, empresa.getTrsCap());
            } else {
                ps.setNull(4, java.sql.Types.NUMERIC);
            }
            
            ps.setInt(5, empresa.getRegCod());
            
            // Establecer el estado (A: activo por defecto)
            ps.setString(6, empresa.getEstReg() != null ? empresa.getEstReg() : "A");
            
            int result = ps.executeUpdate();
            
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    empresa.setTrsEmpCod(generatedKeys.getInt(1));
                }
            }
            
            return result > 0;
        }
    }

    public DefaultTableModel getDatos() {
        String[] columnas = {"Código", "Nombre", "RUC", "Dirección", "Capacidad", "Código Región", "Estado"};
        DefaultTableModel dtm = new DefaultTableModel(null, columnas) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 0 || columnIndex == 5 ? Integer.class : String.class;
            }
        };
        
        String sql = "SELECT TrsEmpCod, TrsNom, TrsRUC, TrsDir, TrsCap, RegCod, EstReg FROM EMPRESA_TRANSPORTISTA ORDER BY TrsEmpCod";
        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Object[] fila = new Object[7];
                fila[0] = rs.getInt("TrsEmpCod");
                fila[1] = rs.getString("TrsNom");
                fila[2] = rs.getString("TrsRUC");
                fila[3] = rs.getString("TrsDir");
                fila[4] = rs.getBigDecimal("TrsCap");
                fila[5] = rs.getInt("RegCod");
                fila[6] = rs.getString("EstReg");  // Agregar el estado
                dtm.addRow(fila);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar empresas transportistas: " + e.getMessage());
        }
        return dtm;
    }

    public boolean update(EmpresaTransportista empresa) throws SQLException {
        String sql = "UPDATE EMPRESA_TRANSPORTISTA SET TrsNom = ?, TrsRUC = ?, TrsDir = ?, TrsCap = ?, RegCod = ?, EstReg = ? WHERE TrsEmpCod = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, empresa.getTrsNom());
            ps.setString(2, empresa.getTrsRUC());
            ps.setString(3, empresa.getTrsDir());
            
            if (empresa.getTrsCap() != null) {
                ps.setBigDecimal(4, empresa.getTrsCap());
            } else {
                ps.setNull(4, java.sql.Types.NUMERIC);
            }
            
            ps.setInt(5, empresa.getRegCod());
            ps.setString(6, empresa.getEstReg());
            ps.setInt(7, empresa.getTrsEmpCod());
            return ps.executeUpdate() > 0;
        }
    }
    
    public boolean updateEstado(int trsEmpCod, String estado) throws SQLException {
        String sql = "UPDATE EMPRESA_TRANSPORTISTA SET EstReg = ? WHERE TrsEmpCod = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, estado);
            ps.setInt(2, trsEmpCod);
            return ps.executeUpdate() > 0;
        }
    }

    public boolean delete(int trsEmpCod) throws SQLException {
        String sql = "DELETE FROM EMPRESA_TRANSPORTISTA WHERE TrsEmpCod = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, trsEmpCod);
            return ps.executeUpdate() > 0;
        }
    }
}
