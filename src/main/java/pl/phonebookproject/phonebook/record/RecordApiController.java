package pl.phonebookproject.phonebook.record;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import pl.phonebookproject.phonebook.models.Record;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-08-03T16:02:09.857300600+02:00[Europe/Warsaw]")
@RestController
public class RecordApiController implements RecordApi {

    private static final Logger log = LoggerFactory.getLogger(RecordApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private final RecordRepository recordRepository;

    @org.springframework.beans.factory.annotation.Autowired
    public RecordApiController(ObjectMapper objectMapper, HttpServletRequest request, RecordRepository repository) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.recordRepository = repository;
        recordRepository.save(new Record("Maciej", "Puzianowski", "232664323"));
        recordRepository.save(new Record("Adrian", "Nowak", "125363235"));
        recordRepository.save(new Record("Kacper", "Polański", "755855455"));
        recordRepository.save(new Record("Anna", "Mucha", "997500454"));
        recordRepository.save(new Record("Kamil", "Tumu(L)ec", "191619161"));
        recordRepository.save(new Record("Karol", "Wojtyła", "213721372"));
        recordRepository.save(new Record("Sebastian", "Alvarez", "125536635"));
    }

    public ResponseEntity<String> recordAddPost(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Record body) {
        String response = "Added new phone number: " + recordRepository.save(body).getPhonenumber();
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }

    public ResponseEntity<String> recordDeleteDelete(@Parameter(in = ParameterIn.QUERY, description = "Phone number to remove from phonebook." ,schema=@Schema()) @Valid @RequestParam(value = "phoneNumber", required = false) String phoneNumber) {
        String response = !recordRepository.deleteByPhonenumber(phoneNumber).isEmpty() ? "Deleted successfully." : "No such record.";
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }

    public ResponseEntity<List<Record>> recordGet(@Parameter(in = ParameterIn.QUERY, description = "Field to sort by." ,schema=@Schema()) @Valid @RequestParam(value = "sortBy", required = false, defaultValue = "id") String sortBy,@Parameter(in = ParameterIn.QUERY, description = "Direction to order by." ,schema=@Schema()) @Valid @RequestParam(value = "orderBy", required = false, defaultValue = "asc") String orderBy) {
        var order = orderBy.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        var response = recordRepository.findAll(PageRequest.of(0, Integer.MAX_VALUE,order, sortBy)).toList();
        return new ResponseEntity<List<Record>>(response, HttpStatus.OK);
    }

}
