package Registro;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class TrasladoResiduoTableModel extends DefaultTableModel {
  private List<Object[]> codigosOcultos;

  public TrasladoResiduoTableModel() {
    super(
        new String[] { "Código", "Fecha", "Cantidad", "Descripción", "Residuo", "Empresa", "Transportista", "Destino" },
        0);
    codigosOcultos = new ArrayList<>();
  }

  public void addRowWithCodes(Object[] displayRow, Object[] hiddenCodes) {
    super.addRow(displayRow);
    codigosOcultos.add(hiddenCodes);
  }

  public Object[] getHiddenCodes(int row) {
    if (row >= 0 && row < codigosOcultos.size()) {
      return codigosOcultos.get(row);
    }
    return new Object[] { 0, 0, 0, 0 };
  }

  @Override
  public Class<?> getColumnClass(int columnIndex) {
    return columnIndex == 0 ? Integer.class : String.class;
  }

  @Override
  public void removeRow(int row) {
    super.removeRow(row);
    if (row < codigosOcultos.size()) {
      codigosOcultos.remove(row);
    }
  }

  @Override
  public void setRowCount(int rowCount) {
    super.setRowCount(rowCount);
    codigosOcultos.clear();
  }
}
