# Phonebook
Simple Phonebook API with ability to get, sort, add and delete records.
## Phone number object
Phone number object consists of three strings that are respectively:
- Firstname {firstName}
- Lastname {lastName}
- Phone number {phoneNumber}
## Endpoints
#### Get records (GET)
```
/records
```
#### Get sorted records (GET)
```
/records?sortBy={fieldName}&orderBy={asc || desc}
```
#### Add record (POST)
Provide request body.
```
/addrecord
```
#### Delete records (DELETE)
```
/deleterecord?phoneNumber={number}
```
