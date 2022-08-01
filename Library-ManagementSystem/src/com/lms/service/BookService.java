package com.lms.service;

import com.lms.bean.Book;

import java.util.List;

public interface BookService {
    Boolean addBook(Book book);

    Boolean removeBook(String bookName);

    Book searchBook(String bookName);

    List<Book> getAllBooks();
}
