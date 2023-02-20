/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendita;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author asistentedirprod
 */
public class Paint extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable maintab, Object value,
            boolean isSelected,
            boolean hasFocus,
            int row,
            int column) {

        Double status = Double.parseDouble(maintab.getValueAt(row, 3).toString());
        if (status==0) {
            setBackground(new java.awt.Color(247, 94, 94));
        } else if (status>0&&status<10) {
            setBackground(new java.awt.Color(245, 228, 105));
        } else if (status>0&&status>10) {
            setBackground(new java.awt.Color(126, 213, 91));
        }

        return super.getTableCellRendererComponent(maintab, value, isSelected, hasFocus, row, column);
    }

}
