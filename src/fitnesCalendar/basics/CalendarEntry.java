package fitnesCalendar.basics;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

public class CalendarEntry {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ENTRYID")
  private long entryId;
  
  @OneToMany(mappedBy = "activityId")
  @Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
  private List<Activity> activities;
  
  @Column()
  private LocalDate date;
  
  
  public CalendarEntry(LocalDate date) {
    this.date = date;
  }

  public List<Activity> getActivities() {
    return activities;
  }
  
  public void setActivities(List<Activity> activities) {
    this.activities = activities;
  }
  
  public LocalDate getDate() {
    return date;
  }
  
  public void setDate(LocalDate date) {
    this.date = date;
  }
  
}
