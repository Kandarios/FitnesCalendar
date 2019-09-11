package fitnesCalendar.core;

import java.time.LocalDate;
import java.util.GregorianCalendar;
import java.util.List;

import fitnesCalendar.basics.CalendarEntry;

public class ActivityCalendar {

  static int currentMonth, currentYear;
  static LocalDate actualDate;
  private GregorianCalendar currentCal;

  private static ActivityCalendar calendarInstance = null;

  public static ActivityCalendar getInstance() {
    if(calendarInstance != null) {
      return calendarInstance;
    } 
    calendarInstance = new ActivityCalendar();
    return calendarInstance;

  }

  private ActivityCalendar() {
    GregorianCalendar cal = new GregorianCalendar(); 
    currentMonth  = cal.get(GregorianCalendar.MONTH); 
    currentYear = cal.get(GregorianCalendar.YEAR); 
    actualDate = LocalDate.of(cal.get(GregorianCalendar.YEAR),  cal.get(GregorianCalendar.MONTH) +1, cal.get(GregorianCalendar.DAY_OF_MONTH));
    System.out.println("Today is: " + actualDate);
    updateCurrentCalendar();  
  }

  public boolean isActualDate(LocalDate date) {
    return actualDate.equals(date);
  }
  
  public int getCurrentMonth() {
    return currentMonth;
  }

  public int getCurrentYear() {
    return currentYear;
  }

  public void increaseMonth() {
    currentMonth++;
    if(currentMonth == 12) {
      currentMonth = 0;
      currentYear++;
    }
    updateCurrentCalendar();
  }

  public void decreaseMonth() {
    currentMonth--;
    if(currentMonth < 0) {
      currentMonth = 11;
      currentYear--;
    }
    updateCurrentCalendar();
  }

  public int getCurrentMonthNofDays() {
    return currentCal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
  }

  public int getCurrentMonthStartDay() {
    int som = currentCal.get(GregorianCalendar.DAY_OF_WEEK) - 1;
    if (som == 0) {
      return 7;
    }
    return som;
  }

  public List<CalendarEntry> getEntriesForMonth (int month) {
    int tmp = month;
    return null;
  }

  private void updateCurrentCalendar() {
    currentCal = new GregorianCalendar(currentYear, currentMonth, 1); 
  }

}
