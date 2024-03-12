
package com.form;

import com.dialogs.Message;
import com.event.EventClasesVisualizar;
import com.main.Main;
import com.model.ModelClass;
import com.swing.icon.GoogleMaterialDesignIcons;
import com.swing.icon.IconFontSwing;
import com.swing.table.EventActionClases;
import java.awt.Color;
import javax.swing.Icon;

/**
 *
 * @author kelvi
 */
public class Form_TodasClases extends javax.swing.JPanel {
    
    private EventClasesVisualizar eventShowSecciones;
    
    private boolean editableClases;
    
    public Form_TodasClases(EventClasesVisualizar event, boolean editable) {
        initComponents();
        Icon icon = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.LIBRARY_ADD, 40, Color.RED, Color.ORANGE);
        
        btnAgregar.setIcon(icon);
        if(!editable)
            btnAgregar.setVisible(false);
        
        this.eventShowSecciones = event;
        table1.fixTable(jScrollPane1);
        
        editableClases = editable;
        initTableClases();
        setOpaque(false);
    }
    
    private void initTableClases() {     
        
        EventActionClases eventAction = new EventActionClases() {
            @Override
            public void delete(ModelClass clase) {
                if (showMessage("Realmente Desea Borrar: " + clase.getNombre())) {
                    System.out.println("User click OK");
                } else {
                    System.out.println("User click Cancel");
                }
            }

            @Override
            public void update(ModelClass clase) {
                
                if (showMessage("Modificar la clase: " + clase.getNombre())) {
                    System.out.println("User click OK");
                }
            
            }

            @Override
            public void secciones(ModelClass clase) {
                 if (showMessage("Ver las secciones  de: " + clase.getNombre())) {
                    eventShowSecciones.visualizar(clase);
                }
            }
        };
 
        table1.addRow(new ModelClass("CCC303", "Teoria de Base de Datos I", "I-01", 4).toRowTable(eventAction));
        table1.addRow(new ModelClass("CCC304", "Teoria de Base de Datos  II", "I-01", 4).toRowTable(eventAction));
        table1.addRow(new ModelClass("CCC307", "Experiencia de Usuario", "I-01", 4).toRowTable(eventAction));
        
        table1.addRow(new ModelClass("CCC303", "Teoria de Base de Datos I", "I-01", 4).toRowTable(eventAction));
        table1.addRow(new ModelClass("CCC304", "Teoria de Base de Datos  II", "I-01", 4).toRowTable(eventAction));
        table1.addRow(new ModelClass("CCC307", "Experiencia de Usuario", "I-01", 4).toRowTable(eventAction));
        
        
        table1.addRow(new ModelClass("CCC303", "Teoria de Base de Datos I", "I-01", 4).toRowTable(eventAction));
        table1.addRow(new ModelClass("CCC304", "Teoria de Base de Datos  II", "I-01", 4).toRowTable(eventAction));
        table1.addRow(new ModelClass("CCC307", "Experiencia de Usuario", "I-01", 4).toRowTable(eventAction));
        
        
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
        pane = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new com.swing.table.Table();
        btnAgregar = new com.raven.swing.Button();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 51, 255));
        jLabel1.setText("Clases / Todas");

        pane.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBorder(null);

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Programa", "Creditos", "Acciones"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table1);

        javax.swing.GroupLayout paneLayout = new javax.swing.GroupLayout(pane);
        pane.setLayout(paneLayout);
        paneLayout.setHorizontalGroup(
            paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 792, Short.MAX_VALUE))
        );
        paneLayout.setVerticalGroup(
            paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
            .addGroup(paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE))
        );

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
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 654, Short.MAX_VALUE)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(pane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(pane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.Button btnAgregar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pane;
    private com.swing.table.Table table1;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the eventShowSecciones
     */
    public EventClasesVisualizar getEventClasesVisualizar() {
        return eventShowSecciones;
    }
}
