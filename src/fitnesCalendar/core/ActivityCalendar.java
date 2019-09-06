package fitnesCalendar.core;

import java.util.GregorianCalendar;
import java.util.List;

import fitnesCalendar.basics.CalendarEntry;

//TODO: make this a singkleton class
public class ActivityCalendar {

  static int actualDay, actualYear, actualMonth, 
             currentMonth, currentYear;
  private GregorianCalendar currentCal;
  
  public ActivityCalendar() {
    GregorianCalendar cal = new GregorianCalendar(); //Create calendar
    actualDay = cal.get(GregorianCalendar.DAY_OF_MONTH); //Get day
    currentMonth = actualMonth = cal.get(GregorianCalendar.MONTH); //Get month
    currentYear = actualYear = cal.get(GregorianCalendar.YEAR); //Get year
    updateCurrentCalendar();  
    System.out.println("actualDay " + actualDay + "actualMonth " + actualMonth + " actualYear: " + actualYear);   
  }
  
  public int getActualDay() {
    return actualDay;
  }
  
  public int getActualMonth() {
    return actualMonth;
  }
  
  public int getActualYear() {
    return actualYear;
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
