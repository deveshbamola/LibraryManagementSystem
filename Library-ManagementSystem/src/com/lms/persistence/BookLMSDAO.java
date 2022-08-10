package com.lms.persistence;

import java.util.List;

import com.lms.bean.Book;

public interface BookLMSDAO {
    boolean addBook(Book book);

    int removeBook(String bookName);

    Book searchBook(String bookName);
     List<Book> getAllBooks();
    boolean issueBook(int transactionId,int bookId,String issueDate,String ScheduledDate);
    boolean returnBook(int employeeId,int bookId);
	String checkReturnDate(int empID, int bookID);
}
