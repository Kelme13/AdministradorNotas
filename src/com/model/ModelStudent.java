
package com.model;

import com.swing.table.EventAction;
import com.swing.table.ModelAction;
import com.swing.table.ModelProfile;
import java.text.DecimalFormat;
import javax.swing.Icon;

/**
 *
 * @author elote
 */
public class ModelStudent {

    /**
     * @return the noCuenta
     */
    public String getNoCuenta() {
        return noCuenta;
    }

    /**
     * @param noCuenta the noCuenta to set
     */
    public void setNoCuenta(String noCuenta) {
        this.noCuenta = noCuenta;
    }

    /**
     * @return the carrera
     */
    public String getCarrera() {
        return carrera;
    }

    /**
     * @param carrera the carrera to set
     */
    public void setCarrera(String carrera) {
        this.carrera = carrera;
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

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the course
     */
    public String getCourse() {
        return course;
    }

    /**
     * @param course the course to set
     */
    public void setCourse(String course) {
        this.course = course;
    }

    /**
     * @return the fees
     */
    public double getFees() {
        return fees;
    }

    /**
     * @param fees the fees to set
     */
    public void setFees(double fees) {
        this.fees = fees;
    }

    public ModelStudent() {
    }

    public ModelStudent(Icon icon, String name, String gender, String carrera, String noCuenta) {
        this.icon = icon;
        this.name = name;
        this.gender = gender;
        this.course = "";
        this.carrera = carrera;
        this.noCuenta = noCuenta;
        this.fees = 0f;
    }

    
    public ModelStudent(Icon icon, String name, String gender, String course, double fees) {
        this.icon = icon;
        this.name = name;
        this.gender = gender;
        this.course = course;
        this.fees = fees;
    }
    
    public Object[]toRowTable(EventAction event) {
        
        return new Object[] {new ModelProfile(icon, name), gender, carrera,
              noCuenta, new ModelAction(this, event)};
        
    }
    
    private Icon icon;
    private String name;
    private String gender;
    private String course;
    private String carrera;
    private String noCuenta;
    private double fees;
    
}
