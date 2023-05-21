package modelo;


import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class ColorCelda extends JTable {
    @Override
    public Component prepareRenderer(TableCellRenderer renderer, int rowIndex, int columnIndex) {
        Component componente = super.prepareRenderer(renderer, rowIndex, columnIndex);

        if (columnIndex == 4) 
        {
            if(getValueAt(rowIndex, columnIndex) != null)
            {
                String valor = (String) getValueAt(rowIndex, columnIndex).toString();

                if (valor.equalsIgnoreCase("0")) 
                {
                    componente.setBackground(Color.green);
                    componente.setForeground(Color.green);
                }
                else
                {
                    componente.setBackground(Color.red);
                    componente.setForeground(Color.red);
                 }
            }
        }
        else 
        {
            componente.setBackground(Color.white);
            componente.setForeground(Color.black);
        }
        return componente;
    }
}
