package pl.phonebookproject.phonebook.phonebookrecord;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public @Data class PhonebookRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstname;
    private String lastname;
    private String phonenumber;

    public PhonebookRecord(String firstName, String lastName, String phoneNumber) {
        firstname = firstName;
        lastname = lastName;
        phonenumber = phoneNumber;
    }

    public PhonebookRecord(){

    }
}
