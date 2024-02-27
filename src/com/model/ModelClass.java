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

    public static Color generarColor() {
        
        Color c = Color.BLACK;
        
        int n = ramdon();
        
        switch (n) {
            case 1:
                c = Color.RED;
                break;

            case 2:
                c = Color.BLACK;
                break;

            case 3:
                c = Color.BLUE;
                break;

            case 4:
                c = Color.GRAY;
                break;

            case 5:
                c = Color.GREEN;
                break;

            case 6:
                c = Color.ORANGE;
                break;

            case 7:
                c = Color.MAGENTA;
                break;

            case 8:
                c = Color.CYAN;
                break;

            case 9:
                c = Color.PINK;
                break;

            case 10:
                c = Color.YELLOW;
                break;
        }
        
        return c;
    }
    public static  int ramdon() {
        return (int) (Math.random() * 10 + 1);
    }
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

    public Object[] toRowTable(EventActionClases event) {
        Icon icon = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.CLASS, 60,
                generarColor(), generarColor());

        return new Object[]{new ModelProfile(icon, codigo), nombre, programa, creditos,
            new ModelActionClases(this, event)};

    }

    private String codigo;
    private String nombre;
    private String programa;
    private int creditos;

}
