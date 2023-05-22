package DAO.Impl;

import static org.junit.jupiter.api.Assertions.*;

import fa.training.DAO.Impl.CandidateDaoImpl;
import fa.training.DAO.Impl.QuestionDaolmpl;
import fa.training.entities.Candidate;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
class QuestionDaolmplTest {
  static CandidateDaoImpl candidateDao;
  static QuestionDaolmpl questionDao;
  @BeforeAll
  static void setUpBeforeClass() throws Exception {
    candidateDao = new CandidateDaoImpl();
    questionDao = new QuestionDaolmpl();
  }
  @Test
  @Order(1)
  void Testcau1() {
    List<Candidate> result = questionDao.cau1();
    assertEquals(1, result.size());
  }

  @Test
  @Order(2)
  void Testcau2() {
    List<Candidate> result = questionDao.cau2();
    assertEquals(1, result.size());
  }

  @Test
  void cau3() {
    List<Candidate> result = questionDao.cau3();
    assertEquals(2, result.size());
  }

  @Test
  void cau4() {
    List<Candidate> result = questionDao.cau4();
    assertEquals(2, result.size());
  }

  @Test
  void cau5() {
    assertEquals(1, questionDao.cau5());
  }
}