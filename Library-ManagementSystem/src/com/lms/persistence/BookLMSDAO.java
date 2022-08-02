package com.lms.persistence;

import com.lms.bean.Book;

public interface BookLMSDAO {
    boolean addBook(Book book);

    int removeBook(String bookName);

    Book searchBook(String bookName);
    
    boolean issueBook(int transactionId,int bookId,String issueDate,String ScheduledDate);
    boolean returnBook(int employeeId,int bookId);
}
