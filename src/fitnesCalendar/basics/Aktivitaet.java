package fitnesCalendar.basics;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AKTIVITAETEN")
public class Aktivitaet {

  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column()
  private long aktivitaetId;
  
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
