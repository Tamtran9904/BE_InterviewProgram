package fa.training.DAO.Impl;

import fa.training.DAO.QuestionDAO;
import fa.training.Ultil.HibernateUltils;
import fa.training.entities.Candidate;
import fa.training.entities.Interview;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.ListJoin;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class QuestionDaolmpl implements QuestionDAO {

  @Override
  public List<Candidate> cau1() {
    Session session = null;
    Transaction transaction = null;
    List<Candidate> result = null;
    try {
      session = HibernateUltils.getSessionFactory().openSession();
      transaction = session.beginTransaction();
      String hql = "FROM Candidate WHERE skill = 'Angular' AND level = 2";
      Query query = session.createQuery(hql);
      result = query.list();
      transaction.commit();
      return result;
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
    return result;
  }

  @Override
  public List<Candidate> cau2() {
    Session session = null;
    Transaction transaction = null;
    List<Candidate> result = null;
    try {
      session = HibernateUltils.getSessionFactory().openSession();
      transaction = session.beginTransaction();
      String hql = "FROM Candidate WHERE foreignLanguage = 'Japanese' AND skill = 'Python/ML'";
      Query query = session.createQuery(hql);
      result = query.list();
      transaction.commit();
      return result;
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
    return result;
  }

  @Override
  public List<Candidate> cau3() {
    Session session = null;
    Transaction transaction = null;
    List<Candidate> result = null;
    try {
      session = HibernateUltils.getSessionFactory().openSession();
      transaction = session.beginTransaction();
      String hql = "FROM Candidate c "
          + "INNER JOIN c.listEntryTest le "
          + "ON c.id = le.idCandidate.id "
          + "WHERE le.entryTestSkill = 'Java' AND le.result = 'Pass' AND le.date = '2020-10-01'";
      Query query = session.createQuery(hql);
      result = query.list();
      transaction.commit();
      return result;
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
    return result;
  }

  @Override
  public List<Candidate> cau4() {
    Session session = null;
    Transaction transaction = null;
    List<Candidate> result = null;
    DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
    try {
      session = HibernateUltils.getSessionFactory().openSession();
      transaction = session.beginTransaction();
      CriteriaBuilder builder = session.getCriteriaBuilder();
      CriteriaQuery<Candidate> criteriaQuery = builder.createQuery(Candidate.class);

      // FROM AND JOIN
      Root<Candidate> rootCan = criteriaQuery.from(Candidate.class);
      Join<Candidate, Interview> rootInt = rootCan.join("listInterview");
      //SELECT
      criteriaQuery.select(rootCan);
      //WHERE
      criteriaQuery.where(builder.and(
          builder.equal(rootInt.get("date"), df.parse("10/15/2020"))
          , builder.equal(rootInt.get("interviewResult"), "Pass"))
      );

      Query<Candidate> query = session.createQuery(criteriaQuery);
      result = query.getResultList();
      transaction.commit();
      return result;
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
    return result;
  }

  @Override
  public Integer cau5() {
    Session session = null;
    Transaction transaction = null;
    Integer result = null;
    DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
    try {
      session = HibernateUltils.getSessionFactory().openSession();
      transaction = session.beginTransaction();
      CriteriaBuilder builder = session.getCriteriaBuilder();
      CriteriaUpdate<Candidate> criteriaUpdate = builder.createCriteriaUpdate(Candidate.class);

      // FROM AND JOIN
      Root<Candidate> rootCan = criteriaUpdate.from(Candidate.class);
      //SELECT
      criteriaUpdate.set("remark", "inactive");
      //WHERE
      criteriaUpdate.where(builder.and(builder.equal(rootCan.get("phone"), "no"), builder.equal(rootCan.get("email"), "no"), builder.equal(rootCan.get("cv"), "no")));

      Query<Candidate> query = session.createQuery(criteriaUpdate);
      result = query.executeUpdate();
      transaction.commit();
      return result;
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
    return result;
  }

  @Override
  public List<Candidate> search(int pageNumber, int pageSize) {
    Session session = HibernateUltils.getSessionFactory().openSession();
    CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
    CriteriaQuery<Candidate> criteriaQuery =
        criteriaBuilder.createQuery(Candidate.class);
    Query<Candidate> query = session.createQuery(criteriaQuery);
    query.setFirstResult((pageNumber - 1) * pageSize);
    query.setMaxResults(pageSize);
    List<Candidate> listOfCandidate = query.getResultList();
    session.close();
    return listOfCandidate;
  }
}
