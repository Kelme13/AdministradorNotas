/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.swing.table;

import com.model.ModelClass;
import com.model.ModelStudent;

/**
 *
 * @author elote
 */
public class ModelActionClases {

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
     * @return the event
     */
    public EventActionClases getEvent() {
        return event;
    }

    /**
     * @param event the event to set
     */
    public void setEvent(EventActionClases event) {
        this.event = event;
    }

    
    private ModelClass clase;
    private EventActionClases event;

    public ModelActionClases() {
    }
    

    public ModelActionClases(ModelClass clase, EventActionClases event) {
        this.clase = clase;
        this.event = event;
    }
    
    
    
}
