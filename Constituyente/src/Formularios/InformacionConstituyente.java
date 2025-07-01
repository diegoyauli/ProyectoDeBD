package Formularios;

import Registro.RegistroConstituyente;
import Registro.Constituyente;
import Validadores.ResiduosToxicosValidator;
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyEvent;

public class InformacionConstituyente extends javax.swing.JFrame {
    private final RegistroConstituyente RC;
    private final ResiduosToxicosValidator validator;
    private final Connection con;

    private int CarFlaAct = 0; // Bandera de actualización (0: no actualizar, 1: actualizar)
    private String currentOperation = ""; // Operación actual (ADD, MOD, DEL, INA, REA)

    public InformacionConstituyente() {
        initComponents();
        con = Conexion.getConnection();
        validator = new ResiduosToxicosValidator(con);
        RC = new RegistroConstituyente();
        listar();
        this.setLocationRelativeTo(null);
        txtEstado = new javax.swing.JTextField(); // Inicializar el campo de estado
        txtEstado.setEditable(false); // El estado no es editable por el usuario
        txtEstado.setText("A"); // Estado inicial: Activo
    }

    private void listar() {
        tblConstituyentes.setModel(RC.getDatos());
    }

    private void limpiarCampos() {
        txtCodigo.setText("");
        txtNombre.setText("");
        txtDescripcion.setText("");
        txtGrado.setText("");
        txtEstado.setText("A");
        CarFlaAct = 0;
        currentOperation = "";
        habilitarCampos(false);
    }

    private void habilitarCampos(boolean habilitar) {
        txtCodigo.setEditable(false); // Código siempre es generado automáticamente
        txtNombre.setEditable(habilitar && !"DEL".equals(currentOperation) && !"INA".equals(currentOperation)
                && !"REA".equals(currentOperation));
        txtDescripcion.setEditable(habilitar && !"DEL".equals(currentOperation) && !"INA".equals(currentOperation)
                && !"REA".equals(currentOperation));
        txtGrado.setEditable(habilitar && !"DEL".equals(currentOperation) && !"INA".equals(currentOperation)
                && !"REA".equals(currentOperation));
        txtEstado.setEditable(false);
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
        txtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        txtGrado = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblConstituyentes = new javax.swing.JTable();
        btnAdicionar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        btnInactivar = new javax.swing.JButton();
        btnReactivar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestión de Constituyentes");

        jPanel1.setBackground(new java.awt.Color(102, 0, 153));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gestión de Constituyentes");

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

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Constituyente"));

        jLabel2.setText("Código:");

        txtCodigo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCodigo.setEnabled(false);

        jLabel3.setText("Nombre:");

        txtNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        jLabel4.setText("Descripción:");

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(txtDescripcion);

        jLabel5.setText("Grado:");

        txtGrado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtGrado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGradoKeyTyped(evt);
            }
        });

        jLabel7.setText("Estado:");

        txtEstado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtEstado.setText("A");
        txtEstado.setEditable(false);

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
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 60,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 300,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtGrado, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(txtGrado, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Constituyentes Registrados:");

        tblConstituyentes.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null }
                },
                new String[] {
                        "Código", "Nombre", "Descripción", "Grado"
                }) {
            boolean[] canEdit = new boolean[] {
                    false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tblConstituyentes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblConstituyentes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblConstituyentesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblConstituyentes);

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
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane1)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        // .addContainerGap())
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(20, 20, 20)
                                                .addComponent(btnAdicionar)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnModificar)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnEliminar)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnInactivar)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnReactivar)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnCancelar)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnActualizar)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnSalir)
                                                .addContainerGap(20, Short.MAX_VALUE)))));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
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
                                        .addComponent(btnSalir)
                                        .addComponent(btnInactivar)
                                        .addComponent(btnReactivar))
                                .addContainerGap(20, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAdicionarActionPerformed
        try {
            String nombre = txtNombre.getText().trim();
            String descripcion = txtDescripcion.getText().trim();
            Byte grado = null;

            if (!txtGrado.getText().isEmpty()) {
                int grad = Integer.parseInt(txtGrado.getText());
                if (grad < 0 || grad > 127) {
                    JOptionPane.showMessageDialog(this, "El grado debe estar entre 0 y 127", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                grado = (byte) grad;
            }

            // Validaciones
            if (nombre.isEmpty() || nombre.length() > 100) {
                JOptionPane.showMessageDialog(this, "Nombre inválido (1-100 caracteres)", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (descripcion.length() > 250) {
                JOptionPane.showMessageDialog(this, "Descripción demasiado larga (máx. 250 caracteres)", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            Constituyente nuevo = new Constituyente();
            nuevo.setConNom(nombre);
            nuevo.setConDes(descripcion);
            nuevo.setConGrad(grado);

            if (RC.create(nuevo)) {
                JOptionPane.showMessageDialog(this, "Constituyente adicionado correctamente", "Éxito",
                        JOptionPane.INFORMATION_MESSAGE);
                listar();
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Error al adicionar el constituyente", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Grado debe ser un número entero", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }// GEN-LAST:event_btnAdicionarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnModificarActionPerformed
        try {
            if (txtCodigo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Seleccione un constituyente primero", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            int codigo = Integer.parseInt(txtCodigo.getText());
            String nombre = txtNombre.getText().trim();
            String descripcion = txtDescripcion.getText().trim();
            Byte grado = null;

            if (!txtGrado.getText().isEmpty()) {
                int grad = Integer.parseInt(txtGrado.getText());
                if (grad < 0 || grad > 127) {
                    JOptionPane.showMessageDialog(this, "El grado debe estar entre 0 y 127", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                grado = (byte) grad;
            }

            // Validaciones
            if (nombre.isEmpty() || nombre.length() > 100) {
                JOptionPane.showMessageDialog(this, "Nombre inválido (1-100 caracteres)", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (descripcion.length() > 250) {
                JOptionPane.showMessageDialog(this, "Descripción demasiado larga (máx. 250 caracteres)", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            Constituyente actualizado = new Constituyente();
            actualizado.setConsCod(codigo);
            actualizado.setConNom(nombre);
            actualizado.setConDes(descripcion);
            actualizado.setConGrad(grado);

            if (RC.update(actualizado)) {
                JOptionPane.showMessageDialog(this, "Constituyente actualizado correctamente", "Éxito",
                        JOptionPane.INFORMATION_MESSAGE);
                listar();
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Error al actualizar el constituyente", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Código o grado inválido", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }// GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnEliminarActionPerformed
        try {
            if (txtCodigo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Seleccione un constituyente primero", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            int codigo = Integer.parseInt(txtCodigo.getText());

            // Verificar si el constituyente está siendo usado
            if (validator.existsInTable("RESIDUO_CONSTITUYENTE", "ConsCod", codigo)) {
                JOptionPane.showMessageDialog(this, "No se puede eliminar: El constituyente está siendo usado", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            int confirm = JOptionPane.showConfirmDialog(this,
                    "¿Está seguro de eliminar este constituyente?",
                    "Confirmar eliminación",
                    JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                if (RC.delete(codigo)) {
                    JOptionPane.showMessageDialog(this, "Constituyente eliminado correctamente", "Éxito",
                            JOptionPane.INFORMATION_MESSAGE);
                    listar();
                    limpiarCampos();
                } else {
                    JOptionPane.showMessageDialog(this, "Error al eliminar el constituyente", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Código inválido", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error de base de datos: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
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

    private void btnInactivarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnInactivarActionPerformed
        if (tblConstituyentes.getSelectedRow() >= 0) {
            int fila = tblConstituyentes.getSelectedRow();
            txtCodigo.setText(tblConstituyentes.getValueAt(fila, 0).toString());
            txtNombre.setText(tblConstituyentes.getValueAt(fila, 1).toString());
            txtDescripcion.setText(tblConstituyentes.getValueAt(fila, 2).toString());
            if (tblConstituyentes.getValueAt(fila, 3) != null) {
                txtGrado.setText(tblConstituyentes.getValueAt(fila, 3).toString());
            } else {
                txtGrado.setText("");
            }

            // Obtenemos el estado actual y verificamos que no esté ya inactivo
            String estadoActual = tblConstituyentes.getValueAt(fila, 4).toString();
            if ("I".equals(estadoActual)) {
                JOptionPane.showMessageDialog(this, "El constituyente ya está inactivo", "Información",
                        JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            // Proteger todos los campos
            habilitarCampos(false);
            // Cambiar estado a inactivo (I)
            txtEstado.setText("I");

            CarFlaAct = 1;
            currentOperation = "INA";

            int confirm = JOptionPane.showConfirmDialog(this,
                    "¿Está seguro de inactivar este constituyente?",
                    "Confirmar inactivación",
                    JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    int codigo = Integer.parseInt(txtCodigo.getText());
                    if (RC.updateEstado(codigo, "I")) {
                        JOptionPane.showMessageDialog(this, "Constituyente inactivado correctamente", "Éxito",
                                JOptionPane.INFORMATION_MESSAGE);
                        listar();
                        limpiarCampos();
                    } else {
                        JOptionPane.showMessageDialog(this, "Error al inactivar el constituyente", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Código inválido", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, "Error de base de datos: " + e.getMessage(), "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            } else {
                limpiarCampos();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un constituyente primero", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }// GEN-LAST:event_btnInactivarActionPerformed

    private void btnReactivarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnReactivarActionPerformed
        if (tblConstituyentes.getSelectedRow() >= 0) {
            int fila = tblConstituyentes.getSelectedRow();
            txtCodigo.setText(tblConstituyentes.getValueAt(fila, 0).toString());
            txtNombre.setText(tblConstituyentes.getValueAt(fila, 1).toString());
            txtDescripcion.setText(tblConstituyentes.getValueAt(fila, 2).toString());
            if (tblConstituyentes.getValueAt(fila, 3) != null) {
                txtGrado.setText(tblConstituyentes.getValueAt(fila, 3).toString());
            } else {
                txtGrado.setText("");
            }

            // Obtenemos el estado actual y verificamos que no esté ya activo
            String estadoActual = tblConstituyentes.getValueAt(fila, 4).toString();
            if ("A".equals(estadoActual)) {
                JOptionPane.showMessageDialog(this, "El constituyente ya está activo", "Información",
                        JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            // Proteger todos los campos
            habilitarCampos(false);
            // Cambiar estado a activo (A)
            txtEstado.setText("A");

            CarFlaAct = 1;
            currentOperation = "REA";

            int confirm = JOptionPane.showConfirmDialog(this,
                    "¿Está seguro de reactivar este constituyente?",
                    "Confirmar reactivación",
                    JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    int codigo = Integer.parseInt(txtCodigo.getText());
                    if (RC.updateEstado(codigo, "A")) {
                        JOptionPane.showMessageDialog(this, "Constituyente reactivado correctamente", "Éxito",
                                JOptionPane.INFORMATION_MESSAGE);
                        listar();
                        limpiarCampos();
                    } else {
                        JOptionPane.showMessageDialog(this, "Error al reactivar el constituyente", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Código inválido", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, "Error de base de datos: " + e.getMessage(), "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            } else {
                limpiarCampos();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un constituyente primero", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }// GEN-LAST:event_btnReactivarActionPerformed

    private void tblConstituyentesMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tblConstituyentesMouseClicked
        int fila = tblConstituyentes.getSelectedRow();
        if (fila >= 0) {
            txtCodigo.setText(tblConstituyentes.getValueAt(fila, 0).toString());
            txtNombre.setText(tblConstituyentes.getValueAt(fila, 1).toString());
            txtDescripcion.setText(tblConstituyentes.getValueAt(fila, 2).toString());
            if (tblConstituyentes.getValueAt(fila, 3) != null) {
                txtGrado.setText(tblConstituyentes.getValueAt(fila, 3).toString());
            } else {
                txtGrado.setText("");
            }
            txtEstado.setText(tblConstituyentes.getValueAt(fila, 4).toString());
        }
    }// GEN-LAST:event_tblConstituyentesMouseClicked

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txtNombreKeyTyped
        String text = txtNombre.getText();
        if (text.length() >= 100) {
            evt.consume();
        }
    }// GEN-LAST:event_txtNombreKeyTyped

    private void txtDescripcionKeyTyped(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txtDescripcionKeyTyped
        String text = txtDescripcion.getText();
        if (text.length() >= 250) {
            evt.consume();
        }
    }// GEN-LAST:event_txtDescripcionKeyTyped

    private void txtGradoKeyTyped(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txtGradoKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
            return;
        }

        String text = txtGrado.getText() + c;
        if (text.length() > 0) {
            try {
                int value = Integer.parseInt(text);
                if (value > 127) {
                    evt.consume();
                }
            } catch (NumberFormatException e) {
                evt.consume();
            }
        }
    }// GEN-LAST:event_txtGradoKeyTyped

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new InformacionConstituyente().setVisible(true);
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblConstituyentes;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtGrado;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
