package fitnesCalendar.basics;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

public class Eintrag {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ENTRYID")
  private long entryId;
  
  @OneToMany(mappedBy = "aktivitaetId")
  @Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
  private List<Aktivitaet> aktivitaeten;
  
  @Column()
  private Date date;
  
  
  public List<Aktivitaet> getAktivitaeten() {
    return aktivitaeten;
  }
  
  public void setAktivitaeten(List<Aktivitaet> aktivitaeten) {
    this.aktivitaeten = aktivitaeten;
  }
  
  public Date getDate() {
    return date;
  }
  
  public void setDate(Date date) {
    this.date = date;
  }
  
}
