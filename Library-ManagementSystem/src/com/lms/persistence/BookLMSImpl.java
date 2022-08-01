package com.lms.persistence;

import com.lms.bean.Book;

import java.sql.*;

public class BookLMSImpl implements BookLMSDAO {
    @Override
    public boolean addBook(Book book) {
        int rows = 0;
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/--", "",
                "");
             PreparedStatement preparedStatement = connection
                     .prepareStatement("INSERT INTO book values(?, ?, ?, ?, ?, ?, ?)");) {

            preparedStatement.setString(2, book.getBookName());
            preparedStatement.setInt(3, book.getIsbnNumber());
            preparedStatement.setString(4, book.getAuthorName());
            preparedStatement.setString(5, book.getPublisherName());
            preparedStatement.setString(6, book.getBookType());
            preparedStatement.setInt(7, book.getBookNumber());

            rows = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows > 0;
    }

    @Override
    public Integer removeBook(String bookName) {
        int rows = 0;
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/",
                "", "");
             PreparedStatement preparedStatement = connection
                     .prepareStatement("DELETE FROM book WHERE bookName=?")) {

            preparedStatement.setString(1, bookName);

            rows = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }
        return rows;
    }

    @Override
    public Book searchBook(String name) {
        Book book = null;
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/--",
                "", "");
             PreparedStatement preparedStatement = connection
                     .prepareStatement("SELECT * FROM book WHERE bookId=?");) {

            int bookID = 0; // temp --

            preparedStatement.setInt(1, bookID);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String bookName = resultSet.getString("bookName");
                int isbnNumber = resultSet.getInt("ISBNNumber");
                String authorName = resultSet.getString("authorName");
                String publisherName = resultSet.getString("publisherName");
                String bookType = resultSet.getString("bookType");
                int  bookNumber = resultSet.getInt("bookNumber");

                book = new Book(bookName, isbnNumber, authorName, publisherName, bookType, bookNumber);
            }

        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }
        return book;
    }
}
