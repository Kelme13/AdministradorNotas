/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model;

import static com.model.ModelClass.generarColor;
import com.swing.icon.GoogleMaterialDesignIcons;
import com.swing.icon.IconFontSwing;
import com.swing.table.EventActionClases;
import com.swing.table.ModelActionClases;
import com.swing.table.ModelProfile;
import javax.swing.Icon;

/**
 *
 * @author kelvi
 */
public class ModelGradeClass {

    /**
     * @return the clase
     */
    public ModelClass getClase() {
        return clase;
    }

    /**
     * @param clase the clase to set
     */
    public void setClase(ModelClass clase) {
        this.clase = clase;
    }

    /**
     * @return the nota
     */
    public float getNota() {
        return nota;
    }

    /**
     * @param nota the nota to set
     */
    public void setNota(float nota) {
        this.nota = nota;
    }
    
    private ModelClass clase;
    private float nota;

    public ModelGradeClass() {
    }

    public ModelGradeClass(ModelClass clase, float nota) {
        this.clase = clase;
        this.nota = nota;
    }
    
     public Object[] toRowTable(EventActionClases event) {
        Icon icon = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.CLASS, 60,
                generarColor(), generarColor());

        return new Object[]{new ModelProfile(icon, clase.getCodigo()),
            clase.getNombre(), clase.getPrograma(), clase.getCreditos(),
            nota};
    }
    
}
