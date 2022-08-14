use lms;

select * from book;
select * from employee;
select * from tbr;
select * from transations;
select * from user;
insert into user values(2001,"devesh@gmail.com","54321" , false);
insert into user values(2000,"Sanketh@gmail.com","54321",true);
call insertIntoEmployee(2003,"Basit","Budroo","Student",2);
call insertIntoTBR(111,10002,08/07/2022,20/07/2022,200,28/07/2022);
call insertIntoTransations(10001,2000);
call insertIntoTransations(10002,2001);
call insertBook(111,"Passage to India",202201,"E.M. Foster","Edward Arnold","politics",10);
call insertBook(112,"Harry porter",202202,"JK. Rowling"," Bloomsbury ","Fantasy",5);
call insertBook(113,"Commonwealth",202203,"Ramachandra","HarperCollins","Sports",5);
call insertBook(114,"Alice in Wonderland",202204,"Lewis Carrol"," Macmillan","Fantasy",15);

SELECT BIN_TO_UUID(bookId) AS ID FROM book;