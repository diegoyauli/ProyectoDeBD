package Formularios;

import Registro.RegistroDestino;
import Registro.Destino;
import Validadores.ResiduosToxicosValidator;
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;

public class InformacionDestino extends javax.swing.JFrame {
    private final RegistroDestino RD;
    private final ResiduosToxicosValidator validator;
    private final Connection con;
    
    private int CarFlaAct = 0; // Bandera de actualización (0: no actualizar, 1: actualizar)
    private String currentOperation = ""; // Operación actual (ADD, MOD, DEL, INA, REA)
    
    public InformacionDestino() {
        initComponents();
        con = Conexion.getConnection();
        validator = new ResiduosToxicosValidator(con);
        RD = new RegistroDestino();
        listar();
        this.setLocationRelativeTo(null);
        txtEstado = new javax.swing.JTextField(); // Inicializar el campo de estado
        txtEstado.setEditable(false); // El estado no es editable por el usuario
        txtEstado.setText("A"); // Estado inicial: Activo
    }
    
    private void listar() {
        tblDestinos.setModel(RD.getDatos());
    }
    
    private void limpiarCampos() {
        txtCodigo.setText("");
        txtNombre.setText("");
        txtDireccion.setText("");
        txtCapacidad.setText("");
        txtCapacidadActual.setText("");
        txtRegion.setText("");
        txtEstado.setText("A");
        CarFlaAct = 0;
        currentOperation = "";
        habilitarCampos(false);
    }
    
    private void habilitarCampos(boolean habilitar) {
        txtCodigo.setEnabled(false); // Código siempre es generado automáticamente
        txtNombre.setEditable(habilitar && !"DEL".equals(currentOperation) && !"INA".equals(currentOperation) && !"REA".equals(currentOperation));
        txtDireccion.setEditable(habilitar && !"DEL".equals(currentOperation) && !"INA".equals(currentOperation) && !"REA".equals(currentOperation));
        txtCapacidad.setEditable(habilitar && !"DEL".equals(currentOperation) && !"INA".equals(currentOperation) && !"REA".equals(currentOperation));
        txtCapacidadActual.setEditable(habilitar && !"DEL".equals(currentOperation) && !"INA".equals(currentOperation) && !"REA".equals(currentOperation));
        txtRegion.setEditable(habilitar && !"DEL".equals(currentOperation) && !"INA".equals(currentOperation) && !"REA".equals(currentOperation));
        txtEstado.setEditable(false);
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
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDireccion = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        txtCapacidad = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCapacidadActual = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtRegion = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDestinos = new javax.swing.JTable();
        btnAdicionar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        btnInactivar = new javax.swing.JButton();
        btnReactivar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestión de Destinos");

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gestión de Destinos");

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

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Destino"));

        jLabel2.setText("Código:");
        txtCodigo.setEnabled(false);

        jLabel3.setText("Nombre:");
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        jLabel4.setText("Dirección:");
        txtDireccion.setColumns(20);
        txtDireccion.setRows(3);
        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDireccionKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(txtDireccion);

        jLabel5.setText("Capacidad:");
        txtCapacidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCapacidadKeyTyped(evt);
            }
        });

        jLabel6.setText("Cap. Actual:");
        txtCapacidadActual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCapacidadActualKeyTyped(evt);
            }
        });

        jLabel7.setText("Código Región:");
        txtRegion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRegionKeyTyped(evt);
            }
        });

        jLabel9.setText("Estado:");

        txtEstado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtEstado.setText("A");
        txtEstado.setEditable(false);

        // Configurar botones de inactivar y reactivar
        btnInactivar.setBackground(new java.awt.Color(255, 153, 0));
        btnInactivar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnInactivar.setForeground(new java.awt.Color(255, 255, 255));
        btnInactivar.setText("Inactivar");
        btnInactivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInactivarActionPerformed(evt);
            }
        });

        btnReactivar.setBackground(new java.awt.Color(0, 102, 102));
        btnReactivar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnReactivar.setForeground(new java.awt.Color(255, 255, 255));
        btnReactivar.setText("Reactivar");
        btnReactivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReactivarActionPerformed(evt);
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
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9)) // Agregar etiqueta de estado
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCapacidadActual, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRegion, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))) // Agregar campo de estado
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtCapacidadActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtRegion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9) // Etiqueta de estado
                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)) // Campo de estado
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Destinos Registrados:");

        tblDestinos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Código", "Nombre", "Dirección", "Capacidad", "Cap. Actual", "Región", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDestinos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblDestinos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDestinosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDestinos);

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
                .addComponent(btnInactivar) // Agregar botón Inactivar
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReactivar) // Agregar botón Reactivar
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
                    .addComponent(btnSalir)
                    .addComponent(btnInactivar)
                    .addComponent(btnReactivar))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        limpiarCampos();
        txtEstado.setText("A");
        currentOperation = "ADD";
        habilitarCampos(true);
        CarFlaAct = 1;
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // ...existing validation code similar to btnAdicionarActionPerformed...
        // Implementation for modify operation
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try {
            if (txtCodigo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Seleccione un destino primero", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            int codigo = Integer.parseInt(txtCodigo.getText());
            
            if (validator.existsInTable("TRASLADO_RESIDUO", "DestCod", codigo)) {
                JOptionPane.showMessageDialog(this, "No se puede eliminar: El destino está siendo utilizado en traslados", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            int confirm = JOptionPane.showConfirmDialog(this, 
                    "¿Está seguro de eliminar este destino?", 
                    "Confirmar eliminación", 
                    JOptionPane.YES_NO_OPTION);
            
            if (confirm == JOptionPane.YES_OPTION) {
                if (RD.delete(codigo)) {
                    JOptionPane.showMessageDialog(this, "Destino eliminado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    listar();
                    limpiarCampos();
                } else {
                    JOptionPane.showMessageDialog(this, "Error al eliminar el destino", "Error", JOptionPane.ERROR_MESSAGE);
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
        listar();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnInactivarActionPerformed(java.awt.event.ActionEvent evt) {
        if (tblDestinos.getSelectedRow() >= 0) {
            int fila = tblDestinos.getSelectedRow();
            txtCodigo.setText(tblDestinos.getValueAt(fila, 0).toString());
            txtNombre.setText(tblDestinos.getValueAt(fila, 1).toString());
            txtDireccion.setText(tblDestinos.getValueAt(fila, 2).toString());
            
            if (tblDestinos.getValueAt(fila, 3) != null) {
                txtCapacidad.setText(tblDestinos.getValueAt(fila, 3).toString());
            } else {
                txtCapacidad.setText("");
            }
            
            if (tblDestinos.getValueAt(fila, 4) != null) {
                txtCapacidadActual.setText(tblDestinos.getValueAt(fila, 4).toString());
            } else {
                txtCapacidadActual.setText("");
            }
            
            txtRegion.setText(tblDestinos.getValueAt(fila, 5).toString());
            
            // Obtenemos el estado actual y verificamos que no esté ya inactivo
            String estadoActual = tblDestinos.getValueAt(fila, 6).toString();
            if ("I".equals(estadoActual)) {
                JOptionPane.showMessageDialog(this, "El destino ya está inactivo", "Información", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            
            // Proteger todos los campos
            habilitarCampos(false);
            // Cambiar estado a inactivo (I)
            txtEstado.setText("I");
            
            CarFlaAct = 1;
            currentOperation = "INA";
            
            int confirm = JOptionPane.showConfirmDialog(this, 
                    "¿Está seguro de inactivar este destino?", 
                    "Confirmar inactivación", 
                    JOptionPane.YES_NO_OPTION);
            
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    int codigo = Integer.parseInt(txtCodigo.getText());
                    if (RD.updateEstado(codigo, "I")) {
                        JOptionPane.showMessageDialog(this, "Destino inactivado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                        listar();
                        limpiarCampos();
                    } else {
                        JOptionPane.showMessageDialog(this, "Error al inactivar el destino", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Código inválido", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, "Error de base de datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                limpiarCampos();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un destino primero", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void btnReactivarActionPerformed(java.awt.event.ActionEvent evt) {
        if (tblDestinos.getSelectedRow() >= 0) {
            int fila = tblDestinos.getSelectedRow();
            txtCodigo.setText(tblDestinos.getValueAt(fila, 0).toString());
            txtNombre.setText(tblDestinos.getValueAt(fila, 1).toString());
            txtDireccion.setText(tblDestinos.getValueAt(fila, 2).toString());
            
            if (tblDestinos.getValueAt(fila, 3) != null) {
                txtCapacidad.setText(tblDestinos.getValueAt(fila, 3).toString());
            } else {
                txtCapacidad.setText("");
            }
            
            if (tblDestinos.getValueAt(fila, 4) != null) {
                txtCapacidadActual.setText(tblDestinos.getValueAt(fila, 4).toString());
            } else {
                txtCapacidadActual.setText("");
            }
            
            txtRegion.setText(tblDestinos.getValueAt(fila, 5).toString());
            
            // Obtenemos el estado actual y verificamos que no esté ya activo
            String estadoActual = tblDestinos.getValueAt(fila, 6).toString();
            if ("A".equals(estadoActual)) {
                JOptionPane.showMessageDialog(this, "El destino ya está activo", "Información", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            
            // Proteger todos los campos
            habilitarCampos(false);
            // Cambiar estado a activo (A)
            txtEstado.setText("A");
            
            CarFlaAct = 1;
            currentOperation = "REA";
            
            int confirm = JOptionPane.showConfirmDialog(this, 
                    "¿Está seguro de reactivar este destino?", 
                    "Confirmar reactivación", 
                    JOptionPane.YES_NO_OPTION);
            
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    int codigo = Integer.parseInt(txtCodigo.getText());
                    if (RD.updateEstado(codigo, "A")) {
                        JOptionPane.showMessageDialog(this, "Destino reactivado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                        listar();
                        limpiarCampos();
                    } else {
                        JOptionPane.showMessageDialog(this, "Error al reactivar el destino", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Código inválido", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, "Error de base de datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                limpiarCampos();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un destino primero", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void tblDestinosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDestinosMouseClicked
        int fila = tblDestinos.getSelectedRow();
        if (fila >= 0) {
            txtCodigo.setText(tblDestinos.getValueAt(fila, 0).toString());
            txtNombre.setText(tblDestinos.getValueAt(fila, 1).toString());
            txtDireccion.setText(tblDestinos.getValueAt(fila, 2).toString());
            if (tblDestinos.getValueAt(fila, 3) != null) {
                txtCapacidad.setText(tblDestinos.getValueAt(fila, 3).toString());
            } else {
                txtCapacidad.setText("");
            }
            if (tblDestinos.getValueAt(fila, 4) != null) {
                txtCapacidadActual.setText(tblDestinos.getValueAt(fila, 4).toString());
            } else {
                txtCapacidadActual.setText("");
            }
            txtRegion.setText(tblDestinos.getValueAt(fila, 5).toString());
            txtEstado.setText(tblDestinos.getValueAt(fila, 6).toString());
        }
    }//GEN-LAST:event_tblDestinosMouseClicked

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        if (txtNombre.getText().length() >= 100) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

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

    private void txtCapacidadActualKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCapacidadActualKeyTyped
        char c = evt.getKeyChar();
        String text = txtCapacidadActual.getText();
        
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
    }//GEN-LAST:event_txtCapacidadActualKeyTyped

    private void txtRegionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRegionKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtRegionKeyTyped

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new InformacionDestino().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnInactivar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnReactivar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JTable tblDestinos;
    private javax.swing.JTextField txtCapacidad;
    private javax.swing.JTextField txtCapacidadActual;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextArea txtDireccion;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRegion;
    // End of variables declaration//GEN-END:variables
}
