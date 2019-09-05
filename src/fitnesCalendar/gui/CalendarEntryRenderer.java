package fitnesCalendar.gui;

import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class CalendarEntryRenderer implements TableCellRenderer {

  @Override
  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
      int row, int column) {
    // TODO Auto-generated method stub
    
    JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    
    if(value != null) {
    Integer val = (Integer)value;
    System.out.println(value);
    JLabel showButton = new JLabel(value.toString());
    
    panel.add(showButton);
    }
    
    if (isSelected) {
      panel.setBackground(table.getSelectionBackground());
    }else{
      panel.setBackground(table.getBackground());
    }
    
    return panel;
  }

}
