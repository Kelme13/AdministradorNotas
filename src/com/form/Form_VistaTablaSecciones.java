/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.form;

import com.dialogs.Message;
import com.event.EventSeccionVisualizar;
import com.main.Main;
import com.model.ModelClass;
import com.model.ModelDocente;
import com.model.ModelSeccion;
import com.swing.icon.GoogleMaterialDesignIcons;
import com.swing.icon.IconFontSwing;
import com.swing.table.EventActionSecciones;
import java.awt.Color;
import javax.swing.Icon;

/**
 *
 * @author elote
 */
public class Form_VistaTablaSecciones extends javax.swing.JPanel {

    private ModelClass clase;
    private EventSeccionVisualizar event;

    public Form_VistaTablaSecciones(ModelClass clase, EventSeccionVisualizar event) {
        initComponents();
        Icon icon = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.LIBRARY_ADD, 40, Color.RED, Color.ORANGE);

        btnAgregar.setIcon(icon);
        lblDir.setText("Clase / " + clase.getNombre() + " / Secciones");

        setOpaque(false);

        tableSecciones1.fixTable(jScrollPane2);
        initSecciones();

        this.clase = clase;
        this.event = event;
    }

    private void initSecciones() {

        EventActionSecciones eventAction = new EventActionSecciones() {
            @Override
            public void verSeccion(ModelSeccion seccion) {
                System.out.println("Mirando esta seccion " + seccion.getSeccion());
            }

            
        };

        ModelDocente profe = new ModelDocente("123431", "Julio Ramirez", "M", 32);

        tableSecciones1.addRow(new ModelSeccion("1230", clase, 12, 23, profe).toRowTable(eventAction));
        tableSecciones1.addRow(new ModelSeccion("1230", clase, 12, 23, profe).toRowTable(eventAction));
        tableSecciones1.addRow(new ModelSeccion("1230", clase, 12, 23, profe).toRowTable(eventAction));
        tableSecciones1.addRow(new ModelSeccion("1230", clase, 12, 23, profe).toRowTable(eventAction));

    }

    private boolean showMessage(String message) {
        Message obj = new Message(Main.getFrames()[0], true);
        obj.showMessage(message);

        return obj.isOk();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDir = new javax.swing.JLabel();
        btnAgregar = new com.raven.swing.Button();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableSecciones1 = new com.swing.table.TableSecciones();

        lblDir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblDir.setForeground(new java.awt.Color(102, 51, 255));
        lblDir.setText("Clases / Nombre_Clase / Secciones");

        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jScrollPane2.setBorder(null);

        tableSecciones1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Seccion", "No. Estudiantes / Max", "Docente", "Acciones"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableSecciones1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 837, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDir)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.Button btnAgregar;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblDir;
    private com.swing.table.TableSecciones tableSecciones1;
    // End of variables declaration//GEN-END:variables
}
