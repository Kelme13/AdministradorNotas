package com.dialogs;

import com.ManejoBasesDeDatos.Querys;
import com.main.Login;
import com.roles.Usuario;
import com.swing.icon.GoogleMaterialDesignIcons;
import com.swing.icon.IconFontSwing;
import java.awt.Color;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class createdUsuario1 extends javax.swing.JDialog {

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    private boolean ok;
    private final Animator animator;
    private boolean show = true;

    public createdUsuario1(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setOpacity(0f);
        getContentPane().setBackground(Color.WHITE);
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

    public void showMessage() {
        animator.start();
        setVisible(true);
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        button2 = new com.raven.swing.Button();
        button1 = new com.raven.swing.Button();
        lbIcon = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCuenta = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        lblDepCar = new javax.swing.JLabel();
        txtDepCar = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75, 134, 253)));

        button2.setForeground(new java.awt.Color(66, 66, 66));
        button2.setText("OK");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        button1.setForeground(new java.awt.Color(66, 66, 66));
        button1.setText("Cancel");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        lbIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel1.setText("Registrarse");

        jLabel6.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel6.setText("Nombre");

        txtNombre.setBackground(new java.awt.Color(245, 245, 245));
        txtNombre.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        txtNombre.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 20));

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel2.setText("Numero de Cuenta");

        txtCuenta.setBackground(new java.awt.Color(245, 245, 245));
        txtCuenta.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        txtCuenta.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 20));

        jLabel3.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel3.setText("Contraseña");

        txtPassword.setBackground(new java.awt.Color(245, 245, 245));
        txtPassword.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        txtPassword.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 20));

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

        lblDepCar.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        lblDepCar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDepCar.setText("?");

        txtDepCar.setBackground(new java.awt.Color(245, 245, 245));
        txtDepCar.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        txtDepCar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 20));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(314, 314, 314)
                        .addComponent(lbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(93, 93, 93)
                            .addComponent(jLabel1))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(89, 89, 89)
                            .addComponent(jLabel2))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(129, 129, 129)
                            .addComponent(jLabel3))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(169, 169, 169)
                            .addComponent(jLabel5))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(105, 105, 105)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(49, 49, 49)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblDepCar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtCuenta, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                .addComponent(txtPassword)
                                .addComponent(txtNombre)
                                .addComponent(txtDepCar)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(133, 133, 133)
                            .addComponent(jLabel6)))
                    .addContainerGap(78, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(675, Short.MAX_VALUE)
                .addComponent(lbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1)
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
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(29, 29, 29)
                    .addComponent(lblDepCar)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txtDepCar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(113, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        ok = true;
        
        NuevasCredenciales();
        

        closeMenu();
    }//GEN-LAST:event_button2ActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        closeMenu();
    }//GEN-LAST:event_button1ActionPerformed

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

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void closeMenu() {
        if (animator.isRunning()) {
            animator.stop();
        }
        show = false;
        animator.start();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.Button button1;
    private com.raven.swing.Button button2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lblDepCar;
    private javax.swing.JTextField txtCuenta;
    private javax.swing.JPasswordField txtDepCar;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}
