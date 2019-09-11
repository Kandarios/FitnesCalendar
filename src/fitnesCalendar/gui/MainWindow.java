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
    initializeMenuBar();
    createGui();
  }


  private void initializeMenuBar() {
    JMenuBar menuBar = new JMenuBar();
    frame.setJMenuBar(menuBar);

    JMenu menuDatei = new JMenu("Datei");
    menuDatei.setFont(new Font("Segoe UI", Font.PLAIN, 17));
    menuBar.add(menuDatei);

    JMenuItem menuItemSchlieﬂen = new JMenuItem("Schlieﬂen");
    menuItemSchlieﬂen.setFont(new Font("Segoe UI", Font.PLAIN, 18));
    menuItemSchlieﬂen.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        frame.dispatchEvent(new WindowEvent(
            frame, WindowEvent.WINDOW_CLOSING));
      }
    });
    menuDatei.add(menuItemSchlieﬂen);

    JMenu menuAktivitaeten = new JMenu("Aktivit‰ten");
    menuAktivitaeten.setFont(new Font("Segoe UI", Font.PLAIN, 17));
    menuBar.add(menuAktivitaeten);

    JMenuItem menuItemBearbeiten = new JMenuItem("Bearbeiten");
    menuItemBearbeiten.setFont(new Font("Segoe UI", Font.PLAIN, 18));
    menuItemBearbeiten.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        ActivityWindow window = new ActivityWindow();
        window.setVisible(true);
      }
    });
    menuAktivitaeten.add(menuItemBearbeiten);
  }

  private void createGui() {
    frame.setSize(900, 900);
    frame.setContentPane(new CalendarPanel());
    frame.setVisible(true);
  }
}
