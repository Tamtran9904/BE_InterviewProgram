package fa.training.DAO.Impl;

import fa.training.DAO.EntryTestDAO;
import fa.training.entities.Candidate;
import fa.training.entities.EntryTest;
import fa.training.Ultil.HibernateUltils;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class EntryTestDaoImpl implements EntryTestDAO {

  @Override
  public List<EntryTest> getAllEntryTest() {
    Session session = null;
    Transaction transaction = null;
    List<EntryTest> result = null;
    try {
      session = HibernateUltils.getSessionFactory().openSession();
      transaction = session.beginTransaction();
      String hql = "FROM EntryTest";
      Query query = session.createQuery(hql);
      result = query.list();
      transaction.commit();
      return result;
    } catch (Exception e) {
      e.printStackTrace();
      if (transaction != null) {
        transaction.rollback();
      }
    }
    finally {
      if (session != null) {
        session.close();
      }
    }
    return result;
  }

  @Override
  public EntryTest getEntryTestById(Long id) {
    Transaction transaction = null;
    EntryTest result = null;
    Session session = null;
    try {
      session = HibernateUltils.getSessionFactory().openSession();
      transaction = session.beginTransaction();
      result = (EntryTest) session.get(EntryTest.class, id);
      transaction.commit();
      return result;
    } catch (Exception e) {
      e.printStackTrace();
      if (transaction != null) {
        transaction.rollback();
      }

    }
    finally {
      if (session != null) {
        session.close();
      }
    }
    return result;
  }

  @Override
  public boolean updateEntryTestById(EntryTest entryTest, Long id) {
    Session session = null;
    Transaction transaction = null;
    try {
      session = HibernateUltils.getSessionFactory().openSession();
      transaction = session.beginTransaction();
      EntryTest temp = getEntryTestById(id);

      if (temp != entryTest) {
        temp.setTime(entryTest.getTime());
        temp.setDate(entryTest.getDate());
        temp.setLanguageValuator(entryTest.getLanguageValuator());
        temp.setLanguageResult(entryTest.getLanguageResult());
        temp.setTechnicalValuator(entryTest.getTechnicalValuator());
        temp.setTechnicalResult(entryTest.getTechnicalResult());
        temp.setResult(entryTest.getResult());
        temp.setRemark(entryTest.getRemark());
        temp.setEntryTestSkill(entryTest.getEntryTestSkill());
        temp.setIdCandidate(entryTest.getIdCandidate());

        session.update(temp);
        transaction.commit();
        return true;
      }
    } catch (Exception e) {
      e.printStackTrace();
      if (transaction != null) {
        transaction.rollback();
      }
    } finally {
      if (session != null) {
        session.close();
      }

    }
    return false;
  }

  @Override
  public boolean deleteEntryTestById(Long id) {
    Session session = null;
    Transaction transaction = null;
    try {
      session = HibernateUltils.getSessionFactory().openSession();
      transaction = session.beginTransaction();
      EntryTest entryTest = session.get(EntryTest.class, id);
      if (entryTest != null) {
        session.delete(entryTest);
        transaction.commit();
        return true;
      }
    } catch (Exception e) {
      e.printStackTrace();
      if (transaction != null) {
        transaction.rollback();
      }
    }
    finally {
      if (session != null) {
        session.close();
      }
    }
    return false;
  }

  @Override
  public boolean saveEntryTest(EntryTest entryTest) {
    Session session = null;
    Transaction transaction = null;
    try {
      session = HibernateUltils.getSessionFactory().openSession();
      transaction = session.beginTransaction();
      Serializable result = (Serializable) session.save(entryTest);
      transaction.commit();
      return (result != null);
    } catch (Exception e) {
      e.printStackTrace();
      if (transaction != null) {
        transaction.rollback();
        return false;
      }
    }
    finally {
      if (session != null) {
        session.close();
      }
    }
    return false;
  }
}
