package fitnesCalendar.database;

import javax.persistence.EntityManager;

public class CalendarDB {

  private EntityManager entityManager = EntityManagerUtil.getEntityManager();
  private static CalendarDB instance = null;

  private CalendarDB() {
  }

  public static CalendarDB getInstance() {
    if(instance == null) {
      instance = new CalendarDB();
    } 
    return instance;
  }
  
  public void refresh(Object object) {
    entityManager.refresh(object);  
  }
  
  public boolean save(Object object) {
    try {
      entityManager.getTransaction().begin();
      entityManager.merge(object);
      entityManager.getTransaction().commit();
    } catch (Exception e) {
      entityManager.getTransaction().rollback();
    }
    return true;
  }
  
  public void delete(Object object) {
    try {
      entityManager.getTransaction().begin();
      entityManager.remove(object);
      entityManager.getTransaction().commit();
    } catch (Exception e) {
      entityManager.getTransaction().rollback();
    }
  }

//  @SuppressWarnings("unchecked")
//  public List<Betreuer> getBetreuerList() {
//    List<Betreuer> betreuerList = new ArrayList<Betreuer>();
//    try {
//      entityManager.getTransaction().begin();
//      betreuerList = entityManager.createQuery("from Betreuer").getResultList();
//      entityManager.getTransaction().commit();
//      return betreuerList;
//    } catch (Exception e) {
//      entityManager.getTransaction().rollback();
//    }
//    return betreuerList;
//  }
  
//  @SuppressWarnings("unchecked")
//  public List<Betreuer> getUnusedBetreuerList() {
//    List<Betreuer> betreuerList = new ArrayList<Betreuer>();
//    try {
//      entityManager.getTransaction().begin();
//      Query query = entityManager.createQuery("from Betreuer where ZELTID is null ");
//      betreuerList = query.getResultList();
//      entityManager.getTransaction().commit();
//      return betreuerList;
//    } catch (Exception e) {
//      entityManager.getTransaction().rollback();
//    }
//    return betreuerList;
//  }
  
//  public void updateBetreuer(Long betreuerID, String newName, String newPicture) {
//    try {
//      System.out.print("Ist doch diese Funktion?");
//      entityManager.getTransaction().begin();
//      Betreuer betreuer = (Betreuer) entityManager.find(Betreuer.class, betreuerID);
//      betreuer.setName(newName);
//      betreuer.setPicture(newPicture);
//      entityManager.getTransaction().commit();
//    } catch (Exception e) {
//      entityManager.getTransaction().rollback();
//    }
//  }
    
}