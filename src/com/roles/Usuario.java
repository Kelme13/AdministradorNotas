/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.roles;

import com.model.ModelCardClass;
import java.util.List;

/**
 *
 * @author elote
 */
public class Usuario {

    /**
     * @return the rol
     */
    public Rol getRol() {
        return rol;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the contra
     */
    public String getContra() {
        return contra;
    }

    /**
     * @param contra the contra to set
     */
    public void setContra(String contra) {
        this.contra = contra;
    }

    /**
     * @return the clases
     */
    public List<ModelCardClass> getClases() {
        return clases;
    }

    /**
     * @param clases the clases to set
     */
    public void setClases(List<ModelCardClass> clases) {
        this.clases = clases;
    }
    
    
    
    private String id;
    private String usuario;
    private String contra;
    private Rol rol;
    
    private List<ModelCardClass> clases;

    public Usuario(String id, String usuario, String contra, Rol rol, List<ModelCardClass> clases) {
        this.id = id;
        this.usuario = usuario;
        this.contra = contra;
        this.rol = rol;
        this.clases = clases;
    }
    
    public Usuario(String id, String usuario, String contra, Rol rol) {
        this.id = id;
        this.usuario = usuario;
        this.contra = contra;
        this.rol = rol;
        this.clases = null;
    }

    
    
    
    
}
