package pl.phonebookproject.phonebook.record;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.phonebookproject.phonebook.models.Record;

import java.util.List;


@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {
    @Transactional
    List<Record> deleteByPhonenumber(String phonenumber);
}
