package Registro;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class RegistroDestino {
    private final Connection con;

    public RegistroDestino() {
        con = Conexion.getConnection();
    }

    public boolean create(Destino destino) throws SQLException {
        String sql = "INSERT INTO DESTINO (DestNom, DestDir, DestCap, DestCapAct, RegCod) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, destino.getDestNom());
            ps.setString(2, destino.getDestDir());
            
            if (destino.getDestCap() != null) {
                ps.setBigDecimal(3, destino.getDestCap());
            } else {
                ps.setNull(3, java.sql.Types.NUMERIC);
            }
            
            if (destino.getDestCapAct() != null) {
                ps.setBigDecimal(4, destino.getDestCapAct());
            } else {
                ps.setNull(4, java.sql.Types.NUMERIC);
            }
            
            ps.setInt(5, destino.getRegCod());
            
            int result = ps.executeUpdate();
            
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    destino.setDestCod(generatedKeys.getInt(1));
                }
            }
            
            return result > 0;
        }
    }

    public DefaultTableModel getDatos() {
        String[] columnas = {"Código", "Nombre", "Dirección", "Capacidad", "Cap. Actual", "Código Región"};
        DefaultTableModel dtm = new DefaultTableModel(null, columnas) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return (columnIndex == 0 || columnIndex == 5) ? Integer.class : String.class;
            }
        };
        
        String sql = "SELECT DestCod, DestNom, DestDir, DestCap, DestCapAct, RegCod FROM DESTINO ORDER BY DestCod";
        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Object[] fila = new Object[6];
                fila[0] = rs.getInt("DestCod");
                fila[1] = rs.getString("DestNom");
                fila[2] = rs.getString("DestDir");
                fila[3] = rs.getBigDecimal("DestCap");
                fila[4] = rs.getBigDecimal("DestCapAct");
                fila[5] = rs.getInt("RegCod");
                dtm.addRow(fila);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar destinos: " + e.getMessage());
        }
        return dtm;
    }

    public boolean update(Destino destino) throws SQLException {
        String sql = "UPDATE DESTINO SET DestNom = ?, DestDir = ?, DestCap = ?, DestCapAct = ?, RegCod = ? WHERE DestCod = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, destino.getDestNom());
            ps.setString(2, destino.getDestDir());
            
            if (destino.getDestCap() != null) {
                ps.setBigDecimal(3, destino.getDestCap());
            } else {
                ps.setNull(3, java.sql.Types.NUMERIC);
            }
            
            if (destino.getDestCapAct() != null) {
                ps.setBigDecimal(4, destino.getDestCapAct());
            } else {
                ps.setNull(4, java.sql.Types.NUMERIC);
            }
            
            ps.setInt(5, destino.getRegCod());
            ps.setInt(6, destino.getDestCod());
            return ps.executeUpdate() > 0;
        }
    }

    public boolean delete(int destCod) throws SQLException {
        String sql = "DELETE FROM DESTINO WHERE DestCod = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, destCod);
            return ps.executeUpdate() > 0;
        }
    }
}
