package fa.training.DAO;

import fa.training.entities.EntryTest;
import java.util.List;

public interface   EntryTestDAO {

  List<EntryTest> getAllEntryTest();

  EntryTest getEntryTestById(Long id);

  boolean updateEntryTestById(EntryTest entryTest, Long id);

  boolean deleteEntryTestById(Long id);

  boolean saveEntryTest(EntryTest entryTest);
}
