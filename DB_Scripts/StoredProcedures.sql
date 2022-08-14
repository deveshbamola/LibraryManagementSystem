SELECT * FROM lms.tbr;

-- Insert into transations book record table
USE `lms`;
DROP procedure IF EXISTS `insertIntoTBR`;

DELIMITER $$
USE `lms`$$
CREATE PROCEDURE `insertIntoTBR` (
in bookId int,
in transationId int, 
in issueDate datetime, 
in scheduledReturn datetime, 
in fine double,
in returnDate datetime
)
BEGIN
insert into tbr values(uuid(),bookId,transationId,issueDate,
 scheduledReturn,fine,returnDate);

END$$

DELIMITER ;

USE `lms`;
DROP procedure IF EXISTS `insertIntoTransations`;

DELIMITER $$
USE `lms`$$
CREATE PROCEDURE `insertIntoTransations` (
in transationId int, 
in employeeId int)
BEGIN
insert into transations values(transationId,employeeId);
END$$

DELIMITER ;


USE `lms`;
DROP procedure IF EXISTS `insertIntoEmployee`;

DELIMITER $$
USE `lms`$$
CREATE PROCEDURE `insertIntoEmployee` (
in employeeId int,
in employeeFn varchar(20), 
in employeeLn varchar(20),
in desg varchar(20), 
in booksIssued int
)
BEGIN
insert into employee 
values(employeeId,employeeFn,employeeLn,desg,booksIssued);
END$$insertBook

DELIMITER ;


USE `lms`;
DROP procedure IF EXISTS `insertBook`;

USE `lms`;
DROP procedure IF EXISTS `lms`.`insertBook`;
;

DELIMITER $$
USE `lms`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertBook`(
in bookId int,
in bookName varchar(20),
in ISBNNumber int,
in bookAuthor varchar(20),
in bookPublisher varchar(20), 
in bookType varchar(20),
in noOfBooks int
)
BEGIN
insert into book values(bookId,bookName,ISBNNumber,bookAuthor,bookPublisher,
bookType,noOfBooks);
END$$

DELIMITER ;
;

--         insertions