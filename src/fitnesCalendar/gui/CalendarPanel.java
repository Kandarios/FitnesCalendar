package fitnesCalendar.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import fitnesCalendar.basics.CalendarEntry;
import fitnesCalendar.core.ActivityCalendar;
import fitnesCalendar.gui.listeners.NextMonthListener;
import fitnesCalendar.gui.listeners.PreviousMonthListener;

public class CalendarPanel extends JPanel {

  
  static JLabel lblMonth;
  static JButton btnPrev, btnNext;
  static JTable tblCalendar;
  static DefaultTableModel mtblCalendar; //Table model
  static JScrollPane stblCalendar; //The scrollpane

  private JPanel panelCalendarTable;
  private JPanel panelNavigation;
  
  private ActivityCalendar calendar;

  
  
  public CalendarPanel() {
    calendar = new ActivityCalendar();
    
    mtblCalendar = new DefaultTableModel(){public boolean isCellEditable(int rowIndex, int mColIndex){return false;}};
    this.setLayout(new BorderLayout(0, 0));
    

    panelCalendarTable = new JPanel();
    this.add(panelCalendarTable);
    panelCalendarTable.setLayout(new BorderLayout(0, 0));
    tblCalendar = new JTable(mtblCalendar);
    stblCalendar = new JScrollPane(tblCalendar);
    panelCalendarTable.add(stblCalendar, BorderLayout.CENTER);
    //Create controls
    lblMonth = new JLabel ("January");
    lblMonth.setFont(new Font("Tahoma", Font.BOLD, 18));
    lblMonth.setHorizontalAlignment(SwingConstants.CENTER);
    panelCalendarTable.add(lblMonth, BorderLayout.NORTH);
    
    panelNavigation = new JPanel();
    this.add(panelNavigation, BorderLayout.SOUTH);
    btnPrev = new JButton ("<<");
    btnPrev.addActionListener(new PreviousMonthListener());
    panelNavigation.add(btnPrev);
    btnNext = new JButton (">>");
    btnNext.addActionListener(new NextMonthListener());
    panelNavigation.add(btnNext);
    
    
    String[] headers = {"Mo", "Di", "Mi", "Do", "Fr", "Sa", "So"}; //All headers
    for (int i=0; i<7; i++){
        mtblCalendar.addColumn(headers[i]);
    }
    
    //Single cell selection
    tblCalendar.setColumnSelectionAllowed(true);
    tblCalendar.setRowSelectionAllowed(true);
    tblCalendar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    
    //Set row/column count
    tblCalendar.setRowHeight(145);
    mtblCalendar.setColumnCount(7);
    mtblCalendar.setRowCount(6);
    
    tblCalendar.setDefaultRenderer(Object.class, new CalendarEntryRenderer());
    
    String[] months =  {"Januar", "Februar", "März", "April", "Mai", "Juni", "Juli", "August", "September", "Oktober", "November", "Dezember"};
    lblMonth.setText(months[calendar.getActualMonth()]); //Refresh the month label (at the top)
    
    int nod = calendar.getCurrentMonthNofDays();
    int som = calendar.getCurrentMonthStartDay();
   
   for (int i=1; i<=nod; i++){
       int row = (i+som-2)/7;
       int column = (i+som-2)%7;
       LocalDate date = LocalDate.of(calendar.getCurrentYear(), calendar.getCurrentMonth(), i);
       CalendarEntry entry = new CalendarEntry(date);
       mtblCalendar.setValueAt(entry, row, column);
   }
  }
}