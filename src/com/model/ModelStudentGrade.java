/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model;

import com.swing.table.EventAction;
import com.swing.table.ModelAction;
import com.swing.table.ModelProfile;

/**
 *
 * @author kelvi
 */
public class ModelStudentGrade {

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

    private float nota;
    private ModelStudent student;

    public ModelStudentGrade() {
    }

    public ModelStudentGrade( ModelStudent student, float nota) {
        this.nota = nota;
        this.student = student;
    }
    
    public Object[] toRowTable(EventAction event) {
       
            return new Object[]{new ModelProfile(student.getIcon(), student.getNoCuenta()), student.getName(),
                this.nota, new ModelAction(this.student, event)};
        

    }

}
