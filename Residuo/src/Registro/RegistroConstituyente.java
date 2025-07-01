package Registro;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class RegistroConstituyente {
    private final Connection con;

    public RegistroConstituyente() {
        con = Conexion.getConnection();
    }

    public boolean create(Constituyente constituyente) throws SQLException {
        String sql = "INSERT INTO CONSTITUYENTE (ConNom, ConDes, ConGrad) VALUES (?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, constituyente.getConNom());
            ps.setString(2, constituyente.getConDes());
            
            if (constituyente.getConGrad() != null) {
                ps.setByte(3, constituyente.getConGrad());
            } else {
                ps.setNull(3, java.sql.Types.TINYINT);
            }
            
            int result = ps.executeUpdate();
            
            // Obtener el ID generado (aunque no lo estamos usando aquí)
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    constituyente.setConsCod(generatedKeys.getInt(1));
                }
            }
            
            return result > 0;
        }
    }

    public DefaultTableModel getDatos() {
        String[] columnas = {"Código", "Nombre", "Descripción", "Grado"};
        DefaultTableModel dtm = new DefaultTableModel(null, columnas) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 0 ? Integer.class : String.class;
            }
        };
        
        String sql = "SELECT ConsCod, ConNom, ConDes, ConGrad FROM CONSTITUYENTE ORDER BY ConsCod";
        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Object[] fila = new Object[4];
                fila[0] = rs.getInt("ConsCod");
                fila[1] = rs.getString("ConNom");
                fila[2] = rs.getString("ConDes");
                fila[3] = rs.getObject("ConGrad");  // Puede ser null
                dtm.addRow(fila);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar constituyentes: " + e.getMessage());
        }
        return dtm;
    }

    public boolean update(Constituyente constituyente) throws SQLException {
        String sql = "UPDATE CONSTITUYENTE SET ConNom = ?, ConDes = ?, ConGrad = ? WHERE ConsCod = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, constituyente.getConNom());
            ps.setString(2, constituyente.getConDes());
            
            if (constituyente.getConGrad() != null) {
                ps.setByte(3, constituyente.getConGrad());
            } else {
                ps.setNull(3, java.sql.Types.TINYINT);
            }
            
            ps.setInt(4, constituyente.getConsCod());
            return ps.executeUpdate() > 0;
        }
    }

    public boolean delete(int consCod) throws SQLException {
        String sql = "DELETE FROM CONSTITUYENTE WHERE ConsCod = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, consCod);
            return ps.executeUpdate() > 0;
        }
    }
}
