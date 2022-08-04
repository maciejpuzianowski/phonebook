# Phonebook
Simple Phonebook API with ability to get, sort, add and delete records.
## Phone number object
Phone number object consists of three strings that are respectively:
- Firstname {firstname}
- Lastname {lastname}
- Phone number {phonenumber}
## Endpoints
#### Get records (GET)
```
/record
```
#### Get sorted records (GET)
```
/record?sortBy={fieldname}&orderBy={asc || desc}
```
#### Add record (POST)
Provide request body.
```
/record/add
```
#### Delete records (DELETE)
```
/record/delete?phoneNumber={number}
```
