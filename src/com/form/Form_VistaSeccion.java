package com.form;

import com.dialogs.Message;
import com.dialogs.MessageInput;
import com.main.Main;
import com.model.ModelSeccion;
import com.model.ModelStudent;
import com.model.ModelStudentGrade;
import com.swing.icon.GoogleMaterialDesignIcons;
import com.swing.icon.IconFontSwing;
import com.swing.table.EventAction;
import java.awt.Color;
import javax.swing.Icon;

public class Form_VistaSeccion extends javax.swing.JPanel {

    public Form_VistaSeccion(ModelSeccion seccion, boolean editable) {
        initComponents();

        this.seccion = seccion;
        jLabel1.setText("Clases / " + seccion.getClase().getNombre() + " / "
                + seccion.getSeccion());

        tableEstudiantes.fixTable(jScrollPane2);

        initComponentes(editable);
        initTxts();
        initDataTable();

    }

    private ModelSeccion seccion;
    private boolean txtEditable;

    private void initComponentes(boolean editable) {

        if (editable) {
            Icon icon = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.LIBRARY_ADD, 40, Color.RED, Color.ORANGE);
            btnAgregar.setIcon(icon);

            icon = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.EDIT, 40, Color.BLUE, Color.CYAN);
            btnEditar.setIcon(icon);

            icon = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.SAVE, 40, Color.GREEN, Color.BLUE);
            btnGuardar.setIcon(icon);

            btnGuardar.setVisible(false);
        } else {
            btnAgregar.setVisible(false);
            btnEditar.setVisible(false);
            btnGuardar.setVisible(false);
        }

        txtDocente.setEditable(false);
        txtNom_Clase.setEditable(false);
        txtSeccion.setEditable(false);

    }

    private void initTxts() {
        txtDocente.setText(seccion.getDocente().getNombre());
        txtNom_Clase.setText(seccion.getClase().getNombre());
        txtSeccion.setText(seccion.getSeccion());

    }

    private EventAction getEventAction() {
        return new EventAction() {
            @Override
            public void delete(ModelStudent student) {
                if (showMessage("Realmente Desea Borrar: " + student.getName())) {
                    System.out.println("Borrando Esta seccion de " + student.getName());
                } else {
                    System.out.println("User click Cancel");
                }
            }

            @Override
            public void update(ModelStudent student) {
                if (showMessage("Desea actualizar la nota de este alumno:  " + student.getName())) {

                    MessageInput obj = new MessageInput(Main.getFrames()[0], true);
                    obj.showMessage("");

                    if (obj.isOk()) {
                        // se actualiza la nota del estudiante vean
                        try {
                            int nota = Integer.parseInt(obj.getInput());

                        } catch (NumberFormatException e) {
                            // Nota invalida
                        }
                    }

                } else {
                    System.out.println("User click Cancel");
                }
            }
        };
    }

    private void initDataTable() {
        EventAction eventAction = getEventAction();
        
        Icon icon = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.ACCOUNT_CIRCLE, 40, Color.RED, Color.ORANGE);
        
        ModelStudent student = new ModelStudent(icon, "Kelvin Melgar", "", "", "12241008");
        
        ModelStudent student2 = new ModelStudent(icon, "Pepe Gallo", "", "", "324344");
        
        tableEstudiantes.addRow(new ModelStudentGrade(student, 23).toRowTable(eventAction));
        tableEstudiantes.addRow(new ModelStudentGrade(student2, 32).toRowTable(eventAction));
        tableEstudiantes.addRow(new ModelStudentGrade(student, 56).toRowTable(eventAction));
        tableEstudiantes.addRow(new ModelStudentGrade(student2, 23).toRowTable(eventAction));
        tableEstudiantes.addRow(new ModelStudentGrade(student, 98).toRowTable(eventAction));
        tableEstudiantes.addRow(new ModelStudentGrade(student2, 3).toRowTable(eventAction));
    }

    private boolean showMessage(String message) {
        Message obj = new Message(Main.getFrames()[0], true);
        obj.showMessage(message);

        return obj.isOk();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableEstudiantes = new com.swing.table.TableSecciones();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNom_Clase = new javax.swing.JTextField();
        txtSeccion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDocente = new javax.swing.JTextField();
        btnGuardar = new com.raven.swing.Button();
        btnEditar = new com.raven.swing.Button();
        btnAgregar = new com.raven.swing.Button();

        setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 51, 255));
        jLabel1.setText("Clases / Nombre_Clase / Seccion");

        jScrollPane2.setBorder(null);

        tableEstudiantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No. Cuenta", "Nombre", "Nota", "Acciones"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableEstudiantes);

        jPanel1.setBackground(new java.awt.Color(212, 16, 173));

        jLabel2.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Clase");

        txtNom_Clase.setFont(new java.awt.Font("Roboto Light", 0, 20)); // NOI18N
        txtNom_Clase.setForeground(new java.awt.Color(232, 19, 190));
        txtNom_Clase.setText("Nomb_clase");

        txtSeccion.setFont(new java.awt.Font("Roboto Light", 0, 20)); // NOI18N
        txtSeccion.setForeground(new java.awt.Color(232, 19, 190));
        txtSeccion.setText("seccion");
        txtSeccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSeccionActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Seccion");

        jLabel4.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Docente");

        txtDocente.setFont(new java.awt.Font("Roboto Light", 0, 20)); // NOI18N
        txtDocente.setForeground(new java.awt.Color(232, 19, 190));
        txtDocente.setText("Nomb_clase");
        txtDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDocenteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNom_Clase, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(45, 45, 45)))
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNom_Clase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtDocente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(77, 77, 77))
        );

        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnGuardarMousePressed(evt);
            }
        });
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnEditarMousePressed(evt);
            }
        });
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSeccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSeccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSeccionActionPerformed

    private void btnGuardarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMousePressed
        // TODO add your handling code here:

        // Aqui deberia haber un query que valide, mas que todo
        // que el codigo no se repita
        btnGuardar.setVisible(false);
        txtDocente.setEditable(false);
        txtNom_Clase.setEditable(false);
        txtSeccion.setEditable(false);

        txtEditable = false;

        initTxts();

    }//GEN-LAST:event_btnGuardarMousePressed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEditarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarMousePressed
        // TODO add your handling code here:

        if (!txtEditable) {
            Icon icon = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.CANCEL, 40, Color.RED, Color.BLACK);
            btnEditar.setIcon(icon);

            btnGuardar.setVisible(true);
            txtDocente.setEditable(true);
            txtNom_Clase.setEditable(true);
            txtSeccion.setEditable(true);

            txtEditable = true;
        } else {
            Icon icon = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.EDIT, 40, Color.BLUE, Color.BLACK);
            btnEditar.setIcon(icon);

            btnGuardar.setVisible(false);
            txtDocente.setEditable(false);
            txtNom_Clase.setEditable(false);
            txtSeccion.setEditable(false);

            txtEditable = false;
            initTxts();
        }
    }//GEN-LAST:event_btnEditarMousePressed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDocenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDocenteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.Button btnAgregar;
    private com.raven.swing.Button btnEditar;
    private com.raven.swing.Button btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.swing.table.TableSecciones tableEstudiantes;
    private javax.swing.JTextField txtDocente;
    private javax.swing.JTextField txtNom_Clase;
    private javax.swing.JTextField txtSeccion;
    // End of variables declaration//GEN-END:variables
}
