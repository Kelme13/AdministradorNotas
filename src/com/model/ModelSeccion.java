
package com.model;

import static com.model.ModelClass.generarColor;
import com.swing.icon.GoogleMaterialDesignIcons;
import com.swing.icon.IconFontSwing;
import com.swing.table.EventActionClases;
import com.swing.table.EventActionSecciones;
import com.swing.table.ModelActionClases;
import com.swing.table.ModelActionSeccion;
import com.swing.table.ModelProfile;
import java.awt.Color;
import javax.swing.Icon;

/**
 *
 * @author elote
 */
public class ModelSeccion {

    /**
     * @return the seccion
     */
    public String getSeccion() {
        return seccion;
    }

    /**
     * @param seccion the seccion to set
     */
    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

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
     * @return the estudiantes
     */
    public int getEstudiantes() {
        return estudiantes;
    }

    /**
     * @param estudiantes the estudiantes to set
     */
    public void setEstudiantes(int estudiantes) {
        this.estudiantes = estudiantes;
    }

    /**
     * @return the max
     */
    public int getMax() {
        return max;
    }

    /**
     * @param max the max to set
     */
    public void setMax(int max) {
        this.max = max;
    }

    /**
     * @return the docente
     */
    public ModelDocente getDocente() {
        return docente;
    }

    /**
     * @param docente the docente to set
     */
    public void setDocente(ModelDocente docente) {
        this.docente = docente;
    }
    
    private Color generarColor() {
        
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
    private int ramdon() {
        return (int) (Math.random() * 10 + 1);
    }

    public ModelSeccion() {
    }

    public ModelSeccion(String seccion, ModelClass clase, int estudiantes, int max, ModelDocente docente) {
        this.clase = clase;
        this.estudiantes = estudiantes;
        this.max = max;
        this.docente = docente;
        this.seccion = seccion;
    }
    
    
    
    public Object[] toRowTable(EventActionSecciones event) {
        Icon icon = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.CLASS, 60,
                generarColor(), generarColor());

        String c = estudiantes + " / " + max;
        return new Object[]{new ModelProfile(icon, seccion), c, docente.getNombre(),
            new ModelActionSeccion(this, event)};

    }
    
    
    
    private ModelClass clase;
    private int estudiantes;
    private int max;
    private ModelDocente docente;
    private String seccion;
}
