package pl.phonebookproject.phonebook.phonebookrecord;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PhonebookRecordControllerTest {

    @Autowired
    PhonebookRecordRepository repository;

    @Test
    void add() {
        PhonebookRecord record = new PhonebookRecord("Maciej", "Puzianowski","123453235");
        repository.save(record);
        assertNotNull(repository.getReferenceById(1L));
    }

    @Test
    void deleteRecord() {
        PhonebookRecord record = new PhonebookRecord("Maciej", "Puzianowski","123453235");
        repository.save(record);
        assertNotNull(repository.getReferenceById(1L));
        repository.delete(record);
        assertEquals(0,repository.count());
    }
}