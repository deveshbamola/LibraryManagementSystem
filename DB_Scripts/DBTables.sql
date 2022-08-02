use lms;
-- Employee Table
CREATE TABLE employee (
    employeeId int primary key,
    employeeFn varchar(20),
    employeeLn varchar(20),
    desg varchar(20),
    booksIssued int
);

-- Transation Book Record Table
create table tbr(
TBRID int primary key,
 bookId int,
 transationId int,
 issueDate varchar(20),
 scheduledReturn varchar(10),
 fine double,
 returnDate varchar(10),
 FOREIGN KEY (bookId) REFERENCES book(bookId),
  FOREIGN KEY (transationId) REFERENCES transations(transationId)
);-- Time and date

-- Transations Table
create table transations(
transationId int primary key,
membershipId int,
constraint FOREIGN KEY (membershipId) REFERENCES employee(membershipId)
);
-- employ ID 
-- Book Table
create table book(
bookId int primary key,
bookName varchar(20),
ISBNNumber int,
bookAuthor varchar(20),
bookPublisher varchar(20),
bookType varchar(20),
noOfBooks int
);