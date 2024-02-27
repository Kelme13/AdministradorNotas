/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.swing.table;

import com.model.ModelClass;
import com.model.ModelSeccion;

/**
 *
 * @author elote
 */
public class ModelActionSeccion {

    /**
     * @return the seccion
     */
    public ModelSeccion getClase() {
        return seccion;
    }

    /**
     * @param clase the seccion to set
     */
    public void setClase(ModelSeccion clase) {
        this.seccion = clase;
    }

    /**
     * @return the event
     */
    public EventActionSecciones getEvent() {
        return event;
    }

    /**
     * @param event the event to set
     */
    public void setEvent(EventActionSecciones event) {
        this.event = event;
    }

    public ModelActionSeccion() {
    }

    public ModelActionSeccion(ModelSeccion clase, EventActionSecciones event) {
        this.seccion = clase;
        this.event = event;
    }
    
    
    
    private ModelSeccion seccion;
    private EventActionSecciones event;
}
