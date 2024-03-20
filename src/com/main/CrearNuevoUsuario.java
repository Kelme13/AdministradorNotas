/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/Customizer.java to edit this template
 */
package com.main;


import com.ManejoBasesDeDatos.Querys;
import com.roles.Usuario;
import com.swing.icon.GoogleMaterialDesignIcons;
import com.swing.icon.IconFontSwing;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import com.swing.icon.GoogleMaterialDesignIcons;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;


/**
 *
 * @author lenovo
 */
public class CrearNuevoUsuario extends javax.swing.JDialog {
    
   public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    private boolean ok;
    private final Animator animator;
    private boolean show = true;

    @Override
    public void setLocationRelativeTo(Component c) {
        super.setLocationRelativeTo(c); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    /**
     * Creates new customizer CrearNuevoUsuario
     */
    public CrearNuevoUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                if (show) {
                    setOpacity(fraction);
                } else {
                    setOpacity(1f - fraction);
                }
            }

            @Override
            public void end() {
                if (show == false) {
                    setVisible(false);
                }
            }

        };
        animator = new Animator(200, target);
        animator.setResolution(0);
        animator.setAcceleration(0.5f);

    }
    
   
    private void NuevasCredenciales() {
        
        Querys querys = new Querys();
        char[] password = txtPassword.getPassword();
        String nombre="";
        Usuario user = querys.validarCredenciales(txtCuenta.getText(), new String(password));

        if (user == null) {
            switch(jComboBox1.getSelectedIndex()){
                case 0 -> {
                    if(querys.getEstudianteByCuenta(txtCuenta.getText())==null){
                        querys.InsertEstudiante(txtNombre.getText(), txtCuenta.getText(), "");
                    }
                    
                    if(querys.getEstudianteByCuenta(txtCuenta.getText())==null){
                        JOptionPane.showMessageDialog(this, "Este Numero de Cuenta No existe dentro de la base de datos!",
                                "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    nombre=querys.getEstudianteByCuenta(txtCuenta.getText()).getName();
                }
                    
                case 1 -> {
                    if(querys.getDocenteByCuenta(txtCuenta.getText())==null){
                        querys.InsertMaestro(txtNombre.getText(), txtCuenta.getText(), "");
                    }
                    
                    if(querys.getDocenteByCuenta(txtCuenta.getText())==null){
                        JOptionPane.showMessageDialog(this, "Este Numero de Cuenta No existe dentro de la base de datos!",
                                "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    nombre=querys.getDocenteByCuenta(txtCuenta.getText()).getNombre();
                }
                case 2 -> {
                    if(querys.getCoordinadorNamebyCuenta(txtCuenta.getText())==null){
                        querys.InsertCoordinador(txtNombre.getText(), txtCuenta.getText(), "");
                    }
                    
                    
                    if(querys.getCoordinadorNamebyCuenta(txtCuenta.getText())==null){
                        JOptionPane.showMessageDialog(this, "Este Numero de Cuenta No existe dentro de la base de datos!",
                                "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    nombre=querys.getCoordinadorNamebyCuenta(txtCuenta.getText());
                }
            }
            System.out.println("EYYYYYY  ");
            user = querys.InsertCredenciales(txtCuenta.getText(),new String(password));
            user.setUsuario(nombre);
            
            
            this.setVisible(false);
            System.out.println("Ya se cerro");
        }
    }
    
    public void showMessage() {
        animator.start();
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the FormEditor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        txtPassword1 = new javax.swing.JPasswordField();
        txtPassword2 = new javax.swing.JPasswordField();
        jSeparator3 = new javax.swing.JSeparator();
        bg = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCuenta = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jSeparator2 = new javax.swing.JSeparator();
        button1 = new com.raven.swing.Button();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        txtNombre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtDepCar = new javax.swing.JPasswordField();
        lblDepCar = new javax.swing.JLabel();

        jLabel4.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel4.setText("Numero de Cuenta");

        txtPassword1.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        txtPassword1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 20));

        txtPassword2.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        txtPassword2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 20));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel1.setText("Registrarse");

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel2.setText("Numero de Cuenta");

        txtCuenta.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        txtCuenta.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 20));

        jLabel3.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel3.setText("Contraseña");

        txtPassword.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        txtPassword.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 20));

        button1.setBackground(new java.awt.Color(225, 147, 186));
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setText("Ingresar");
        button1.setFont(new java.awt.Font("Segoe UI Light", 1, 24)); // NOI18N
        button1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button1MouseClicked(evt);
            }
        });
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel5.setText("Rol");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Estudiante", "Maestro", "Coordinador" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        txtNombre.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        txtNombre.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 20));

        jLabel6.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel6.setText("Nombre");

        txtDepCar.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        txtDepCar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 20));

        lblDepCar.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        lblDepCar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDepCar.setText("?");

        bg.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        bg.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        bg.setLayer(txtCuenta, javax.swing.JLayeredPane.DEFAULT_LAYER);
        bg.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        bg.setLayer(txtPassword, javax.swing.JLayeredPane.DEFAULT_LAYER);
        bg.setLayer(jSeparator2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        bg.setLayer(button1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        bg.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        bg.setLayer(jComboBox1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        bg.setLayer(txtNombre, javax.swing.JLayeredPane.DEFAULT_LAYER);
        bg.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        bg.setLayer(txtDepCar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        bg.setLayer(lblDepCar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jLabel1))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addComponent(jLabel2))
                            .addGroup(bgLayout.createSequentialGroup()
                                .addGap(127, 127, 127)
                                .addComponent(jLabel3))
                            .addGroup(bgLayout.createSequentialGroup()
                                .addGap(167, 167, 167)
                                .addComponent(jLabel5))
                            .addGroup(bgLayout.createSequentialGroup()
                                .addGap(103, 103, 103)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(bgLayout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblDepCar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtCuenta, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                    .addComponent(txtPassword)
                                    .addComponent(txtNombre)
                                    .addComponent(txtDepCar))))
                        .addGap(62, 62, 62)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE)))
                .addContainerGap(40, Short.MAX_VALUE))
            .addGroup(bgLayout.createSequentialGroup()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(jLabel6))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(280, 280, 280)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addComponent(lblDepCar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDepCar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        getContentPane().add(bg, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void button1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button1MouseClicked
        // TODO add your handling code here:
        NuevasCredenciales();
        
    }//GEN-LAST:event_button1MouseClicked

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:
        NuevasCredenciales();
    }//GEN-LAST:event_button1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        // TODO add your handling code here:
        switch(jComboBox1.getSelectedIndex()){
                case 0 -> {
                    lblDepCar.setText("Carrera");
                    
                }
                    
                case 1 -> {
                    lblDepCar.setText("Departamento");
                }
                case 2 -> {
                    lblDepCar.setText("Departamento");
                }
                
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void closeMenu() {
        if (animator.isRunning()) {
            animator.stop();
        }
        show = false;
        animator.start();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    private com.raven.swing.Button button1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblDepCar;
    private javax.swing.JTextField txtCuenta;
    private javax.swing.JPasswordField txtDepCar;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JPasswordField txtPassword1;
    private javax.swing.JPasswordField txtPassword2;
    // End of variables declaration//GEN-END:variables
}
