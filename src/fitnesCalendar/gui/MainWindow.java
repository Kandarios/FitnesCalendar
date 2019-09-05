package fitnesCalendar.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class MainWindow {

  private JFrame frame;
//  private CalendarDB calendarDB = CalendarDB.getInstance();

  /**
   * Create the application.
   */
  public MainWindow() {
    frame = new JFrame("Betreuer Verwaltung");
    frame.setSize(1075, 1051);
    frame.setContentPane(new CalendarPanel());
//    pane = frame.getContentPane();
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
  }
  
  private void createGui() {

  }
}
