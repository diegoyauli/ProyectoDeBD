package Formularios;

import Registro.RegistroTrasladoResiduo;
import Registro.TrasladoResiduo;
import Validadores.ResiduosToxicosValidator;
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class InformacionTrasladoResiduo extends javax.swing.JFrame {
  private final RegistroTrasladoResiduo RT;
  private final ResiduosToxicosValidator validator;
  private final Connection con;

  public InformacionTrasladoResiduo() {
    initComponents();
    con = Conexion.getConnection();
    validator = new ResiduosToxicosValidator(con);
    RT = new RegistroTrasladoResiduo();
    listar();
    this.setLocationRelativeTo(null);
  }

  private void listar() {
    tblTraslados.setModel(RT.getDatos());
  }

  private void limpiarCampos() {
    txtCodigo.setText("");
    txtFecha.setText("");
    txtCantidad.setText("");
    txtDescripcion.setText("");
    txtResiduo.setText("");
    txtEmpresa.setText("");
    txtTransportista.setText("");
    txtDestino.setText("");
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated
  // Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPanel1 = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    jPanel2 = new javax.swing.JPanel();
    jLabel2 = new javax.swing.JLabel();
    txtCodigo = new javax.swing.JTextField();
    jLabel3 = new javax.swing.JLabel();
    txtFecha = new javax.swing.JTextField();
    jLabel4 = new javax.swing.JLabel();
    txtCantidad = new javax.swing.JTextField();
    jLabel5 = new javax.swing.JLabel();
    jScrollPane2 = new javax.swing.JScrollPane();
    txtDescripcion = new javax.swing.JTextArea();
    jLabel6 = new javax.swing.JLabel();
    txtResiduo = new javax.swing.JTextField();
    jLabel7 = new javax.swing.JLabel();
    txtEmpresa = new javax.swing.JTextField();
    jLabel8 = new javax.swing.JLabel();
    txtTransportista = new javax.swing.JTextField();
    jLabel9 = new javax.swing.JLabel();
    txtDestino = new javax.swing.JTextField();
    jLabel10 = new javax.swing.JLabel();
    jScrollPane1 = new javax.swing.JScrollPane();
    tblTraslados = new javax.swing.JTable();
    btnAdicionar = new javax.swing.JButton();
    btnModificar = new javax.swing.JButton();
    btnEliminar = new javax.swing.JButton();
    btnCancelar = new javax.swing.JButton();
    btnActualizar = new javax.swing.JButton();
    btnSalir = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Gestión de Traslados de Residuos");

    jPanel1.setBackground(new java.awt.Color(102, 0, 153));

    jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
    jLabel1.setForeground(new java.awt.Color(255, 255, 255));
    jLabel1.setText("Gestión de Traslados de Residuos");

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap()));

    jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Traslado"));

    jLabel2.setText("Código:");

    txtCodigo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    txtCodigo.setEnabled(false);

    jLabel3.setText("Fecha (YYYY-MM-DD):");

    txtFecha.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

    jLabel4.setText("Cantidad:");

    txtCantidad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

    jLabel5.setText("Descripción:");

    txtDescripcion.setColumns(20);
    txtDescripcion.setRows(3);
    jScrollPane2.setViewportView(txtDescripcion);

    jLabel6.setText("Código Residuo:");

    txtResiduo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

    jLabel7.setText("Código Empresa:");

    txtEmpresa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

    jLabel8.setText("Código Transportista:");

    txtTransportista.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

    jLabel9.setText("Código Destino:");

    txtDestino.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300,
                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtResiduo, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTransportista, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
    jPanel2Layout.setVerticalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 60,
                        javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtResiduo, javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtTransportista, javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtDestino, javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

    jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel10.setText("Traslados Registrados:");

    tblTraslados.setModel(new javax.swing.table.DefaultTableModel(
        new Object[][] {
            { null, null, null, null, null, null, null, null },
            { null, null, null, null, null, null, null, null },
            { null, null, null, null, null, null, null, null },
            { null, null, null, null, null, null, null, null }
        },
        new String[] {
            "Código", "Fecha", "Cantidad", "Descripción", "Residuo", "Empresa", "Transportista", "Destino"
        }) {
      boolean[] canEdit = new boolean[] {
          false, false, false, false, false, false, false, false
      };

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit[columnIndex];
      }
    });
    tblTraslados.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    tblTraslados.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        tblTrasladosMouseClicked(evt);
      }
    });
    jScrollPane1.setViewportView(tblTraslados);

    btnAdicionar.setBackground(new java.awt.Color(0, 153, 51));
    btnAdicionar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    btnAdicionar.setForeground(new java.awt.Color(255, 255, 255));
    btnAdicionar.setText("Adicionar");
    btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnAdicionarActionPerformed(evt);
      }
    });

    btnModificar.setBackground(new java.awt.Color(51, 102, 255));
    btnModificar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    btnModificar.setForeground(new java.awt.Color(255, 255, 255));
    btnModificar.setText("Modificar");
    btnModificar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnModificarActionPerformed(evt);
      }
    });

    btnEliminar.setBackground(new java.awt.Color(204, 0, 0));
    btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
    btnEliminar.setText("Eliminar");
    btnEliminar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnEliminarActionPerformed(evt);
      }
    });

    btnCancelar.setBackground(new java.awt.Color(153, 153, 153));
    btnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
    btnCancelar.setText("Cancelar");
    btnCancelar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnCancelarActionPerformed(evt);
      }
    });

    btnActualizar.setBackground(new java.awt.Color(102, 102, 102));
    btnActualizar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
    btnActualizar.setText("Actualizar");
    btnActualizar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnActualizarActionPerformed(evt);
      }
    });

    btnSalir.setBackground(new java.awt.Color(51, 51, 51));
    btnSalir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    btnSalir.setForeground(new java.awt.Color(255, 255, 255));
    btnSalir.setText("Salir");
    btnSalir.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnSalirActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                        Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnAdicionar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnActualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir)
                .addContainerGap(20, Short.MAX_VALUE)));
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                    javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                    javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200,
                    javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnCancelar)
                    .addComponent(btnActualizar)
                    .addComponent(btnSalir))
                .addContainerGap(20, Short.MAX_VALUE)));

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAdicionarActionPerformed
    try {
      LocalDate fecha = LocalDate.parse(txtFecha.getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
      BigDecimal cantidad = new BigDecimal(txtCantidad.getText());
      String descripcion = txtDescripcion.getText().trim();
      int resCod = Integer.parseInt(txtResiduo.getText());
      int empCod = Integer.parseInt(txtEmpresa.getText());
      int trsEmpCod = Integer.parseInt(txtTransportista.getText());
      int destCod = Integer.parseInt(txtDestino.getText());

      // Validaciones usando el validator
      if (!validator.validateTrasladoResiduo(fecha, cantidad, descripcion, resCod, empCod, trsEmpCod, destCod)) {
        JOptionPane.showMessageDialog(this, "Datos inválidos o referencias no existen", "Error",
            JOptionPane.ERROR_MESSAGE);
        return;
      }

      TrasladoResiduo nuevo = new TrasladoResiduo();
      nuevo.setTrasFec(fecha);
      nuevo.setTrasCant(cantidad);
      nuevo.setTrasDsc(descripcion);
      nuevo.setResCod(resCod);
      nuevo.setEmpCod(empCod);
      nuevo.setTrsEmpCod(trsEmpCod);
      nuevo.setDestCod(destCod);

      if (RT.create(nuevo)) {
        JOptionPane.showMessageDialog(this, "Traslado adicionado correctamente", "Éxito",
            JOptionPane.INFORMATION_MESSAGE);
        listar();
        limpiarCampos();
      } else {
        JOptionPane.showMessageDialog(this, "Error al adicionar el traslado", "Error", JOptionPane.ERROR_MESSAGE);
      }
    } catch (Exception e) {
      JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
  }// GEN-LAST:event_btnAdicionarActionPerformed

  private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnModificarActionPerformed
    try {
      if (txtCodigo.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Seleccione un traslado primero", "Error", JOptionPane.ERROR_MESSAGE);
        return;
      }

      int codigo = Integer.parseInt(txtCodigo.getText());
      LocalDate fecha = LocalDate.parse(txtFecha.getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
      BigDecimal cantidad = new BigDecimal(txtCantidad.getText());
      String descripcion = txtDescripcion.getText().trim();
      int resCod = Integer.parseInt(txtResiduo.getText());
      int empCod = Integer.parseInt(txtEmpresa.getText());
      int trsEmpCod = Integer.parseInt(txtTransportista.getText());
      int destCod = Integer.parseInt(txtDestino.getText());

      if (!validator.validateTrasladoResiduo(fecha, cantidad, descripcion, resCod, empCod, trsEmpCod, destCod)) {
        JOptionPane.showMessageDialog(this, "Datos inválidos o referencias no existen", "Error",
            JOptionPane.ERROR_MESSAGE);
        return;
      }

      TrasladoResiduo actualizado = new TrasladoResiduo();
      actualizado.setTrasCod(codigo);
      actualizado.setTrasFec(fecha);
      actualizado.setTrasCant(cantidad);
      actualizado.setTrasDsc(descripcion);
      actualizado.setResCod(resCod);
      actualizado.setEmpCod(empCod);
      actualizado.setTrsEmpCod(trsEmpCod);
      actualizado.setDestCod(destCod);

      if (RT.update(actualizado)) {
        JOptionPane.showMessageDialog(this, "Traslado actualizado correctamente", "Éxito",
            JOptionPane.INFORMATION_MESSAGE);
        listar();
        limpiarCampos();
      } else {
        JOptionPane.showMessageDialog(this, "Error al actualizar el traslado", "Error", JOptionPane.ERROR_MESSAGE);
      }
    } catch (Exception e) {
      JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
  }// GEN-LAST:event_btnModificarActionPerformed

  private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnEliminarActionPerformed
    try {
      if (txtCodigo.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Seleccione un traslado primero", "Error", JOptionPane.ERROR_MESSAGE);
        return;
      }

      int codigo = Integer.parseInt(txtCodigo.getText());

      int confirm = JOptionPane.showConfirmDialog(this,
          "¿Está seguro de eliminar este traslado?",
          "Confirmar eliminación",
          JOptionPane.YES_NO_OPTION);

      if (confirm == JOptionPane.YES_OPTION) {
        if (RT.delete(codigo)) {
          JOptionPane.showMessageDialog(this, "Traslado eliminado correctamente", "Éxito",
              JOptionPane.INFORMATION_MESSAGE);
          listar();
          limpiarCampos();
        } else {
          JOptionPane.showMessageDialog(this, "Error al eliminar el traslado", "Error", JOptionPane.ERROR_MESSAGE);
        }
      }
    } catch (Exception e) {
      JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
  }// GEN-LAST:event_btnEliminarActionPerformed

  private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCancelarActionPerformed
    limpiarCampos();
  }// GEN-LAST:event_btnCancelarActionPerformed

  private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnActualizarActionPerformed
    listar();
  }// GEN-LAST:event_btnActualizarActionPerformed

  private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSalirActionPerformed
    System.exit(0);
  }// GEN-LAST:event_btnSalirActionPerformed

  private void tblTrasladosMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tblTrasladosMouseClicked
    int fila = tblTraslados.getSelectedRow();
    if (fila >= 0) {
      // Obtener el código del traslado seleccionado
      int trasCod = (Integer) tblTraslados.getValueAt(fila, 0);

      // Cargar los datos básicos (que se muestran correctamente)
      txtCodigo.setText(String.valueOf(trasCod));
      txtFecha.setText(tblTraslados.getValueAt(fila, 1).toString());
      txtCantidad.setText(tblTraslados.getValueAt(fila, 2).toString());
      txtDescripcion.setText(tblTraslados.getValueAt(fila, 3).toString());

      // Obtener los códigos reales desde la base de datos
      Object[] codigos = RT.getCodigosFromRow(trasCod);
      txtResiduo.setText(String.valueOf(codigos[0]));
      txtEmpresa.setText(String.valueOf(codigos[1]));
      txtTransportista.setText(String.valueOf(codigos[2]));
      txtDestino.setText(String.valueOf(codigos[3]));
    }
  }// GEN-LAST:event_tblTrasladosMouseClicked

  public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(() -> {
      new InformacionTrasladoResiduo().setVisible(true);
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnActualizar;
  private javax.swing.JButton btnAdicionar;
  private javax.swing.JButton btnCancelar;
  private javax.swing.JButton btnEliminar;
  private javax.swing.JButton btnModificar;
  private javax.swing.JButton btnSalir;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel10;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JLabel jLabel8;
  private javax.swing.JLabel jLabel9;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JTable tblTraslados;
  private javax.swing.JTextField txtCantidad;
  private javax.swing.JTextField txtCodigo;
  private javax.swing.JTextArea txtDescripcion;
  private javax.swing.JTextField txtDestino;
  private javax.swing.JTextField txtEmpresa;
  private javax.swing.JTextField txtFecha;
  private javax.swing.JTextField txtResiduo;
  private javax.swing.JTextField txtTransportista;
  // End of variables declaration//GEN-END:variables
}