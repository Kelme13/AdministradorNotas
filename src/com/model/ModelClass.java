
package com.model;

import com.swing.icon.GoogleMaterialDesignIcons;
import com.swing.icon.IconFontSwing;
import com.swing.table.EventActionClases;
import com.swing.table.ModelActionClases;
import com.swing.table.ModelProfile;
import java.awt.Color;
import javax.swing.Icon;

/**
 *
 * @author elote
 */
public class ModelClass {

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the programa
     */
    public String getPrograma() {
        return programa;
    }

    /**
     * @param programa the programa to set
     */
    public void setPrograma(String programa) {
        this.programa = programa;
    }

    /**
     * @return the creditos
     */
    public int getCreditos() {
        return creditos;
    }

    /**
     * @param creditos the creditos to set
     */
    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public ModelClass() {
    }

    public ModelClass(String codigo, String nombre, String programa, int creditos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.programa = programa;
        this.creditos = creditos;
    }
    
    public Object[]toRowTable(EventActionClases event) {
        Icon icon = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.CLASS, 60, Color.RED, Color.ORANGE);
        
        return new Object[] {new ModelProfile(icon, codigo),nombre,  programa, creditos,
               new ModelActionClases(this, event)};
        
    }
    
    private String codigo;
    private String nombre;
    private String programa;
    private int creditos;
    
}
