package fitnesCalendar.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import fitnesCalendar.basics.CalendarEntry;
import fitnesCalendar.core.ActivityCalendar;

public class CalendarEntryRenderer implements TableCellRenderer {

  @Override
  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
      int row, int column) {
    // TODO Auto-generated method stub
    
    CalendarEntry entry = (CalendarEntry)value;
    
    if(entry == null) {
      return new JPanel();
    }
    
    ActivityCalendar.getInstance().isActualDate(entry.getDate());
    
    CalendarEntryPanel panel = new CalendarEntryPanel(new FlowLayout(FlowLayout.LEFT), entry);
    
    if (isSelected) {
      panel.setBackground(new Color(0, 204, 0));
    } else if (ActivityCalendar.getInstance().isActualDate(entry.getDate())) {
      panel.setBackground(new Color(102, 255, 102));
    } else {
      panel.setBackground(table.getBackground());
    }
    
    return panel;
  }

}
