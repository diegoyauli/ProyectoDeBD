package Registro;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class RegistroResiduoConstituyente {
    private final Connection con;

    public RegistroResiduoConstituyente() {
        con = Conexion.getConnection();
    }

    public boolean create(ResiduoConstituyente residuoConstituyente) throws SQLException {
        String sql = "INSERT INTO RESIDUO_CONSTITUYENTE (ResCod, ConsCod, ResConsPorc) VALUES (?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, residuoConstituyente.getResCod());
            ps.setInt(2, residuoConstituyente.getConsCod());
            
            if (residuoConstituyente.getResConsPorc() != null) {
                ps.setBigDecimal(3, residuoConstituyente.getResConsPorc());
            } else {
                ps.setNull(3, java.sql.Types.NUMERIC);
            }
            
            int result = ps.executeUpdate();
            
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    residuoConstituyente.setResConsCod(generatedKeys.getInt(1));
                }
            }
            
            return result > 0;
        }
    }

    public DefaultTableModel getDatos() {
        String[] columnas = {"Código", "Residuo", "Constituyente", "Porcentaje (%)"};
        DefaultTableModel dtm = new DefaultTableModel(null, columnas) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 0) return Integer.class;
                if (columnIndex == 3) return Double.class;
                return String.class;
            }
        };
        
        String sql = "SELECT rc.ResConsCod, r.ResNom, c.ConNom, rc.ResConsPorc " +
                    "FROM RESIDUO_CONSTITUYENTE rc " +
                    "INNER JOIN RESIDUO r ON rc.ResCod = r.ResCod " +
                    "INNER JOIN CONSTITUYENTE c ON rc.ConsCod = c.ConsCod " +
                    "ORDER BY rc.ResConsCod";
        
        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Object[] fila = new Object[4];
                fila[0] = rs.getInt("ResConsCod");
                fila[1] = rs.getString("ResNom");
                fila[2] = rs.getString("ConNom");
                fila[3] = rs.getObject("ResConsPorc");
                dtm.addRow(fila);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar residuo-constituyentes: " + e.getMessage());
        }
        return dtm;
    }

    public boolean update(ResiduoConstituyente residuoConstituyente) throws SQLException {
        String sql = "UPDATE RESIDUO_CONSTITUYENTE SET ResCod = ?, ConsCod = ?, ResConsPorc = ? WHERE ResConsCod = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, residuoConstituyente.getResCod());
            ps.setInt(2, residuoConstituyente.getConsCod());
            
            if (residuoConstituyente.getResConsPorc() != null) {
                ps.setBigDecimal(3, residuoConstituyente.getResConsPorc());
            } else {
                ps.setNull(3, java.sql.Types.NUMERIC);
            }
            
            ps.setInt(4, residuoConstituyente.getResConsCod());
            return ps.executeUpdate() > 0;
        }
    }

    public boolean delete(int resConsCod) throws SQLException {
        String sql = "DELETE FROM RESIDUO_CONSTITUYENTE WHERE ResConsCod = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, resConsCod);
            return ps.executeUpdate() > 0;
        }
    }

    public DefaultComboBoxModel<ComboItem> getResiduos() {
        DefaultComboBoxModel<ComboItem> model = new DefaultComboBoxModel<>();
        String sql = "SELECT ResCod, ResNom FROM RESIDUO ORDER BY ResNom";
        
        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                model.addElement(new ComboItem(rs.getInt("ResCod"), rs.getString("ResNom")));
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar residuos: " + e.getMessage());
        }
        return model;
    }

    public DefaultComboBoxModel<ComboItem> getConstituyentes() {
        DefaultComboBoxModel<ComboItem> model = new DefaultComboBoxModel<>();
        String sql = "SELECT ConsCod, ConNom FROM CONSTITUYENTE ORDER BY ConNom";
        
        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                model.addElement(new ComboItem(rs.getInt("ConsCod"), rs.getString("ConNom")));
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar constituyentes: " + e.getMessage());
        }
        return model;
    }

    public ResiduoConstituyente getById(int resConsCod) throws SQLException {
        String sql = "SELECT rc.*, r.ResNom, c.ConNom " +
                    "FROM RESIDUO_CONSTITUYENTE rc " +
                    "INNER JOIN RESIDUO r ON rc.ResCod = r.ResCod " +
                    "INNER JOIN CONSTITUYENTE c ON rc.ConsCod = c.ConsCod " +
                    "WHERE rc.ResConsCod = ?";
        
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, resConsCod);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    ResiduoConstituyente rc = new ResiduoConstituyente();
                    rc.setResConsCod(rs.getInt("ResConsCod"));
                    rc.setResCod(rs.getInt("ResCod"));
                    rc.setConsCod(rs.getInt("ConsCod"));
                    rc.setResConsPorc(rs.getBigDecimal("ResConsPorc"));
                    rc.setResNom(rs.getString("ResNom"));
                    rc.setConNom(rs.getString("ConNom"));
                    return rc;
                }
            }
        }
        return null;
    }

    public static class ComboItem {
        private int id;
        private String nombre;

        public ComboItem(int id, String nombre) {
            this.id = id;
            this.nombre = nombre;
        }

        public int getId() {
            return id;
        }

        public String getNombre() {
            return nombre;
        }

        @Override
        public String toString() {
            return nombre;
        }
    }
}
