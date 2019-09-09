package fitnesCalendar.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class ActivityWindow extends JFrame {
  
  static JTable tblActivities;
  static DefaultTableModel mtblActivities; //Table model
  static JScrollPane stblActivities; //The scrollpane

  
  
  
  public ActivityWindow() {
    this.setSize(794, 436);
    setTitle("Aktivit\u00E4ten");
    getContentPane().setLayout(new BorderLayout(0, 0));
    
    JPanel panel_Controls = new JPanel();
    panel_Controls.setBorder(new LineBorder(new Color(0, 0, 0), 0));
    getContentPane().add(panel_Controls, BorderLayout.EAST);
    
    JButton btn_Add = new JButton("Hinzuf\u00FCgen");
    
    JButton btn_Modify = new JButton("Bearbeiten");
    panel_Controls.setLayout(new GridLayout(12, 1, 0, 0));
    panel_Controls.add(btn_Add);
    panel_Controls.add(btn_Modify);
    
    JButton btn_Delete = new JButton("L\u00F6schen");
    panel_Controls.add(btn_Delete);
    
    JPanel panel_Main = new JPanel();
    getContentPane().add(panel_Main, BorderLayout.CENTER);
    
    
    mtblActivities = new DefaultTableModel(){public boolean isCellEditable(int rowIndex, int mColIndex){return false;}};
    tblActivities = new JTable(mtblActivities);
    stblActivities = new JScrollPane(tblActivities);
    panel_Main.add(stblActivities, BorderLayout.CENTER);
    //Single cell selection
    tblActivities.setColumnSelectionAllowed(false);
    tblActivities.setRowSelectionAllowed(true);
    tblActivities.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    //Set row/column count
//    tblActivities.setRowHeight(145);
    mtblActivities.addColumn("Aktivität");
    mtblActivities.addColumn("Symbol");
    //    mtblActivities.setRowCount(6);

    
  }

}
