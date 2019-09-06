package fitnesCalendar.gui;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import fitnesCalendar.basics.CalendarEntry;

public class CalendarEntryPanel extends JPanel {
  
  CalendarEntry correspondingEntry;

  public CalendarEntryPanel(FlowLayout flowLayout, CalendarEntry entry) {
    super(flowLayout);
    correspondingEntry = entry;
    
    if(entry != null) {
      JLabel date = new JLabel(String.valueOf(entry.getDate().getDayOfMonth()));
      this.add(date);
    }
  
  }



}
