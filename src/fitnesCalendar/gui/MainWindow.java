package fitnesCalendar.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import fitnesCalendar.database.CalendarDB;

public class MainWindow {

  private JFrame frame;
  private CalendarDB calendarDB = CalendarDB.getInstance();
  private JTable tableCalendar;
  static JLabel lblMonth, lblYear;
  static JButton btnPrev, btnNext;
  static JTable tblCalendar;
  static JComboBox cmbYear;
  static Container pane;
  static DefaultTableModel mtblCalendar; //Table model
  static JScrollPane stblCalendar; //The scrollpane
  static JPanel pnlCalendar;
  static int realYear, realMonth, realDay, currentYear, currentMonth;

  /**
   * Create the application.
   */
  public MainWindow() {
    frame = new JFrame("Betreuer Verwaltung");
    frame.setSize(447, 456);
    pane = frame.getContentPane(); //Get content pane
    pane.setLayout(null); //Apply null layout
    initializeMenuBar();
    this.frame.setVisible(true);
    createGui();
  }


  private void initializeMenuBar() {
    JMenuBar menuBar = new JMenuBar();
    frame.setJMenuBar(menuBar);

    JMenu mnFile = new JMenu("Datei");
    mnFile.setFont(new Font("Segoe UI", Font.PLAIN, 17));
    menuBar.add(mnFile);

    JMenuItem mntmExit = new JMenuItem("Schlieﬂen");
    mntmExit.setFont(new Font("Segoe UI", Font.PLAIN, 18));
    mntmExit.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        frame.dispatchEvent(new WindowEvent(
            frame, WindowEvent.WINDOW_CLOSING));
      }
    });
    mnFile.add(mntmExit);
    
    tableCalendar = new JTable();
    frame.getContentPane().add(tableCalendar, BorderLayout.CENTER);
    
    JComboBox comboBox = new JComboBox();
    frame.getContentPane().add(comboBox, BorderLayout.SOUTH);
    
    JPanel panel = new JPanel();
    frame.getContentPane().add(panel, BorderLayout.NORTH);
    panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
    
    JButton btnNewButton = new JButton("New button");
    panel.add(btnNewButton);
    
    JButton btnNewButton_1 = new JButton("New button");
    panel.add(btnNewButton_1);
  }
  
  private void createGui() {
    //Create controls
    lblMonth = new JLabel ("January");
    lblYear = new JLabel ("Change year:");
    cmbYear = new JComboBox();
    btnPrev = new JButton ("&lt;&lt;");
    btnNext = new JButton ("&gt;&gt;");
    mtblCalendar = new DefaultTableModel(){public boolean isCellEditable(int rowIndex, int mColIndex){return false;}};
    tblCalendar = new JTable(mtblCalendar);
    stblCalendar = new JScrollPane(tblCalendar);
    pnlCalendar = new JPanel(null);
    
    //Set border
    pnlCalendar.setBorder(BorderFactory.createTitledBorder("Calendar"));
    
    //Register action listeners
//    btnPrev.addActionListener(new btnPrev_Action());
//    btnNext.addActionListener(new btnNext_Action());
//    cmbYear.addActionListener(new cmbYear_Action());
    
    //Add controls to pane
    pane.add(pnlCalendar);
    pnlCalendar.add(lblMonth);
    pnlCalendar.add(lblYear);
    pnlCalendar.add(cmbYear);
    pnlCalendar.add(btnPrev);
    pnlCalendar.add(btnNext);
    pnlCalendar.add(stblCalendar);
    
    //Set bounds
    pnlCalendar.setBounds(0, 0, 320, 335);
    lblMonth.setBounds(160-lblMonth.getPreferredSize().width/2, 25, 100, 25);
    lblYear.setBounds(10, 305, 80, 20);
    cmbYear.setBounds(230, 305, 80, 20);
    btnPrev.setBounds(10, 25, 50, 25);
    btnNext.setBounds(260, 25, 50, 25);
    stblCalendar.setBounds(10, 50, 300, 250);
    
    JPanel panel = new JPanel();
    panel.setBounds(0, 0, 10, 10);
    frame.getContentPane().add(panel);
  }
}
