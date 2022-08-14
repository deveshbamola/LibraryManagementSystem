use lms;
-- Employee Table
CREATE TABLE employee (
    employeeId int primary key,
    employeeFn varchar(20),
    employeeLn varchar(20),
    desg varchar(20),
    booksIssued int
);
alter table tbr modify column TBRID Binary(24);

-- Transation Book Record Table
create table tbr(
TBRID int primary key,
 bookId int,
 transationId int,
 issueDate datetime,
 scheduledReturn datetime,
 fine double,
 returnDate datetime,
 FOREIGN KEY (bookId) REFERENCES book(bookId),
  FOREIGN KEY (transationId) REFERENCES transations(transationId)
 
);
-- Transations Table
create table transations(
transationId int primary key,
employeeId int,
constraint FOREIGN KEY (employeeId) REFERENCES employee(employeeId)
);

create table user(
employeeId int,
email varchar(30) primary key,
pass varchar(20),

constraint FOREIGN KEY (employeeId) REFERENCES employee(employeeId)
);

-- Book Table
create   table book(
bookId int primary key,
bookName varchar(20),
ISBNNumber int,
bookAuthor varchar(20),
bookPublisher varchar(20),
bookType varchar(20),
noOfBooks int
);