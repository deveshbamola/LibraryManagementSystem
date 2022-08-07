package com.lms.persistence;

import com.lms.bean.Book;

import java.util.List;

public interface BookLMSDAO {
    boolean addBook(Book book);

    int removeBook(String bookName);

    Book searchBook(String bookName);
<<<<<<< HEAD

    List<Book> getAllBooks();
=======
    
    boolean issueBook(int transactionId,int bookId,String issueDate,String ScheduledDate);
    boolean returnBook(int employeeId,int bookId);
>>>>>>> 9459c4a2d3b5b76ef9a95aa00beb0b5cd08cc927
}
