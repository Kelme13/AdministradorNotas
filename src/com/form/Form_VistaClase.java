package com.form;

import com.ManejoBasesDeDatos.Querys;
import com.event.EventSeccionVisualizar;
import com.model.ModelClass;
import com.model.ModelDocente;
import com.model.ModelSeccion;
import com.swing.icon.GoogleMaterialDesignIcons;
import com.swing.icon.IconFontSwing;
import com.swing.table.EventActionSecciones;
import java.awt.Color;
import javax.swing.Icon;

import com.dialogs.Message;
import com.dialogs.createdSeccionDg;
import com.main.Login;
import com.main.Main;
import com.roles.Rol;
import com.roles.Usuario;
import java.util.List;

/**
 *
 * @author elote
 */
public class Form_VistaClase extends javax.swing.JPanel {

    private ModelClass clase;
    private boolean txtEditable = false;
    private EventSeccionVisualizar event;
    private Usuario user;
    Querys querys;

    public Form_VistaClase(ModelClass clase, EventSeccionVisualizar event, boolean editable,
            Usuario user) {
        initComponents();

        this.clase = clase;
        this.event = event;
        
        jLabel1.setText("Clases / " + clase.getNombre());
        querys = new Querys();
        this.user = user;
        
        tableSecciones.fixTable(jScrollPane2);

        initComponentes(editable);
        initTxts();
        initDataTable();

    }

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

        txtCodClase.setEditable(false);
        txtNombreClase.setEditable(false);
        txtUnidades.setEditable(false);

    }

    private void initTxts() {
        txtCodClase.setText(clase.getCodigo());
        txtNombreClase.setText(clase.getNombre());
        txtUnidades.setText("" + clase.getCreditos());
        
    }
    
    private void initDataTable() {
        
        tableSecciones.limpiarTabla();
        
        EventActionSecciones eventAction = new EventActionSecciones() {
            @Override
            public void verSeccion(ModelSeccion seccion) {
                event.visualizar(seccion);
            }

            @Override
            public void delete(ModelSeccion seccion) {
                if (showMessage("Realmente Desea Borrar: " + clase.getNombre())) {
                    System.out.println("Borrando Esta seccion de " + clase.getNombre());
                } else {
                    System.out.println("User click Cancel");
                }
            }
        };
        
         List<ModelSeccion> scs = null;
        
        if(user.getRol().getTp() == Rol.Tipo.DOCENTE)
            scs = querys.selectSeccionesbyClaseDocente(clase.getCodigo(),
                    user.getId());
        else
            scs = querys.selectTodasSeccionesbyClase(clase.getCodigo());
       
        
        for(ModelSeccion s : scs) {
            tableSecciones.addRow(s.toRowTable(eventAction));
        }
    }
    
     private boolean showMessage(String message) {
        Message obj = new Message(Login.getFrames()[0], true);
        obj.showMessage(message);
        
        return obj.isOk();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableSecciones = new com.swing.table.TableSecciones();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCodClase = new javax.swing.JTextField();
        txtUnidades = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNombreClase = new javax.swing.JTextField();
        btnAgregar = new com.raven.swing.Button();
        btnEditar = new com.raven.swing.Button();
        btnGuardar = new com.raven.swing.Button();

        setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 51, 255));
        jLabel1.setText("Clases / nom_clase");

        jScrollPane2.setBorder(null);

        tableSecciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Seccion", "Docente", "Alumnos / Max", "Acciones"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableSecciones.setOpaque(false);
        jScrollPane2.setViewportView(tableSecciones);

        jPanel1.setBackground(new java.awt.Color(212, 16, 173));

        jLabel2.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Cod");

        txtCodClase.setFont(new java.awt.Font("Roboto Light", 0, 20)); // NOI18N
        txtCodClase.setForeground(new java.awt.Color(232, 19, 190));
        txtCodClase.setText("Codigo Clase");

        txtUnidades.setFont(new java.awt.Font("Roboto Light", 0, 20)); // NOI18N
        txtUnidades.setForeground(new java.awt.Color(232, 19, 190));
        txtUnidades.setText("txtUnidades");
        txtUnidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUnidadesActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("UV");

        jLabel4.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Clase");

        txtNombreClase.setFont(new java.awt.Font("Roboto Light", 0, 20)); // NOI18N
        txtNombreClase.setForeground(new java.awt.Color(232, 19, 190));
        txtNombreClase.setText("Nombre Clase");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodClase, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombreClase, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
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
                            .addComponent(txtCodClase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtNombreClase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(77, 77, 77))
        );

        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtUnidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUnidadesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUnidadesActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        createdSeccionDg dg = new createdSeccionDg(Login.getFrames()[0], true, clase.getCodigo());
        dg.showMessage();
        
        if(dg.isOk()) {
            initDataTable();
        }
        
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEditarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarMousePressed
        // TODO add your handling code here:

        if (!txtEditable) {
            Icon icon = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.CANCEL, 40, Color.RED, Color.BLACK);
            btnEditar.setIcon(icon);

            btnGuardar.setVisible(true);
            txtCodClase.setEditable(true);
            txtNombreClase.setEditable(true);
            txtUnidades.setEditable(true);

            txtEditable = true;
        } else {
            Icon icon = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.EDIT, 40, Color.BLUE, Color.BLACK);
            btnEditar.setIcon(icon);

            btnGuardar.setVisible(false);
            txtCodClase.setEditable(false);
            txtNombreClase.setEditable(false);
            txtUnidades.setEditable(false);

            txtEditable = false;
        }

    }//GEN-LAST:event_btnEditarMousePressed

    private void btnGuardarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMousePressed
        // TODO add your handling code here:

        // Aqui deberia haber un query que valide, mas que todo
        // que el codigo no se repita
        
        
        
        
        
        btnGuardar.setVisible(false);
        txtCodClase.setEditable(false);
        txtNombreClase.setEditable(false);
        txtUnidades.setEditable(false);

        txtEditable = false;


    }//GEN-LAST:event_btnGuardarMousePressed


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
    private com.swing.table.TableSecciones tableSecciones;
    private javax.swing.JTextField txtCodClase;
    private javax.swing.JTextField txtNombreClase;
    private javax.swing.JTextField txtUnidades;
    // End of variables declaration//GEN-END:variables
}
