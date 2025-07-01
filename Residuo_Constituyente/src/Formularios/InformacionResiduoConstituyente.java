package Formularios;

import Registro.RegistroResiduoConstituyente;
import Registro.ResiduoConstituyente;
import Validadores.ResiduosToxicosValidator;
import Conexion.Conexion;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyEvent;

public class InformacionResiduoConstituyente extends javax.swing.JFrame {
    private final RegistroResiduoConstituyente RRC;
    private final ResiduosToxicosValidator validator;
    private final Connection con;
    
    public InformacionResiduoConstituyente() {
        initComponents();
        con = Conexion.getConnection();
        validator = new ResiduosToxicosValidator(con);
        RRC = new RegistroResiduoConstituyente();
        cargarCombos();
        listar();
        this.setLocationRelativeTo(null);
    }
    
    private void cargarCombos() {
        cmbResiduo.setModel(RRC.getResiduos());
        cmbConstituyente.setModel(RRC.getConstituyentes());
    }
    
    private void listar() {
        tblResiduoConstituyente.setModel(RRC.getDatos());
    }
    
    private void limpiarCampos() {
        txtCodigo.setText("");
        cmbResiduo.setSelectedIndex(-1);
        cmbConstituyente.setSelectedIndex(-1);
        txtPorcentaje.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cmbResiduo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cmbConstituyente = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtPorcentaje = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResiduoConstituyente = new javax.swing.JTable();
        btnAdicionar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestión de Residuo-Constituyente");

        jPanel1.setBackground(new java.awt.Color(102, 0, 153));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gestión de Residuo-Constituyente");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Residuo-Constituyente"));

        jLabel2.setText("Código:");

        txtCodigo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCodigo.setEnabled(false);

        jLabel3.setText("Residuo:");

        cmbResiduo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel4.setText("Constituyente:");

        cmbConstituyente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel5.setText("Porcentaje (%):");

        txtPorcentaje.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPorcentaje.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPorcentajeKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbResiduo, 0, 300, Short.MAX_VALUE)
                    .addComponent(cmbConstituyente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPorcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbResiduo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbConstituyente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPorcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Relaciones Residuo-Constituyente Registradas:");

        tblResiduoConstituyente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código", "Residuo", "Constituyente", "Porcentaje (%)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblResiduoConstituyente.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblResiduoConstituyente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblResiduoConstituyenteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblResiduoConstituyente);

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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
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
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnCancelar)
                    .addComponent(btnActualizar)
                    .addComponent(btnSalir))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        try {
            if (cmbResiduo.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(this, "Seleccione un residuo", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (cmbConstituyente.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(this, "Seleccione un constituyente", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            RegistroResiduoConstituyente.ComboItem residuoItem = (RegistroResiduoConstituyente.ComboItem) cmbResiduo.getSelectedItem();
            RegistroResiduoConstituyente.ComboItem constituyenteItem = (RegistroResiduoConstituyente.ComboItem) cmbConstituyente.getSelectedItem();
            
            BigDecimal porcentaje = null;
            if (!txtPorcentaje.getText().trim().isEmpty()) {
                try {
                    double porc = Double.parseDouble(txtPorcentaje.getText().trim());
                    if (porc < 0 || porc > 100) {
                        JOptionPane.showMessageDialog(this, "El porcentaje debe estar entre 0 y 100", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    porcentaje = new BigDecimal(porc);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Porcentaje inválido", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            
            if (!validator.validateResiduoConstituyente(residuoItem.getId(), constituyenteItem.getId(), porcentaje)) {
                JOptionPane.showMessageDialog(this, "Datos inválidos o referencias no existen", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            ResiduoConstituyente nuevo = new ResiduoConstituyente();
            nuevo.setResCod(residuoItem.getId());
            nuevo.setConsCod(constituyenteItem.getId());
            nuevo.setResConsPorc(porcentaje);
            
            if (RRC.create(nuevo)) {
                JOptionPane.showMessageDialog(this, "Relación residuo-constituyente adicionada correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                listar();
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Error al adicionar la relación", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        try {
            if (txtCodigo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Seleccione una relación primero", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (cmbResiduo.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(this, "Seleccione un residuo", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (cmbConstituyente.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(this, "Seleccione un constituyente", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            int codigo = Integer.parseInt(txtCodigo.getText());
            RegistroResiduoConstituyente.ComboItem residuoItem = (RegistroResiduoConstituyente.ComboItem) cmbResiduo.getSelectedItem();
            RegistroResiduoConstituyente.ComboItem constituyenteItem = (RegistroResiduoConstituyente.ComboItem) cmbConstituyente.getSelectedItem();
            
            BigDecimal porcentaje = null;
            if (!txtPorcentaje.getText().trim().isEmpty()) {
                try {
                    double porc = Double.parseDouble(txtPorcentaje.getText().trim());
                    if (porc < 0 || porc > 100) {
                        JOptionPane.showMessageDialog(this, "El porcentaje debe estar entre 0 y 100", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    porcentaje = new BigDecimal(porc);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Porcentaje inválido", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            
            ResiduoConstituyente actualizado = new ResiduoConstituyente();
            actualizado.setResConsCod(codigo);
            actualizado.setResCod(residuoItem.getId());
            actualizado.setConsCod(constituyenteItem.getId());
            actualizado.setResConsPorc(porcentaje);
            
            if (RRC.update(actualizado)) {
                JOptionPane.showMessageDialog(this, "Relación actualizada correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                listar();
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Error al actualizar la relación", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try {
            if (txtCodigo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Seleccione una relación primero", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            int codigo = Integer.parseInt(txtCodigo.getText());
            
            int confirm = JOptionPane.showConfirmDialog(this, 
                    "¿Está seguro de eliminar esta relación residuo-constituyente?", 
                    "Confirmar eliminación", 
                    JOptionPane.YES_NO_OPTION);
            
            if (confirm == JOptionPane.YES_OPTION) {
                if (RRC.delete(codigo)) {
                    JOptionPane.showMessageDialog(this, "Relación eliminada correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    listar();
                    limpiarCampos();
                } else {
                    JOptionPane.showMessageDialog(this, "Error al eliminar la relación", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        cargarCombos();
        listar();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void tblResiduoConstituyenteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblResiduoConstituyenteMouseClicked
        int fila = tblResiduoConstituyente.getSelectedRow();
        if (fila >= 0) {
            try {
                txtCodigo.setText(tblResiduoConstituyente.getValueAt(fila, 0).toString());
                
                // Cargar el registro completo para obtener los IDs
                int codigo = Integer.parseInt(txtCodigo.getText());
                ResiduoConstituyente rc = RRC.getById(codigo);
                
                if (rc != null) {
                    // Seleccionar en los combos
                    for (int i = 0; i < cmbResiduo.getItemCount(); i++) {
                        RegistroResiduoConstituyente.ComboItem item = cmbResiduo.getItemAt(i);
                        if (item.getId() == rc.getResCod()) {
                            cmbResiduo.setSelectedIndex(i);
                            break;
                        }
                    }
                    
                    for (int i = 0; i < cmbConstituyente.getItemCount(); i++) {
                        RegistroResiduoConstituyente.ComboItem item = cmbConstituyente.getItemAt(i);
                        if (item.getId() == rc.getConsCod()) {
                            cmbConstituyente.setSelectedIndex(i);
                            break;
                        }
                    }
                    
                    if (rc.getResConsPorc() != null) {
                        txtPorcentaje.setText(rc.getResConsPorc().toString());
                    } else {
                        txtPorcentaje.setText("");
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al cargar datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_tblResiduoConstituyenteMouseClicked

    private void txtPorcentajeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPorcentajeKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == '.' || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
            return;
        }
        
        String text = txtPorcentaje.getText();
        if (c == '.' && text.contains(".")) {
            evt.consume();
            return;
        }
        
        String newText = text + c;
        if (newText.length() > 0 && !newText.equals(".")) {
            try {
                double value = Double.parseDouble(newText);
                if (value > 100) {
                    evt.consume();
                }
            } catch (NumberFormatException e) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtPorcentajeKeyTyped

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new InformacionResiduoConstituyente().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<RegistroResiduoConstituyente.ComboItem> cmbConstituyente;
    private javax.swing.JComboBox<RegistroResiduoConstituyente.ComboItem> cmbResiduo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblResiduoConstituyente;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtPorcentaje;
    // End of variables declaration//GEN-END:variables
}
