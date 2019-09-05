package fitnesCalendar.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class CalendarPanel extends Container {

  
  static JLabel lblMonth, lblYear;
  static JButton btnPrev, btnNext;
  static JTable tblCalendar;
  static JComboBox cmbYear;
  static DefaultTableModel mtblCalendar; //Table model
  static JScrollPane stblCalendar; //The scrollpane
  static JPanel pnlCalendar;
  static int realYear, realMonth, realDay, currentYear, currentMonth;
  private JPanel panel;
  private JPanel panel_1;
  private JPanel panel_2;
  private JPanel panel_3;

  
  
  public CalendarPanel() {
    mtblCalendar = new DefaultTableModel(){public boolean isCellEditable(int rowIndex, int mColIndex){return false;}};
    this.setLayout(new BorderLayout(0, 0));
    pnlCalendar = new JPanel(null);
    
    //Set border
    pnlCalendar.setBorder(null);
    
    //Register action listeners
//    btnPrev.addActionListener(new btnPrev_Action());
//    btnNext.addActionListener(new btnNext_Action());
//    cmbYear.addActionListener(new cmbYear_Action());
    
   
    
    //Add controls to pane
    this.add(pnlCalendar);
    pnlCalendar.setLayout(new BorderLayout(0, 0));
    
    panel = new JPanel();
    pnlCalendar.add(panel, BorderLayout.NORTH);
    panel.setLayout(new BorderLayout(0, 0));
    
    panel_3 = new JPanel();
    panel.add(panel_3, BorderLayout.EAST);
    lblYear = new JLabel ("Change year:");
    panel_3.add(lblYear);
    lblYear.setAlignmentX(Component.CENTER_ALIGNMENT);
    cmbYear = new JComboBox();
    panel_3.add(cmbYear);
    
    panel_1 = new JPanel();
    pnlCalendar.add(panel_1);
    panel_1.setLayout(new BorderLayout(0, 0));
    tblCalendar = new JTable(mtblCalendar);
    stblCalendar = new JScrollPane(tblCalendar);
    panel_1.add(stblCalendar, BorderLayout.CENTER);
    //Create controls
    lblMonth = new JLabel ("January");
    lblMonth.setFont(new Font("Tahoma", Font.PLAIN, 14));
    lblMonth.setHorizontalAlignment(SwingConstants.CENTER);
    panel_1.add(lblMonth, BorderLayout.NORTH);
    
    panel_2 = new JPanel();
    pnlCalendar.add(panel_2, BorderLayout.SOUTH);
    btnPrev = new JButton ("<<");
    panel_2.add(btnPrev);
    btnNext = new JButton (">>");
    panel_2.add(btnNext);
    
    
    //TODO: We want that somewhere else
    //Get real month/year
    GregorianCalendar cal = new GregorianCalendar(); //Create calendar
    realDay = cal.get(GregorianCalendar.DAY_OF_MONTH); //Get day
    realMonth = cal.get(GregorianCalendar.MONTH); //Get month
    realYear = cal.get(GregorianCalendar.YEAR); //Get year
    currentMonth = realMonth; //Match month and year
    currentYear = realYear;
    
  //Add headers TODO: We want Monday first
    String[] headers = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"}; //All headers
    for (int i=0; i<7; i++){
        mtblCalendar.addColumn(headers[i]);
    }
    
    //Single cell selection
    tblCalendar.setColumnSelectionAllowed(true);
    tblCalendar.setRowSelectionAllowed(true);
    tblCalendar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    
    //Set row/column count
    tblCalendar.setRowHeight(180);
    mtblCalendar.setColumnCount(7);
    mtblCalendar.setRowCount(6);
    
    tblCalendar.setDefaultRenderer(Object.class, new CalendarEntryRenderer());
    
    //Populate table TODO range is not needed
    for (int i=realYear-2; i<=realYear+2; i++){
        cmbYear.addItem(String.valueOf(i));
    }
    cmbYear.setSelectedIndex(2); //TODO das geh klueger: cmbYear.setSelectedItem(String.valueOf(year))
    
    
    String[] months =  {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    lblMonth.setText(months[currentMonth]); //Refresh the month label (at the top)
    
  //Get first day of month and number of days
   GregorianCalendar currentCal = new GregorianCalendar(currentYear, currentMonth, 1);
   
   System.out.println("Month " + currentMonth + " year: " + currentYear);   
   int nod = currentCal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
   int som = currentCal.get(GregorianCalendar.DAY_OF_WEEK);
   
   
   //TODO: Understand this
   for (int i=1; i<=nod; i++){
       int row = new Integer((i+som-2)/7);
       int column  =  (i+som-2)%7;
       mtblCalendar.setValueAt(i, row, column);
   }
   
   
  }
  
}



// Beautify
//static class tblCalendarRenderer extends DefaultTableCellRenderer{
//  public Component getTableCellRendererComponent (JTable table, Object value, boolean selected, boolean focused, int row, int column){
//      super.getTableCellRendererComponent(table, value, selected, focused, row, column);
//      if (column == 0 || column == 6){ //Week-end14
//          setBackground(new Color(255, 220, 220));41
//      }
//      else{ //Week
//          setBackground(new Color(255, 255, 255));
//      }
//      if (value != null){
//          if (Integer.parseInt(value.toString()) == realDay && currentMonth == realMonth && currentYear == realYear){ //Today
//              setBackground(new Color(220, 220, 255));
//          }
//      }
//      setBorder(null);
//      setForeground(Color.black);
//      return this;
//  }

