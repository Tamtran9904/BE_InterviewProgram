package fa.training.DAO;

import fa.training.entities.Interview;
import java.util.List;

public interface InterviewDAO {

  List<Interview> getAllInterview();

  Interview getInterviewById(Long id);

  boolean updateInterviewById(Interview interview, Long id);

  boolean deleteInterviewById(Long id);

  boolean saveInterview(Interview interview);
}
