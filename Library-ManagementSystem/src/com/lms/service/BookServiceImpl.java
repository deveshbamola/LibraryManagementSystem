package com.lms.service;

import com.lms.bean.Book;
import com.lms.persistence.BookLMSDAO;
import com.lms.persistence.BookLMSImpl;

import java.time.LocalDate;
import java.util.List;

public class BookServiceImpl implements BookService {
    private final BookLMSDAO bookLMSDAO = new BookLMSImpl();

    @Override
    public Boolean addBook(Book book) {
        return bookLMSDAO.addBook(book);
    }

    @Override
    public Boolean removeBook(String bookName) {
        return bookLMSDAO.removeBook(bookName) > 0;
    }

    @Override
    public Book searchBook(String bookName) {
        return bookLMSDAO.searchBook(bookName);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookLMSDAO.getAllBooks();
    }

    @Override
    public boolean issueBook(int transactionId, int bookId, String ScheduledDate) {
        LocalDate date = LocalDate.now();
        System.out.println("Current date: " + date);
        return bookLMSDAO.issueBook(transactionId, bookId, date.toString(), ScheduledDate);
    }

    @Override
    public String checkDueReturnDate(int empID, int bookID) {
        return bookLMSDAO.checkReturnDate(empID, bookID);
    }

    @Override
    public boolean returnBook(int tranID) {
        return bookLMSDAO.returnBook(tranID);
    }
}
