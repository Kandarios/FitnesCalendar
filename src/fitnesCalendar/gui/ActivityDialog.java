package fitnesCalendar.gui;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ActivityDialog extends JFrame {
  private JTextField textField;
  private JTextField textField_1;

  public ActivityDialog() {
    this.setSize(694, 336);
    getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
    
    JPanel panel_Icon = new JPanel();
    getContentPane().add(panel_Icon);
    
    JLabel lblNewLabel = new JLabel("New label");
    panel_Icon.add(lblNewLabel);
    
    textField = new JTextField();
    panel_Icon.add(textField);
    textField.setColumns(10);
    
    JButton btnNewButton = new JButton("New button");
    panel_Icon.add(btnNewButton);
    
    JPanel panel_name = new JPanel();
    getContentPane().add(panel_name);
    
    JLabel lblNewLabel_1 = new JLabel("New label");
    panel_name.add(lblNewLabel_1);
    
    textField_1 = new JTextField();
    panel_name.add(textField_1);
    textField_1.setColumns(10);
  }
  
}
