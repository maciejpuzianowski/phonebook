package pl.phonebookproject.phonebook.phonebookrecord;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface PhonebookRecordRepository extends JpaRepository<PhonebookRecord, Long> {
    @Transactional
    List<PhonebookRecord> deleteByPhonenumber(String phonenumber);
}
