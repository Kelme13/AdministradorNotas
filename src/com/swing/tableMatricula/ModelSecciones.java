/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.swing.tableMatricula;

/**
 *
 * @author kelvi
 */
public class ModelSecciones {

    /**
     * @return the secciones
     */
    public String[] getSecciones() {
        return secciones;
    }

    /**
     * @param secciones the secciones to set
     */
    public void setSecciones(String[] secciones) {
        this.secciones = secciones;
    }
    private String[] secciones;

    public ModelSecciones() {
    }

    public ModelSecciones(String[] secciones) {
        this.secciones = secciones;
    }
    
}
