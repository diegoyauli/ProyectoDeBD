package Registro;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import javax.swing.table.DefaultTableModel;

public class RegistroTrasladoResiduo {
  private final Connection con;

  public RegistroTrasladoResiduo() {
    con = Conexion.getConnection();
  }

  public boolean create(TrasladoResiduo traslado) throws SQLException {
    String sql = "INSERT INTO TRASLADO_RESIDUO (TrasFec, TrasCant, TrasDsc, ResCod, EmpCod, TrsEmpCod, DestCod) VALUES (?, ?, ?, ?, ?, ?, ?)";
    try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
      ps.setDate(1, Date.valueOf(traslado.getTrasFec()));
      ps.setBigDecimal(2, traslado.getTrasCant());
      ps.setString(3, traslado.getTrasDsc());
      ps.setInt(4, traslado.getResCod());
      ps.setInt(5, traslado.getEmpCod());
      ps.setInt(6, traslado.getTrsEmpCod());
      ps.setInt(7, traslado.getDestCod());

      int result = ps.executeUpdate();

      try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
        if (generatedKeys.next()) {
          traslado.setTrasCod(generatedKeys.getInt(1));
        }
      }

      return result > 0;
    }
  }

  public DefaultTableModel getDatos() {
    String[] columnas = { "Código", "Fecha", "Cantidad", "Descripción", "Residuo", "Empresa", "Transportista",
        "Destino" };
    DefaultTableModel dtm = new DefaultTableModel(null, columnas) {
      @Override
      public Class<?> getColumnClass(int columnIndex) {
        return columnIndex == 0 ? Integer.class : String.class;
      }
    };

    String sql = "SELECT t.TrasCod, t.TrasFec, t.TrasCant, t.TrasDsc, " +
        "r.ResNom, e.EmpNom, tr.TrsNom, d.DestNom " +
        "FROM TRASLADO_RESIDUO t " +
        "JOIN RESIDUO r ON t.ResCod = r.ResCod " +
        "JOIN EMPRESA_PRODUCTORA e ON t.EmpCod = e.EmpCod " +
        "JOIN EMPRESA_TRANSPORTISTA tr ON t.TrsEmpCod = tr.TrsEmpCod " +
        "JOIN DESTINO d ON t.DestCod = d.DestCod " +
        "ORDER BY t.TrasCod";
    try (PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery()) {
      while (rs.next()) {
        Object[] fila = new Object[8];
        fila[0] = rs.getInt("TrasCod");
        fila[1] = rs.getDate("TrasFec");
        fila[2] = rs.getBigDecimal("TrasCant");
        fila[3] = rs.getString("TrasDsc");
        fila[4] = rs.getString("ResNom");
        fila[5] = rs.getString("EmpNom");
        fila[6] = rs.getString("TrsNom");
        fila[7] = rs.getString("DestNom");
        dtm.addRow(fila);
      }
    } catch (SQLException e) {
      System.out.println("Error al listar traslados: " + e.getMessage());
    }
    return dtm;
  }

  // Método auxiliar para obtener los códigos de una fila específica
  public Object[] getCodigosFromRow(int trasCod) {
    String sql = "SELECT ResCod, EmpCod, TrsEmpCod, DestCod FROM TRASLADO_RESIDUO WHERE TrasCod = ?";
    try (PreparedStatement ps = con.prepareStatement(sql)) {
      ps.setInt(1, trasCod);
      try (ResultSet rs = ps.executeQuery()) {
        if (rs.next()) {
          return new Object[] {
              rs.getInt("ResCod"),
              rs.getInt("EmpCod"),
              rs.getInt("TrsEmpCod"),
              rs.getInt("DestCod")
          };
        }
      }
    } catch (SQLException e) {
      System.out.println("Error al obtener códigos: " + e.getMessage());
    }
    return new Object[] { 0, 0, 0, 0 };
  }

  public boolean update(TrasladoResiduo traslado) throws SQLException {
    String sql = "UPDATE TRASLADO_RESIDUO SET TrasFec = ?, TrasCant = ?, TrasDsc = ?, ResCod = ?, EmpCod = ?, TrsEmpCod = ?, DestCod = ? WHERE TrasCod = ?";
    try (PreparedStatement ps = con.prepareStatement(sql)) {
      ps.setDate(1, Date.valueOf(traslado.getTrasFec()));
      ps.setBigDecimal(2, traslado.getTrasCant());
      ps.setString(3, traslado.getTrasDsc());
      ps.setInt(4, traslado.getResCod());
      ps.setInt(5, traslado.getEmpCod());
      ps.setInt(6, traslado.getTrsEmpCod());
      ps.setInt(7, traslado.getDestCod());
      ps.setInt(8, traslado.getTrasCod());
      return ps.executeUpdate() > 0;
    }
  }

  public boolean delete(int trasCod) throws SQLException {
    String sql = "DELETE FROM TRASLADO_RESIDUO WHERE TrasCod = ?";
    try (PreparedStatement ps = con.prepareStatement(sql)) {
      ps.setInt(1, trasCod);
      return ps.executeUpdate() > 0;
    }
  }
}
