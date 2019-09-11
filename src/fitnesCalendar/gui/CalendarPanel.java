package fitnesCalendar.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class CalendarPanel extends JPanel {


  static JLabel lblMonth;
  static JButton btnPrev, btnNext;
  static JTable tblCalendar;
  static DefaultTableModel mtblCalendar; //Table model
  static JScrollPane stblCalendar; //The scrollpane

  static final String[] HEADERS = {"Mo", "Di", "Mi", "Do", "Fr", "Sa", "So"};
  static final String[] MONTHS =  {"Januar", "Februar", "März", "April", "Mai", "Juni", "Juli", "August", "September", "Oktober", "November", "Dezember"};

  
  private JPanel panelCalendarTable;
  private JPanel panelNavigation;
  private ActivityCalendar calendar;



  public CalendarPanel() {
    calendar = ActivityCalendar.getInstance();

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
    btnPrev.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
        calendar.decreaseMonth();
        updateGUI();        
      }
    });
    panelNavigation.add(btnPrev);
    btnNext = new JButton (">>");
    btnNext.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
        calendar.increaseMonth();
        updateGUI();
      }
    });
    panelNavigation.add(btnNext);


     //All headers
    for (int i=0; i<7; i++) {
      mtblCalendar.addColumn(HEADERS[i]);
    }

    //Single cell selection
    tblCalendar.setColumnSelectionAllowed(true);
    tblCalendar.setRowSelectionAllowed(true);
    tblCalendar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    //Set row/column count
    tblCalendar.setRowHeight(125);
    mtblCalendar.setColumnCount(7);
    mtblCalendar.setRowCount(6);

    tblCalendar.setDefaultRenderer(Object.class, new CalendarEntryRenderer());
    updateGUI();
    
  }
  
  public void initializeGUI() {
    
  }
  
  public void updateGUI() {
    lblMonth.setText(MONTHS[calendar.getCurrentMonth()] + " " + calendar.getCurrentYear()); //Refresh the month label (at the top)

    int nod = calendar.getCurrentMonthNofDays();
    int som = calendar.getCurrentMonthStartDay();

    //Clear table
    for (int i=0; i<6; i++){
        for (int j=0; j<7; j++){
            mtblCalendar.setValueAt(null, i, j);
        }
    }
    
    for (int i=1; i<=nod; i++){
      int row = (i+som-2)/7;
      int column = (i+som-2)%7;
      LocalDate date = LocalDate.of(calendar.getCurrentYear(), calendar.getCurrentMonth() + 1, i); // + 1 cause localDate starts at 1
      CalendarEntry entry = new CalendarEntry(date);
      mtblCalendar.setValueAt(entry, row, column);
    }
  }
  
}