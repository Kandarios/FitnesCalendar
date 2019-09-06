package fitnesCalendar.gui;

import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import fitnesCalendar.basics.CalendarEntry;

public class CalendarEntryRenderer implements TableCellRenderer {

  @Override
  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
      int row, int column) {
    // TODO Auto-generated method stub
    
    CalendarEntry entry = (CalendarEntry)value;
    
    CalendarEntryPanel panel = new CalendarEntryPanel(new FlowLayout(FlowLayout.LEFT), entry);
    
    if (isSelected) {
      panel.setBackground(table.getSelectionBackground());
    } else {
      panel.setBackground(table.getBackground());
    }
    
    return panel;
  }

}
