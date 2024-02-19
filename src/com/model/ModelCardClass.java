package com.model;

import javax.swing.Icon;

/**
 *
 * @author kelvi
 */
public class ModelCardClass {

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
     * @return the values
     */
    public double getValues() {
        return values;
    }

    /**
     * @param values the values to set
     */
    public void setValues(double values) {
        this.values = values;
    }

    /**
     * @return the percentage
     */
    public int getPercentage() {
        return percentage;
    }

    /**
     * @param percentage the percentage to set
     */
    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

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

    public ModelCardClass(String title, double values, int percentage, Icon icon) {
        this.title = title;
        this.values = values;
        this.percentage = percentage;
        this.icon = icon;
    }
    
    

    private String title;
    private double values;
    private int percentage;
    private Icon icon;

}
