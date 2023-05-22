package DAO.Impl;


//import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import fa.training.DAO.Impl.CandidateDaoImpl;
import fa.training.entities.Candidate;
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
class CandidateDaoImplTest {
  static CandidateDaoImpl candidateDao;
  @BeforeAll
  static void setUpBeforeClass() throws Exception {
    candidateDao = new CandidateDaoImpl();
  }
  @Test
  @Order(1)
  void saveCandidate() throws ParseException {
    DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
    Candidate personThree = new Candidate("tam", df.parse("04/16/1999"), 1, df.parse("05/11/2023"),
        "3", "3@gmail.com", "java", "English", 7, "good",
        7, "nope");
    Candidate personFour = new Candidate("tam", df.parse("04/16/1999"), 1, df.parse("05/11/2023"),
        "4", "4@gmail.com", "java", "English", 7, "good",
        7, "nope");
    assertEquals(true, candidateDao.saveCandidate(personThree));
    candidateDao.saveCandidate(personFour);
  }
  @Test
  @Order(2)
  void getCandidateById() throws ParseException {
    DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
    Candidate personThree = new Candidate("tam", df.parse("04/16/1999"), 1, df.parse("05/11/2023"),
        "3", "3@gmail.com", "java", "English", 7, "good",
        7, "nope");
    assertEquals(personThree, candidateDao.getCandidateById(3L));
  }
  @Test
  @Order(3)
  void updateCandidate() throws ParseException {
    DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
    Candidate personThree = new Candidate("tam", df.parse("04/16/1999"), 1, df.parse("05/11/2023"),
        "3", "3@gmail.com", "java", "English", 7, "good",
        7, "nope");
    assertEquals(true, candidateDao.updateCandidateById(personThree, 3L));
  }
  @Test
  @Order(4)
  void deleteCandidate() {
    assertEquals(true, candidateDao.deleteCandidateById(4L));
  }
  @Test
  @Order(5)
  void getAll() {
    List<Candidate> list = candidateDao.getAllCandidate();
    assertEquals(3, list.size());
  }
}