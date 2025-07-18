package Formularios;

import Registro.RegistroEmpresaTransportista;
import Registro.EmpresaTransportista;
import Validadores.ResiduosToxicosValidator;
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;

public class InformacionEmpresaTransportista extends javax.swing.JFrame {
    private final RegistroEmpresaTransportista RET;
    private final ResiduosToxicosValidator validator;
    private final Connection con;
    
    public InformacionEmpresaTransportista() {
        initComponents();
        con = Conexion.getConnection();
        validator = new ResiduosToxicosValidator(con);
        RET = new RegistroEmpresaTransportista();
        listar();
        this.setLocationRelativeTo(null);
    }
    
    private void listar() {
        tblEmpresas.setModel(RET.getDatos());
    }
    
    private void limpiarCampos() {
        txtCodigo.setText("");
        txtNombre.setText("");
        txtRUC.setText("");
        txtDireccion.setText("");
        txtCapacidad.setText("");
        txtRegion.setText("");
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
        txtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtRUC = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDireccion = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        txtCapacidad = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtRegion = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmpresas = new javax.swing.JTable();
        btnAdicionar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestión de Empresas Transportistas");

        jPanel1.setBackground(new java.awt.Color(153, 51, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gestión de Empresas Transportistas");

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

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de la Empresa Transportista"));

        jLabel2.setText("Código:");
        txtCodigo.setEnabled(false);

        jLabel3.setText("Nombre:");
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        jLabel4.setText("RUC:");
        txtRUC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRUCKeyTyped(evt);
            }
        });

        jLabel5.setText("Dirección:");
        txtDireccion.setColumns(20);
        txtDireccion.setRows(3);
        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDireccionKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(txtDireccion);

        jLabel6.setText("Capacidad:");
        txtCapacidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCapacidadKeyTyped(evt);
            }
        });

        jLabel7.setText("Código Región:");
        txtRegion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRegionKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRUC, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRegion, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtRegion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtRUC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Empresas Transportistas Registradas:");

        tblEmpresas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Código", "Nombre", "RUC", "Dirección", "Capacidad", "Región"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEmpresas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblEmpresas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmpresasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEmpresas);

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
                        .addComponent(jLabel8)
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
                .addComponent(jLabel8)
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
            String nombre = txtNombre.getText().trim();
            String ruc = txtRUC.getText().trim();
            String direccion = txtDireccion.getText().trim();
            String capacidadStr = txtCapacidad.getText().trim();
            BigDecimal capacidad = null;
            
            if (nombre.isEmpty() || nombre.length() > 200) {
                JOptionPane.showMessageDialog(this, "Nombre inválido (1-200 caracteres)", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (!isValidRUC(ruc)) {
                JOptionPane.showMessageDialog(this, "RUC debe tener 11 dígitos", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (direccion.isEmpty() || direccion.length() > 250) {
                JOptionPane.showMessageDialog(this, "Dirección inválida (1-250 caracteres)", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (!capacidadStr.isEmpty()) {
                try {
                    capacidad = new BigDecimal(capacidadStr);
                    if (capacidad.compareTo(new BigDecimal("999999.99")) > 0 || capacidad.compareTo(BigDecimal.ZERO) < 0) {
                        JOptionPane.showMessageDialog(this, "Capacidad debe estar entre 0 y 999999.99", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Capacidad debe ser un número válido", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            
            if (txtRegion.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Código de región es obligatorio", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            int regCod = Integer.parseInt(txtRegion.getText());
            
            if (!validator.existsInTable("REGION", "RegCod", regCod)) {
                JOptionPane.showMessageDialog(this, "El código de región no existe", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            EmpresaTransportista nueva = new EmpresaTransportista();
            nueva.setTrsNom(nombre);
            nueva.setTrsRUC(ruc);
            nueva.setTrsDir(direccion);
            nueva.setTrsCap(capacidad);
            nueva.setRegCod(regCod);
            
            if (RET.create(nueva)) {
                JOptionPane.showMessageDialog(this, "Empresa transportista adicionada correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                listar();
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Error al adicionar la empresa transportista", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Código de región debe ser un número entero", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        try {
            if (txtCodigo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Seleccione una empresa primero", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            int codigo = Integer.parseInt(txtCodigo.getText());
            String nombre = txtNombre.getText().trim();
            String ruc = txtRUC.getText().trim();
            String direccion = txtDireccion.getText().trim();
            String capacidadStr = txtCapacidad.getText().trim();
            BigDecimal capacidad = null;
            
            if (nombre.isEmpty() || nombre.length() > 200) {
                JOptionPane.showMessageDialog(this, "Nombre inválido (1-200 caracteres)", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (!isValidRUC(ruc)) {
                JOptionPane.showMessageDialog(this, "RUC debe tener 11 dígitos", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (direccion.isEmpty() || direccion.length() > 250) {
                JOptionPane.showMessageDialog(this, "Dirección inválida (1-250 caracteres)", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (!capacidadStr.isEmpty()) {
                try {
                    capacidad = new BigDecimal(capacidadStr);
                    if (capacidad.compareTo(new BigDecimal("999999.99")) > 0 || capacidad.compareTo(BigDecimal.ZERO) < 0) {
                        JOptionPane.showMessageDialog(this, "Capacidad debe estar entre 0 y 999999.99", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Capacidad debe ser un número válido", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            
            if (txtRegion.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Código de región es obligatorio", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            int regCod = Integer.parseInt(txtRegion.getText());
            
            if (!validator.existsInTable("REGION", "RegCod", regCod)) {
                JOptionPane.showMessageDialog(this, "El código de región no existe", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            EmpresaTransportista actualizada = new EmpresaTransportista();
            actualizada.setTrsEmpCod(codigo);
            actualizada.setTrsNom(nombre);
            actualizada.setTrsRUC(ruc);
            actualizada.setTrsDir(direccion);
            actualizada.setTrsCap(capacidad);
            actualizada.setRegCod(regCod);
            
            if (RET.update(actualizada)) {
                JOptionPane.showMessageDialog(this, "Empresa transportista actualizada correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                listar();
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Error al actualizar la empresa transportista", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Código o región inválido", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try {
            if (txtCodigo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Seleccione una empresa primero", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            int codigo = Integer.parseInt(txtCodigo.getText());
            
            if (validator.existsInTable("TRASLADO_RESIDUO", "TrsEmpCod", codigo)) {
                JOptionPane.showMessageDialog(this, "No se puede eliminar: La empresa está siendo utilizada en traslados", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            int confirm = JOptionPane.showConfirmDialog(this, 
                    "¿Está seguro de eliminar esta empresa transportista?", 
                    "Confirmar eliminación", 
                    JOptionPane.YES_NO_OPTION);
            
            if (confirm == JOptionPane.YES_OPTION) {
                if (RET.delete(codigo)) {
                    JOptionPane.showMessageDialog(this, "Empresa transportista eliminada correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    listar();
                    limpiarCampos();
                } else {
                    JOptionPane.showMessageDialog(this, "Error al eliminar la empresa transportista", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Código inválido", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error de base de datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        listar();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void tblEmpresasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmpresasMouseClicked
        int fila = tblEmpresas.getSelectedRow();
        if (fila >= 0) {
            txtCodigo.setText(tblEmpresas.getValueAt(fila, 0).toString());
            txtNombre.setText(tblEmpresas.getValueAt(fila, 1).toString());
            txtRUC.setText(tblEmpresas.getValueAt(fila, 2).toString());
            txtDireccion.setText(tblEmpresas.getValueAt(fila, 3).toString());
            if (tblEmpresas.getValueAt(fila, 4) != null) {
                txtCapacidad.setText(tblEmpresas.getValueAt(fila, 4).toString());
            } else {
                txtCapacidad.setText("");
            }
            txtRegion.setText(tblEmpresas.getValueAt(fila, 5).toString());
        }
    }//GEN-LAST:event_tblEmpresasMouseClicked

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        if (txtNombre.getText().length() >= 200) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtRUCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRUCKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
            return;
        }
        if (txtRUC.getText().length() >= 11) {
            evt.consume();
        }
    }//GEN-LAST:event_txtRUCKeyTyped

    private void txtDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyTyped
        if (txtDireccion.getText().length() >= 250) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDireccionKeyTyped

    private void txtCapacidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCapacidadKeyTyped
        char c = evt.getKeyChar();
        String text = txtCapacidad.getText();
        
        if (!(Character.isDigit(c) || c == '.' || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
            return;
        }
        
        if (c == '.' && (text.contains(".") || text.isEmpty())) {
            evt.consume();
            return;
        }
        
        if (text.contains(".")) {
            String[] parts = text.split("\\.");
            if (parts.length > 1 && parts[1].length() >= 2 && Character.isDigit(c)) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtCapacidadKeyTyped

    private void txtRegionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRegionKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtRegionKeyTyped

    private boolean isValidRUC(String ruc) {
        return ruc != null && ruc.length() == 11 && ruc.matches("\\d+");
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new InformacionEmpresaTransportista().setVisible(true);
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblEmpresas;
    private javax.swing.JTextField txtCapacidad;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextArea txtDireccion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRUC;
    private javax.swing.JTextField txtRegion;
    // End of variables declaration//GEN-END:variables
}
