
package com.swing.table;

import javax.swing.Icon;

/**
 *
 * @author elote
 */
public class ModelProfile {

    /**
     * @return the icon
     */
    public Icon getIcon() {
        return icon;
    }

    /**
     * @param icon the icon to set
     */
    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    private Icon icon;
    private String name;

    public ModelProfile() {
    }

    public ModelProfile(Icon icon, String name) {
        this.icon = icon;
        this.name = name;
    }
    
    
}
