package com.lms.persistence;

import com.lms.bean.Book;

public interface BookLMSDAO {
    boolean addBook(Book book);
    Integer removeBook(int bookID);
    Book searchBook(int bookID);
}
