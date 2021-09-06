/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MerchantProyect;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
/**
 *
 * @author santiago
 */
public class ColorearFilas extends DefaultTableCellRenderer {
   
@Override
public Component getTableCellRendererComponent(JTable table, Object value, boolean Selected, boolean hasFocus, int row, int col){
   
super.getTableCellRendererComponent(table, value, Selected, hasFocus, row, col);

try {
        String status = String.valueOf(table.getValueAt(row, 3));
    switch (status) {
        case "Preparando":
            setBackground(Selected ? table.getSelectionBackground():Color.YELLOW);
            break;
        case "Listo":
            setBackground(Selected ? table.getSelectionBackground():Color.GREEN);
            break;
        case "":
             setBackground(Selected ? table.getSelectionBackground() : table.getBackground());
             setForeground(Selected ? table.getSelectionForeground() :
             table.getForeground());
                break;
        default:
             setBackground(Selected ? table.getSelectionBackground() : table.getBackground());
             setForeground(Selected ? table.getSelectionForeground() :
             table.getForeground());
            break;
    }
    }
catch (Exception ex){
    
}
 setText(value !=null ? value.toString() : "");
 return this;
}

}
