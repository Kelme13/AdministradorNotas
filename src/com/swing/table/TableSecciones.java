package com.swing.table;

import com.swing.scrollbar.ScrollBarCustom;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author elote
 */
public class TableSecciones extends JTable {

    public TableSecciones() {

        setShowHorizontalLines(true);
        setGridColor(new Color(230, 230, 230));
        setRowHeight(40);
        getTableHeader().setReorderingAllowed(false);
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                TableHeader header = new TableHeader(value + "");
                if (column == 3) {
                    header.setHorizontalAlignment(JLabel.CENTER);
                }

                return header;

            }
        });

        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                if (value instanceof ModelProfile) {
                    ModelProfile data = (ModelProfile) value;
                    Profile cell = new Profile(data);
                    if (isSelected) {
                        cell.setBackground(new Color(239, 244, 255));
                    } else {
                        cell.setBackground(Color.WHITE);
                    }

                    return cell;
                } else if (value instanceof ModelActionSeccion) {
                    ModelActionSeccion data = (ModelActionSeccion) value;
                    Action cell = new Action(data);

                    if (isSelected) {
                        cell.setBackground(new Color(239, 244, 255));
                    } else {
                        cell.setBackground(Color.WHITE);
                    }

                    return cell;

                } else if (value instanceof ModelAction) {
                    ModelAction data = (ModelAction) value;
                    Action cell = new Action(data);

                    if (isSelected) {
                        cell.setBackground(new Color(239, 244, 255));
                    } else {
                        cell.setBackground(Color.WHITE);
                    }

                    return cell;

                } else {
                    Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                    setBorder(noFocusBorder);
                    com.setForeground(new Color(102, 102, 102));

                    if (isSelected) {
                        com.setBackground(new Color(239, 244, 255));
                    } else {
                        com.setBackground(Color.WHITE);
                    }

                    return com;
                }
            }

        });
    }

    @Override
    public TableCellEditor getCellEditor(int row, int column) {
        if (column == 3) {
            return new TableCellAction();
        } else {
            return super.getCellEditor(row, column);
        }
    }

    public void addRow(Object[] row) {
        DefaultTableModel mod = (DefaultTableModel) getModel();
        mod.addRow(row);
    }

    public void fixTable(JScrollPane scroll) {
        scroll.getViewport().setBackground(Color.WHITE);
        scroll.setVerticalScrollBar(new ScrollBarCustom());
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        scroll.setBorder(new EmptyBorder(5, 10, 5, 10));
    }

    public void limpiarTabla() {
        DefaultTableModel model = (DefaultTableModel) this.getModel();
        model.setRowCount(0); // Establecer el número de filas en 0
    }

}
