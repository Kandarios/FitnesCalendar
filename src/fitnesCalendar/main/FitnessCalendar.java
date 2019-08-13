package fitnesCalendar.main;

import java.awt.EventQueue;

import fitnesCalendar.gui.MainWindow;

public class FitnessCalendar {

  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          MainWindow window = new MainWindow();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }
}
