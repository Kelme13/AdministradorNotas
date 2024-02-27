/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.swing.table;

import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author elote
 */
public class TableCellAction extends DefaultCellEditor {

    private ModelAction data = null;
    private ModelActionClases dataC = null;
    private ModelActionSeccion dataS = null;

    public TableCellAction() {
        super(new JCheckBox());
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {

        if (value instanceof ModelAction) {

            data = (ModelAction) value;
            Action cell = new Action(data);
            cell.setBackground(new Color(239, 244, 255));
            return cell;
            
        } else if (value instanceof ModelActionClases) {
            
            dataC = (ModelActionClases) value;
            Action cell = new Action(dataC);
            
            cell.setBackground(new Color(239, 244, 255));
            return cell;

        } else if (value instanceof ModelActionSeccion) {
            
            dataS = (ModelActionSeccion) value;
            Action cell = new Action(dataS);
            
            cell.setBackground(new Color(239, 244, 255));
            return cell;
        }
        
        return (Component)value;

        
    }

    @Override
    public Object getCellEditorValue() {
        if(data != null)
            return data;
        else if(dataC != null)
            return dataC;
        else
            return dataS;
    }

}
