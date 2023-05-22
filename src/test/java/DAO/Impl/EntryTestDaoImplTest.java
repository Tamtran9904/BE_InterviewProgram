package DAO.Impl;

import static org.junit.jupiter.api.Assertions.*;

import fa.training.DAO.Impl.CandidateDaoImpl;
import fa.training.DAO.Impl.EntryTestDaoImpl;
import fa.training.Enum.ResultStatus;
import fa.training.entities.Candidate;
import fa.training.entities.EntryTest;
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
class EntryTestDaoImplTest {

  static EntryTestDaoImpl EntryTestDao;
  static CandidateDaoImpl CandidateDao;

  @BeforeAll
  static void setUpBeforeClass() throws Exception {
    EntryTestDao = new EntryTestDaoImpl();
    CandidateDao = new CandidateDaoImpl();
  }

  @Test
  @Order(5)
  void getAllEntryTest() {
    List<EntryTest> list = EntryTestDao.getAllEntryTest();
    assertEquals(2, list.size());
  }

  @Test
  @Order(2)
  void getEntryTestById() throws ParseException {
    DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
    Candidate perTwo = CandidateDao.getCandidateById(2L);
    EntryTest TestTwo = new EntryTest("2023", df.parse("05/14/2023"), "English", 8.2, "Anh", 9.1,
        ResultStatus.Pass, "remark", "java", perTwo);
    assertEquals(TestTwo, EntryTestDao.getEntryTestById(2L));
  }

  @Test
  @Order(3)
  void updateEntryTestById() throws ParseException {
    DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
    Candidate perTwo = CandidateDao.getCandidateById(2L);
    EntryTest TestTwo = new EntryTest("2023", df.parse("05/14/2023"), "France", 9.0, "Phap", 9.1,
        ResultStatus.Pass, "remark", "java", perTwo);
    assertEquals(true, EntryTestDao.updateEntryTestById(TestTwo, 2L));
  }

  @Test
  @Order(4)
  void deleteEntryTestById() {
    assertEquals(true, EntryTestDao.deleteEntryTestById(3L));
  }

  @Test
  @Order(1)
  void saveEntryTest() throws ParseException {
    DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
    Candidate perTwo = CandidateDao.getCandidateById(2L);
    EntryTest TestTwo = new EntryTest("2023", df.parse("05/14/2023"), "English", 8.2, "Anh", 9.1,
        ResultStatus.Pass, "remark", "java", perTwo);
    EntryTest TestThree = new EntryTest("2023", df.parse("05/14/2023"), "Jappanese", 8.2, "Nhat", 9.1,
        ResultStatus.Pass, "remark", "java", perTwo);
    assertEquals(true, EntryTestDao.saveEntryTest(TestTwo));
    EntryTestDao.saveEntryTest(TestThree);
  }
}