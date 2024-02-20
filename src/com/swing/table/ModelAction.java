
package com.swing.table;

import com.model.ModelClass;
import com.model.ModelStudent;

/**
 *
 * @author elote
 */
public class ModelAction {

    /**
     * @return the student
     */
    public ModelStudent getStudent() {
        return student;
    }

    /**
     * @param student the student to set
     */
    public void setStudent(ModelStudent student) {
        this.student = student;
    }

    /**
     * @return the event
     */
    public EventAction getEvent() {
        return event;
    }

    /**
     * @param event the event to set
     */
    public void setEvent(EventAction event) {
        this.event = event;
    }
    
    private ModelStudent student;
    private EventAction event;

    public ModelAction() {
    }

    public ModelAction(ModelStudent student, EventAction event) {
        this.student = student;
        this.event = event;
    }
    
}
