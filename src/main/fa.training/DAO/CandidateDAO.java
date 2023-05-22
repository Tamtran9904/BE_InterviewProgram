package fa.training.DAO;

import fa.training.entities.Candidate;
import java.util.List;

public interface CandidateDAO {

  List<Candidate> getAllCandidate();

  Candidate getCandidateById(Long id);

  boolean updateCandidateById(Candidate candidate, Long id);

  boolean deleteCandidateById(Long id);

  boolean saveCandidate(Candidate candidate);
}
