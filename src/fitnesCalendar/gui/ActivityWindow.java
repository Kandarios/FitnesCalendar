package fitnesCalendar.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
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
    btn_Add.setMargin(new Insets(10, 14, 10, 14));
    btn_Add.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        
        JPanel panel_Icon = new JPanel();
        getContentPane().add(panel_Icon);
        
        JLabel lblNewLabel = new JLabel("New label");
        panel_Icon.add(lblNewLabel);
        
        JTextField textField = new JTextField();
        panel_Icon.add(textField);
        textField.setColumns(10);
        
        JButton btnNewButton = new JButton("New button");
        panel_Icon.add(btnNewButton);
        
        JPanel panel_name = new JPanel();
        getContentPane().add(panel_name);
        
        JLabel lblNewLabel_1 = new JLabel("New label");
        panel_name.add(lblNewLabel_1);
        
        JTextField textField_1 = new JTextField();
        panel_name.add(textField_1);
        textField_1.setColumns(10);
        
        Object[] content = {panel_Icon, panel_name};
        
        int result = JOptionPane.showConfirmDialog(
            ActivityWindow.this,
            content,
            "Use default layout",
            JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.PLAIN_MESSAGE);
        
      }
    });
    
    JButton btn_Modify = new JButton("Bearbeiten");
    btn_Modify.setMargin(new Insets(10, 14, 10, 14));
    btn_Modify.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
      }
    });
    panel_Controls.setLayout(new GridLayout(12, 1, 0, 0));
    panel_Controls.add(btn_Add);
    panel_Controls.add(btn_Modify);
    
    JButton btn_Delete = new JButton("L\u00F6schen");
    btn_Delete.setMargin(new Insets(10, 14, 10, 14));
    btn_Delete.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
      }
    });
    panel_Controls.add(btn_Delete);
    
    JPanel panel_Main = new JPanel();
    getContentPane().add(panel_Main, BorderLayout.CENTER);
    
    
    mtblActivities = new DefaultTableModel(){public boolean isCellEditable(int rowIndex, int mColIndex){return false;}};
    panel_Main.setLayout(new BorderLayout(0, 0));
    tblActivities = new JTable(mtblActivities);
    stblActivities = new JScrollPane(tblActivities);
    panel_Main.add(stblActivities);
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
