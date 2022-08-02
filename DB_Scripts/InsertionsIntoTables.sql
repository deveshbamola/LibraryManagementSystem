use lms;

select * from book;
select * from employee;
select * from tbr;
select * from transations;
call insertIntoEmployee(2003,"Basit","Budroo","Student",2);
call insertIntoTBR(111,10002,08/07/2022,20/07/2022,200,28/07/2022);
call insertIntoTransations(10001,2000);
call insertIntoTransations(10002,2001);
call insertBook(111,"Passage to India",202201,"E.M. Foster"," Edward Arnold","politics",10);
SELECT BIN_TO_UUID(bookId) AS ID FROM book;