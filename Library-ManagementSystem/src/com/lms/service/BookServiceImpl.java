package com.lms.service;

import com.lms.bean.Book;
import com.lms.persistence.BookLMSDAO;
import com.lms.persistence.BookLMSImpl;

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
}
