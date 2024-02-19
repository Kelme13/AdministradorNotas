

package com.swing.noticeboard;

import java.awt.Color;
/**
 *
 * @author kelvi
 */
public class ModelNoticeBoard {

    /**
     * @return the titleColor
     */
    public Color getTitleColor() {
        return titleColor;
    }

    /**
     * @param titleColor the titleColor to set
     */
    public void setTitleColor(Color titleColor) {
        this.titleColor = titleColor;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * @return the Descripcion
     */
    public String getDescripcion() {
        return Descripcion;
    }

    /**
     * @param Descripcion the Descripcion to set
     */
    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public ModelNoticeBoard(Color titleColor, String title, String time, String Descripcion) {
        this.titleColor = titleColor;
        this.title = title;
        this.time = time;
        this.Descripcion = Descripcion;
    }
    
    

    public ModelNoticeBoard() {
    }
    
    
    
    private Color titleColor;
    private String title;
    private String time;
    private String Descripcion;
}
