package fa.training.DAO;

import fa.training.entities.Candidate;
import java.util.List;

public interface QuestionDAO {

  List<Candidate> cau1();

  List<Candidate> cau2();

  List<Candidate> cau3();

  List<Candidate> cau4();

  Integer cau5();

  List<Candidate> search(int pageNumber, int pageSize);

}
