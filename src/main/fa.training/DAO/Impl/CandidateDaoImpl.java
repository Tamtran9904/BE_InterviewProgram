package fa.training.DAO.Impl;

import fa.training.DAO.CandidateDAO;
import fa.training.Ultil.HibernateUltils;
import fa.training.entities.Candidate;
import fa.training.entities.Interview;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class CandidateDaoImpl implements CandidateDAO {

  @Override
  public List<Candidate> getAllCandidate() {
    Transaction transaction = null;
    List<Candidate> result = null;
    Session session = null;
    try  {
      session = HibernateUltils.getSessionFactory().openSession();
      transaction = session.beginTransaction();
      String hql = "FROM Candidate";
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
  public Candidate getCandidateById(Long id) {
    Transaction transaction = null;
    Candidate result = null;
    Session session = null;
    try {
      session = HibernateUltils.getSessionFactory().openSession();
      transaction = session.beginTransaction();
      result = (Candidate) session.get(Candidate.class, id);
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
  public boolean updateCandidateById(Candidate candidate, Long id) {
    Transaction transaction = null;
    Session session = null;
    try {
      session = HibernateUltils.getSessionFactory().openSession();
      transaction = session.beginTransaction();
      Candidate temp = getCandidateById(id);

      if (temp != candidate) {
        temp.setName(candidate.getName());
        temp.setDateOfBirth(candidate.getDateOfBirth());
        temp.setGender(candidate.getGender());
        temp.setGraduationYear(candidate.getGraduationYear());
        temp.setPhone(candidate.getPhone());
        temp.setEmail(candidate.getEmail());
        temp.setSkill(candidate.getSkill());
        temp.setForeignLanguage(candidate.getForeignLanguage());
        temp.setLevel(candidate.getLevel());
        temp.setCv(candidate.getCv());
        temp.setAllocationStatus(candidate.getAllocationStatus());
        temp.setRemark(candidate.getRemark());

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
  public boolean deleteCandidateById(Long id) {
    Transaction transaction = null;
    Session session = null;
    try {
      session = HibernateUltils.getSessionFactory().openSession();
      transaction = session.beginTransaction();
      Candidate candidate = session.get(Candidate.class, id);
      if (candidate != null) {
        session.delete(candidate);
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
  public boolean saveCandidate(Candidate candidate) {
    Transaction transaction = null;
    Session session = null;
    try {
      session = HibernateUltils.getSessionFactory().openSession();
      transaction = session.beginTransaction();
      Serializable result = (Serializable) session.save(candidate);
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



