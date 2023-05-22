package DAO.Impl;

import static org.junit.jupiter.api.Assertions.*;

import fa.training.DAO.Impl.CandidateDaoImpl;
import fa.training.DAO.InterviewDAO;
import fa.training.DAO.Impl.InterviewDaoImpl;
import fa.training.entities.Candidate;
import fa.training.entities.EntryTest;
import fa.training.entities.Interview;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
class InterviewDaoImplTest {

  static InterviewDaoImpl interviewDao;
  static CandidateDaoImpl CandidateDao;

  @BeforeAll
  static void setUpBeforeClass() throws Exception {
    interviewDao = new InterviewDaoImpl();
    CandidateDao = new CandidateDaoImpl();
  }

  @Test
  @Order(5)
  void getAllInterview() {
    List<Interview> list = interviewDao.getAllInterview();
    assertEquals(2, list.size());
  }

  @Test
  @Order(2)
  void getInterviewById() throws ParseException {
    DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
    Candidate perOne = CandidateDao.getCandidateById(1L);
    Interview viewTwo = new Interview("2023", df.parse("05/14/2023"), "Anh", "Nope", "Pass",
        "remark", perOne);
    assertEquals(viewTwo, interviewDao.getInterviewById(2L));
  }

  @Test
  @Order(3)
  void updateInterviewById() throws ParseException {
    DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
    Candidate perOne = CandidateDao.getCandidateById(1L);
    Interview viewTwo = new Interview("2023", df.parse("05/14/2023"), "Anh", "Nope", "Pass",
        "remark", perOne);
    assertEquals(true, interviewDao.updateInterviewById(viewTwo, 2L));
  }

  @Test
  @Order(4)
  void deleteInterviewById() {
    assertEquals(true, interviewDao.deleteInterviewById(3L));
  }

  @Test
  @Order(1)
  void saveInterview() throws ParseException {
    DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
    Candidate perOne = CandidateDao.getCandidateById(1L);
    Candidate perTwo = CandidateDao.getCandidateById(2L);
    Interview viewTwo = new Interview("2023", df.parse("05/14/2023"), "Anh", "Nope", "Pass",
        "remark", perOne);
    Interview viewThree = new Interview("2023", df.parse("05/14/2023"), "Anh", "Nope", "Pass",
        "remark", perTwo);
    assertEquals(true, interviewDao.saveInterview(viewTwo));
    interviewDao.saveInterview(viewThree);
  }
}