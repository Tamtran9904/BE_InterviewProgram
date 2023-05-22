package fa.training.DAO.Impl;

import fa.training.DAO.InterviewDAO;
import fa.training.entities.Interview;
import fa.training.entities.Interview;
import fa.training.Ultil.HibernateUltils;
import fa.training.entities.Interview;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class InterviewDaoImpl implements InterviewDAO {

  @Override
  public List<Interview> getAllInterview() {
    Session session = null;
    Transaction transaction = null;
    List<Interview> result = null;

    try {
      session = HibernateUltils.getSessionFactory().openSession();
      transaction = session.beginTransaction();
      String hql = "FROM Interview";
      Query query = session.createQuery(hql);
      result = query.list();
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
  public Interview getInterviewById(Long id) {
    Session session = null;
    Transaction transaction = null;
    Interview result = null;
    try {
      session = HibernateUltils.getSessionFactory().openSession();
      transaction = session.beginTransaction();
      result = (Interview) session.get(Interview.class, id);
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
  public boolean updateInterviewById(Interview interview, Long id) {
    Session session = null;
    Transaction transaction = null;
    try {
      session = HibernateUltils.getSessionFactory().openSession();
      transaction = session.beginTransaction();
      Interview temp = getInterviewById(id);

      if (temp != interview) {
        temp.setTime(interview.getTime());
        temp.setDate(interview.getDate());
        temp.setInterviewer(interview.getInterviewer());
        temp.setComments(interview.getComments());
        temp.setInterviewResult(interview.getInterviewResult());
        temp.setRemark(interview.getRemark());
        temp.setIdCandidate(interview.getIdCandidate());

        session.update(temp);
        transaction.commit();
        return true;
      }

    } catch (Exception e) {
      e.printStackTrace();
      if (transaction != null) {
        transaction.rollback();
      }
    }finally {
      if (session != null) {
        session.close();
      }
    }
    return false;
  }

  @Override
  public boolean deleteInterviewById(Long id) {
    Session session = null;
    Transaction transaction = null;
    try {
      session = HibernateUltils.getSessionFactory().openSession();
      transaction = session.beginTransaction();
      Interview interview = session.get(Interview.class, id);
      if (interview != null) {
        session.delete(interview);
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
  public boolean saveInterview(Interview Interview) {
    Session session = null;
    Transaction transaction = null;
    try {
      session = HibernateUltils.getSessionFactory().openSession();
      transaction = session.beginTransaction();
      Serializable result = (Serializable) session.save(Interview);
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
