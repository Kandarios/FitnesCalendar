package fitnesCalendar.basics;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ACTIVITIES")
public class Activity {

  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column()
  private long activityId;
  
  @Column()
  private String name;
  
  @Column()
  private String iconURI;
  
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getIconURI() {
    return iconURI;
  }
  
  public void setIconURI(String iconURI) {
    this.iconURI = iconURI;
  }
  
}
