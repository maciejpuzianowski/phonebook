package pl.phonebookproject.phonebook.record;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.phonebookproject.phonebook.models.Record;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RecordApiControllerTest {

    @Autowired
    RecordRepository repository;

    @Test
    void add() {
        Record record = new Record("Maciej", "Puzianowski","123453235");
        repository.save(record);
        assertNotNull(repository.getReferenceById(1L));
    }

    @Test
    void deleteRecord() {
        Record record = new Record("Maciej", "Puzianowski","123453235");
        repository.save(record);
        assertNotNull(repository.getReferenceById(1L));
        repository.deleteById(1L);
        assertFalse(repository.existsById(1L));
    }

}