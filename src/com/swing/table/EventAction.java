
package com.swing.table;


import com.model.ModelStudent;

/**
 *
 * @author elote
 */
public interface EventAction {
    
    public void delete(ModelStudent student);
    
    public void update(ModelStudent student);
    
}
