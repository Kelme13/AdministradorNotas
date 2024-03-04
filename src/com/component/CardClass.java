
package com.component;

import com.model.ModelCardClass;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.text.DecimalFormat;

/**
 *
 * @author kelvi
 * 
 * 
 * Con vista de Coordinador
 * El lblValues lo usariamos para indicar el Docente
 * 
 * Con Vista de Alumno o Docente
 * El lblValues lo utilizariamos para indicar la nota
 */
public class CardClass extends javax.swing.JPanel {

    private Color colorGradient;
    
    public CardClass() {
        initComponents();
        setOpaque(false);
        setBackground(new Color(112, 69, 246));
        colorGradient = new Color(255, 255, 255);
        pro.setBackground(new Color(255, 255, 255, 100));
        pro.setForeground(Color.WHITE);
    }
    
    public void setData(ModelCardClass data) {
        DecimalFormat df = new DecimalFormat("#,##0.##");
        lblTitle.setText(data.getTitle());
        lblValues.setText(df.format(data.getValues()));
        lblIcon.setIcon(data.getIcon());
        pro.setValue(data.getPercentage());
        lblPer.setText(df.format(data.getPercentage()) + "%");
        
    }
    
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        lblValues = new javax.swing.JLabel();
        lblIcon = new javax.swing.JLabel();
        pro = new com.raven.swing.ProgressBarCustom();
        lblPer = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setMaximumSize(new java.awt.Dimension(310, 500));
        setName(""); // NOI18N

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("Title");

        lblValues.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblValues.setForeground(new java.awt.Color(255, 255, 255));
        lblValues.setText("Values");

        lblIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblPer.setForeground(new java.awt.Color(255, 255, 255));
        lblPer.setText("0 %");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitle)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblValues)
                            .addComponent(pro, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPer)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(lblIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblPer)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblValues)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addComponent(pro, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
            .addComponent(lblIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public Color getColorGradient() {
        return colorGradient;
    }

    public void setColorGradient(Color colorGradient) {
        this.colorGradient = colorGradient;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gra = new GradientPaint(0, getHeight(), getBackground(), getWidth(), 0, colorGradient);
        
        g2.setPaint(gra);
        g2.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }


    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblIcon;
    private javax.swing.JLabel lblPer;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblValues;
    private com.raven.swing.ProgressBarCustom pro;
    // End of variables declaration//GEN-END:variables
}
