package com.lms.persistence;

import com.lms.bean.Book;

import java.util.List;

public interface BookLMSDAO {
    boolean addBook(Book book);

    Integer removeBook(String bookName);

    Book searchBook(String bookName);

    List<Book> getAllBooks();
}
