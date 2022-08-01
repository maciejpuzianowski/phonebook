package pl.phonebookproject.phonebook.phonebookrecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
public class PhonebookRecordController {

    PhonebookRecordRepository PhonebookRecords;

    @Autowired
    public PhonebookRecordController(PhonebookRecordRepository repository){
        PhonebookRecords = repository;
        PhonebookRecords.save(new PhonebookRecord("Maciej", "Puzianowski", "503945623"));
        PhonebookRecords.save(new PhonebookRecord("Adrian", "Nowak", "125363235"));
        PhonebookRecords.save(new PhonebookRecord("Kacper", "Polański", "755855455"));
        PhonebookRecords.save(new PhonebookRecord("Anna", "Mucha", "997500454"));
        PhonebookRecords.save(new PhonebookRecord("Kamil", "Tumu(L)ec", "191619161"));
        PhonebookRecords.save(new PhonebookRecord("Karol", "Wojtyła", "213721372"));
        PhonebookRecords.save(new PhonebookRecord("Sebastian", "Alvarez", "125536635"));
    }

    @GetMapping("/records")
    public Page<PhonebookRecord> records(@RequestParam(value = "sortBy", defaultValue = "id") String sort,
                                         @RequestParam(value = "orderBy", defaultValue = "asc") String order){

        var orderBy = order.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;

        return PhonebookRecords.findAll(PageRequest.of(0, Integer.MAX_VALUE,orderBy, sort));
    }

    @PostMapping("/addrecord")
    public String addRecord(@RequestBody PhonebookRecord record){
        return "Added phone number: " + PhonebookRecords.save(record).getPhoneNumber();
    }

    @DeleteMapping("/deleterecord")
    public String deleteRecord(@RequestParam(value = "phoneNumber") String number){
        return !PhonebookRecords.deleteByPhonenumber(number).isEmpty() ? "Deleted successfully." : "No such phone number.";
    }
}
